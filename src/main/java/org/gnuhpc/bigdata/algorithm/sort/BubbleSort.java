package org.gnuhpc.bigdata.algorithm.sort;

import org.junit.Test;

import static org.gnuhpc.bigdata.leetcode.utils.Utils.printArray;
import static org.gnuhpc.bigdata.leetcode.utils.Utils.swap;

// 左边是unsorted， 右边是sorted， 把最大的一个个交换到sorted区域
public class BubbleSort{
    //O(n^2) - because outer and inner loop ,stable
    public Void sort(int[] arr) {
        int n = arr.length;

        boolean swapped;
        for (int i = n-1; i > 0; i--) { //i --  last unsorted index
            swapped = false;
            for (int j = 0; j < i; j++) { //j --> unsorted section
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }

        return null;
    }

    @Test
    public void testBubbleSort(){
        int[] array = new int[]{1,9,4,3,5,6,11,8};
        sort(array);
        printArray(array);
    }
}