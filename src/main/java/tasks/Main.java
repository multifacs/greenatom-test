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

        System.out.println();

        // Task 3
        System.out.println("Task 3");
        Task3.SinglyLinkedList list = new Task3.SinglyLinkedList();
        list.push(2);
        list.push(5);
        list.push(8);
        System.out.println("Length = " + list.getLength());
        try {
            System.out.println("Last value = " + list.peek());

            Task3.SinglyLinkedList.Node temp = list.getHead();
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        } catch (Exception e) {
            System.out.println("List error");
        }

    }
}