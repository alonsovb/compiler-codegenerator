class claseMain
{ 
  public static void main (String [] m3 )
  {
        System.out.println ( new llamar().k() );
/*    if (true)
    {
        System.out.println ( new llamar().k() );
    }
    else
        System.out.println ( true );
*/
  } 
}

class hola
{ 
  Boolean d ;
  public int [] f (Boolean o, int g, Boolean z)         
  {
    //Boolean d;
    int x;
    int [] a;
    {
      System.out.println("codigo de f");
      d = false;
      x = 9;
      //a = new int[x];
    }
    return a;
  }
}

class llamar
{ 
  //Boolean d ;
  
  public int metodo()
  {
     System.out.println("codigo de metodo");
     return 6; //PROBAR CON ERROR DE TIPO
  }

  public int metodo2() //ERROR DE MÉTODO YA DECLARADO
  {
     System.out.println("codigo de metodo");
     return 3;
  }

  public Boolean k()         
  {
    Boolean d;
    Boolean r;
    int x;
    hola j;
    int [] a;
    
    { 
      System.out.println("codigo de K");
      x = 5;
      r = false;
      d = true;
      j = new hola();//.f(d,x,r); //ERROR DE TIPOS //VERIFICAR FUNCIONALIDAD DE ESTA LINEA

      if (x < 1)
	{ 
		a = new int[x];
	}
      else
        {
		a = new int[this.metodo()];//VERIFICAR FUNCIONALIDAD DEL "THIS"
	} 
     }

    a[5] = 2;
    a[2] = 7; //ERROR DE TIPOS
    
    //x = (3 + (5 * a[1])); //ERROR DE VARIABLE NO DECLARADA

    return d;
  }
}


/*
 ContextAnalizer.java: Linea 163, Quitar .getClass().getName()
 ContextAnalizer.java: Linea 297 y 299, Cambiar Object por String. Luego sustituir comparacion en 302 por "!idClass.equals(expressionClass)"
 321: Cambiar tipo de Object a String. Asignar TypeUtilities.getClass(it.retrieve(c.id1.value.toString()));
 323: Cambiar tipo de Object a String. Agregar el .toString();
 ContextAnalizer.java: Linea 325, Cambiar comparacion por "!idClass.contains("[]")"
*/
