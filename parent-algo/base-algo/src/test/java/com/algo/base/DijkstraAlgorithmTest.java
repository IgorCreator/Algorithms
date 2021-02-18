package com.algo.base;

import com.algo.base.dijkstra.DijkstraAlgorithm;
import com.algo.base.dijkstra.Graph;
import com.algo.base.dijkstra.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraAlgorithmTest {

    @Test
    public void testDijkstraAlgo() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        Graph graphRes = DijkstraAlgorithm.calculateShortestPathFromSource(graph, nodeA);
        graphRes.getNodes().forEach(System.out::println);

        List<Node> shortestPathForNodeB = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeC = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Node node : graphRes.getNodes()) {
            switch (node.getName()) {
                case "B":
                    assertEquals(node.getShortestPath(), shortestPathForNodeB);
                    break;
                case "C":
                    assertEquals(node.getShortestPath(), shortestPathForNodeC);
                    break;
                case "D":
                    assertEquals(node.getShortestPath(), shortestPathForNodeD);
                    break;
                case "E":
                    assertEquals(node.getShortestPath(), shortestPathForNodeE);
                    break;
                case "F":
                    assertEquals(node.getShortestPath(), shortestPathForNodeF);
                    break;
            }
        }
    }
}