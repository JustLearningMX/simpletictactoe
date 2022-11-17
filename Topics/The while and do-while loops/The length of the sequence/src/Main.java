import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int item = scanner.nextInt();
        int count = 0;

        while (item > 0) {
            count += 1;
            item = scanner.nextInt();
        }

        System.out.println(count);
    }
}