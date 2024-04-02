import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
    
        Test action = new Test();
        boolean loop_var = true;
        while (loop_var) {
            display_options();
            String inp_user_choice = scanner.nextLine();

            // I Expect us getting an input that corespons to one or more methods
            // from Test class, this methods will use other methods from 
            // other classes inside of them, main.java cares about the flow not about implementation
            // { DO NOT MAKE AND/OR USE ANYTHING EXEPT FOR TEST OBJ(action) }
            switch (inp_user_choice) {
                case "a":
                    action.insert_event();
                    action.acknowledge("Create event successfully");
                    break;
                case "b":
                    action.delete_comp_event();
                    action.acknowledge("Removed completed events successfully");
                    break;
                case "c":
                    action.display_comp_event();
                    action.acknowledge("Got all completed events successfully");
                    break;
                case "d":
                    action.register();
                    action.acknowledge("Register to an event successfully");
                    break;
                case "e":
                    action.un_register();
                    action.acknowledge("Cancel a registration successfully");
                    break;

                case "f":
                    // we sould probably create a function that will clear the canseled_events.txt file content
                    // but it is optional
                    loop_var = false;
                    break;

                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
  public static void display_options(){
      System.out.println("<><><><><><><><><><><><><><><><>");
      System.out.println("Enter an option:");
      System.out.println("(a) Create a new event");
      System.out.println("(b) Remove all completed events");
      System.out.println("(c) Show all completed events");
      System.out.println("(d) Register to an event");
      System.out.println("(e) Cancel a registration");
      System.out.println("(f) Exit the programm");
      System.out.println("<><><><><><><><><><><><><><><><>");
  }
}

