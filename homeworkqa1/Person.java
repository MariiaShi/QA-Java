package homeworkqa1;

public class Person implements Printable {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    @Override
    public String printableValue() {
        return name + ":" + birthYear;
    }
}

