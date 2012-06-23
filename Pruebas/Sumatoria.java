class Program {
    public static void main(String[] a) {
        System.out.println(new Mate().Sumatoria(10));
    }
}
class Mate {
    public int Sumatoria(int Num) {
        int aux;
		int total;

        if (Num < 2) {
            aux = 1;
			total = 0;
		}
		else {
			aux = Num;
			total = 0;
		}

		while (aux > 1) {
			total = total + aux;
			aux = aux - 1;
		}
        return total;
    }
}
