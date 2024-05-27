package Week5.İçerik1;

import java.util.Arrays;
import java.util.Scanner;

public class TryCatchBlogu {
    public static void main(String[] args) {


        // MyArrayClass örneği oluşturma
        MyArrayClass myArrayClass = new MyArrayClass();

        // Array ve index değerlerini yazdırma
        System.out.println("Initial index: " + myArrayClass.getIndex());
        System.out.print("Array: ");
        for (int value : myArrayClass.getArray()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // set metodunu test etme
        try {
            int valueAtIndex = myArrayClass.set(3);
            System.out.println("Value at index 3: " + valueAtIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        // Geçersiz bir indeksle set metodunu test etme
        try {
            int valueAtInvalidIndex = myArrayClass.set(13);  // Geçersiz indeks
            System.out.println("Value at index 11: " + valueAtInvalidIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }

}

