package org.homeworkqa4;
// Вопросы по пройденному
//
//Вопросы по синтаксису (на память, самостоятельно)
//
//1. Напишите создание переменной arr, которая инициализируется массивом целых чисел 5, 7, -3
//
//2. Напишите цикл с пустым телом/блоком, который итерирует по массиву arr из вопроса 1
//
//3. Добавьте в тело цикла вывод на печать текущего элемента из массива arr - System.out.println();
//
//4. Измените тело цикла, чтобы на печать выводились только положительные числа
//
//5. Факультативно. Посчитайте количество положительных значений из массива arr и выведете их количество после цикла.
//
//Класс-заготовка для вопросов QuestionsApp. Код можно писать в методе main.
//
//
//package java_qa.lec_04;
//
//public class QuestionsApp {
//
//  public static void main(String[] args) {
//    System.out.println();
//  }
//}

public class ClassReview {
    public static void main(String[] args) {
        int[] arr = {5, 7, -3};
        int count = 0;

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i);
//        }
        //через итератор все числа, а не индекс
        for (int num : arr) {
            if (num > 0) {
                count++;
                System.out.println(num);
            }

        }
        System.out.println("Количество положительных чисел: " + count);
    }
}
