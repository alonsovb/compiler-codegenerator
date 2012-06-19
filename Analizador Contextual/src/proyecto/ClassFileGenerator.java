/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author alonso
 */
public class ClassFileGenerator {

    HashMap<String, StringBuilder> Files = new HashMap<String, StringBuilder>();

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
            System.out.println("No se encuentra el string para " + ClassName + " al escribir \n" + Code);
        }
    }
    
    public void writeCodeLine(String ClassName) {
        StringBuilder builder = Files.get(ClassName);
        if (builder != null) {
            builder.append("\n");
        } else {
            System.out.println("No se encuentra el string para " + ClassName + " al escribir una nueva línea");
        }
    }

    public void writeFile(String ClassName) {
        File f;
        f = new File(ClassName + ".j");
        System.out.println("Escribiendo a " + ClassName + ".j"); // Cambiar para mostrar en ventana
        f.delete();
        try {
            f.createNewFile();
        } catch (IOException ex) {
            System.out.print("No se pudo crear el archivo " + ClassName);
        }
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(Files.get(ClassName).toString());
            writer.close();
        } catch (Exception ex) {
            System.out.print("No se pudo escribir al archivo " + ClassName);
        }
    }
    
    public void replaceValues(String ClassName, String ToReplace, String NewValue) {
        StringBuilder builder = Files.get(ClassName);
        if (builder != null) {
            builder = new StringBuilder(builder.toString().replace(ToReplace, NewValue));
            Files.remove(ClassName);
            Files.put(ClassName, builder);
        } else {
            System.out.println("No se encuentra el string para " + ClassName + " al remplazar " + ToReplace + " por " + NewValue);
        }
    }
}
