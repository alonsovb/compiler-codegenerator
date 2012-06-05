/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AST.AST;

/**
 *
 * @author Alonso
 */
public class Identifier {
    
    int level;
    String name;
    AST attr;
    
    Identifier _next;

    public Identifier(String Name, AST Attribute, int Level) {
        name = Name;
        attr = Attribute;
        level = Level;
    }
    
}
