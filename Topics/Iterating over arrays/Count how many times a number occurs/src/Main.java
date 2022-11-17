import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int a = scanner.nextInt();
        int[] b = new int[a];

        for (int i = 0; i < a; i++){
            b[i] = scanner.nextInt();
        }
        int c = scanner.nextInt();

        int count = 0;
        for (int j = 0; j < a; j++){
            count += b[j] == c ? 1 : 0;
        }

        System.out.println(count);

    }
}