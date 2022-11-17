import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean isNotExceeding = false;

        int rows = 0;
        int cols = 0;

        do {
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            isNotExceeding = rows > 0 && rows < 101 && cols > 0 && cols < 101;
        } while (!isNotExceeding);

        int[][] twoArrays = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                twoArrays[i][j] = scanner.nextInt();
            }
        }
        
        int swapOne = scanner.nextInt();
        int swapTwo = scanner.nextInt();

        for (int[] item: twoArrays) {

            String line = "";

            int val1 = item[swapOne];
            int val2 = item[swapTwo];

            for (int k = 0; k < item.length; k++) {
                item[k] = k ==  swapOne ? val2 :
                        k ==  swapTwo ? val1 : item[k];

                line += item[k] + " ";
            }

            System.out.println(line);
        }

    }
}