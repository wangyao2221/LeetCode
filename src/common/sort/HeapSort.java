package common.sort;

public class HeapSort {
    public int[] sort(int[] arr) {
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }

        return arr;
    }

    public void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public void heapify(int[] arr, int root, int len) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, largest, len);
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] sourceArray = {5,2,7,3,6,1,4};
        int[] arr = new HeapSort().sort(sourceArray);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
