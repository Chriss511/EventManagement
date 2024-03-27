import java.util.Scanner;

public class Test {
    private Event[] temp_completed;
    private String temp_file_text;

    // I Expect it to be used 
    public void insert_event() {
    }

    public String delete_comp_event() {
    }

    public void display_comp_event() {
    }

    public void register() {
    }

    public void un_register() {
    }

    public void write_file_comp(String text) {
    }

    // I expect this to be used as a conformation that everything executed
    // it will ask to press enter(to let user to read the output)
    // and add a bunch of space(for readibility)
    public void acknowledge(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.print("\n\n\n\n\n\n");
    }
}

