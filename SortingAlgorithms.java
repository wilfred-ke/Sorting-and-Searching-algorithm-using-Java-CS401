package org.example;

public class SortingAlgorithms {
    // Selection Sort algorithm implementation
    public static int selectionSort(Employee[] arr) {
        int comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++; // Count a comparison
                if (arr[j].getId() < arr[minIndex].getId()) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            Employee temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return comparisons;
    }

    // Quicksort algorithm implementation
    public static int quickSort(Employee[] arr, int low, int high) {
        int comparisons = 0;
        if (low < high) {
            int pi = partition(arr, low, high);
            comparisons += high - low; // Count comparisons
            comparisons += quickSort(arr, low, pi - 1);
            comparisons += quickSort(arr, pi + 1, high);
        }
        return comparisons;
    }

    private static int partition(Employee[] arr, int low, int high) {
        int pivot = arr[high].getId();
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j].getId() < pivot) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}







