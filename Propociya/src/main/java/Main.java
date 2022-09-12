import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String DATA = "1024 byte = 1 kilobyte \n" +
            "\n" +
            "2 bar = 12 ring \n" +
            "\n" +
            "16.8 ring = 2 pyramid \n" +
            "\n" +
            "4 hare = 1 cat \n" +
            "\n" +
            "5 cat = 0.5 giraffe \n" +
            "\n" +
            "1 byte = 8 bit \n" +
            "\n" +
            "15 ring = 2.5 bar\n" +
            "1 pyramid = ? bar\n" +
            "1 giraffe = ? hare\n" +
            "0.5 byte = ? cat\n" +
            "2 kilobyte = ? bit";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();


        Giraffe giraffe = new Giraffe();
        Pyramid pyramid = new Pyramid();
        Byte customByte = new Byte();

        try {

            Scanner sc2 = new Scanner((System.in));
            System.out.println("How many piramids do you have transfer in bars?");
            double pyr = sc2.nextDouble();

            Scanner sc1 = new Scanner((System.in));
            System.out.println("How many giraffes do you have transfer in hares?");
            double gir = sc1.nextDouble();

            Scanner sc3 = new Scanner((System.in));
            System.out.println("How many cats do you have transfer in bytes?");
            double cats = sc3.nextDouble();

            Scanner sc = new Scanner((System.in));
            System.out.println("How many kilobytes do you have transfer in bits?");
            double kilo = sc.nextDouble();

            DecimalFormat df = new DecimalFormat("#.###");

            System.out.println(pyr + " pyramid = " + df.format(pyramid.mathPyramid(pyr)) + " bar\n" +
                    gir + " giraffe = " + df.format(giraffe.mathGiraffe(gir)) + " hare\n" +
                    "Conversion not possible.\n" +
                    kilo + " kilobyte = " + df.format(customByte.mathByte(kilo)) + " bit");
        } catch (InputMismatchException e) {
            System.out.println("Введите данные!");
        }
    }
}
