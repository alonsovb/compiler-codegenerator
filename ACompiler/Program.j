.class public Program
.super java/lang/Object

;
; inicializador estandar
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 2
    ldc 100
    istore 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return
.end method

