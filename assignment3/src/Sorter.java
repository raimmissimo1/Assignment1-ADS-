import java.util.Random;

public class Sorter {
    private final Random random = new Random(42);

    public void basicSort(int[] arr) {
        selectionSort(arr);
    }

    public void advancedSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void printArray(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i < arr.length - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        System.out.println(builder);
    }

    public int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10 + 1);
        }
        return arr;
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftPart = new int[mid - left + 1];
        int[] rightPart = new int[right - mid];

        for (int i = 0; i < leftPart.length; i++) {
            leftPart[i] = arr[left + i];
        }
        for (int i = 0; i < rightPart.length; i++) {
            rightPart[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                arr[k++] = leftPart[i++];
            } else {
                arr[k++] = rightPart[j++];
            }
        }

        while (i < leftPart.length) {
            arr[k++] = leftPart[i++];
        }

        while (j < rightPart.length) {
            arr[k++] = rightPart[j++];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
