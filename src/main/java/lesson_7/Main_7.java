package lesson_7;

public class Main_7 {

    public static void main(String[] args) {
//        testGraph();
//        testDfs();
//        testBfs();

        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Москва", "Липецк");
        graph.addEdges("Рязань", "Москва", "Тамбов");
        graph.addEdges("Калуга", "Москва", "Орел");
        graph.addEdges("Липецк", "Тула", "Воронеж");
        graph.addEdges("Тамбов", "Рязань", "Саратов");
        graph.addEdges("Орел", "Калуга", "Курск");
        graph.addEdges("Саратов", "Тамбов", "Воронеж");
        graph.addEdges("Курск", "Орел", "Воронеж");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

//        Stack<String> shortestWay = graph.findShortestWay("Москва", "Воронеж");
//        for (String s : shortestWay) {
//            System.out.print(s + " -> ");
//        }


        graph.printShortestWay(graph,"Москва", "Воронеж");
//        graph.printShortestWay(graph,"Москва", "Саратов");


    }

    private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
        //A B E C D F G
    }

    private static void testGraph() {
        Graph graph = new Graph(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        System.out.println("The graph size is " + graph.getSize());
        graph.display();
    }
}
