public class Generic_Stack<T> {
    private int top;
    private T[] stack;

    
    public Generic_Stack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public boolean push(T data) {
        if (top == stack.length - 1) {
        	System.out.println("Participation list is full. Can't register");
        	return false;
            //throw new IllegalStateException("Stack is full");
            
        }
        stack[++top] = data;
        return true;
    }
    
    ///PENDING: WHEN PARTICIPATION IS LIST IS EMPTY and there is nothing to delete from the un_register function
    // I need to fix the ""Cancelation to event -" + choice_event.get_event_name() + "- successfull.");" that still shows up
    public T pop() {
        if (!isEmpty()) {      
            return stack[top--];
        }else {System.out.println("Participants list is empty");
        // no need to assign a value on top as in an example video
		return null; 
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public void show() {
        // TODO
        // find a way to actually show content maybe???
        for (T n : stack) {
            System.out.printf(n + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return top == -1;
    }
    
 /* trying to implement to check for duplicate participants 
    public boolean isParticipantExist(T[] participants, String email) {
        for (T participant : participants) {
            if (participant.get_email().equals(email)) {
            	System.out.println("Failed. Email already exists.");
                return true; 
            }
        }
        return false; 
    }
    */
}

