import java.util.Scanner;
import java.util.Random;

public class LabTest {
    public static void main(String[] args) {
        System.out.println("Exercise 1:");
        birthCount();

        System.out.println("Exercise 2:");
        accumulate();

        System.out.println("Exercise 3:");
        bankSavings();

        System.out.println("Exercise 4:");
        randomMonth();

        System.out.println("Exercise 5:");
        tuition();

        System.out.println("Exercise 6:");
        triangle();
    }

    // Exercise 1
    static void birthCount()  {
        double popCount = 312032486.0;
        double seconds = 31536000.0;


        for (int i = 0; i < 5; ++i){
            popCount += (seconds / 7.0) + (seconds / 45.0);
            popCount -= seconds / 13.0;
            System.out.print("Year " + (i+1) + ": ");
            System.out.printf("%.3f", popCount);
            System.out.println();
        }
        System.out.println();
    }

    // Exercise 2
    static void accumulate() {
        Scanner read = new Scanner(System.in);
        int val = 1;
        while(val != 0) {
            do {
                if (val < 1 || val > 1000)
                    System.out.println("Invalid Number! Try again.");
                System.out.print("Enter a Number between 0 and 1000: ");
                val = read.nextInt();
            } while (val < 0 || val > 1000);

            int sum = val / 100 + val % 100 / 10 + val % 10;

            System.out.println("The sum of the Digits is : " + sum);
            System.out.println();
        }
    }

    // Exercise 3
    static void bankSavings() {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter monthly savings amount: ");
        int amnt = read.nextInt();
        float account = 0.0f;
        for(int i = 0; i < 6; ++i) {
            account += amnt;
            account *= 1.00417f;
        }
        System.out.println("After six months, the account value is: " + account);
        System.out.println();
    }

    // Exercise 4
    static void randomMonth() {
        Random rand = new Random();
        for(int i = 0; i < 5; ++i) {
            int num = rand.nextInt((12 - 1) + 1) + 1;

            switch (num) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("March");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
                    break;
            }
        }
        System.out.println();
    }

    // Exercise 5
    static void tuition() {
        float tuition = 10000.0f;
        for (int i = 0; i < 10; ++i){
            tuition *= 1.05f;
        }
        System.out.println("The Tuition after 10 years is going to be: $"+ tuition);

        float total = 0.0f;
        for (int i = 0; i < 4; ++i){
            tuition *= 1.05f;
            total += tuition;
        }
        System.out.println("The cost of 4 years of tuition after the 10th year : $"+ total);
        System.out.println();
    }

    // Exercise 6
    static void triangle() {
        int numLoops = 8;
        int space = 0;

        for(int i = 0; i <= numLoops; ++i)
        {
            space = (((numLoops - i) / 4) * 16) + (((numLoops - i) % 4) * 4 + 3);
            String format = "%" + space + ".0f";

            for(int j = 0; j < i; ++j)
            {
                double power = Math.pow(2, j);

                if(power < 10)
                    System.out.print("   ");
                else if (power < 100)
                    System.out.print("  ");
                else if (power < 1000)
                    System.out.print(" ");

                if(j == 0)
                    System.out.printf(format, power);
                else
                    System.out.printf("%.0f", power);
            }

            for(int k = i - 1; k > 0; --k)
            {
                double power = Math.pow(2, k - 1);

                if (power < 10)
                    System.out.print("   ");
                else if (power < 100)
                    System.out.print("  ");
                else if (power < 1000)
                    System.out.print(" ");

                System.out.printf("%.0f", power);
            }
            System.out.println();
        }
    }
}
