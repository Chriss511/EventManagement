import java.util.*;
import java.time.LocalDate;


public class Event {
    private String event_name;
    private LocalDate event_date;
    private String time;
    private String location;
    private int max_capacity;
    // I already have code that need them implemented so don't comment them out
    private Generic_Stack<Participant> participant_list;  
    private Generic_Stack<Participant> cancellation_list; 

    public Event(String event_name, LocalDate event_date, String time, String location, int max_capacity) {
      this.event_name = event_name;
      this.event_date = event_date;
      this.location = location;
      this.max_capacity = max_capacity;
      this.time = time;

    }
    
    public Generic_Stack<Participant> get_part_list(){
      return participant_list; 
    }
    public String get_event_name() {
      return event_name;
    }

    public void set_event_name(String event_name) {
      this.event_name = event_name;
    }

    public LocalDate get_event_date() {
      return event_date;
    }

    public void set_event_date(LocalDate event_date) {
      this.event_date = event_date;
    }

    public String get_time() {
      return time;
    }

    public void set_time(String time) {
      this.time = time;
    }

    public String get_location() {
      return location;
    }

    public void se_tLocation(String location) {
      this.location = location;
    }

    public int get_max_capacity() {
      return max_capacity;
    }

    public void set_max_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    
    
    // make_key probably can be removed
    /*
    public String make_key() {
        return null;
    }*/
    // I Expect it to be used by check_completed_BST() as a means
    // of creating array that consists of events that are completed
    public boolean check_completed_Event(Event event) {
        LocalDate currentDate = LocalDate.now();
        if (event.get_event_date().isEqual(currentDate) || event.get_event_date().isBefore(currentDate)){
            return true;
        }else{
            return false;
        }
    }
    public String get_event_info_list() {
        StringBuilder temp_build_registered = new StringBuilder();
        StringBuilder temp_build_unregistered = new StringBuilder();
        
        while (!(this.participant_list.isEmpty())) {
            temp_build_registered.append(this.participant_list.pop());
        }
        while (!(this.cancellation_list.isEmpty())) {
            temp_build_unregistered.append(this.cancellation_list.pop()); 
        }
        
        String temp_registered = temp_build_registered.toString();
        String temp_unregistered = temp_build_unregistered.toString();

        return "info:\n" + get_event_name() + "\n" 
          + "starts at " + get_event_date() + " at " + get_time() + "\n" 
          + "located at " + get_location() + " with a capacity of " + get_max_capacity() + "\n"
          + "registered people: " + temp_registered + "\n"
          + "unegistered people: " + temp_unregistered + "\n";
          // TODO fix the fact that after pop we get a pointer to memory and not a rerevant data
    }
    public void update_capacity(){
         this.participant_list = new Generic_Stack(this.max_capacity);
         this.cancellation_list = new Generic_Stack(this.max_capacity);
    }
    public void add_to_participant_list(Participant new_part) {
        participant_list.push(new_part);
    }

    private Participant remove_from_participant_list() {
        return participant_list.pop();
    }

    public void add_to_cancellation_list() {
        cancellation_list.push(remove_from_participant_list());
}
    public void show_all_participants(){
    // TODO
     // use show() from Generic_Stack 
    // right now show() will show addresses 
    }
}
