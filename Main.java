package org.example;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();// Creating  a new list for non  sorted data
        ArrayList<Employee> sortedList = new ArrayList<>(); // Creating  a new list for sorted data
        //creating objects of the classes
        SortingAlgorithms SortingAlgorithms1=new SortingAlgorithms();
        SearchingAlgorithms SearchingAlgorithms1=new SearchingAlgorithms();

        Employee[] arr = employeeList.toArray(new Employee[employeeList.size()]);
        while (true) {
            System.out.println("1. Add Employee Data");
            System.out.println("2. Sort Employee List");
            System.out.println("3. Search Employee List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:

                    // Add employee data
                    System.out.println("\nSelect data input method:\n");
                    System.out.println("1. Manual Entry");
                    System.out.println("2. Read from emp.txt file");
                    int dataInputChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (dataInputChoice) {
                        case 1:
                            // Manual Entry
                            System.out.print("\nEnter employee name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter employee ID: \n");
                            int id = scanner.nextInt();
                            employeeList.add(new Employee(name, id));

                            break;
                        case 2:
                            // Read from emp.txt file
                            try {
                                BufferedReader reader = new BufferedReader(new FileReader("emp.txt"));
                                String line;

                                while ((line = reader.readLine()) != null) {
                                    String[] parts = line.split(" ");
                                    if (parts.length == 2) {
                                        String empName = parts[0].trim();
                                        int empId = Integer.parseInt(parts[1].trim());
                                        employeeList.add(new Employee(empName, empId));

                                    }
                                }

                                reader.close();
                                System.out.println("\nEmployee data loaded from emp.txt file.\n");
                            } catch (IOException e) {
                                System.out.println("Error reading emp.txt file: " + e.getMessage());
                            }

                            break;



                        default:
                            System.out.println("Invalid data input method choice.");
                    }
                    //printing employee data
                    System.out.println("\nAn non sorted Employee List \n");
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    // Sorting menu
                    if (employeeList.isEmpty()) {
                        System.out.println("\nEmployee list is empty. Please add employee data first.");
                    } else {
                        System.out.println("\n ******** Sorting Options: *****\n");
                        System.out.println("1. Selection Sort");
                        System.out.println("2. Quicksort");
                        System.out.print("Enter sorting algorithm choice: ");
                        int sortChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        int comparisons = 0;

                        switch (sortChoice) {
                            case 1:
                                // Perform selection sort and store the sorted data in sortedList
                                Employee[] selectionSortArr = employeeList.toArray(new Employee[employeeList.size()]);
                                int selectionSortComparisons = SortingAlgorithms1.selectionSort(selectionSortArr);
                                sortedList = new ArrayList<>(Arrays.asList(selectionSortArr));
                                comparisons = selectionSortComparisons;
                                break;
                            case 2:
                                // Perform quicksort and store the sorted data in sortedList
                                Employee[] quickSortArr = employeeList.toArray(new Employee[employeeList.size()]);
                                int quickSortComparisons = SortingAlgorithms1.quickSort(quickSortArr, 0, quickSortArr.length - 1);
                                sortedList = new ArrayList<>(Arrays.asList(quickSortArr));
                                comparisons = quickSortComparisons;
                                break;
                            default:
                                System.out.println("\nInvalid sorting algorithm choice.");
                                continue;
                        }

                        System.out.println("\nSorted Employee List:");
                        for (Employee employee : sortedList) {
                            System.out.println(employee);
                        }
                        System.out.println("\nComparisons: " + comparisons);
                    }
                    break;

                case 3:
                    // Searching menu
                    if (employeeList.isEmpty()) {
                        System.out.println("\nEmployee list is empty. Please add employee data first.");
                    } else {
                        System.out.println("\nSearching Options:\n");
                        System.out.println("1. Linear Search");
                        System.out.println("2. Binary Search");
                        System.out.println("3. Hash Function Search");
                        System.out.print("\nEnter searching algorithm choice: \n");
                        int searchChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("\nEnter the employee ID to search: \n");
                        int targetId = scanner.nextInt();

                        int comparisons = 0;

                        switch (searchChoice) {
                            case 1:
                                comparisons = SearchingAlgorithms1.linearSearch(employeeList.toArray(new Employee[employeeList.size()]), targetId);
                                break;
                            case 2:
                                // Sorting  the 'employeeList' based on employee IDs for binary search
                                Employee[] sortedArr = employeeList.toArray(new Employee[employeeList.size()]);
                                Arrays.sort(sortedArr, (e1, e2) -> Integer.compare(e1.getId(), e2.getId()));
                                comparisons = SearchingAlgorithms1.binarySearch(sortedArr, targetId);
                                break;
                            case 3:
                                HashMap<Integer, Employee> hashMap = new HashMap<>();
                                for (Employee employee : employeeList) {
                                    hashMap.put(employee.getId(), employee);
                                }
                                comparisons = SearchingAlgorithms1.hashFunctionSearch(hashMap, targetId);
                                break;
                            default:
                                System.out.println("\nInvalid searching algorithm choice.");
                                continue;
                        }

                        System.out.println("\n ******** Search Result ****\n");
                        if (comparisons > 0) {
                            System.out.println("\nEmployee found with ID " + targetId);
                        } else {
                            System.out.println("\nEmployee not found with ID " + targetId);
                        }
                        System.out.println("\nComparisons: " + comparisons);
                    }
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}
























