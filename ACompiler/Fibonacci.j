.class public Fibonacci
.super java/lang/Object

;
; inicializador estandar
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static CalcularFibonacci(I)I
.limit stack 3
.limit locals 5
    ldc 0
    istore 2
    ldc 0
    istore 3
    ldc 0
    istore 4
    ldc 2
    iload 0
    istore 3
    iload 3
    iadd
    ldc 9
    ldc 2
    idiv
    imul
    istore 4
    iload 4
    ireturn
.end method

