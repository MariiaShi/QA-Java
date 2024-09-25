package org.example.homeworksqa.homeworkqa2;

//Написать метод, который принимает на
// вход массив целых чисел и возвращает разницу
// между суммой элементов, находящихся под чётными индексами и
// суммой элементов, находящихся под нечётными индексами.
//
//Например, для массива [4, 11, 5, -6, 8]
// результат будет (4 + 5 + 8) - (11 + (-6)) = 12
//
//Проверить работу метода для массивов чётного и
// нечётного размера, а также для массивов размера 1 и
// пустого массива. Для пустого должен возвращаться
// результат 0.
public class ClassArr {
    public static void main(String[] args) {
        int[] array = {4, 11, 5, -6, 8};
        int[] array1 = {4};
        int[] array0 = {};


        System.out.println(sumDifference(array));
        System.out.println(sumDifference(array1));
        System.out.println(sumDifference(array0));
    }

    public static int sumDifference(int[] array) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }
        return sumEven - sumOdd;
    }
}
