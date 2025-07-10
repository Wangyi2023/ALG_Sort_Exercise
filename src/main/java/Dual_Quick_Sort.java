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
        // Todo 09 - Dual Pivot Quick Sort
        // Aufgabe 2
    }

    private void select_dual_pivot(int[] array, int start, int end) {
        // Aufgabe 1
    }
}
