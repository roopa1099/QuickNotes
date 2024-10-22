package Coding;

class SingleLLNode {
    int value;
    SingleLLNode next;

}

class DoubleLLNode {
    int value;
    SingleLLNode next;
    SingleLLNode previous;

}

/*
 * Random access not possible
 * 
 * insertion at head O(1)
 * 
 * insertion at end -> Doubly LL O(1), Single LL O(n)
 * 
 * search or random index -> O(n)
 * 
 * 
 * Good for queue
 * Good for Dynamic memory allocation
 * 
 * betterinsertion at end and begining
 * 
 * 
 * More memory for pointers
 * 
 * Data stored as nodes
 */
public class LinkedList {

}
