package datastructures;

/**
 * 1 based max heap
 */
public class MaxHeap {
    int[] heap;
    int size;
    int end;

    public MaxHeap(int size) {
        this.size = size;
        this.heap = new int[size];
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
        while (key > 1) {
            int parent = key / 2;
            if (heap[key] > heap[parent]) {
                int tmp = heap[parent];
                heap[parent] = heap[key];
                heap[key] = tmp;
                key = parent;
            } else {
                break;
            }
        }
    }

    void heapifyDown(int key) {
        int left = key * 2;
        int right = key * 2 + 1;

        if (left >= end && right >= end) return;

        if (left < end && right >= end) {
            if (heap[left] > heap[key])
                this.swap(key, left);
            return;
        }

        if (heap[left] > heap[right] && heap[left] > heap[key]) {
            this.swap(key, left);
            heapifyDown(left);
        } else if (heap[right] > heap[key]) {
            this.swap(key, right);
            heapifyDown(right);
        }
    }

    void swap(int key1, int key2) {
        int tmp = heap[key1];
        heap[key1] = heap[key2];
        heap[key2] = tmp;
    }
}
