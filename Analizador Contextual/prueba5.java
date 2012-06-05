class Factorial {
    public static void main(String[] a) {
        System.out.println(new Fac().ComputeFac(10));
    }
}
class Math {
    public int Random() {
	return 2;
    }
}
class Fac extends Math {
    public int ComputeFac(int num) {
        int num_aux;
	char[] asdlkj;
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
            num_aux = num * (this.Random(num-1));
        return num_aux;
    }
}
