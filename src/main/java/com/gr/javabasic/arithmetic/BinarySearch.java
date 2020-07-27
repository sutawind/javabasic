package com.gr.javabasic.arithmetic;


import java.util.Arrays;

/**
 * 算法
 */
public class BinarySearch {
    /**
     * main 方法
     */
    public static void main(String[] args) {
        int[] nums = {10, 2, 4, 1, 0, 7, 6, 8, 3, 9, 5, 0};
//        bubbleSort(nums);
//        System.out.println("查找元素7的下标：" + binarySearch(nums, 7));
//        long start = System.currentTimeMillis();
        //有n步台阶每次走一步或两步有多少种走法？
//        System.out.println(f(44));
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + "" + f2(44));
//        System.out.println(f3(7));
        System.out.println(max(nums));
        System.out.println(min(nums));
        selectionSort(nums);
    }

    /**
     * 冒泡排序(从小到大)
     *
     * @param arr 数组
     */
    private static void bubbleSort(int[] arr) {
        System.out.println("排序前：" + Arrays.toString(arr) + " 数组长度为：" + arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = arr[j + 1];
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 求最大值
     */
    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i + 1]) {
                max = arr[i + 1];
            }
        }
        return max;
    }

    /**
     * 求最小值
     */
    private static int min(int[] arr) {
        int min = arr[0];
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (min == arr[i + 1])
                count++;
            if (min > arr[i + 1]) {
                min = arr[i + 1];
                count = 1;
            }
        }
        System.out.println("出现次数:" + count);
        return min;
    }

    /**
     * 选择排序
     */
    private static void selectionSort(int[] arr) {
        System.out.println("排序前：" + Arrays.toString(arr) + " 数组长度为：" + arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[min_index] > arr[j + 1])
                    min_index = j + 1;
            }
            int min = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = min;
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] arr){

    }

    /**
     * 二分查找
     *
     * @param arr 数组
     * @param num 目标元素
     * @return 索引
     */
    private static int binarySearch(int[] arr, int num) {
        int max = arr.length - 1;
        int min = 0;
        int middle;
        for (int i = 0; i < arr.length; i++) {
            middle = (max + min) / 2;
            if (num == arr[middle]) {
                return middle;
            } else if (num > arr[middle]) {
                min = middle + 1;
            } else if (num < arr[middle]) {
                max = middle - 1;
            }
            System.out.println(middle);
        }
        return -1;
    }

    /**
     * 递归 方法调用自身称为递归
     */
    private static int f(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n不小于1");
        if (n == 1 || n == 2)
            return n;
        return f(n - 2) + f(n - 1);
    }

    /**
     * 利用变量的原值推出新值称为迭代
     */
    private static int f2(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n不小于1");
        if (n == 1 || n == 2)
            return n;
        int one = 2;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    /**
     * 斐波那契数  第4个数是前三个数的和
     */
    private static int f3(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n > 3)
            return f3(n - 1) + f3(n - 2) + f3(n - 3);
        return n;
    }

}
