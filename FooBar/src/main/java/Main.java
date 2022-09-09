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

        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Введите число n:  ");
        n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            String j;

            j = ((i % 3) + (i % 5) == 0) ? "FooBar" : (
                    ((i % 3 == 0)) ? "Foo" : (
                            ((i % 5 == 0)) ? "Bar" :
                                    String.valueOf(i)));

            System.out.println(j);
        }
    }

    public static void recurrent(int num, int i)
    {
        if(i<=num)
        {
            if((i % 3 != 0) && (i % 5 != 0))
            {
                System.out.print(i + " ");
            }
            else if((i % 3 == 0) && (i % 5 != 0))
            {
                System.out.print("Foo");
            }
            else if((i % 3 != 0) && (i % 5 == 0))
            {
                System.out.print("Bar");
            }
            else if((i % 3 == 0)&&(i % 5 == 0)) {
                System.out.print("FooBar");
            }
        }
        if(i > num) return;
        i++;
        recurrent(num, i);

    }
}
