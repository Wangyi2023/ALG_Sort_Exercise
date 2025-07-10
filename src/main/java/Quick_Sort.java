public class Quick_Sort extends Sort_Algorithm {
    @Override
    public void sort(int[] array) {
        quick_sort(array, 0, array.length - 1);
    }

    private void quick_sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = array[end];
        int insertion_index = start;
        for (int i = start; i <= end; i++) {
            if (array[i] < pivot) {
                swap(array, insertion_index, i);
                insertion_index++;
            }
        }

        swap(array, insertion_index, end);
        quick_sort(array, start, insertion_index - 1);
        quick_sort(array, insertion_index + 1, end);
    }
}
