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
.limit locals 3
    ldc 0
    istore 2
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
    ifne then0
    goto else0
  then0:
    ldc 1
    istore 2
    goto ifend0
  else0:
    iload 0
    iload 0
    ldc 1
    isub
    invokestatic Factorial/CalcularFactorial(I)I
    imul
    istore 2
  ifend0:
    iload 2
    ireturn
.end method

