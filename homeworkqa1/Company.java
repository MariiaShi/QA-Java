package homeworkqa1;

public class Company extends Printable {
    private String companyName;
    private String city;

    public Company(String companyName, String city) {
        this.companyName = companyName;
        this.city = city;
    }

    @Override
    public String printableValue() {
        return companyName + ". " + city;
    }
}

