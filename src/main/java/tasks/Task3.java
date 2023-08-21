package tasks;

public class Task3 {

    static class SinglyLinkedList {
        static class Node {
            Node next;
            int value;

            Node(int value) {
                next = null;
                this.value = value;
            }
        }

        private Node head;
        private Node current;

        public SinglyLinkedList() {
            head = null;
            current = null;
        }

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

        public int getLength() {
            if (current == null) {
                return 0;
            }

            Node temp = head;
            int counter = 1;
            while (temp != current) {
                temp = temp.next;
                counter++;
            }
            return counter;
        }

        public int peek() throws Exception {
            if (current == null) {
                throw new Exception();
            }
            return current.value;
        }

        public Node getHead() {
            return head;
        }
        public Node getCurrent() {
            return current;
        }
    }

}
