class DynamicArray {
    private int[] array;
    private int size; // how many elements stored
    private int capacity; // length of array

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        int val = array[size - 1];
        array[size - 1] = 0;
        size--;
        return val;
    }

    private void resize() {
        int[] oldArr = array;
        int[] newArr = new int[capacity * 2];

        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }

        this.array = newArr;
        this.capacity = capacity * 2;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
