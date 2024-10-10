package org.homeworkqa4;
// Создать класс c информацией о сотруднике (имя: строка, должность:строка, год начала работы: целое)

import java.util.ArrayList;

// Создать класс c информацией о компании (название: строка, список сотрудников)
// В классе компании сделать два метода - добавить сотрудника (add) и удалить сотрудника (remove)
public class ClassCompany {
    // public static void main(String[] args) {
// Создать класс c информацией о сотруднике (имя: строка, должность:строка,
// год начала работы: целое)

// Создать класс c информацией о компании (название: строка, список сотрудников

// В классе компании сделать два метода - добавить сотрудника (add)
// и удалить сотрудника (remove)
//
//        public static class Employee {
//
//        }
//
//        public static class Company {
//
//        }
//
//        public static void main(String[] args) {
    //  Company c1 = new Company ("Happy Train");
    //  Company c2 = new Company ("Bubbles");

//        c1.add(new Employee("John", "Dev", 2000));
//        c1.add(new Employee("Bob", "QA", 2015));
//        c1.add(new Employee("Julia", "Dev", 2002));
//        c1.add(new Employee("Liz", "HR", 2007));

    public static void printEmployees(ArrayList<Employee> listEmployee) {
        for (Employee e : listEmployee) {
            System.out.println(e.name + "(" + e.position + ") : " + e.year);
        }
    }

    public static class Employee {
        String name;
        String position;
        int year;
        double salary; // Добавляем поле salary


        public Employee(String name, String position, int year, int i) {
            this.name = name;
            this.position = position;
            this.year = year;
            this.salary = getSalary();

        }

        public double getSalary() {
            return salary;//getter
        }

        public void setSalary(double salary) {
            this.salary = salary; //setter
        }
    }

    public static class Company {
        String name;
        ArrayList<Employee> employees = new ArrayList<>();

        public Company(String name) {
            this.name = name;
        }

        public void add(Employee e) {
            employees.add(e);
        }

        public Employee remove(String name) {
            for (int i = 0; i < employees.size(); i++) {
                Employee e = employees.get(i);
                if (name.equals(e.name)) {
                    employees.remove(i);
                    return e;
                }
            }
            return null;
        }

        public void printEmployees() {
            for (Employee e : employees) {
                System.out.println(e.name + "(" + e.position + ") : " + e.year);
            }
        }

        public void printEmployees(String title) {
            System.out.println(title);
            printEmployees();
        }

        public ArrayList<Employee> findByPosition(String position) {
            ArrayList<Employee> result = new ArrayList<>();


            //

            return result;
        }

        public ArrayList<Employee> findHiredAfter(int year) {
            ArrayList<Employee> result = new ArrayList<>();


            //

            return result;
        }

        // Метод для расчета общей зарплаты всех сотрудников
        public double salaryTotal() {
            double total = 0;
            for (Employee e : employees) {
                total += e.getSalary();
            }
            return total;
        }

        // Метод для поиска сотрудников с зарплатой выше, чем у переданного сотрудника
        public ArrayList<Employee> salaryAbove(Employee employee) {
            ArrayList<Employee> result = new ArrayList<>();
            double targetSalary = employee.getSalary();
            for (Employee e : employees) {
                if (e.getSalary() > targetSalary) {
                    result.add(e);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Company c1 = new Company("Happy Train");
        Company c2 = new Company("Bubbles");

        c1.add(new Employee("John", "Dev", 2000, 75000));
        c1.add(new Employee("Bob", "QA", 2015, 75000));
        c1.add(new Employee("Julia", "Dev", 2002, 75000));
        c1.add(new Employee("Liz", "HR", 2007, 75000));

        c1.printEmployees("выводит список сотрудников на экран");

        // увольняем "Julia"
        c1.remove("Julia");
        c1.printEmployees("выводит список сотрудников на экран без Julia");

        // берем на работу Rita
        c1.add(new Employee("Rita", "CTO", 2024, 75000));
        c1.printEmployees("выводит список сотрудников на экран  с Rita");

//        Company[] companies = new Company[]{};

        ArrayList<Employee> devs = c1.findByPosition("Dev");
        printEmployees(devs);
        ArrayList<Employee> after2005 = c1.findHiredAfter(2005);
        printEmployees(after2005);

        // Find employees by position "Dev"
        ArrayList<Employee> dev = c1.findByPosition("Dev");
        printEmployees(devs);

        // Find employees hired after 2005
//        ArrayList<Employee> after2005 = c1.findHiredAfter(2005);
//        printEmployees(after2005);
        // Выводим общую зарплату всех сотрудников
        double totalSalary = c1.salaryTotal();
        System.out.println("Общая зарплата всех сотрудников: $" + totalSalary);
        // Поиск сотрудников с зарплатой выше, чем у Bob
        Employee bob = new Employee("Bob", "QA", 2015, 75000); // создаем сотрудника Bob
        ArrayList<Employee> higherSalaryEmployees = c1.salaryAbove(bob);
        System.out.println("Сотрудники с зарплатой выше, чем у Bob:");
        printEmployees(higherSalaryEmployees);
    }
}


