import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();

        if (number2 <= number3) {
            if (number1 >= number2 && number1 <= number3) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } else {
            if (number1 >= number3 && number1 <= number2) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}
