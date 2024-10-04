package org.example.homeworksqa.homeworkqa3;
//Реализовать метод insertSorted, который принимает на вход отсортированный по
// возрастанию массив ArrayList и целое число типа Integer.
//Метод должен вставить переданное число в нужное место массива,
// чтобы массив остался отсортированным по возрастанию элементов.
//Вставки элемента на нужную позицию: arr.add(index, value)
// Размер массива: arr.size() Значение элемента на нужной позиции: arr.get(index)
//Пример 1: исходный массив: [5, 9, 17, 18, 23],
// вставляем число 14, результат [5, 9, 14, 17, 18, 23]
//Пример 2: исходный массив: [5, 9, 17, 18, 23],
// вставляем число 3, результат [3, 5, 9, 17, 18, 23]
//Пример 3: исходный массив: [], вставляем число 7, результат [7]

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayClassList {

    public static void insertSorted(ArrayList<Integer> arr, Integer inserted) {
        //        arr.add(index, value)
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > inserted) {
                arr.add(i, inserted);
                break;
            }
        }

    }

    public static ArrayList<Integer> convertToSorted(ArrayList<Integer> unsorted) {
        ArrayList<Integer> sorted = new ArrayList<>();
        int N = unsorted.size();
        int N2 = unsorted.size();
        for (int i = 0; i < N; i++) {
            int min = unsorted.get(0);
            int index = i;
            for (int j = i + 1; j < N2; j++) {
                if(unsorted.get(j) < min){
                    min = unsorted.get(j);
                    index = j;
                }
            }
            unsorted.remove(index);
            sorted.add(min);
            N2 -=1;
        }


        return sorted;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 9, 17, 18, 23));

        System.out.println("Source array:           " + arr);

        insertSorted(arr, 14);
        System.out.println("Array with inserted 14: " + arr);
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(23, 18, 17, 9, 5));
        System.out.println(convertToSorted(arr));
    }
}
public static ArrayList<Integer> convertToSorted(ArrayList<Integer> arr){
    ArrayList<Integer> sorted = new ArrayList<>(); // create sorted ArrayList
    int N = arr.size();                           // get arr size

    for(int i = 0; i < N; i++){  // find min element and index of min element
        int min = arr.get(0);
        int index = 0;
        for(int j = 0; j < arr.size(); j++){
            if(arr.get(j) < min){
                min = arr.get(j);
                index = j;
            }
        }
        // add min element in sorted ArrayList
        sorted.add(min);
        // remove min element from arr
        arr.remove(index);
    }
    return sorted;
}

public void main() {
}






