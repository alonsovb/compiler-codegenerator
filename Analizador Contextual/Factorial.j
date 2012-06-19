.class public Factorial
.super java/lang/Object

;
; inicializador estandar
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static CalcularFactorial(I)I
.limit stack 3
.limit locals 2
    iload 0
    ldc 1
    if_icmplt true0
    goto false0
  true0:
    ldc 1
    goto exit0
  false0:
    ldc 0
  exit0:
    ldc 1
    iload 0
    iload 0
    ldc 1
    isub
    imul
    ireturn
.end method

