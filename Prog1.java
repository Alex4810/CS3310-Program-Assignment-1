/**************************************************************/
/*  Name: Alexander Lin                                      */
/*  Login ID: 014460537                                      */
/*  CS 3310, Spring 2025                                     */
/*  Programming Assignment 1                                 */
/*  This program reads an undirected graph from a file,      */
/*  finds its connected components, and prints them.        */
/**************************************************************/

import java.io.*;
import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adjustList;
    private boolean[] visited;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjustList = new ArrayList<>();
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjustList.add(i, new ArrayList<>());
        }
    }


    public void addEdge(int x, int y) {
        adjustList.get(x).add(y);
        adjustList.get(x).add(y);
    }

    public List<List<Integer>> findConnectedComponents() {
        List<Lis<Integer>> components = new ArrayList<>();
        for (int i = 1; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                components.add(component);
            }
        }
        return components;
    }


    private void dfs(int node, List<Integer>, component) {
        vosited[node] = true;
        component.add(node);

        for (int neighbor : adjustList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }
}


class GraphReader {
    public static List<Graph> readGraph(String fileName) throws IOException {
        List<Graph> graphs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String line;

        while ((line = br.readLine()) != null) {
            graphs.add(parseGraph(line));
        }
        br.close();
        return graphs;
    }


    private static Graph parseGraph(String line) {
        String[] parts = line.split(" ");
        int numVertices = Integer.parseInt(parts[0]);
        Graph graph = new Graph(numVertices);

        for (int i = 1; i < parts.length; i++) {
            String edge = parts[i].replaceAll("[()]", "");
            String[] nodes = edge.split(",");
            int x = Integer.parseInt(nodes[0]);
            int y = integer.parseInt(nodes[1]);
            graph.addEdge(u,v);
        }
        return graph;
    }
}



public class Prog1 {
    poublic static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: jave Prog1 <inputFile>");
            return;
        }

        try {
            List<Graph> graphs = GraphReader.readGraph(args[0]);

        }
    }
}
