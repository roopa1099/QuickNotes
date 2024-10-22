package Coding;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 2 Types => Max Heap (Parent > Children) & Min Heap (Parent < children)
 * 
 * Complete balanced binary tree => All levels are complete except for the last one => from lef to right
 * 
 * Insert => Add Element to last => Heapify up(compare and swap) log(N)
 * 
 * Delete => Remove root => Last element on top =>Heapify down (compare and swap) log(N)
 * 
 * peek => root element O(1)
 * 
 * Heap Sort => Build a tree (O(n) as leaf nodes don't require heapify and max nodes are present in heap)  ; 
 * Delete=> remove top element(heapify again) and add to a array(n * logn N) => n log N
 * 
 * 
 * PriorityQueue
 * Prims
 * Djikstra
 */
public class Heap {
    // Max Heap
    List<Integer> heap = new ArrayList();

    int getParentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    int getLeftChildIndex(int currentIndex) {
        return (2 * currentIndex) + 1;
    }

    int getRightChildIndex(int currentIndex) {
        return (2 * currentIndex) + 2;
    }

    boolean hasLeftChild(int currentIndex) {
        return (heap.size() - 1) >= (2 * currentIndex) + 1;
    }

    boolean hasRightChild(int currentIndex) {
        return (heap.size() - 1) >= (2 * currentIndex) + 2;
    }

    void insertToHeap(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);

    }

    int deleteFromHeap() {
        if (heap.size() == 0) {
            // throw error
            throw new UnsupportedOperationException("Unimplemented method 'heapifyUp'");
        }
        int element = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        // swap

        if (heap.size() > 0) {
            heap.set(0, lastElement);

            //
            heapifyDown(0);
        }

        System.out.println(heap);

        return element;

    }

    int peek() {
        if (heap.size() == 0) {
            // throw error
            throw new UnsupportedOperationException("Unimplemented method 'heapifyUp'");
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        // TODO Auto-generated method stub
        if (index == 0) {
            return;
        }
        int parentIndex = getParentIndex(index);
        while (parentIndex >= 0 && heap.get(parentIndex) < heap.get(index)) {
            swap(parentIndex, index); // swap
            index = parentIndex; // prent in now new currrent
            parentIndex = getParentIndex(index); // next parent
        }

    }

    private void heapifyDown(int index) {
        // TODO Auto-generated method stub
        if (index >= heap.size()) {
            return;
        }

        int leftChildIndex = getLeftChildIndex(index);
        while (hasLeftChild(index) && heap.get(leftChildIndex) > heap.get(index)) {
            // parent should be max value
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = getRightChildIndex(index);
            if (hasRightChild(index) && heap.get(rightChildIndex) > heap.get(leftChildIndex)) {
                largerChildIndex = rightChildIndex;
            }
            swap(largerChildIndex, index);
            index = largerChildIndex;
            leftChildIndex = getLeftChildIndex(index);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        {
            int item = heap.get(indexOne);
            heap.set(indexOne, heap.get(indexTwo));
            heap.set(indexTwo, item);
        }

    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        List<Integer> list = Arrays.asList(5, 2, 7, 9, 1);
        for (int element : list) {
            heap.insertToHeap(element);
        }

        System.out.println(heap.deleteFromHeap());
        System.out.println(heap.deleteFromHeap());
        System.out.println(heap.deleteFromHeap());
        System.out.println(heap.deleteFromHeap());

    }

}
