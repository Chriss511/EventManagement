public class Participant extends Person {
    private String email_address;
    private int phone_number;
    private String registration_date;
    private String payment_method;

    
    public Participant(String email_address, int phone_number, String payment_method) {
        this.full_name = full_name;
        this.age = age;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.payment_method = payment_method;
    }

    public void set_email(String email_address) {
    }

    public void set_phone(int phone_number) {
    }

    public void set_date() {
    }

    public void set_payment(String payment_method) {
    }

    public String get_email() {
        return null;
    }

    public int get_phone() {
        return 0;
    }

    public String get_date() {
        return null;
    }

    public String get_payment() {
        return null;
    }
}

