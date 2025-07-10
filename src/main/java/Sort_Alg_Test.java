import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Sort_Alg_Test {
    private final Sort_Algorithm[] algorithms;
    private final String test_name;
    private final int test_size, number_of_int, maximum;

    public static class Test_Result {
        public Double current_time;
        public Boolean valid;
        public Test_Result(Double current_time, Boolean valid) {
            this.current_time = current_time;
            this.valid = valid;
        }
    }

    public Sort_Alg_Test(Sort_Algorithm[] algorithms, String test_name, int test_size, int number_of_int, int maximum) {
        this.algorithms = algorithms;
        this.test_name = test_name;
        this.test_size = test_size;
        this.number_of_int = number_of_int;
        this.maximum = maximum;
    }
    public Sort_Alg_Test(Sort_Algorithm[] algorithms, String test_name, int test_size, int number_of_int) {
        this(algorithms, test_name, test_size, number_of_int, 100);
    }

    public void start(boolean display_chart) {
        int[][] test_array = create_test_array(test_size, number_of_int, maximum);
        int[][] sorted_test_array = create_sorted_test_array(test_array);
        Sort_Alg_Chart chart = new Sort_Alg_Chart();
        Map<String, Test_Result> result_map = new LinkedHashMap<>();
        System.out.println();
        System.out.println("--- " + test_name + " ---");

        for (Sort_Algorithm algorithm : algorithms) {
            algorithm.print_test_result(test_array, sorted_test_array, result_map);
        }

        if (display_chart) {
            chart.display_chart(result_map, test_name);
        }
    }

    public static int[] create_random_array(int number_of_int, int maximum) {
        if (maximum < 1) {
            maximum = 100;
        }
        int[] array = new int[number_of_int];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maximum);
        }
        return array;
    }
    public static int[][] create_test_array(int test_size, int number_of_int) {
        return create_test_array(test_size, number_of_int, 100);
    }
    public static int[][] create_test_array(int test_size, int number_of_int, int maximum) {
        int[][] test_array = new int[test_size][number_of_int];
        for (int i = 0; i < test_array.length; i++) {
            test_array[i] = create_random_array(number_of_int, maximum);
        }
        return test_array;
    }
    public static int[][] create_sorted_test_array(int[][] test_array) {
        int[][] sorted_test_array = new int[test_array.length][test_array[0].length];
        for (int i = 0; i < test_array.length; i++) {
            sorted_test_array[i] = Arrays.copyOf(test_array[i], test_array[i].length);
            Arrays.sort(sorted_test_array[i]);
        }
        return sorted_test_array;
    }
}
