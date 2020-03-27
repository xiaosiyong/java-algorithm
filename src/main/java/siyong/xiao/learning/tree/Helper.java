package siyong.xiao.learning.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author iss
 * @Date 2020/3/27 18:09
 * @Version 1.0
 **/
public class Helper {
    private static List<List<String>> levels = new ArrayList<>();

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
}
