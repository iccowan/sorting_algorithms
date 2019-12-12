import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] arr) { mergeSort(arr, 0, arr.length - 1); }
    private static void mergeSort(int[] arr, int i, int j) {
        if(i >= j) return;
        // Split the array and sort the subsections of the array
        int m = i + ((j - i) / 2);
        mergeSort(arr, i, m);
        mergeSort(arr, m + 1, j);

        // Now, merge the 2 halves of the array
        merge(arr, i, m, j);
    }

    private static void merge(int[] arr, int i, int m, int j) {
        // Go ahead and calculate numbers needed later on
        int length = j - i + 1;
        int l1 = m - i + 1;
        int l2 = j - m;

        // Temp arrays
        int[] temp1 = new int[l1];
        int[] temp2 = new int[l2];

        // Copy items over
        for(int k = 0; k < l1; k++) {
            temp1[k] = arr[i + k];
        }
        for(int k = 0; k < l2; k++) {
            temp2[k] = arr[m + 1 + k];
        }

        // Now, remerge back into the original array
        int pos1 = 0;
        int pos2 = 0;
        for(int k = 0; k < length; k++) {
            if(pos1 >= l1) {
                arr[i + k] = temp2[pos2];
                pos2++;
            } else if(pos2 >= l2) {
                arr[i + k] = temp1[pos1];
                pos1++;
            } else if(temp1[pos1] <= temp2[pos2]) {
                arr[i + k] = temp1[pos1];
                pos1++;
            } else if(temp2[pos2] < temp1[pos1]) {
                arr[i + k] = temp2[pos2];
                pos2++;
            }
        }
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
        int arrayLen = Math.abs(r.nextInt(25));
        int[] myArray = new int[arrayLen];
        for(int i = 0; i < arrayLen; i++) myArray[i] = r.nextInt(100);
        printArray(myArray);
        mergeSort(myArray);
        printArray(myArray);
    }
}