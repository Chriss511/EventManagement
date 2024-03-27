public class Event {
    private String event_name;
    private String event_date;
    private int time;
    private String location;
    private int max_capacity;
    private Generic_Stack participant_list;
    private Generic_Stack cancellation_list;

    public Event(String event_name, String event_date, int time, String location, int max_capacity) {
        // Constructor
    }

    public String make_key() {
        // make_key method
        return null;
    }

    private boolean check_completed_Event(Event event) {
        // check_completed_Event method
        return false;
    }

    public String get_event_info_list(Event event) {
        // get_event_info_list method
        return null;
    }

    public void add_to_participant_list() {
        // add_to_participant_list method
    }

    public void remove_from_participant_list() {
        // remove_from_participant_list method
    }

    public void add_to_cancellation_list() {
        // add_to_cancellation_list method
    }
}
