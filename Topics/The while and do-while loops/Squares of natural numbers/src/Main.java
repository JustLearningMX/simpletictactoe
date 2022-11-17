import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number = scanner.nextInt();
        int count = 1;

        if (number > 0) {
            do {
                System.out.println(count * count);
                count += 1;
            } while (count * count <= number);
        }
    }
}