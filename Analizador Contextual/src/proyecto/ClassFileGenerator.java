/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alonso
 */
public class ClassFileGenerator {

    public void createClassFile(String ClassName) {
        File f;
        f = new File(ClassName + ".j");
        f.delete();
        try {
            f.createNewFile();
        } catch (IOException ex) {
            System.out.print("No se pudo crear el archivo");
        }

        writeCodeLine(ClassName, ".class public " + ClassName);
        writeCodeLine(ClassName, ".super java/lang/Object");
        writeCodeLine(ClassName, ";");
        writeCodeLine(ClassName, "; inicializador estandar");
        writeCodeLine(ClassName, ".method public <init>()V");
        writeCodeLine(ClassName, "   aload_0");
        writeCodeLine(ClassName, "   invokenonvirtual java/lang/Object/<init>()V");
        writeCodeLine(ClassName, "   return");
        writeCodeLine(ClassName, ".end method");

    }

    public void writeCodeLine(String ClassName, String Code) {
        try {
            FileWriter writer = new FileWriter(ClassName + ".j", true);
            writer.append(Code + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.print("No se pudo escribir al archivo: " + Code);
        }
    }
}
