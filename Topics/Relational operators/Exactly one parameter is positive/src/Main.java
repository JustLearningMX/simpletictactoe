import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if ( (a > 0 && (b < 1 && c < 1)) || (b > 0 && (a < 1 && c < 1)) || (c > 0 && (a < 1 && b < 1))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
