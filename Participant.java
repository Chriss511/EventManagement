public class Participant extends Person {
    private String email_address;
    private int phone_number;
    private String registration_date;
    private String payment_method;

    public Participant(String full_name, int age, String email_address, int phone_number, String payment_method) {
        super(full_name, age);
        // Constructor
    }

    public void set_email(String email_address) {
        // set_email method
    }

    public void set_phone(int phone_number) {
        // set_phone method
    }

    public void set_date() {
        // set_date method
    }

    public void set_payment(String payment_method) {
        // set_payment method
    }

    public String get_email() {
        // get_email method
        return null;
    }

    public int get_phone() {
        // get_phone method
        return 0;
    }

    public String get_date() {
        // get_date method
        return null;
    }

    public String get_payment() {
        // get_payment method
        return null;
    }
}

