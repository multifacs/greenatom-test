package tasks;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Task 1
        System.out.println("Task 1");
        Connection conn = Task1.Repository.connect();
        try {
            Task1.Repository.migrate(conn);
        } catch (SQLException e) {
            System.out.println("DB migration error");
            e.printStackTrace();
        }

        try {
            Task1.selectSecondMaxExp(conn);
        } catch (SQLException e) {
            System.out.println("DB SELECT error");
            e.printStackTrace();
        }

        System.out.println();

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
        } catch (Exception e) {
            System.out.println("List error");
        }

        Task3.SinglyLinkedList.Node head = list.getHead();

        System.out.print("Before reverse: ");
        Task3.SinglyLinkedList.printList(head);
        head = Task3.SinglyLinkedList.reverse(head);
        System.out.print("After reverse: ");
        Task3.SinglyLinkedList.printList(head);
    }
}