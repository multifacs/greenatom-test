package tasks;

public class Task3 {

    static class SinglyLinkedList {
        private static class Node {
            Node next;
            int value;

            Node(int value) {
                next = null;
                this.value = value;
            }
        }

        Node head;
        Node current;

        public void push(int value) {
            if (head == null) {
                head = new Node(value);
                current = head;
                return;
            }

            current.next = new Node(value);
            current = current.next;
        }

        public int pop() throws Exception {
            if (current == null) {
                throw new Exception();
            }

            int value = current.value;
            Node prev = head;
            while (prev.next.value != value) {
                prev = prev.next;
            }
            current = prev;
            current.next = null;
            return value;
        }
    }

}
