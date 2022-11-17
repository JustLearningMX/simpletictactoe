import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int[] b = new int[a];

        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }

        int c = scanner.nextInt();

        boolean isInArray = false;
        for (int j = 0; j < b.length; j++) {
            if (b[j] == c) {
                isInArray = true;
                break;
            }
        }

        System.out.println(isInArray);
    }
}