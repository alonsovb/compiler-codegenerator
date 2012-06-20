/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AST.AST;
import editor.EditorFrame;
import java.io.StringReader;

/**
 *
 * @author Alonso
 */
public class Driver {

    Reporter repoter;
    String sourceCode;
    IdentifierTable table;
    AST root;
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

    public Boolean compile() {
        try {
            // Análisis sintáctico
            root = parse(sourceCode);

            // Análisis contextual
            table = new IdentifierTable();
            ContextAnalizer analizer = new ContextAnalizer(table, repoter);
            analizer.visit(root);
            repoter.ReportMessage("Successfully compiled.");
            return true;
        } catch (Exception ex) {
            repoter.ReportMessage("Failed to compile.");
            return false;
        }
    }

    public void run() {
    }

    // Realizar el parsing (Análisis sintáctico)
    public AST parse(String source) throws Exception {
        proyecto.Scanner s = new proyecto.Scanner(new StringReader(source));
        proyecto.parser p = new parser(s);
        p.reporter = repoter;

        p.parse();

        return p.raiz;
    }
}
