public class MinHeap {
    class element{
        int key;
        double value;
        public element(int key, double value)
        {
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return this.key;
        }
        public double getValue(){
            return this.value;
        }
        public void setKey(int key){
            this.key = key;
        }
        public void setValue(double value){
            this.value = value;
        }
    }

    //to store array of elements in heap
    private element[] heapArray;

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
        heapArray = new element[capacity];
        current_heap_size = 0;
    }

    //node swap
    private void swap(element[] arr, element a, element b){
//        for
//        element temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
        return;
    }

    //returns the parent's index for the given node index
    private int parent(int key){
        return (key-1)/2;
    }

    //returns the left index for the given node index
    private int left(int key){
        return 2*key + 1;
    }

    //returns the right index for the given node index
    private int right(int key){
        return 2*key + 2;
    }

    // Inserts a new key
    public boolean insertKey(int key){
        if (current_heap_size==capacity){
            return false;
        }
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        //fix min heap property if violated
        while(i!=0 && heapArray[i] < heapArray[parent(i)]){
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    // Decreases value of given key to new_val.
    public void decreaseKey(int key, int new_val){
        heapArray[key] = new_val;

        while(key!=0 && heapArray[key] < heapArray[parent(key)]){
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }

    //returns the key of the root of the minHeap
    public int getMin(){
        return heapArray[0];
    }

    public int extractMin(){
        if(current_heap_size <= 0){
            return Integer.MAX_VALUE;
        }
        if (current_heap_size==1){
            current_heap_size--;
            return heapArray[0];
        }

        //Store the minimum element and remove it from the heap
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }

    public void deleteKey(int key){
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    private void MinHeapify(int key){
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if(l < current_heap_size && heapArray[l] < heapArray[smallest]){
            smallest = l;
        }
        if(r < current_heap_size && heapArray[r] < heapArray[smallest]){
            smallest = r;
        }
        if (smallest != key){
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }
    }

    // Increases value of given key to new_val.
    public void increaseKey(int key, int new_val){
        heapArray[key] = new_val;
        MinHeapify(key);
    }

    public void changeValueOnAKey(int key, int new_val){
        if(heapArray[key] == new_val){
            return;
        }
        if (heapArray[key] < new_val){
            increaseKey(key, new_val);
        }else{
            decreaseKey(key, new_val);
        }
    }

}
