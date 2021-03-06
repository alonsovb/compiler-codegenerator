/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import ast.AST;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alonso
 */
public class Driver implements Reporter {
    
    Reporter repoter;
    String sourceCode;
    IdentifierTable table;
    AST root;
    String mainClass;
    int totalErrors;
    
    public AST getAST() {
        return root;
    }
    
    public IdentifierTable getTable() {
        return table;
    }
    
    public Driver(Reporter Reporter, String SourceCode) {
        repoter = Reporter;
        sourceCode = SourceCode;
    }
    
    public Boolean run() {
        if (totalErrors == 0) {
            try {
                // Crear un proceso para ejecutar el código generado
                Process jasmin = Runtime.getRuntime().exec(new String[]{"java", mainClass});
                
                InputStream inputStream = jasmin.getInputStream();
                InputStream errorStream = jasmin.getErrorStream();
                
                try {
                    String inputString = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
                    repoter.ReportMessage("Program output:");
                    repoter.ReportMessage(inputString);
                } catch (Exception ex) {
                }
                try {
                    String errorString = new java.util.Scanner(errorStream).useDelimiter("\\A").next();
                    repoter.ReportError("Program error output:");
                    repoter.ReportError(errorString);
                } catch (Exception ex) {
                    return false;
                }
            } catch (IOException ex) {
                repoter.ReportError("Cannot write to file: " + ex.getMessage());
                return false;
            }
        } else {
            repoter.ReportError("Cannot run program with " + totalErrors + " errors.");
            return false;
        }
        return true;
    }
    
    public Boolean compile() {
        try {
            // Análisis sintáctico
            root = parse(sourceCode);

            // Análisis contextual
            table = new IdentifierTable();
            ContextAnalizer analizer = new ContextAnalizer(table, this);
            analizer.visit(root);
            
            if (totalErrors == 0) {
                // Generación de código
                CodeGenerator generator = new CodeGenerator(root, table, repoter);
                List<String> files = new LinkedList<String>();
                mainClass = generator.getMainClass();
                // Crear un nuevo proceso para ejecutar jasmin y generar cada ensamblado .class
                for (int i = 0; i < generator.getGeneratedClasses().size(); i++) {
                    String fileName = generator.getGeneratedClasses().get(i) + ".j";
                    Process jasmingen = Runtime.getRuntime().exec(new String[]{"java", "-jar", "jasmin.jar", fileName});
                    files.add(fileName);
                    try {
                        jasmingen.waitFor();
                    } catch (InterruptedException inter) {
                        continue;
                    }
                }
                repoter.ReportMessage("Successfully compiled.");
                ShowGeneratedFiles(files);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            repoter.ReportMessage("Failed to compile.");
            return false;
        }
    }

    // Realizar el parsing (Análisis sintáctico)
    public AST parse(String source) throws Exception {
        proyecto.Scanner s = new proyecto.Scanner(new StringReader(source));
        proyecto.parser p = new parser(s);
        p.reporter = this;
        
        p.parse();
        
        return p.raiz;
    }
    
    @Override
    public void ReportMessage(String message) {
        this.repoter.ReportMessage(message);
    }
    
    @Override
    public void ReportError(String message) {
        totalErrors++;
        this.repoter.ReportError(message);
    }
    
    @Override
    public void ShowGeneratedFiles(List<String> Files) {
        repoter.ShowGeneratedFiles(Files);
    }
}
