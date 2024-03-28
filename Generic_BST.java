import java.util.List;
import java.util.ArrayList;
public class Generic_BST {
	
	// I updated the generic_bst class to create a BST with objects not with generics 
	// since as explained in the Project2_2024 pdf, the BST class stores event "objects"
	// these objects will have the information of the event
	
  private class Node {
      private Event event;
      private Node leftChild;
      private Node rightChild;

      public Node(Event event) {
          this.event = event;
          this.leftChild = null;
          this.rightChild = null;
      }
  }

  private Node root;

  public Generic_BST() {
      this.root = null;
  }


  public void insert(Event event) {
      root = insert(root, event);
  }

  private Node insert(Node root, Event event) {
      if (root == null) {
          return new Node(event);
      }

      if (event.get_event_name().compareTo(root.event.get_event_name()) < 0) {
          root.leftChild = insert(root.leftChild, event);
      } else if (event.get_event_name().compareTo(root.event.get_event_name()) > 0) {
          root.rightChild = insert(root.rightChild, event);
      }

      return root;
  }

  public Event search(String eventName) {
      return search(root, eventName);
  }

  private Event search(Node root, String eventName) {
      if (root == null || root.event.get_event_name().equals(eventName)) {
          return root != null ? root.event : null;
      }

      if (eventName.compareTo(root.event.get_event_name()) < 0) {
          return search(root.leftChild, eventName);
      } else {
          return search(root.rightChild, eventName);
      }
  }

  public void display() {
      display(root);
  }

  private void display(Node root) {
      if (root != null) {
          display(root.leftChild);
          System.out.println(root.event.get_event_name()); // Assuming Event class overrides toString()
          display(root.rightChild);
      }
  }

  
  // DELETION CODE REFERENCED FROM  https://medium.com/swlh/java-how-to-delete-a-node-in-binary-search-tree-aa2d4befe728
  // But except using key variable, our key is the eventName as requested in the project requirements.
  
  public void delete(String eventName) {
      root = delete(root, eventName);
  }

  private Node delete(Node root, String eventName) {
      if (root == null) {
          return root;
      }

      if (eventName.compareTo(root.event.get_event_name()) < 0) {
          root.leftChild = delete(root.leftChild, eventName);
      } else if (eventName.compareTo(root.event.get_event_name()) > 0) {
          root.rightChild = delete(root.rightChild, eventName);
      } else {
          if (root.leftChild == null) {
              return root.rightChild;
          } else if (root.rightChild == null) {
              return root.leftChild;
          }

          // Node with two children: Get the inorder successor (smallest in the right subtree)
          root.event = minValue(root.rightChild);

          // Delete the inorder successor
          root.rightChild = delete(root.rightChild, root.event.get_event_name());
      }

      return root;
  }

  private Event minValue(Node root) {
      Event minEvent = root.event;
      while (root.leftChild != null) {
          minEvent = root.leftChild.event;
          root = root.leftChild;
      }
      return minEvent;
  }
  
  // I Expect this mothod to be used inside delete_comp_event()
  // and I want it to return an array
  public Event[] check_completed_BST() {
      List<Event> comp_event_list = new ArrayList<>();
      check_completed_BST(root, comp_event_list);
      
      Event[] comp_event_array = new Event[comp_event_list.size()];
      comp_event_array = comp_event_list.toArray(comp_event_array);
      //System.out.println(comp_event_array[0].get_event_name()); // for debug note that you need to add an event first
      
      return comp_event_array;
  }

  private void check_completed_BST(Node root, List<Event> comp_event_list) {
      if (root != null) {
          check_completed_BST(root.leftChild, comp_event_list);
          if (root.event.check_completed_Event(root.event)) {
              delete(root.event.get_event_name());
              comp_event_list.add(root.event);
          }
          check_completed_BST(root.rightChild, comp_event_list);
      }
  }
 
}


