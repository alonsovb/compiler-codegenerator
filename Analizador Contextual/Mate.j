.class public Mate
.super java/lang/Object

;
; inicializador estandar
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static Sumatoria(I)I
.limit stack 6
.limit locals 3
    iload 0
    ldc 2
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
    istore 1
    ldc 0
    istore 2
    goto ifend0
  else0:
    iload 0
    istore 1
    ldc 0
    istore 2
  ifend0:
  check2:
    iload 1
    ldc 1
    if_icmpgt true2
    goto false2
  true2:
    ldc 1
    goto exit2
  false2:
    ldc 0
  exit2:
    ifne do2
    goto endwhile2
  do2:
    iload 2
    iload 1
    iadd
    istore 2
    iload 1
    ldc 1
    isub
    istore 1
    goto check2
  endwhile2:
    iload 2
    ireturn
.end method

