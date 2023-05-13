public class MinHeap {

    //implementing using https://www.geeksforgeeks.org/binary-heap/#

    //to store array of elements in heap
    private int[] heapArray;

    //max size of the heap
    private int capacity;

    //current number of elements in the heap
    private int current_heap_size;

    //default constructor
    public MinHeap(){
        this(2); // calls the constructor below with a k parameter of 2
    }

    //constructor
    public MinHeap(int k){
        capacity = k;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    private void swap(){

    }

}
