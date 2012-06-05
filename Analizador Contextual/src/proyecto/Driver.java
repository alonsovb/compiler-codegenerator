/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AST.AST;
import editor.EditorFrame;
import java.io.FileReader;
import java.io.StringReader;

/**
 *
 * @author Alonso
 */
public class Driver {

    EditorFrame ef;
    
    public Driver(EditorFrame frame) {
        ef = frame;
    }

    public AST parse(String source) throws Exception {
        proyecto.Scanner s = new proyecto.Scanner(new StringReader(source));
        proyecto.parser p = new parser(s);
        p.frame = ef;
        
        p.parse();
        
        return p.raiz;
    }
}
