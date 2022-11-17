import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int resultado = a;

        for ( ; a < b; a++) {
            resultado = a + 1 < b ? (resultado * (a + 1)) : resultado;
        }

        System.out.println(resultado);
    }
}