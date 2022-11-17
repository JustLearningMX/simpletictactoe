import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int numberOfCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        if ((numberOfCups > 9 && numberOfCups < 21 && !isWeekend) || (numberOfCups > 15 && numberOfCups < 26 && isWeekend)) {
            System.out.println(true);
//        } else if (numberOfCups > 15 && numberOfCups < 26 && isWeekend) {
//            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}