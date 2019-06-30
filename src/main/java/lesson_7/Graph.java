package lesson_7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;
    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void addEdge(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for Vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    public void addEdges(String first, String second, String... others) {
        addEdge(first,second);
        for (String other : others) {
            addEdge(first,other);
        }
    }

    public Stack<String> findShortestWay(String startPoint, String finishPoint) {
        int startIndex = indexOf(startPoint);
        int finishIndex = indexOf(finishPoint);
        if(startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Wrong name of start point ore finish point");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue,vertex);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getLabel().equals(finishPoint)){
                    Stack<String> stack = new Stack<>();
                    Vertex current = vertex;
                    while (current != null) {
                        stack.push(current.getLabel());
                        current = current.getPreviousVertex();
                    }
                    return stack;
                }
            }
        }
        resetVertexState();
        return null;
    }

    public void printShortestWay(Graph graph, String start, String finish) {
        Stack<String> way = graph.findShortestWay(start, finish);
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        while (!way.isEmpty()) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(way.pop());
        }
        System.out.println(sb);
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if(vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     * @param startLabel
     */
    public void bfs(String startLabel){
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
//        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }
}
