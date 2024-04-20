import java.util.Scanner;

public class Main {
    public static int task1Sol(int n, int[] arr) {
        if (n == 1) return arr[0];
        int temp = task1Sol(n - 1, arr);
        return Math.min(temp, arr[n - 1]);
    }
    public static void task1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task1: Enter the number: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Task1: Enter the array of " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Task1: Answer: " + task1Sol(n, arr));
    }

    public static double task2Sol(int n, int[] arr) {
        if (n == 1) return arr[0];
        double result = (arr[n - 1] + (n - 1) * task2Sol(n - 1, arr)) / n;
        return result;
    }

    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task2: Enter the number: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Task2: Enter the array of " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Task2: Answer: " + task2Sol(n, arr));
    }

    public static boolean task3Sol (int n, int div) {
        if (n <= 1) return false;
        if (div == 1) return true;
        if (n % div == 0) return false;

        return task3Sol(n, div - 1);
    }

    public static void task3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task3: Enter the number: ");
        int n = sc.nextInt();
        boolean prime = task3Sol(n, n/2);
        if (prime) System.out.println("Task3: Answer: " + n + " is prime number.");
        if (!prime) System.out.println("Task3: Answer: " + n + " is not prime number.");
    }

    public static int task4Sol(int n) {
        if (n == 1) return 1;

        return task4Sol(n - 1) * n;
    }

    public static void task4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task4: Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Task4: Answer: " + task4Sol(n));
    }

    public static int task5Sol(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        return task5Sol(n - 1) + task5Sol(n - 2);
    }

    public static void task5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task5: Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Task5: Answer: " + task5Sol(n));
    }

    public static int task6Sol(int a, int n) {
        if (a == 0) return 1;
        if (n == 1) return 1;

        return (int) Math.pow(n, a - 1) * n;
    }

    public static void task6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task6: Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Task6: Enter the power: ");
        int a = sc.nextInt();
        System.out.println("Task6: Answer: " + task6Sol(a, n));
    }

    public static void task7Sol(String s, boolean[] visited, String current) {
        if (s.length() == current.length()) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                task7Sol(s, visited, current + s.charAt(i));
                visited[i] = false;
            }
        }
    }

    public static void task7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task7: Enter the row: ");
        String s = sc.nextLine();
        boolean[] visited = new boolean[s.length()];
        System.out.print("Task7: Answer: ");
        task7Sol(s, visited, "");
    }

    public static int task9Sol(int n, int k) {
        if (k == 0 || k == n) return 1;

        return task9Sol(n - 1, k - 1) + task9Sol(n- 1, k);
    }

    public static void task9() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task9: Enter the first number: ");
        int n = sc.nextInt();
        System.out.print("Task9: Enter the second number: ");
        int k = sc.nextInt();
        System.out.println("Task9: Answer: " + task9Sol(n, k));
    }

    public static int task10Sol(int a, int b) {
        if (b == 0) return a;

        return task10Sol(b, a % b);
    }

    public static void task10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task10: Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Task10: Enter the second number: ");
        int b = sc.nextInt();
        System.out.println("Task10: Answer: " + task10Sol(a, b));
    }

    public static boolean task8Sol(String s) {
        if (s.isEmpty()) return true;

        char first = s.charAt(0);
        if (Character.isDigit(first)) {
            return task8Sol(s.substring(1));
        } else {
            return false;
        }
    }

    public static void task8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task8: Enter the string: ");
        String s = sc.nextLine();
        if (!task8Sol(s)) {
            System.out.println("Task8: Answer: No.");
        } else {
            System.out.println("Task8: Answer: Yes.");
        }
    }
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task7();
        //task9();
        //task10();
        task8();
    }
}