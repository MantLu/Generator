import java.util.Scanner;
import java.lang.String;

class generator {

    static void toGenerateNumbers() {

        final int coefficientForA = 16807;
        final int coefficientForB = 48271;

        final long divisor = 2147483647;

        int times_matched = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first parameter (1-9999) for A generator: ");
        int A_parameter = scanner.nextInt();

        if (A_parameter > 0 && A_parameter < 10000) {
            System.out.println("Enter second parameter (1-9999) for B generator: ");
        } else {
            System.err.println("Invalid parameter");
            System.exit(0);
        }

        int B_parameter = scanner.nextInt();

        if (B_parameter > 0 && B_parameter < 10000) {

        } else {
            System.err.println("Invalid parameter");
            System.exit(0);
        }

        long final_numberA = A_parameter;    // final_numberA (galutinis desimtainis skaicius) prilyginu vartotojo ivestam skaiciui A_parameter,
        long final_numberB = B_parameter;    // kad for cikle spausdintu nuo pirmo skaiciaus

        for (int i = 1; i <= 1000000; i++) {    // Generuoju milijona A ir B generatoriu reiksmiu

            final_numberA = (final_numberA * coefficientForA) % divisor;
            final_numberB = (final_numberB * coefficientForB) % divisor;

            // System.out.println("A - " + final_numberA + " B - " + final_numberB); // Galima pasitikrinti ar gerai generuoja pries keiciant i dvejataini

            String A_binary = Long.toBinaryString(final_numberA);    // Sugeneruotas desimtaines reiksmes keiciu i dvejetaines String pavidalu
            String B_binary = Long.toBinaryString(final_numberB);

            // Palieku paskutinius 8 skaitmenis is dvejetainio skaiciaus

            String lastEightDigitsA = "";
            String lastEightDigitsB = "";

            if ((A_binary.length() > 8) && (B_binary.length() > 8)) {
                lastEightDigitsA = A_binary.substring(A_binary.length() - 8);
                lastEightDigitsB = B_binary.substring(B_binary.length() - 8);
            } else {
                lastEightDigitsA = lastEightDigitsA;
                lastEightDigitsB = lastEightDigitsB;
            }

            // Galima patikrint kaip tikrinami sugeneruotu dvejetainiu skaiciu paskutiniai 8 skaitmenys
            // System.out.println("Comparing " + lastEightDigitsA + " and " + lastEightDigitsB + " : " + lastEightDigitsB.compareTo(lastEightDigitsA));

            if (lastEightDigitsB.compareTo(lastEightDigitsA) == 0) {
                times_matched++;
            } else {

            }
        }

        // Spausdinu atsakyma

        System.out.println("A generator parameter was " + A_parameter + "\n" +
                "B generator parameter was " + B_parameter + "\n" +
                "results matched - " + times_matched + " times");
    }
}
