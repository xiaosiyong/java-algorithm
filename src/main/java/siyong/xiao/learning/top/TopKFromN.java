package siyong.xiao.learning.top;

/**
 * @Description
 * @Author iss
 * @Date 2019/10/22 10:10
 * @Version 1.0
 **/

import java.util.ArrayList;

/**
 * 从N个数的数组中取出第k个最大者
 */
public class TopKFromN {
    /**
     * 最简单直接的排序
     * 1、将所有元素读入数组
     * 2、通过简单的冒泡排序对数组排序
     * 3、返回数组中的第k个元素
     * @param array
     * @param k
     * @return
     */
    public static int simpleSelect(ArrayList<Integer> array, int k){

        if(array.size()<k){
            return -1;
        }
        int[] originalArray=new int[array.size()];
        for(int i=0;i<array.size();i++){
            originalArray[i]=array.get(i);
        }
        popSort(originalArray);
        StringBuilder str=new StringBuilder();
        for (int i=0;i<originalArray.length;i++){
            str.append(originalArray[i]+"，");
        }
        System.out.println("排序后的数组："+str.toString());
        return originalArray[k-1];
    }

    /**
     * 先把K个元素读入数组 然后挨个比较
     * @param arrays
     * @param k
     * @return
     */
    public static int insertThenSelect(ArrayList<Integer> arrays,int k){
        if(arrays.size()<k){
            return -1;
        }
        StringBuilder sb=new StringBuilder();

        int[] array=new int[k];
        for (int i=0;i<k;i++){
            array[i]=arrays.get(i);
        }
        popSort(array);
        for (int i=k;i<arrays.size();i++){
            for(int j=0;j<k;j++){
                if(arrays.get(i)>array[j]){//需要插入到有序数组 同时原数组发生移位
                    for(int t=k-1;t>j;t--){
                        array[t]=array[t-1];
                    }
                    array[j]=arrays.get(i);
                    break;
                }
            }

        }
        for (int i=0;i<array.length;i++){
            sb.append(array[i]+",");
        }
        System.out.println("最终数组里存的数据是："+sb.toString());
        return array[k-1];
    }


    /**
     * 冒泡排序算法
     * @param array 待排序数组
     */
    private static void popSort(int[] array){
        for(int i=array.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(array[i]>array[j]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
    }


    public static int getIndexByValueFromSortedArray(int[] sortedArray,int value){
        if(sortedArray.length<1){
            return -1;
        }
        int mid=0;
        int low=0,high=sortedArray.length-1;
        while (low<=high){
            mid=(low+high)/2;
            if(value>sortedArray[mid]){
                low=mid+1;
            }else if(value<sortedArray[mid]){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return -1;

    }
}
