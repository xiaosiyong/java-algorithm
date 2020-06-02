package siyong.xiao.learning.leetcode;

/**
 * @Description
 * leetcode410 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 由题意可知：子数组的最大值是有范围的，即在区间 [max(nums),sum(nums)][max(nums),sum(nums)] 之中。
 * 令 l=max(nums)，h=sum(nums)l=max(nums)，h=sum(nums)，mid=(l+h)/2mid=(l+h)/2，计算数组和最大值不大于mid对应的子数组个数 cnt(这个是关键！)
 * 如果 cnt>m，说明划分的子数组多了，即我们找到的 mid 偏小，故 l=mid+1l=mid+1；
 * 否则，说明划分的子数组少了，即 mid 偏大(或者正好就是目标值)，故 h=midh=mid。
 * @Author xiaosy
 * @Date 2020/6/2 11:25
 * @Version 1.0
 **/
public class SplitArray {


    /***
     * 利用动态规划求解
     * @param a
     * @param m
     * @return
     */
    public static int splitArray1(int[] a, int m) {
        if (a.length > 0 && m > 0) {
            int n = a.length;
            int[][] f = new int[n + 1][m + 1];
            int[] sum = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    f[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + a[i];
            }


            f[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int t = 0; t < i; t++) {
                        f[i][j] = Math.min(f[i][j], Math.max(f[t][j - 1], sum[i] - sum[t]));
                    }
                }
            }
            return f[n][m];
        }
        return 0;
    }

    /***
     * 利用2分法求解
     * @param a
     * @param m
     * @return
     */
    public static int splitArray2(int[] a, int m) {
        if (a.length > 0 && m > 0) {
            int right = 0;//save the sum
            int left = 0;//save the min item
            for (int i = 0; i < a.length; i++) {
                right += a[i];
                if (left < a[i]) {
                    left = a[i];
                }
            }
            int result = right;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int sum = 0, count = 1;
                for (int i = 0; i < a.length; i++) {
                    if (sum + a[i] > mid) {
                        count++;
                        sum = a[i];
                    } else {
                        sum += a[i];
                    }
                }
                if (count <= m) {
                    result = Math.min(result, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return result;

        }
        return 0;
    }

}
