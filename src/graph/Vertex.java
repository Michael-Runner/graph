package graph;

public class Vertex {
    private int id;
    private boolean isVisited;

    public Vertex(int id){
        this.id = id;
    }

    public void setVisited(boolean visited){
        this.isVisited = visited;
    }

    public boolean isVisited(){
        return this.isVisited;
    }

    public int getId() {
        return id;
    }
}
