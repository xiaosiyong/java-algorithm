package siyong.xiao.learning.other;

import java.util.LinkedList;

/**
 * @Description
 * @Author iss
 * @Date 2019/10/23 09:35
 * @Version 1.0
 **/
public class SimpleGraph {
    private int v;
    private LinkedList<Integer> adj[];//邻接表

    public SimpleGraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
    }


    public void addEdge(int s, int t){//s先于t，边s->t
        adj[s].add(t);
    }

    /**
    * @Description: Kahn算法
    * @Param: 1、计算每个顶点的入度 2、入度为0的顶点加入队列 2、依次输出
    * @return:
    * @Author: Xiaosy
    * @Date: 2019/11/6 09:44
    */
    public void topoSortByKahn(){
      int[] indegree = new int[v];
      for (int i = 0;i<v;i++){
          for(int j = 0;j<adj[i].size();j++){
              int w = adj[i].get(j);
              indegree[w]++;
          }
      }
      LinkedList<Integer> queue = new LinkedList<>();
      for (int i=0;i<v;i++){
          if (indegree[i]==0){
              queue.add(i);
          }
      }

      while (!queue.isEmpty()){
          int i = queue.remove();
          System.out.println("->"+i);
          for(int j = 0;j<adj[i].size();j++){
              int w = adj[i].get(j);
              indegree[w]--;
              if (indegree[w]==0){
                  queue.add(w);
              }
          }
      }

    }


    /**
    * @Description: DFS算法
    * @Param:   1、构建逆邻链表 2、深度遍历（先访问节点，再访问自己）3、循环输出
    * @return:
    * @Author: Xiaosy
    * @Date: 2019/11/6 09:45
    */
    public void topoSortByDFS(){
       LinkedList<Integer> inverseAdj[]= new LinkedList[v];
       for (int i=0;i<v;i++){
           inverseAdj[i] = new LinkedList<>();
       }
       for (int i =0;i<v;i++){
           for(int j =0;j<adj[i].size();j++){
               int w = adj[i].get(j);
               inverseAdj[w].add(i);
           }
       }

       boolean[] visited = new boolean[v];
       for(int i=0;i<v;i++){
           if (!visited[i]){
               visited[i]= true;
               dfs(i,inverseAdj,visited);
           }
       }


    }



    private void dfs(int vertex,LinkedList<Integer> inverseAdj[],boolean[] visited){
        for (int j=0;j<adj[vertex].size();j++){
            int h = adj[vertex].get(j);
            if (visited[h]){
                continue;
            }
            visited[h] = true;
            dfs(h,inverseAdj,visited);
        }
        System.out.println("->"+vertex);
    }

}
