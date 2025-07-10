public class Count_Sort extends Sort_Algorithm {
    private static final int limit = (int) 1e6;

    @Override
    public void sort(int[] array) {
        int minimum = array[0];
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            } else if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        if (maximum - minimum > limit) {
            System.out.println("数据范围过大，计数排序无法处理 ");
            return;
        }
        count_sort_for_integers(array, minimum, maximum);
    }

    private void count_sort_for_integers(int[] array, int minimum, int maximum) {
        int[] counter = new int[maximum - minimum + 1];

        for (int i : array) {
            counter[i - minimum]++;
        }

        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                array[index] = i + minimum;
                index++;
                counter[i]--;
            }
        }
    }
}
