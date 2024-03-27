import java.util.*;

public class Event {
	private String event_name;
    private Date event_date;
    private String time;
    private String location;
    private int max_capacity;
    //private Generic_Stack participant_list;
    //private Generic_Stack cancellation_list;

    public Event(String event_name, Date event_date, int time, String location, int max_capacity) {
       this.event_name = event_name;
       this.event_date = event_date;
       this.location = location;
       this.max_capacity = max_capacity;
    }
    
    public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}
	
    
/*
    public String make_key() {
        // make_key method
        return null;
    }*/

	
	/*
    private boolean check_completed_Event(Event event) {
        // check_completed_Event method
        return false;
    }*/

	/*
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
    */
}
