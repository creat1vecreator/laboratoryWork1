package com.company;

import java.io.PrintStream;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        getRandomArray(array, 100);
        printArray(array);
        printArray(indexesOf(array, max(array)));
        System.out.println("Минимум = " + min(array) + (indexesOf(array, min(array)).length > 1 ? ". Индексы минимумов: " : ". Индекс: "));
        printArray(indexesOf(array, min(array)));
        decreasedMax(array);
        increasedMin(array, min(array));
        System.out.println("Следующий максимум = " + nextMax(array, 1) + ", индекс" + (indexesOf(array, nextMax(array, 1)).length > 1 ? "ы: " : ": "));
        printArray(indexesOf(array, nextMax(array, 1)));
        System.out.println("Следующий минимум = " + nextMin(array, 1) + ", индекс" + (indexesOf(array, nextMin(array, 1)).length > 1 ? "ы: " : ": "));
        printArray(indexesOf(array, nextMin(array, 1)));
        System.out.println(("Следующий после следующего максимума (третий максимум) = " + nextMax(array, 2) + ", индекс" + (indexesOf(array, nextMax(array, 2)).length > 1 ? "ы: " : ": ")));
        printArray(indexesOf(array, nextMax(array, 2)));
        System.out.println("Следующий после следующего минимума (третий минимум) = " + nextMin(array, 2) + ", индекс" + (indexesOf(array, nextMin(array, 2)).length > 1 ? "ы: " : ": "));
        printArray(indexesOf(array, nextMin(array, 2)));

    }

    public static int getRandomValue(int range) {
        return new Random().nextInt(range);
    }


    public static void getRandomArray(int[] array, int range) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomValue(range);
        }
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int[] indexesOf(int[] input, int num) {
        int[] indexes = new int[input.length];
        int counter = 0;
        int position = 0;

        for (int i = 0; i < input.length; ++i) {
            if (input[i] == num) {
                indexes[position++] = i;
                counter++;
            }
        }

        int[] output = new int[counter];

        for (int i = 0; i < output.length; i++) {
            output[i] = indexes[i];
        }
        return output;
    }

    public static void decreasedMax(int[] array) {
        System.out.print("Индексы максимумов минус один: ");
        boolean isFound = false;
        int max = max(array);
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == max - 1) {
                isFound = true;
                System.out.print(i + " ");
            }

        }
        if (!isFound) {
            System.out.print("не найдены.");
        }
        System.out.println();
    }

    public static void increasedMin(int[] array, int min) {
        System.out.print("Индексы минимумов плюс один: ");
        boolean isFound = false;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == min + 1) {
                isFound = true;
                System.out.print(i + " ");
            }
        }

        if (!isFound) {
            System.out.print("не найдены.");
        }

        System.out.println();
    }

    public static int nextMax(int[] array, int next) {
        int[] sorted = new int[array.length];
        duplicateArray(array, sorted);

        for (int i = 0; i < next; ++i) {
            int currentMax = max(sorted);

            for (int j = 0; j < sorted.length; ++j) {
                sorted[j] = sorted[j] == currentMax ? min(sorted) : sorted[j];
            }
        }

        return max(sorted);
    }

    public static int nextMin(int[] array, int next) {
        int[] sorted = new int[array.length];
        duplicateArray(array, sorted);

        for (int i = 0; i < next; ++i) {
            int currentMin = min(sorted);

            for (int j = sorted.length - 1; j >= 0; --j) {
                sorted[j] = sorted[j] == currentMin ? max(sorted) : sorted[j];
            }
        }

        return min(sorted);
    }

    public static void duplicateArray(int[] from, int[] to) {
        for (int i = 0; i < from.length; ++i) {
            to[i] = from[i];
        }
    }

    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.println(number);
        }
    }
}


