public class Heap_Sort extends Sort_Algorithm {
    @Override
    public void sort(int[] array) {
        Heap heap = new Heap(array, 4);
        heap.heapify();
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
            int last_parent_index = calculate_parent_index(data_size - 1);
            for (int i = last_parent_index; i >= 0; i--) {
                sift_down(i);
            }
        }

        private void sift_down(int index) {
            int first_child_index, last_child_index, current_child_index, maximum;
            while (true) {
                first_child_index = calculate_child_index(0, index);
                last_child_index = first_child_index + dimension - 1;

                if (first_child_index >= data_size) {
                    return;
                }
                if (last_child_index >= data_size) {
                    last_child_index = data_size - 1;
                }

                maximum = heap[first_child_index];
                current_child_index = first_child_index;
                for (int child_index = first_child_index + 1; child_index <= last_child_index; child_index++) {
                    if (heap[child_index] > maximum) {
                        maximum = heap[child_index];
                        current_child_index = child_index;
                    }
                }

                if (heap[index] < maximum) {
                    swap(index, current_child_index);
                    index = current_child_index;
                } else {
                    return;
                }
            }
        }

        public int[] get_heap() {
            return heap;
        }
        public int get_data_size() {
            return data_size;
        }
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private int calculate_parent_index(int index) {
            return (index - 1) / dimension;
        }
        private int calculate_child_index(int childIndex, int nodeIndex) {
            return dimension * nodeIndex + 1 + childIndex;
        }
        public void extract_max() {
            swap(0, data_size - 1);
            data_size--;
            sift_down(0);
        }
        public void heapify() {
            while (data_size > 0) {
                extract_max();
            }
        }
    }


    @Override
    public String get_name() {
        return "Heap_Sort         ";
    }
}
