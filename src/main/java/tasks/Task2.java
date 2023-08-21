package tasks;

public class Task2 {

    static class Wrapper {
        public Wrapper(int value) {
            this.value = value;
        }
        public int value;
    }
    public static void swap(Wrapper a, Wrapper b)
    {
        // <=> a = a + b
        a.value = (a.value & b.value) + (a.value | b.value);
        // <=> b = a - b
        b.value = a.value + (~b.value) + 1;
        // <=> a = a - b
        a.value = a.value + (~b.value) + 1;
    }
}
