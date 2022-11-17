class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        // write your code here
        for (int[] item: twoDimArray) {
            int[] temp = new int[item.length];
            int count = 0;

            for (int i = item.length - 1; i >= 0; i--) {
                temp[count] = item[i];
                count++;
            }

            for (int j = 0; j < item.length; j++) {
                item[j] = temp[j];
            }
        }

    }
}