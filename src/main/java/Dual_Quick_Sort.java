public class Dual_Quick_Sort extends Sort_Algorithm {
    private static final int INSERTION_SORT_THRESHOLD = 16;
    private static final Insertion_Sort insertion_sort = new Insertion_Sort();

    private static final int QUICK_SORT_X_THRESHOLD = 47;
    private static final Quick_Sort_X quick_sort_x = new Quick_Sort_X();

    @Override
    public void sort(int[] array) {
        dual_pivot_quick_sort(array, 0, array.length - 1);
    }

    private void dual_pivot_quick_sort(int[] array, int start, int end) {
        while (start < end) {
            if (end - start <= INSERTION_SORT_THRESHOLD) {
                insertion_sort.sort(array, start, end);
                return;
            } else if (end - start <= QUICK_SORT_X_THRESHOLD) {
                quick_sort_x.quick_sort_x(array, start, end);
                return;
            }

            select_dual_pivot(array, start, end);

            int pivot_left_value = array[start];
            int pivot_right_value = array[end];

            int left_bound = start + 1;
            int right_bound = end - 1;

            int index = start + 1;

            while (index <= right_bound) {
                if (array[index] < pivot_left_value) {
                    swap(array, index, left_bound);
                    left_bound++;
                    index++;
                } else if (array[index] > pivot_right_value) {
                    swap(array, index, right_bound);
                    right_bound--;
                } else {
                    index++;
                }
            }

            swap(array, start, left_bound - 1);
            swap(array, end, right_bound + 1);

            dual_pivot_quick_sort(array, start, left_bound - 2);
            dual_pivot_quick_sort(array, right_bound + 2, end);
            if (pivot_left_value < pivot_right_value) {
                start = left_bound;
                end = right_bound;
            } else {
                return;
            }
        }
    }

    private void select_dual_pivot(int[] array, int start, int end) {
        int step = (end - start) >> 2;
        for (int i = 1; i < 5; i++) {
            int x = array[start + i * step];
            int j = i - 1;

            while (j >= 0 && array[start + j * step] > x) {
                array[start + (j + 1) * step] = array[start + j * step];
                j--;
            }
            array[start + (j + 1) * step] = x;
        }
        swap(array, start, start + step);
        swap(array, end, start + 4 * step);
    }
}
