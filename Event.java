import java.util.*;
import java.time.LocalDate;


public class Event {
    private String event_name;
    private LocalDate event_date;
    private String time;
    private String location;
    private int max_capacity;
    // why did you comment them out???
    //private Generic_Stack participant_list;
    //private Generic_Stack cancellation_list;

    public Event(String event_name, LocalDate event_date, int time, String location, int max_capacity) {
       this.event_name = event_name;
       this.event_date = event_date;
       this.location = location;
       this.max_capacity = max_capacity;

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
        return get_event_name();
    }
    /*
    public void add_to_participant_list() {
    }

    public void remove_from_participant_list() {
    }

    public void add_to_cancellation_list() {
    }
    */
}
