public class Selection_Sort extends Sort_Algorithm {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = array[i];
            int min_index = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_index = j;
                }
            }

            if (min_index != i) {
                swap(array, i, min_index);
            }
        }
    }
}
