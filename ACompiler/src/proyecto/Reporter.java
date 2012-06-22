/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.List;

/**
 *
 * @author Alonso
 */
public interface Reporter {
    public void ReportMessage(String Message);
    public void ReportError(String Message);
    public void ShowGeneratedFiles(List<String> Files);
}
