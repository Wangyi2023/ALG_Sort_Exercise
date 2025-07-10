public class Merge_Sort_X extends Sort_Algorithm{
    private static final int INSERTION_SORT_THRESHOLD = 16;
    private static final Insertion_Sort insertion_sort = new Insertion_Sort();

    @Override
    public void sort(int[] array) {
        merge_sort(array, 0, array.length - 1);
    }

    private void merge_sort(int[] array, int start, int end) {
        // Todo 10 - Merge Sort X
        // Aufgabe 2
    }

    private void merge(int[] array, int start, int middle, int end) {
        // Aufgabe 1
    }
}
