public class Generic_BST<T> {
    private class Node {
        private String key;
        private T event_data;
        private Node left_child;
        private Node right_child;

        public Node(String key, T event_data) {
            this.key = key;
            this.event_data = event_data;
            this.left_child = null;
            this.right_child = null;
        }
    }

    private Node root;

    public Generic_BST() {
        this.root = null;
    }

    public void insert_BST(String key, T event_data) {
        root = insert_BST(root, key, event_data);
    }

    private Node insert_BST(Node root, String key, T event_data) {
        if (root == null) {
            return new Node(key, event_data);
        }

        if (key.compareTo(root.key) < 0) {
            root.left_child = insert_BST(root.left_child, key, event_data);
        } else if (key.compareTo(root.key) > 0) {
            root.right_child = insert_BST(root.right_child, key, event_data);
        }

        return root;
    }

    public T search_BST(String key) {
        return search_BST(root, key);
    }

    private T search_BST(Node root, String key) {
        if (root == null || root.key.equals(key)) {
            if (root != null)
                return root.event_data;
            return null;
        }

        if (key.compareTo(root.key) < 0) {
            return search_BST(root.left_child, key);
        } else {
            return search_BST(root.right_child, key);
        }
    }

    public void display_BST() {
        display_BST(root);
    }

    private void display_BST(Node root) {
        if (root != null) {
            display_BST(root.left_child);
            System.out.print(root.key + ":" + root.event_data + " ");
            display_BST(root.right_child);
        }
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    private Node delete(Node root, String key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left_child = delete(root.left_child, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right_child = delete(root.right_child, key);
        } else {
            if (root.left_child == null) {
                return root.right_child;
            } else if (root.right_child == null) {
                return root.left_child;
            }

            root.key = min_value(root.right_child);
            root.right_child = delete(root.right_child, root.key);
        }

        return root;
    }

    private String min_value(Node root) {
        String minv = root.key;
        while (root.left_child != null) {
            minv = root.left_child.key;
            root = root.left_child;
        }
        return minv;
    }
/*
    public T[] check_completed_BST() {
        List<T> completedEventsList = new ArrayList<>();
        check_completed_BST(root, completedEventsList);
        return completedEventsList;
    }

    private void check_completed_BST(Node root, List<T> completedEventsList) {
        if (root != null) {
            check_completed_BST(root.left_child, completedEventsList);
            if (root.event_data.check_completed_Event()) {
                completedEventsList.add(root.event_data);
            }
            check_completed_BST(root.right_child, completedEventsList);
        }
    }*/
}

