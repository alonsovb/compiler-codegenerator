package proyecto;

public class MyException extends Exception
{
  public MyException(String mensaje, int Line, int Column)
  {
	super(mensaje + " en la linea : " + Line + " en la columna: " + Column);
  }
}
