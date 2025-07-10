public class Quick_Sort_X extends Sort_Algorithm {
    private static final int INSERTION_SORT_THRESHOLD = 16;
    private final Insertion_Sort insertion_sort = new Insertion_Sort();

    @Override
    public void sort(int[] array) {
        quick_sort_x(array, 0, array.length - 1);
    }

    public void quick_sort_x(int[] array, int start, int end) {
        // Todo 08 - Quick Sort X
        // Aufgabe 2
    }

    private int select_pivot(int[] array, int start, int end) {
        // Aufgabe 1
        return 0;
    }
}