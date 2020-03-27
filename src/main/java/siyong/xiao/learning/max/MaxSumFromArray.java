package siyong.xiao.learning.max;

/**
 * @Description
 * @Author iss
 * @Date 2019/10/22 10:12
 * @Version 1.0
 **/

/**
 * 最大子序列和问题求解
 * 给定整数（可能含有负数）求和的最大值
 * 如果所有整数都未负数 则最大和为0
 * [-1,0,-2,2,3,-5,6,9]
 */
public class MaxSumFromArray {
    /**
     * 第一种方法求解
     * 时间复杂度 O(N*N*N)
     * @param array 待计算的数组
     * @return
     */
    public static int maxSum1(int[] array){
        if(array.length<=0){
            return 0;
        }
        int maxSum=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=array[k];
                }
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 去掉第一种方法中的第三次循环
     * 时间复杂度O(N*N)
     * @param array 待求和数组
     * @return 最大和
     */
    public static int maxSum2(int[] array){
        int maxSum=0;
        for(int i=0;i<array.length;i++){
            int sum=0;
            for(int j=i;j<array.length;j++){
                sum+=array[j];
                if(sum>maxSum){
                    maxSum=sum;
                }
            }

        }
        return maxSum;
    }

    /**
     * 通过递归 分两部分去算最大和
     * 时间复杂度 O(N*Log N)
     * @param array
     * @return
     */
    public static int maxSum3(int[] array){
        int maxSum=0;
        if(array.length<=0){
            return maxSum;
        }
        if(array.length==1){
            return Math.max(array[0],0);
        }
        if(array.length==2){
            return Math.max(array[0],Math.max(array[1],array[0]+array[1]));
        }
        int[] leftArray=new int[array.length/2];
        int[] rightArray=new int[array.length-array.length/2];
        for(int i=0;i<array.length;i++){
            if(i<array.length/2){
                leftArray[i]=array[i];
            }else{
                rightArray[i-array.length/2]=array[i];
            }
        }
        int maxleft=maxSum3(leftArray);
        int maxright=maxSum3(rightArray);
        int lefttemp=0,maxleftborder=0;
        for(int i=array.length/2;i>=0;i--){
            lefttemp+=array[i];
            if(lefttemp>maxleftborder){
                maxleftborder=lefttemp;
            }
        }
        int righttemp=0,maxrightborder=0;
        for(int i=array.length/2+1;i<array.length;i++){
            righttemp+=array[i];
            if(righttemp>maxrightborder){
                maxrightborder=righttemp;
            }
        }
        return Math.max(maxleft,Math.max(maxright,maxleftborder+maxrightborder));
    }

    /**
     * 比较高效的最大子序列算法
     * @param array
     * @return
     */
    public static int maxSum4(int[] array){
        int max=0,temp=0;
        for(int i=0;i<array.length;i++){
            temp+=array[i];
            if(temp>max){
                max=temp;
            }else if(temp<0){
                temp=0;
            }
        }
        return max;
    }
}
