import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Test {
    private String[] temp_completed = new String[15];
    private StringBuilder temp_file_text = new StringBuilder();
    Generic_BST event_BST = new Generic_BST();

    // I Expect it to be used in main.java when inp_user_choice is = a 
    // it is going to create an event obj get it's key and insert it 
    // into an BST(event_BST)
    // {> ALEX <} :made: 
    public void insert_event() {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n<><><><><><><><><><><><><><><><>");
        
        System.out.println("Creating event ");
        
        System.out.print("\nName of the event: ");       
        String inp_event_name = scanner.nextLine();
        
        while (inp_event_name.isEmpty()) {
            System.out.println("You must enter at least one character.");
            System.out.print("Name of the event: ");
            inp_event_name = scanner.nextLine();
        }
        
        System.out.print("\nDate (YYYY-MM-DD): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String inp_event_date = scanner.nextLine();


        while (inp_event_date.length() != 10) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            System.out.print("Date (YYYY-MM-DD): ");
            inp_event_date = scanner.nextLine();
        }
        
        String inp_event_time;
        while (true) {
            System.out.print("\nTime (hh:mm): ");
            inp_event_time = scanner.nextLine();
            if (isValidTimeFormat(inp_event_time)) {
                break;
            } else {
                System.out.println("Invalid time format. Please enter the time in the format hh:mm.");
            }
        }
        
        System.out.print("\nLocation: ");
        String inp_event_loca = scanner.nextLine();
        
        int inp_event_cap;
        while (true) {
            System.out.print("\nMax capacity: ");
            String capacityInput = scanner.nextLine();
            try {
                inp_event_cap = Integer.parseInt(capacityInput);
                if (inp_event_cap > 0) {
                    break;
                } else {
                    System.out.println("Invalid capacity. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        
        //scanner.nextLine();
        
        System.out.println("<><><><><><><><><><><><><><><><>");

        
        try {
            LocalDate inp_event_date_pars = LocalDate.parse(inp_event_date, formatter);
            Event event = new Event(inp_event_name, inp_event_date_pars, inp_event_time, inp_event_loca, inp_event_cap);
            //String event_key = event.get_event_name();
            
            event.update_capacity();
            event_BST.insert(event);  
            //event_BST.display(); // for debug
            
            System.out.println("\nEvent creation successfull.");
            
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
        }
    }
    
    private boolean isValidTimeFormat(String time) {
        if (time.length() != 5) {
            return false; // "hh:mm" means exactly 5 characters
        }
       
        String hoursStr = time.substring(0, 2);
        String minutesStr = time.substring(3, 5);
        
        if (!hoursStr.matches("[0-9]+") || !minutesStr.matches("[0-9]+")) {
            return false;
        }
        
        int hours = Integer.parseInt(hoursStr);
        int minutes = Integer.parseInt(minutesStr);
        
        return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
    }

    // I Expect it to be used in main.java when inp_user_choice is = b 
    // it is going to use check_competed_BST() from the event_BST, <in sequence uml
    // the loop and stuff is describing what check_competed_BST() is going to have insidet>   
    // it will retutn a sting that will be consists of information of evets
    // that is than going to be used by write_file_comp()
    // {> ALEX <} :made:

    
    public boolean delete_comp_event() {
        Event[] comp_event_list = event_BST.check_completed_BST();
        if (comp_event_list.length > 0 && comp_event_list[0] != null) {
            for (int i = 0; i < comp_event_list.length; i++) {
                this.temp_completed[i] = comp_event_list[i].get_event_info_list();
            }
            	
            for (String e: this.temp_completed) {
                if (e != null) {
                    this.temp_file_text.append(e);
                }
            }

            String file_text = this.temp_file_text.toString();
            write_file_comp(file_text);         
        	return false;        	
        } else {
        	return true;
        }
    }

    // I Expect it to be used in main.java when inp_user_choice is = b 
    // it will interact with the file [canseled_events.txt] by writting 
    // it's input into it
    // {> ALEX <} :made:
    private void write_file_comp(String file_text) {
        String fileName = "canceled_events.txt";
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            
            writer.write(file_text);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    // I Expect it to be used in main.java when inp_user_choice is = c 
    // it will just print the contense of the canseled_events.txt file 
    // {> ALEX <} :made: 
    public void display_comp_event() {
        String filePath = "canceled_events.txt";
        try {
            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        bufferedReader.close();
        } catch (IOException e) {
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
    // {> Chris <} :TODO:
    // TODO add check for Person so that there would be no duplicate,
    //show current list of participants and if the 
    //participants email was already in the list the
    // it has to restart the register process, if the participant is not in the list then the register can proceed succesfully
    
    
    /*trying to implement to check for duplicate participants when the user registers
     * 
     * 
    boolean regFailFlag = false;
    public boolean register() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n<><><><><><><><><><><><><><><><>");
            System.out.println("Event(s) available:");
            System.out.println("\n");

            event_BST.display();

            System.out.print("\nEnter event: ");

            String inp_event = scanner.nextLine();
            if (event_BST.search(inp_event) != null) {
                Event choice_event = event_BST.search(inp_event);

                // Display current list of participants
                System.out.println("\nCurrent participants:");
                choice_event.displayParticipants();

                System.out.println("\nEnter your personal information");

                System.out.print("\nFull name:");
                String inp_user_name = scanner.nextLine();

                // Check if participant's email already exists in the list
                String inp_user_addr;
                while (true) {
                    System.out.print("\nEmail address:");
                    inp_user_addr = scanner.nextLine();
                    if (Event.isParticipantExist(inp_user_addr)) {
                        System.out.println("Participant with this email already exists. Please try again.");
                    } else {
                        break;
                    }
                }

                // Continue with the rest of the registration process
                // ...

            } else {
                regFailFlag = true;
                System.out.println("\nWrong input. Please try again.");
                return regFailFlag; // by adding a brake here at least the user is able to back when the input is null
            }
        }
    }*/
    
    
   
    public void register() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("\n<><><><><><><><><><><><><><><><>");
            System.out.println("Event(s) available:");
            
            event_BST.display();
            
            System.out.print("\nEnter event: ");
            
            String inp_event = scanner.nextLine();
            if (event_BST.search(inp_event) != null) {
            	
                Event choice_event = event_BST.search(inp_event);
             
                System.out.println("\nEnter your personal information");             
                System.out.print("\nFull name:");
                String inp_user_name = scanner.nextLine();
                             
                int inp_user_age;
                while (true) {
                    System.out.print("\nAge:");
                    String ageInput = scanner.nextLine();
                    try {
                        inp_user_age = Integer.parseInt(ageInput);
                        if (inp_user_age >= 1 && inp_user_age <= 100) {
                            break;
                        } else {
                            System.out.println("Invalid age. Please enter a number between 1 and 100.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter numbers only.");
                    }
                }
                                  
                //scanner.nextLine(); // Consume newline left-over
                
                String inp_user_addr;
                
                while (true) {
                    System.out.print("\nEmail address:");
                    inp_user_addr = scanner.nextLine();
                    if (inp_user_addr.contains("@")) {
                        break; 
                    } else {
                        System.out.println("Invalid email address. It must contain '@'.");
                    }
                }
                
                String inp_user_num;
                while (true) {
                    System.out.print("\nPhone number:");
                    inp_user_num = scanner.nextLine();
                    if (inp_user_num.matches("[0-9]+")) {
                        break; 
                    } else {
                        System.out.println("Invalid phone number. Please enter only numeric digits.");
                    }
                }
                
                String inp_user_pay;
                while (true) {
                    System.out.println("\nSelect payment method:");
                    System.out.println("a) Cash");
                    System.out.println("b) Card");
                    System.out.println("c) E-transfer");
                    System.out.print("\nEnter selection: ");
                    inp_user_pay = scanner.nextLine().trim().toLowerCase();
                    if (inp_user_pay.equals("a") || inp_user_pay.equals("b") || inp_user_pay.equals("c")) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please select a valid payment method (a, b, or c).");
                    }
                }
                       
                Participant new_part = new Participant(inp_user_name, inp_user_age, inp_user_addr, inp_user_num, inp_user_pay);
                if(choice_event.add_to_participant_list(new_part)) {
                	System.out.println("\nRegistration successfull");
                }else System.out.println("\nFail to register.");
   
                break;          
            } else {
                System.out.println("\nWrong input. Please try again.");
                break; // by adding a brake here at least the user is able to back when the input is null
            }
        }       
          
        
    }
    

    // I Expect it to be used in main.java when inp_user_choice is = e 
    // it will use display_BST() to output all keys(names) for user to choose from
    // ask a uset to choose that using terminal input as input for search_BST()
    // that will return a poiter to node, than it will run remove_from_participation_list()
    // and add_to_cancellation_list() <all the other stuff you see in sequence uml
    // is related for implementation of remove_from_participation_list 
    // and add_to_participart_list methods>
    // {> Chris <} :TODO:
    // TODO add an display of all participants from registered and ask for conformation before "add_to_cancellation_list"
    public void un_register() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("\n<><><><><><><><><><><><><><><><><>");
            System.out.println("Your currently registered to events:");
            event_BST.display();
            System.out.printf("\nChoose one: ");
            String inp_event = scanner.nextLine();
            if (event_BST.search(inp_event) != null) {
                Event choice_event = event_BST.search(inp_event);
                choice_event.add_to_cancellation_list();
                System.out.println("Cancelation to event -" + choice_event.get_event_name() + "- successfull.");
            } else {
                System.out.println("\nWrong input. Please try again.");
                break;
            }
        }       
     }

    // I Expect this to be used as a conformation that everything executed
    // it will ask to press enter(to let user to read the output)
    // and add a bunch of space(for readibility)
    public void acknowledge(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        System.out.println(message);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
}

