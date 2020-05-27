package siyong.xiao.learning.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description leetcode85 leetcode84
 * @Author iss
 * @Date 2020/5/27 09:35
 * @Version 1.0
 **/
public class MaximalRectangle {

    public static int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] leftMax = new int[cols];
        int[] rightMin = new int[cols];
        Arrays.fill(leftMax, -1);
        Arrays.fill(rightMin, cols);
        int[] heights = new int[cols];
        for (int i = 0; i < matrix.length; i++) {
            //update heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            //update lefts
            int curZero = -1;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    leftMax[j] = Math.max(curZero, leftMax[j]);
                } else {
                    leftMax[j] = -1;
                    curZero = j;
                }
            }

            //update rights
            int curRight = cols;
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rightMin[j] = Math.min(curRight, rightMin[j]);
                } else {
                    rightMin[j] = cols;
                    curRight = j;
                }
            }

            for (int j = 0; j < cols; j++) {
                int area = (rightMin[j] - leftMax[j] - 1) * heights[j];
                maxArea = Math.max(area, maxArea);
            }

        }

        return maxArea;
    }

    public static int maximalRectangle2(char[][] matrix) {
        int max = 0;
        int row = matrix.length;
        if (row == 0) {
            return max;
        }
        int col = matrix[0].length;
        int[][] width = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    width[i][j] = j == 0 ? 1 : width[i][j - 1] + 1;
                    int w = width[i][j];
                    for (int k = i; k >= 0; k--) {
                        w = Math.min(w, width[k][j]);
                        max = Math.max(max, w * (i - k + 1));
                    }
                }
            }
        }
        return max;
    }

    public static int maximalRectangle3(char[][] matrix) {
        int max = 0;
        if (matrix.length > 0) {
            int[] dp = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
                }
                max = Math.max(max, maximalRectangle(dp));
            }
        }
        return max;
    }

    public static int maximalRectangle(int[] heights) {
        int max = 0;
        if (heights.length > 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            }
        }
        return max;
    }
}
