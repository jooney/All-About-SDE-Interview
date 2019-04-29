package org.gnuhpc.bigdata.algorithm.sort;

import org.gnuhpc.bigdata.leetcode.utils.Utils;
import org.junit.Test;


// O(nlogn) 稳定，Object类型的排序一般都是merge sort , 空间复杂度O(n)
// 左闭右开
public class MergeSort {
    public static Void sort(int[] input){
        if (input == null || input.length < 2 ) return null;
//        mergeSort(input,0,input.length);
        parallelMergeSort(input,0,input.length,16);

        return null;
    }

    //左闭右开
    public static void mergeSort(int[] input, int start, int end) {
        //Breaking condition
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // 左闭右开 ， 誊写的过程
    public static void merge(int[] input, int start, int mid, int end) {

        //已经有序就返回
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int k = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[k++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        while (i < mid) {
            temp[k++] = input[i++];
        }
        while (j < end) {
            temp[k++] = input[j++];
        }

        //拷贝回结果
        System.arraycopy(temp, 0, input, start, temp.length);
    }

    public static void parallelMergeSort(int[] input,int low, int high, int numOfThreads) {

        if (numOfThreads <= 1) {
            mergeSort(input,low, high);
            return;
        }
        int middleIndex = (low + high) / 2;

        Thread leftSorter = mergeSortThread(input,low, middleIndex, numOfThreads);
        Thread rightSorter = mergeSortThread(input,middleIndex, high, numOfThreads);

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(input,low, middleIndex, high);
    }

    private static Thread mergeSortThread(int[] input, int low, int high, int numOfThreads) {

        return new Thread() {
            @Override
            public void run() {
                parallelMergeSort(input,low, high, numOfThreads / 2);
            }
        };
    }




    @Test
    public void test() {
        int[] arr = Utils.generateRandomArray(10000000, 0, 100);
//        Utils.printArray(arr);
        Utils.evaluateSort(MergeSort::sort,arr);
//        Utils.printArray(arr);
    }
}
