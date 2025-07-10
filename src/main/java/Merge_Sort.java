public class Merge_Sort extends Sort_Algorithm {


    @Override
    public void sort(int[] array) {
        merge_sort(array, 0, array.length - 1);
    }

    private void merge_sort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int middle = (start + end) / 2;

        merge_sort(array, start, middle);
        merge_sort(array, middle + 1, end);

        merge(array, start, middle, end);
    }

    private void merge(int[] array, int start, int middle, int end) {
        int index_1 = start;
        int index_2 = middle + 1;

        int[] temp = new int[end - start + 1];
        int index_temp = 0;

        while (index_1 <= middle && index_2 <= end) {
            if (array[index_1] < array[index_2]) {
                temp[index_temp] = array[index_1];
                index_temp++;
                index_1++;
            } else {
                temp[index_temp] = array[index_2];
                index_temp++;
                index_2++;
            }
        }

        while (index_1 <= middle) {
            temp[index_temp] = array[index_1];
            index_temp++;
            index_1++;
        }
        while (index_2 <= end) {
            temp[index_temp] = array[index_2];
            index_temp++;
            index_2++;
        }

        System.arraycopy(temp, 0, array, start, temp.length);
    }
}
