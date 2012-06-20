class Program {
    public static void main(String[] a) {
        System.out.println(new Fibonacci().CalcularFibonacci(10));
    }
}
class Fibonacci {
    public int CalcularFibonacci(int Num) {
        int aux;
        if (Num < 2)
            aux = Num;
        else
            aux = (this.CalcularFibonacci(Num - 1)) + (this.CalcularFibonacci(Num - 2));
        return aux;
    }
}
