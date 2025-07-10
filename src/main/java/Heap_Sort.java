public class Heap_Sort extends Sort_Algorithm {
    @Override
    public void sort(int[] array) {
        // Todo 06 - Heap Sort
        // Aufgabe 8
    }

    public static class Heap {
        private final int[] heap;
        private final int dimension;

        private int data_size;

        public Heap(int[] array, int dimension) {
            this.data_size = array.length;
            this.dimension = dimension;
            this.heap = array;

            create_heap();
        }

        private void create_heap() {
            // Aufgabe 5
        }

        private void sift_down(int index) {
            // Aufgabe 4
        }

        public int[] get_heap() {
            return heap;
        }
        public int get_data_size() {
            return data_size;
        }
        private void swap(int i, int j) {
            // Aufgabe 1
        }

        private int calculate_parent_index(int index) {
            // Aufgabe 2
            return 0;
        }
        private int calculate_child_index(int childIndex, int nodeIndex) {
            // Aufgabe 3
            return 0;
        }
        public void extract_max() {
            // Aufgabe 6
        }
        public void heapify() {
            // Aufgabe 7
        }
    }
}
