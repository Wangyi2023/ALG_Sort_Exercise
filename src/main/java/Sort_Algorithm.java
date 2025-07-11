/**
 在此项目中归纳了一些排序方式，所有排序在各自的类中被编写，且均为当前类的子类
 运行此文件，可以测试下列所有排序方式的正确性和效率

 基础排序有以下几类
 它们在处理少量数据，或者特定类型的数据时有良好表现
 1.  Bubble-Sort       冒泡排序
 2.  Selection-Sort    选择排序
 3.  Insertion-Sort    插入排序
 4.  Count-Sort        计数排序

 高级排序有以下几类
 它们设计巧妙，在处理大量数据时速度很快，归并排序快且稳定，堆排序空间消耗极少，而快速排序会
 顺序访问内存，集中访问相邻数据，因此对缓存友好，在优化后速度极快
 5.  Merge-Sort        归并排序
 6.  Heap-Sort         堆排序
 7.  Quick-Sort        快速排序

 优化排序有以下几类
 它们特定排序方式的基础上优化后，在处理大量特殊数据，例如存在有序片段的，存在大量重复数值的，
 或者存在极端数据的特殊数据时有非常好的表现
 例如优化快速排序在快速排序的基础上，更改了单轴的选择方式，使用了三路分区策略，对末端小数组使用
 插入排序，使用尾递归和迭代混合的递归优化避免栈溢出
 双轴排序通过在优化插入排序的基础上更改为两个轴，小幅减少比较次数，大幅减少交换次数，在 Java内置
 排序中也使用了这一优化策略，但由于不稳定只将它用于对整型浮点型这样的数据排序，而在 Java内置排序
 中还运用了动态随机采样来防御最坏情况，并在检测到递归深度过大时切换到堆排序
 8.  Merge-Sort-X      优化归并排序
 9.  Quick-Sort-X      优化快速排序
 10. Dual-Quick-Sort   双轴快速排序
 11. Java-Sort         Java 内置排序

 */
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public abstract class Sort_Algorithm {
    String PASS = "√ ";
    String FAIL = "x ";
    String QUAD = "      ";

    public static void main(String[] args) {
        String str = start_test();
        boolean display_chart = str.contains("0");

        Sort_Algorithm[] algorithms;
        Sort_Alg_Test test;

        Java_Sort java_sort = new Java_Sort();
        Selection_Sort selection_sort = new Selection_Sort();
        Bubble_Sort bubble_sort = new Bubble_Sort();
        Insertion_Sort insertion_sort = new Insertion_Sort();
        Count_Sort count_sort = new Count_Sort();
        Merge_Sort merge_sort = new Merge_Sort();
        Merge_Sort_X merge_sort_x = new Merge_Sort_X();
        Heap_Sort heap_sort = new Heap_Sort();
        Quick_Sort quick_sort = new Quick_Sort();
        Quick_Sort_X quick_sort_x = new Quick_Sort_X();
        Dual_Quick_Sort dual_quick_sort = new Dual_Quick_Sort();

        // Test 1
        if (str.contains("1")) {
            algorithms = new Sort_Algorithm[]{java_sort, selection_sort, bubble_sort,
                    insertion_sort, count_sort, merge_sort, merge_sort_x, heap_sort, quick_sort,
                    quick_sort_x, dual_quick_sort};
            test = new Sort_Alg_Test(algorithms, "Test 1", 10, 1_000, 100);
            test.start(display_chart);
        }

        // Test 2
        if (str.contains("2")) {
            algorithms = new Sort_Algorithm[]{java_sort, count_sort, merge_sort, merge_sort_x,
                    heap_sort, quick_sort_x, dual_quick_sort};
            test = new Sort_Alg_Test(algorithms, "Test 2", 1, 1_000_000, 100);
            test.start(display_chart);
        }

        // Test 3
        if (str.contains("3")) {
            algorithms = new Sort_Algorithm[]{java_sort, merge_sort, merge_sort_x,
                    heap_sort, quick_sort_x, dual_quick_sort};
            test = new Sort_Alg_Test(algorithms, "Test 3", 1, 1_000_000, Integer.MAX_VALUE);
            test.start(display_chart);
        }

        System.out.println();
    }

    public static String start_test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择本次参与的测试: ");
        String str = scanner.nextLine();
        if (str.contains("all") || str.equals(" ") || str.isEmpty()) { str += "123"; }
        scanner.close();
        return str;
    }

    public void sort(int[] array) {}

    public String get_name() {
        StringBuilder name = new StringBuilder(this.getClass().getName());
        while (name.length() < 18) {
            name.append(" ");
        }
        return name.toString();
    }
    public String get_name(boolean valid) {
        return valid ? this.get_name() + PASS : this.get_name() + FAIL;
    }

    public void print_test_result(int[][] test_array, int[][] sorted_test_array, Map<String, Sort_Alg_Test.Test_Result> result_map) {
        int test_size = test_array.length;
        int number_of_int = test_array[0].length;

        int[] array_tst_copy;
        long[] time = new long[test_size];  long start_time, end_time, mean_time;

        boolean valid = true;

        for (int i = 0; i < test_size; i++) {
            array_tst_copy = Arrays.copyOf(test_array[i], number_of_int);

            start_time = System.nanoTime();
            this.sort(array_tst_copy);
            end_time = System.nanoTime();
            time[i] = end_time - start_time;

            if (!Arrays.equals(array_tst_copy, sorted_test_array[i])) {
                valid = false;
                break;
            }
        }
        mean_time = Arrays.stream(time).sum() / test_size;
        Double current_time = mean_time / 1e6;

        Sort_Alg_Test.Test_Result test_result = new Sort_Alg_Test.Test_Result(current_time, valid);
        result_map.put(this.get_name(valid), test_result);

        System.out.println(this.get_name(valid) + QUAD + String.format("Mean time:  %.5f ms", current_time));
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int calculate_median_of_three(int[] array, int a, int b, int c) {
        return array[a] < array[b]
                ? array[b] < array[c] ? b : array[a] < array[c] ? c : a
                : array[b] > array[c] ? b : array[a] > array[c] ? c : a;
    }
}