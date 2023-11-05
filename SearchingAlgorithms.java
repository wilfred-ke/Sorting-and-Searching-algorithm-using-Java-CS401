package org.example;
import java.util.HashMap;

public class SearchingAlgorithms {
    // Linear Search
    public static int linearSearch(Employee[] arr, int targetId) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++; // Count a comparison
            if (arr[i].getId() == targetId) {
                return comparisons;
            }
        }
        return comparisons;
    }

    // Binary Search
    public static int binarySearch(Employee[] arr, int targetId) {
        int comparisons = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++; // Count a comparison
            if (arr[mid].getId() == targetId) {
                return comparisons;
            } else if (arr[mid].getId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return comparisons;
    }

    // Hash Function Search
    public static int hashFunctionSearch(HashMap<Integer, Employee> hashMap, int targetId) {
        int comparisons = 0;
        if (hashMap.containsKey(targetId)) {
            comparisons++; // Count a comparison
        }
        return comparisons;
    }
}



