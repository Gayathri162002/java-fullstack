package com.example.mergesortedlists;

public class Listnode {
    int val;
    Listnode next;
    
    Listnode(int val) {
        this.val = val;
        this.next = null;
    
}

}
package com.example.mergesortedlists;

public class MergeSortedLists {
	public static Listnode mergeTwoLists(Listnode l1, Listnode l2) {
     
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        
        Listnode dummy = new Listnode(-1);
        Listnode current = dummy;

        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

      
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

       
        return dummy.next;
    }

    
    public static void printList(Listnode head) {
        Listnode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        Listnode l1 = new Listnode(1);
        l1.next = new Listnode(3);
        l1.next.next = new Listnode(5);

        Listnode l2 = new Listnode(2);
        l2.next = new Listnode(4);
        l2.next.next = new Listnode(6);

        Listnode mergedList = mergeTwoLists(l1, l2);
        printList(mergedList);
    }
}


