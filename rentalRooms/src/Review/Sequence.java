package Review;

public class Sequence {
    private Object[] objects;
    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next++] = x;
        }
    }

    // ❗️Make this inner class package-private instead of private
    class SSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == next;
        }

        public Object current() {
            return objects[i];
        }

        public void next() {
            if (i < next) i++;
        }
    }

    public Selector getSelector() {
        return new SSelector();  // ✅ Now works
    }
}
