import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
     first();
    }

    public static void first() {
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Введите число n:  ");
        n = scan.nextInt();
        if (n <= 0) {
            System.out.println("Вы ввели неккоректное число!");
        } else {
            for (int i = 0; i < n; i++) {
                if ((i % 3) == 0 && (i % 5) != 0) {
                    System.out.println("Foo");
                }
                if ((i % 3) != 0 && (i % 5) == 0) {
                    System.out.println("Bar");
                }
                if ((i % 3) == 0 && (i % 5) == 0) {
                    System.out.println("FooBar");
                } else if ((i % 3) != 0 && (i % 5) != 0) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void second(){

    }
}
