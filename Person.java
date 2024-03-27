public abstract class Person {
    private String full_name;
    private int age;

    public Person(String full_name, int age) {
        this.full_name = full_name;
        this.age = age;
    }
    
    public String get_full_name() {
    	return full_name;
    }

    public int get_age() {
        return age;
    }

    public void set_full_name(String full_name) {
        this.full_name = full_name;
    }

    public void set_age(int age) {
        this.age = age;
    }

    
}