package edu.neu.coe.info6205.sort.elementary;
import java.util.Random;

public class ArrTypes {
    private int n;
    private static final Random rng = new Random(69);
    private final Integer[] arr;
    public ArrTypes(int n) {
        this.n = n;
        arr= new Integer[n];
        for(int i = 0; i < n; i++)
            arr[i] = i; }
    public Integer[] getIncreasing(){
        return arr.clone(); }
    public Integer[] getDecreasing() {
        Integer[] ret = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++)
            ret[arr.length - 1 - i] = arr[i];
        return ret; }
    public Integer[] getPartial(){
        int swap_count = rng.nextInt(Math.max(1,arr.length/2 - 2));
        Integer[] ret = arr.clone();
        for(int i=0;i<swap_count;++i) {
            int a = rng.nextInt(arr.length);
            int b = rng.nextInt(arr.length);
            int tmp = ret[a];
            ret[a] = ret[b];
            ret[b] = tmp; }
        return ret; }
    public Integer[] getRandom(){
        int swap_count = rng.nextInt(2*arr.length);
        Integer[] ret = arr.clone();
        for(int i=0;i<swap_count;++i) {
            int a = rng.nextInt(arr.length);
            int b = rng.nextInt(arr.length);
            int tmp = ret[a];
            ret[a] = ret[b];
            ret[b] = tmp; }
        return ret;

    }
}
