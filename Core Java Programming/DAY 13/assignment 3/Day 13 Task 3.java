Day 13
Java Code:
package Day13;
import java.util.ArrayList;
public class MinHeap {
	private ArrayList<MinHeapNode> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Inserts a new value into the heap
    public void insert(int value) {
        heap.add(new MinHeapNode(value));
        heapifyUp(heap.size() - 1);
    }

    // Removes and returns the minimum element from the heap
    public int deleteMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap.get(0).getValue();
        MinHeapNode lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return min;
    }

    // Returns the minimum element from the heap without removing it
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0).getValue();
    }

    // Maintains the heap property after insertion
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap.get(index).getValue() < heap.get(parentIndex).getValue()) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    // Maintains the heap property after deletion
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).getValue() < heap.get(smallest).getValue()) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).getValue() < heap.get(smallest).getValue()) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swaps two elements in the heap
    private void swap(int i, int j) {
        MinHeapNode temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);

        System.out.println("Minimum element: " + minHeap.getMin()); // Output: 1
        System.out.println("Deleted minimum element: " + minHeap.deleteMin()); // Output: 1
        System.out.println("Minimum element after deletion: " + minHeap.getMin()); // Output: 2
    }
}

package Day13;

public class MinHeapNode {
	 private int value;

	    public MinHeapNode(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }

	    public void setValue(int value) {
	        this.value = value;
	    }
	}
