/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Alonso
 */
public interface ErrorReporter {
    public void ReportMessage(String message);
    public void ReportError(String message);
}
