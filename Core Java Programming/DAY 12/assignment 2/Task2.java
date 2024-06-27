class LinkedList {
    Node head; 
    
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    
    void printMiddle() {
        Node slow = head;
        Node fast = head;

        if (head != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            System.out.println("The middle element is: " + slow.data);
        }
    }

    
    public void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " -> ");
            tnode = tnode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 9; i++) {
            list.append(i);
        }
        list.printList();
        list.printMiddle();
    }
}
