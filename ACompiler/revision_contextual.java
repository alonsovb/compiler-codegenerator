class hola
{ 
  boolean d ;
  public int [] f (boolean o, int g, boolean z)         
  {
    boolean d;
    int x;
    int [] a;
    {
      System.out.println("codigo de f");
      d = false;
      x = 9;
      a = new int[x];
    }
    return a;
  }
}

class llamar
{ 
  boolean d ;
  
  public int metodo()
  {
     System.out.println("codigo de metodo");
     return 6; //PROBAR CON ERROR DE TIPO
  }

  public int metodo() //ERROR DE MÉTODO YA DECLARADO
  {
     System.out.println("codigo de metodo");
     return boolean;
  }

  public boolean k()         
  {
    boolean d;
    boolean r;
    int x;
    hola j;
    int [] a;
    
    { 
      System.out.println("codigo de K");     
      x = 5;
      r = false;
      d = true;
      j = new hola().f(d,x,r); //ERROR DE TIPOS //VERIFICAR FUNCIONALIDAD DE ESTA LINEA

      if (x < 1)
	   { a = new int[x]; }
      else
         { a = new int[this.metodo()]; } //VERIFICAR FUNCIONALIDAD DEL "THIS"
    }

    a[5] = 2;
    a[2] = '6'; //ERROR DE TIPOS
    
    x = (3 + (5 * arr[arr[x]])); //ERROR DE VARIABLE NO DECLARADA

    return d;
  }
}

class claseMain
{ 
  public static void main (String [] m3 )
  {
    if (true)
    {
        System.out.println ( new llamar().k() );
    }
    else
        System.out.println ( true );
  } 
}
