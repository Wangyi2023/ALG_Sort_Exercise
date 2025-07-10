public class Insertion_Sort extends Sort_Algorithm {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int x = array[i];
            int j = i - 1;

            while (j >= start && array[j] > x) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = x;
        }
    }
}
