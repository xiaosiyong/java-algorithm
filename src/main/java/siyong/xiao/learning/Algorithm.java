package siyong.xiao.learning;

import siyong.xiao.learning.other.SimpleGraph;

/**
 * @Description
 * @Author iss
 * @Date 2019/10/22 10:09
 * @Version 1.0
 **/
public class Algorithm {
    public static void main(String[] args){
        SimpleGraph graph = new SimpleGraph(5);
        graph.addEdge(4,1);
        graph.addEdge(1,3);
        graph.topoSortByKahn();
        System.out.println();
        SimpleGraph graph1 = new SimpleGraph(5);
        graph1.addEdge(4,1);
        graph1.addEdge(1,3);
        graph1.addEdge(4,2);
        graph1.topoSortByDFS();

        Integer a =5;
        int b = 5;
        System.out.println(a.equals(b));
        char[] bytes = new char[1];
        System.out.println(bytes[0]);
        bytes[0] |= 3;
        System.out.println(bytes[0]);
        System.out.println(1<<5);
    }
}
