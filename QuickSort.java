import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr) { quickSort(arr, 0, arr.length - 1); }
    private static void quickSort(int[] arr, int i, int j) {
        if(i >= j || i < 0 || j >= arr.length) return;

        // Pick a pivot
        Random r = new Random();
        int pivot = i + r.nextInt(j - i);

        // Move the pivot to the end
        swap(arr, pivot, j);

        // Now sort the list in relation to the pivot
        int minIndex = j - 1;
        int maxIndex = i;

        while(minIndex > maxIndex) {
            minIndex = j - 1;
            maxIndex = i;
            while(arr[minIndex] > arr[j] && minIndex > i) minIndex--;
            while(arr[maxIndex] < arr[j] && maxIndex < j - 1) maxIndex++;
            if(minIndex > maxIndex) swap(arr, minIndex, maxIndex);
        }

        // Find where to put the pivot back
        int newPivot = j;
        for(int k = i; k < j; k++) {
            if(arr[k] > arr[j]) {
                newPivot = k;
                break;
            }
        }

        pivot = newPivot;
        swap(arr, pivot, j);
        quickSort(arr, i, pivot- 1);
        quickSort(arr, pivot + 1, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.print("{");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Random r = new Random();
        int arrayLen = Math.abs(r.nextInt(30));
        int[] myArray = new int[arrayLen];
        for(int i = 0; i < arrayLen; i++) myArray[i] = r.nextInt(100);
        printArray(myArray);
        quickSort(myArray);
        printArray(myArray);
    }
}