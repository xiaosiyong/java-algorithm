package siyong.xiao.learning.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author iss
 * @Date 2020/3/27 18:09
 * @Version 1.0
 **/
public class Helper {
    private static List<List<String>> levels = new ArrayList<>();

    /***
     * bfs with recursion 时间复杂度与空间复杂度均为O(N)
     * @param node
     * @param level
     */
    public static void bfsPrint(TreeNode node,int level){
        if (levels.size() == level){
            levels.add(new ArrayList<String>());
        }
        levels.get(level).add(node.getValue());
        if (node.getLeft() != null){
            bfsPrint(node.getLeft(), level + 1);
        }
        if (node.getRight() != null){
            bfsPrint(node.getRight(), level + 1);
        }
    }

    public static List<List<String>>  bfs(TreeNode root){
        if (root == null){
            return levels;
        }
        bfsPrint(root, 0);
        return levels;
    }

    public static List<List<String>> levelOrder(TreeNode root){
        if ( root == null){
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for(int i = 0;i < level_length; i++){
                TreeNode node = queue.remove();
                levels.get(level).add(node.getValue());
                if (node.getLeft()!=null){
                    queue.add(node.getLeft());
                }
                if (node.getRight()!=null){
                    queue.add(node.getRight());
                }
            }
            level++;
        }
        return levels;
    }
}
