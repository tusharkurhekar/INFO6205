package edu.neu.coe.info6205.sort.par;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.Scanner;

import static edu.neu.coe.info6205.sort.par.ParSort.getCutoff;

/**
 * This code has been fleshed out by Ziyao Qiao. Thanks very much.
 * TODO tidy it up a bit.
 */
public class Main {

    public static void main(String[] args) {


        for(int l=0;l<10;l++){
            System.out.println("Enter cut off value");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            Random random = new Random(0L);
            int[] array = new int[64000];
            for (int i = 0; i < array.length; i++) array[i] = random.nextInt(64000);
            long t1=System.nanoTime();
            ParSort.sort(array, 0, array.length-1,n);
            //
            System.out.println( "Thread count: "+java.lang.Thread.activeCount());
            long t2=System.nanoTime();
            long totalTime=t2-t1;
            System.out.println("Total time taken in ms:"+totalTime/1000000);
            //System.out.println(array[0]);
            //for (int i : array) System.out.println(i);
            if (array[0]==11) System.out.println("Success!");
        }

//        processArgs(args);
//        System.out.println("Degree of parallelism: " + ForkJoinPool.getCommonPoolParallelism());
//        Random random = new Random();
//        int[] array = new int[2000000];
//        ArrayList<Long> timeList = new ArrayList<>();
//        for (int j = 50; j < 100; j++) {
//            ParSort.cutoff = 10000 * (j + 1);
//            // for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
//            long time;
//            long startTime = System.currentTimeMillis();
//            for (int t = 0; t < 10; t++) {
//                for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
//                ParSort.sort(array, 0, array.length, getCutoff());
//            }
//            long endTime = System.currentTimeMillis();
//            time = (endTime - startTime);
//            timeList.add(time);
//
//
//            System.out.println("cutoff：" + (ParSort.cutoff) + "\t\t10times Time:" + time + "ms");
//
//        }
//        try {
//            FileOutputStream fis = new FileOutputStream("./src/result.csv");
//            OutputStreamWriter isr = new OutputStreamWriter(fis);
//            BufferedWriter bw = new BufferedWriter(isr);
//            int j = 0;
//            for (long i : timeList) {
//                String content = (double) 10000 * (j + 1) / 2000000 + "," + (double) i / 10 + "\n";
//                j++;
//                bw.write(content);
//                bw.flush();
//            }
//            bw.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void processArgs(String[] args) {
        String[] xs = args;
        while (xs.length > 0)
            if (xs[0].startsWith("-")) xs = processArg(xs);
    }

    private static String[] processArg(String[] xs) {
        String[] result = new String[0];
        System.arraycopy(xs, 2, result, 0, xs.length - 2);
        processCommand(xs[0], xs[1]);
        return result;
    }

    private static void processCommand(String x, String y) {
        if (x.equalsIgnoreCase("N")) setConfig(x, Integer.parseInt(y));
        else
            // TODO sort this out
            if (x.equalsIgnoreCase("P")) //noinspection ResultOfMethodCallIgnored
                ForkJoinPool.getCommonPoolParallelism();
    }

    private static void setConfig(String x, int i) {
        configuration.put(x, i);
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private static final Map<String, Integer> configuration = new HashMap<>();


}
