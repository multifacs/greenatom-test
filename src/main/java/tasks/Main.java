package tasks;

public class Main {
    public static void main(String[] args) {

        // Task 2
        System.out.println("Task 2");
        var a = new Task2.Wrapper(2);
        var b = new Task2.Wrapper(3);
        System.out.println("Before swapping: a = " + a.value + ", b = " + b.value);
        Task2.swap(a, b);
        System.out.println("After swapping: a = " + a.value + ", b = " + b.value);
    }
}