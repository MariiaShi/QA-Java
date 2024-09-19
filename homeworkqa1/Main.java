package homeworkqa1;

public class Main {
    public static void main(String[] args) {

        Printable[] printables = {
                new Person("John Matthew", 1995),
                new Person("Alice Johnson", 1987),
                new Company("Hewlett Packard", "Boston"),
                new Company("Google", "Mountain View")
        };


        for (Printable printable : printables) {
            System.out.println(printable.printableValue());
        }
    }
}
