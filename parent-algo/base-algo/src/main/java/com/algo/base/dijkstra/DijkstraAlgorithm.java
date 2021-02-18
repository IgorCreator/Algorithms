package com.algo.base.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while(unsettledNodes.size() != 0){
            Node currentNode = findClosestNotVisitedPaths(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Map.Entry<Node, Integer> link: currentNode.links.entrySet()){
                Node linkedNode = link.getKey();
                Integer edgeWeight = link.getValue();
                if(!settledNodes.contains(linkedNode)){
                    calculateMinimumDestination(currentNode, linkedNode, edgeWeight);
                    unsettledNodes.add(linkedNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node findClosestNotVisitedPaths(Set<Node> unsettledNodes) {
        Node closestNode = null;
        int shortestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDist = node.getDistance();
            if(nodeDist < shortestDistance){
                shortestDistance = nodeDist;
                closestNode = node;
            }
        }
        return closestNode;
    }

    private static void calculateMinimumDestination(Node sourceNode, Node destinationNode, Integer edgeWeight) {
        Integer shortestDist = sourceNode.getDistance();
        if(shortestDist + edgeWeight < destinationNode.getDistance()){
            destinationNode.setDistance(shortestDist + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            destinationNode.setShortestPath(shortestPath);
        }
    }
}
