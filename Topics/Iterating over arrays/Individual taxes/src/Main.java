import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int numberOfCompanies = scanner.nextInt();
        Double[][] dataTaxes = new Double[2][numberOfCompanies]; //1-individualTaxes, 2-yearlyIncomes
        dataTaxes = setDataInArray(dataTaxes, scanner);
        int companyPayMostTaxes = calculateTaxes(dataTaxes);
        System.out.println(companyPayMostTaxes);
    }

    static int calculateTaxes(Double[][] dataTaxes) {
        Double taxMaxValue = 0.0;
        int companyPayMostTaxes = 0;

        for (int i = 0; i < dataTaxes[0].length; i++){
            Double yearlyIncome = dataTaxes[0][i];
            Double individualTaxes = dataTaxes[1][i];
            Double taxCompany = (individualTaxes/100) * yearlyIncome;

            if (taxMaxValue < taxCompany) {
                taxMaxValue = taxCompany;
                companyPayMostTaxes = i + 1;
            }
        }
        return companyPayMostTaxes;
    }

    static Double[][] setDataInArray(Double[][] dataTaxes, Scanner scanner) {
        int companies = dataTaxes[0].length;

        for (int i = 0; i < companies; i++) {
            Double yearlyIncome = scanner.nextDouble();
            dataTaxes[0][i] = yearlyIncome;
        }

        for (int i = 0; i < companies; i++) {
            Double individualTaxes = scanner.nextDouble();
            dataTaxes[1][i] = individualTaxes;
        }

        return dataTaxes;
    }
}