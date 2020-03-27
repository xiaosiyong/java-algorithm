import org.junit.Test;
import siyong.xiao.learning.tree.Helper;
import siyong.xiao.learning.tree.TreeNode;

import java.util.List;

/**
 * @Description
 * @Author iss
 * @Date 2020/3/27 18:22
 * @Version 1.0
 **/
public class TreeTest {
    @Test
    public void  testBfsPrint(){
        TreeNode root = new TreeNode("1");
        TreeNode root2 = new TreeNode("2");
        TreeNode root3 = new TreeNode("3");
        TreeNode root4 = new TreeNode("4");
        TreeNode root5 = new TreeNode("5");
        TreeNode root6 = new TreeNode("6");
        TreeNode root7 = new TreeNode("7");
        root.setLeft(root2);
        root.setRight(root3);
        root2.setLeft(root4);
        root2.setRight(root5);
        root3.setLeft(root6);
        root3.setRight(root7);
        List<List<String>> lists = Helper.bfs(root);
        lists.forEach(
                list->{
                    System.out.println(list.size());
                    StringBuilder sb = new StringBuilder();
                   list.forEach(
                           i->{
                               sb.append(i).append(",");
                           }
                   );
                   System.out.println(sb.substring(0,sb.length()-1));
                }
        );
    }
}
