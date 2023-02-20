package Lesson_1;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class Main {

    //    public static void main(String[] args) {
//        String name;
//        Console console = System.console();
//        name = console.readLine("Enter name: ");
//        System.out.println("Hello " + name);
//    }
//psvm
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(in);
        System.out.println("Enter the amount of numbers: ");
        if (!scanner.hasNextInt())
        {
            System.out.println("Entered figure is not an integer!");
        }
        int numbersAmount = scanner.nextInt();
//        System.out.println("Enter " + numbersAmount + " numbers:");
        int[] arr = new int[numbersAmount];
        System.out.print("Entered array: ");
//        for (int i = 0; i < numbersAmount; i++) {
//            Integer number = scanner.nextInt();
//            arr[i] = number;
//            array = array + number + " ";
//        }
        for (int i = 0; i < numbersAmount; i++) {
            int number = 1 + Math.abs(rnd.nextInt()) % (100 - 1 + 1);
            arr[i] = number;
            System.out.print(arr[i]+" ");
        }
        int min = arr[0];
        int max = arr[0];
        double avg = 0;
        for (int i = 0; i < numbersAmount; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
            avg += arr[i];
        }
//        for (int i=0; i < numbersAmount; i++)  {
//            for (int j=0; j < numbersAmount-1-i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int tempmax = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = tempmax;
//                }
//            }
//        }
        int tempFigure = 0;
        int leftside = 0;
        int rightside = numbersAmount-1;
        do {
            for (int i = leftside; i < rightside; i++) {
                if (arr[i] > arr[i + 1]) {
                    tempFigure = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tempFigure;
                }
            }
            rightside--;
            for (int j = rightside; j > leftside; j--) {
                if (arr[j] < arr[j - 1]) {
                    tempFigure = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tempFigure;
                }
            }
            leftside++;
        } while (leftside<rightside);

        avg = avg / numbersAmount;
        String stringArr = Arrays.toString(arr);

        System.out.println();
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Average: " + avg);
        System.out.println("Modified array: " + stringArr);


    }
}



