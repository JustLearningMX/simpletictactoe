import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int busHeight = scanner.nextInt(); //Altura del autobus
        int numberOfBridges = scanner.nextInt(); //Numero de puentes
        int[] heigthsOfBridges = new int[numberOfBridges]; //Altura de los puentes
        boolean isMinor = true; //Autobus es menor
        int bridge = 0; //Puente donde choca

        for (int i = 0; i < numberOfBridges; i++) {
            int heightActualBridge = scanner.nextInt();
            heigthsOfBridges[i] = heightActualBridge;

            if (busHeight >= heightActualBridge) {
                isMinor = false;
                bridge = bridge > 0 ? bridge : i + 1;
            }
        }

        String msg = isMinor ? "Will not crash" : "Will crash on bridge " + bridge;
        System.out.println(msg);
    }
}