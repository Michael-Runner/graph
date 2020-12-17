package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private final int SIZE=10;
    private Vertex vertices[];
    private int adjMatrix[][];
    private int count;

    public Graph() {
        this.vertices = new Vertex[SIZE];
        this.adjMatrix = new int[SIZE][SIZE];
    }

    public void addVertex(int id){
        if(count<SIZE){
            vertices[count++] = new Vertex(id);
        }
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    private int getAdjVertex(int id){
        for(int i = 0; i<SIZE; i++){
             if(adjMatrix[id][i] == 1 && !vertices[i].isVisited()){
                 return i;
             }
        }
        return -1;
    }

    public void getWidth(int start){
        System.out.println(start);
        vertices[start].setVisited(true);
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(vertices[start]);

        int num;
        while(!queue.isEmpty()){
            Vertex tmp = queue.peek();

            while ((num = getAdjVertex(tmp.getId())) != -1){
                System.out.println(num);
                vertices[num].setVisited(true);
                queue.add(vertices[num]);
            }
            queue.remove();
        }
    }

    public void getDepth(int start){
        System.out.println(start);
        vertices[start].setVisited(true);

        int num;
        while((num = getAdjVertex(start))!=-1){
            getDepth(num);
        }
    }
}
