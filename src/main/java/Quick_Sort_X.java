public class Quick_Sort_X extends Sort_Algorithm {
    private static final int INSERTION_SORT_THRESHOLD = 16;
    private final Insertion_Sort insertion_sort = new Insertion_Sort();

    @Override
    public void sort(int[] array) {
        quick_sort_x(array, 0, array.length - 1);
    }

    public void quick_sort_x(int[] array, int start, int end) {
        while (start < end) {
            if (end - start <= INSERTION_SORT_THRESHOLD) {
                insertion_sort.sort(array, start, end);
                return;
            }

            int pivot = select_pivot(array, start, end);
            int pivot_value = array[pivot];

            swap(array, pivot, end);

            int left_bound = start;
            int right_bound = end;
            int index = start;

            while (index <= right_bound) {
                if (array[index] < pivot_value) {
                    swap(array, left_bound, index);
                    left_bound++;
                    index++;
                } else if (array[index] > pivot_value) {
                    swap(array, index, right_bound);
                    right_bound--;
                } else {
                    index++;
                }
            }

            if (left_bound - start < end - right_bound) {
                quick_sort_x(array, start, left_bound - 1);
                start = right_bound + 1;
            } else {
                quick_sort_x(array, right_bound + 1, end);
                end = left_bound - 1;
            }
        }
    }

    private int select_pivot(int[] array, int start, int end) {
        int middle = (start + end) >> 1;
        int step = (end - start) >> 3;

        int m_1 = calculate_median_of_three(array, start, start + step, start + 2 * step);
        int m_2 = calculate_median_of_three(array, middle - step, middle, middle + step);
        int m_3 = calculate_median_of_three(array, end - 2 * step, end - step, end);

        return calculate_median_of_three(array, m_1, m_2, m_3);
    }
}