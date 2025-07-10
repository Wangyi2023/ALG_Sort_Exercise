public class Bubble_Sort extends Sort_Algorithm {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean sorted = true;

            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }
    }
}
