package datastructures;

/**
 * 1 based max heap
 */
public class MaxHeap {
    int[] heap;
    int size;
    int end;

    public MaxHeap(int size) {
        this.size = size + 1; // using 1 base indexing
        this.heap = new int[this.size];
        this.end = 1;
    }

    void insert(int data) {
        if (end >= size) return;

        heap[end] = data;
        end++;
        this.heapifyUp(end - 1);
    }

    void delete(int key) {
        if (key >= end) return;

        if (key < end - 1) {
            heap[key] = heap[end - 1];
        }
        end--;
        this.heapifyDown(key);
    }

    int getMax() { return heap[1]; }

    int extractMax() {
        if (end == 1) {
            return Integer.MAX_VALUE;
        }
        if (end - 1 == 1) {
            end--;
            return heap[1];
        }

        int max = heap[1];
        heap[1] = heap[end - 1];
        end--;
        this.heapifyDown(1);

        return max;
    }

    void increaseKey(int key, int value) {
        if (key >= end) return;

        heap[key] = heap[key] + value;
        this.heapifyUp(key);
    }

    void decreaseKey(int key, int value) {
        if (key >= end) return;

        heap[key] = heap[key] - value;
        this.heapifyDown(key);
    }

    void heapifyUp(int key) {
        int parent = key / 2;
        while (key > 1 && heap[key] > heap[parent]) {
            this.swap(key, parent);
            key = parent;
            parent = key / 2;
        }
    }

    void heapifyDown(int key) {
        int left = key * 2;
        int right = key * 2 + 1;
        int largest = key;
        
        if (left < end && heap[left] > heap[largest])
            largest = left;
        if (right < end && heap[right] > heap[largest])
            largest = right;
        if (largest != key) {
            this.swap(key, largest);
            this.heapifyDown(largest);
        }
    }

    void swap(int key1, int key2) {
        int tmp = heap[key1];
        heap[key1] = heap[key2];
        heap[key2] = tmp;
    }
}
