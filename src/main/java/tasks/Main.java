package tasks;

import tasks.Task2.Wrapper;
import tasks.Task3.SinglyLinkedList;
import tasks.Task3.SinglyLinkedList.Node;

import java.sql.Connection;
import java.sql.SQLException;

import static tasks.Task1.Repository.connect;
import static tasks.Task1.Repository.migrate;
import static tasks.Task1.selectSecondMaxExp;
import static tasks.Task2.swap;
import static tasks.Task3.SinglyLinkedList.printList;
import static tasks.Task3.SinglyLinkedList.reverse;

public class Main {
    public static void main(String[] args) {

        // Task 1
        System.out.println("Task 1");
        Connection conn = connect();
        try {
            migrate(conn);
        } catch (SQLException e) {
            System.out.println("DB migration error");
            e.printStackTrace();
        }

        try {
            String result = selectSecondMaxExp(conn);
            if (result != null) {
                System.out.println("2nd max experience: " + result);
            } else {
                System.out.println("No 2nd max experience!");
            }
        } catch (SQLException e) {
            System.out.println("DB SELECT error");
            e.printStackTrace();
        }

        System.out.println();

        // Task 2
        System.out.println("Task 2");
        System.out.println("Normal check:");
        var a = new Wrapper(2);
        var b = new Wrapper(3);
        System.out.println("Before swapping: a = " + a.value + ", b = " + b.value);
        swap(a, b);
        System.out.println("After swapping: a = " + a.value + ", b = " + b.value);
        System.out.println("Overflow check:");
        a = new Wrapper(2147483647);
        b = new Wrapper(1);
        System.out.println("Before swapping: a = " + a.value + ", b = " + b.value);
        swap(a, b);
        System.out.println("After swapping: a = " + a.value + ", b = " + b.value);

        System.out.println();

        // Task 3
        System.out.println("Task 3");
        SinglyLinkedList list = new SinglyLinkedList();
        list.push(2);
        list.push(5);
        list.push(8);
        System.out.println("Length = " + list.getLength());
        try {
            System.out.println("Last value = " + list.peek());
        } catch (Exception e) {
            System.out.println("List error");
        }

        Node head = list.getHead();

        System.out.print("Before reverse: ");
        printList(head);
        head = reverse(head);
        System.out.print("After reverse: ");
        printList(head);
    }
}