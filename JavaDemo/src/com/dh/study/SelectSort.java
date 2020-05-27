package com.dh.study;

import java.util.Arrays;

/**
 *选择排序
 * 1.arr[0]依次与arr[1-4]比较
 * 2.arr[1]依次与arr[2-4]比较
 * 3.arr[2]依次与arr[3-4]比较
 * 4.arr[3]依次与arr[4]比较
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,5,4};
        for (int i=0;i<arr.length-1;i++){ //外层循环三次
            for (int j=i+1;j<arr.length;j++){ //内层从1开始，根据i变化
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}
