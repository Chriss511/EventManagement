import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	

        Scanner scanner = new Scanner(System.in);
        
    
        Test action = new Test();
        boolean loop_var = true;
        while (loop_var) {
            display_options();
            String inp_user_choice = scanner.nextLine();

            // I Expect us getting an input that corresponds to one or more methods
            // from Test class, this methods will use other methods from 
            // other classes inside of them, main.java cares about the flow not about implementation
            // { DO NOT MAKE AND/OR USE ANYTHING EXEPT FOR TEST OBJ(action) }
            switch (inp_user_choice) {
                case "a":
                    action.insert_event();           
                    break;
                case "b":
                    if (!action.delete_comp_event()) {
                 
                    action.acknowledge("Removed completed events successfully");
                    }else {
                    	action.acknowledge("There are no completed events to remove.");
                    }
                    break;
                case "c":
                    action.display_comp_event();
                    action.acknowledge("Got all completed events successfully.");
                    break;
                case "d":
                    action.register();
                    break;
                case "e":                	
                    action.un_register();                                       
                    break;

                case "f":
                    // we sould probably create a function that will clear the canseled_events.txt file content
                    // but it is optional
                    loop_var = false;
                    System.out.println("Good bye.");
                    break;

                default:
                    System.out.println("\nWrong input");
                    break;
            }
        }
    }
  public static void display_options(){
      System.out.println("\n<><><><><><><><><><><><><><><><><>");
      System.out.println("<><><>EVENT MANAGEMENT SYSTEM<><><>");
      System.out.println("<><><><><><><><><><><><><><><><><>");
      System.out.println("(a) Create a new event");
      System.out.println("(b) Remove past Events from the BST");
      System.out.println("(c) Show all past events that where removed from BST by option (b)");
      System.out.println("(d) Register to a future event");
      System.out.println("(e) Cancel a registration");
      System.out.println("(f) Exit the programm");
      System.out.println("<><><><><><><><><><><><><><><><>");
      System.out.print("\nEnter selection: ");
  }
}

