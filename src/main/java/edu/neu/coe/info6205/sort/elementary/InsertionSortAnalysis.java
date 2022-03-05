package edu.neu.coe.info6205.sort.elementary;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import java.util.*;
public class InsertionSortAnalysis  {

    private static final int UPPER_BOUND = (int)Math.pow(2,14);
    private static final int RUNS = 100;
    public static double benchmark(String description, final Integer[] arr)
    {
        Benchmark<Integer[]> benchmarkTimer = new Benchmark_Timer<>(description, x ->
                x.clone(),
                input_arr -> new
                        InsertionSort<Integer>().sort(input_arr,0,input_arr.length), null
        );
        return benchmarkTimer.run(arr, RUNS);
    }

    public static void main(String[] args)
    {
        List<Double> times = new ArrayList<>();
        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrTypes af = new ArrTypes(i);
            Integer[] arr = af.getDecreasing();
            times.add(benchmark("Reverse", arr.clone())); }
        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Array size: " + i + " -> " + times.get(j)); }

        times = new ArrayList<>();
        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrTypes af = new ArrTypes(i);
            Integer[] arr = af.getIncreasing();
            times.add(benchmark("Increasing", arr.clone())); }
        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Array size: " + i + " -> " + times.get(j)); }

        times = new ArrayList<>();
        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrTypes af = new ArrTypes(i);
            Integer[] arr = af.getRandom();
            times.add(benchmark("Random", arr.clone())); }
        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Array size: " + i + " -> " + times.get(j)); }

        times = new ArrayList<>();
        for (int i = 1; i < UPPER_BOUND; i *= 2) {
            ArrTypes af = new ArrTypes(i);
            Integer[] arr = af.getPartial();
            times.add(benchmark("Partial order", arr.clone())); }
        for (int i = 1, j = 0; i < UPPER_BOUND; i *= 2, j++) {
            System.out.println("Array size: " + i + " -> " + times.get(j)); }




    }
}