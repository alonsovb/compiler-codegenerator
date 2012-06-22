/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author alonso
 */
public class ClassFileGenerator {

    HashMap<String, StringBuilder> Files = new HashMap<String, StringBuilder>();
    Reporter reporter;
    
    public ClassFileGenerator(Reporter Reporter) {
        reporter = Reporter;
    }

    public void createClassFile(String ClassName) {
        Files.put(ClassName, new StringBuilder());
        writeCodeLine(ClassName, ".class public " + ClassName);
        writeCodeLine(ClassName, ".super java/lang/Object");
        writeCodeLine(ClassName);
        writeCodeLine(ClassName, ";");
        writeCodeLine(ClassName, "; inicializador estandar");
        writeCodeLine(ClassName, ".method public <init>()V");
        writeCodeLine(ClassName, "   aload_0");
        writeCodeLine(ClassName, "   invokenonvirtual java/lang/Object/<init>()V");
        writeCodeLine(ClassName, "   return");
        writeCodeLine(ClassName, ".end method");
        writeCodeLine(ClassName);
    }

    public void writeCodeLine(String ClassName, String Code) {
        StringBuilder builder = Files.get(ClassName);
        if (builder != null) {
            builder.append(Code).append("\n");
        } else {
            this.reporter.ReportError("Cannot find string for " + ClassName + " when writing \n" + Code);
        }
    }
    
    public void writeCodeLine(String ClassName) {
        StringBuilder builder = Files.get(ClassName);
        if (builder != null) {
            builder.append("\n");
        } else {
            this.reporter.ReportError("Cannot find string for " + ClassName + " when writing new line");
        }
    }

    public void writeFile(String ClassName) {
        File f;
        f = new File(ClassName + ".j");
        reporter.ReportMessage("Created file " + ClassName + ".j");
        f.delete();
        try {
            f.createNewFile();
        } catch (IOException ex) {
            reporter.ReportError("Cannot create file " + ClassName);
        }
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(Files.get(ClassName).toString());
            writer.close();
        } catch (Exception ex) {
            reporter.ReportError("Cannot write to file " + ClassName);
        }
    }
    
    public void replaceValues(String ClassName, String ToReplace, String NewValue) {
        StringBuilder builder = Files.get(ClassName);
        if (builder != null) {
            builder = new StringBuilder(builder.toString().replace(ToReplace, NewValue));
            Files.remove(ClassName);
            Files.put(ClassName, builder);
        } else {
            reporter.ReportError("Cannot find string for " + ClassName + " when replacing " + ToReplace + " to " + NewValue);
        }
    }
    
    public static String readFile(String FileName) {
        File f;
        f = new File(FileName);
        try {
            String reader = new java.util.Scanner(f).useDelimiter("\\A").next();
            return reader;
        } catch (Exception ex) {
            return "Unable to read " + FileName;
        }
    }
}
