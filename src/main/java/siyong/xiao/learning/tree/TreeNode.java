package siyong.xiao.learning.tree;


/**
 * @Description
 * @Author iss
 * @Date 2020/3/27 17:39
 * @Version 1.0
 **/

public class TreeNode {

    private String value;
    private TreeNode left;
    private TreeNode right;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(String value){
        this.value = value;
    }

}
