import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Test {
    private Event[] temp_completed;
    private String temp_file_text;
    Generic_BST event_BST = new Generic_BST();

    // I Expect it to be used in main.java when inp_user_choice is = a 
    // it is going to create an event obj get it's key and insert it 
    // into an BST(event_BST)
    // {> ALEX <} :made: 
    public void insert_event() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("<><><><><><><><><><><><><><><><>");
        System.out.println("Event information:");
        System.out.println("Name:");
        String inp_event_name = scanner.nextLine();
        System.out.println("Date (YYYY-MM-DD):");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String inp_event_date = scanner.nextLine();
        System.out.println("Time:");
        int inp_event_time = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Location:");
        String inp_event_loca = scanner.nextLine();
        System.out.println("Max capacity:");
        int inp_event_cap = scanner.nextInt();
        scanner.nextLine();
        System.out.println("<><><><><><><><><><><><><><><><>");
        try {
            LocalDate inp_event_date_pars = LocalDate.parse(inp_event_date, formatter);
            Event event = new Event(inp_event_name, inp_event_date_pars, inp_event_time, inp_event_loca, inp_event_cap);
            //String event_key = event.get_event_name();

            event_BST.insert(event);  
            //event_BST.display(); // for debging
            
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
        }
    }

    // I Expect it to be used in main.java when inp_user_choice is = b 
    // it is going to use check_competed_BST() from the event_BST, <in sequence uml
    // the loop and stuff is describing what check_competed_BST() is going to have insidet>   
    // it will retutn a sting that will be consists of information of evets
    // that is than going to be used by write_file_comp()
    // {> ALEX <}
    public String delete_comp_event() {
      
      return "test";
    }

    // I Expect it to be used in main.java when inp_user_choice is = b 
    // it will interact with the file [canseled_events.txt] by writting 
    // it's input into it
    // {> ALEX <}
    public void write_file_comp(String text) {
    }

    // I Expect it to be used in main.java when inp_user_choice is = c 
    // it will just print the contense of the canseled_events.txt file 
    // {> ALEX <} :made: 
    public void display_comp_event() {
        String filePath = "canceled_events.txt";
        try {
            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read each line from the file and print it
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        bufferedReader.close();
        } catch (IOException e) {
            // Handle file reading errors
            e.printStackTrace();
        }
    }

    // I Expect it to be used in main.java when inp_user_choice is = d 
    // it will use display_BST() to output all keys(names) for user to choose from
    // ask a uset to choose that using terminal input as input for search_BST()
    // that will return a poiter to node(noiter so that we would be about to mutate it here)
    // than it will run add_to_participart_list() <in sequence uml all the stuff after 
    // is related to implementation of add_to_participart_list() >
    // it may be need to look like this register(inp_user_name, inp_user_age)
    // because we somehow need to move that imput values from main func to add_to_participart_list
    // {> Chris <}
    public void register() {
    }

    // I Expect it to be used in main.java when inp_user_choice is = e 
    // it will use display_BST() to output all keys(names) for user to choose from
    // ask a uset to choose that using terminal input as input for search_BST()
    // that will return a poiter to node, than it will run remove_from_participation_list()
    // and add_to_cancellation_list() <all the other stuff you see in sequence uml
    // is related for implementation of remove_from_participation_list 
    // and add_to_participart_list methods>
    // {> Chris <}
    public void un_register() {
    }

    // I Expect this to be used as a conformation that everything executed
    // it will ask to press enter(to let user to read the output)
    // and add a bunch of space(for readibility)
    public void acknowledge(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        System.out.println(message);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.print("\n\n\n\n\n\n");
    }
}

