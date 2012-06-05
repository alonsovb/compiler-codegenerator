class Factorial {
    public static void main(String[] a) {
        System.out.println(1);
    }
}
class Fac {
    public int ComputeFac(int num) {
        Fac num_aux;
        if (num < 1)
            num_aux = 1;
        else
            num_aux = num * (this.ComputeFac(num-1));
        return num_aux;
    }
    public int ComputeFac2(int num) {
        int num_aux;
        if (num < 1)
            num_aux = 1;
        else
            num_aux = 2;
        return num_aux;
    }
}
