package org.example.homeworkqa7;

public class MyLinkedList<E> {

    // Head -> null
    // Head -> "Olga"|next -> null
    // Head -> "Irina"|next -> "Olga"|next -> null
    // .....
    // Head -> "Mikhail"|next-> ..... "Irina"|next -> "Olga"|next -> null

    private static class Node<E> {
        E payload;
        Node<E> next;

        public Node(E payload, Node<E> next) {
            this.payload = payload; // -->  -->  -->
            this.next = next;       // main push Node()
        }

        public boolean isLast() {
            return next == null;
        }
    }

    private Node<E> head;

    private int count;

    public MyLinkedList() {
        this.head = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public void push(E v) {
        Node<E> newNode = new Node<E>(v, head); // -->   -->
        head = newNode;                         // main  push
        count++;
    }

    public E pull() {
        if (head != null) {
            Node<E> current = head;
            head = current.next;
            count--;
            return current.payload;
        } else {
            return null;
        }
    }

    void clean() {
        head = null;
        count = 0;
    }

    //
//  public E look() {
//    return "";
//  }

    // printAll

    boolean contains(E val) {
//    System.out.println("\n\nИщем: " + val);

        Node currentNode = head;

//    System.out.println("currentNode перед циклом: " + currentNode);

        // Head -> "Mikhail"|next -> "Liza"|next -> "Irina"|next -> "Olga"|next -> null
        while (currentNode != null) {
//      System.out.println("\ncurrentNode значение: " + currentNode.payload);
//      System.out.println("currentNode следующий внутри цикла: " + currentNode.next);
            if (currentNode.payload.equals(val)) {
//        System.out.println("Нашли, выходим с true");
                return true;
            }
//      System.out.println("Не нашли, идём дальше с " + currentNode.next);
            currentNode = currentNode.next;
        }
//    System.out.println("Не нашли, выходим с false");
        return false;
    }

    // Head -> "Mikhail"|next -> "Liza"|next -> "Irina"|next -> "Olga"|next -> null
    boolean containsRecurive(E val) {         // -->   -->
        System.out.println("\n\nЗаходим с " + head); // main  containsRecurive(1)
        return containsRecurive(head, val, "--");
    }

    private boolean containsRecurive(Node<E> node, E val, String prefix) {
        // -->   -->                 -->                 -->
        // main  containsRecurive(1) containsRecurive(2) containsRecurive(2)
        System.out.println(prefix + ">> containsRecurive(): Заходим с " + node + ". Ищем " + val);
        if (node == null) {
            System.out.println(prefix + "> Зашли с null - выходим с false");
            return false;
        } else if (node.payload.equals(val)){
            System.out.println(prefix + "> Нашли "+ node.payload + " выходим с true");
            return true;
        } else {
            System.out.println(prefix + "> Не нашли - продолжаем с " + node.next);
            // на 3м уровне
            boolean result = containsRecurive(node.next, val, "--" + prefix);
            System.out.println(prefix + "> Вышли из рек. вызова со значением " + result);
            return result;
        }
    }

    @Override
    public String toString() {
        Node<E> currentNode = head;
        String s = "";
        while (currentNode != null) {
            if (!s.isEmpty()) {
                s += ", ";
            }
            s = s + currentNode.payload.toString();
            currentNode = currentNode.next;
        }
        return "[" + s + "]";
    }

    // Head -> "Mikhail"|next -> "Liza"|next *> "Irina"|next -> "Olga"|next -> null
    // "Daniel" -> 2
    // Head -> "Mikhail"|next -> "Liza"|next +> "Daniel"|next *> "Irina"|next -> "Olga"|next -> null
    boolean insertAt(int at, E val) {
        if (at < 0) {
            return false;
        } if (at == 0) {
            push(val);
            return true;
        } else {
            Node<E> currentNode = head;
            int i = 0;

            while(currentNode != null) {
                if (i == at-1) {
                    Node<E> insertedNode = new Node<>(val, currentNode.next);
                    currentNode.next = insertedNode;
                    return true;
                }
                i++;
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    // HW
    // Вставка после элемента с указанным значением
    boolean insertAfter(E afterValue, E insertedValue) {
        Node<E> currentNode = head;

        while (currentNode != null) {
            if (currentNode.payload.equals(afterValue)) {
                Node<E> newNode = new Node<>(insertedValue, currentNode.next);
                currentNode.next = newNode;
                count++;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    // HW
    // Удаление по индексу
    boolean removeAt(int at) {
        if (at < 0 || at >= count) {
            return false;
        }

        if (at == 0) {
            head = head.next;
            count--;
            return true;
        }

        Node<E> currentNode = head;
        for (int i = 0; i < at - 1; i++) {
            currentNode = currentNode.next;
        }

        // currentNode сейчас указывает на элемент перед удаляемым
        currentNode.next = currentNode.next.next;
        count--;
        return true;
    }

    // HW
    // Удаление первого найденного элемента по значению
    boolean remove(E removedValue) {
        if (head == null) {
            return false;
        }

        if (head.payload.equals(removedValue)) {
            head = head.next;
            count--;
            return true;
        }

        Node<E> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.payload.equals(removedValue)) {
                currentNode.next = currentNode.next.next;
                count--;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    // HW+
    // Удаление всех элементов с заданным значением
    int removeAll(E removedValue) {
        int removedCount = 0;

        // Удаляем все совпадения в начале списка (head)
        while (head != null && head.payload.equals(removedValue)) {
            head = head.next;
            count--;
            removedCount++;
        }

        // Удаляем совпадения внутри списка
        Node<E> currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.payload.equals(removedValue)) {
                currentNode.next = currentNode.next.next;
                count--;
                removedCount++;
            } else {
                currentNode = currentNode.next;
            }
        }

        return removedCount;
    }
}
