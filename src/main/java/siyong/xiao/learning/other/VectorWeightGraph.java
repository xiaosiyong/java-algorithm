package siyong.xiao.learning.other;

import java.util.LinkedList;

/**
 * @Description
 * @Author iss
 * @Date 2019/11/20 09:40
 * @Version 1.0
 **/
public class VectorWeightGraph {

    private LinkedList<Edge> adj[];//邻链表
    private int v;//顶点个数

    public VectorWeightGraph(int v){
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    private class Edge{
        public int sid;//边的起始顶点编号
        public int tid;//边的终止顶点编号
        public int w;//权重
        public Edge(int sid,int tid,int w){
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertex {
        public int id;//顶点编号Id
        public int dist;//从起始顶点到这个顶点的距离
        public Vertex(int id,int dist){
            this.id = id;
            this.dist = dist;
        }

    }

    private class PriorityQueue {
        private Vertex[] nodes;
        private int count;
        public PriorityQueue(int v){
            this.nodes = new Vertex[v+1];
            this.count = v;
        }

        public Vertex poll(){
            return null;
        }
    }
}
