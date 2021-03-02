package com.algo.base.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String nameNode;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> links = new HashMap<>();

    public Node(String nameNode) {
        this.nameNode = nameNode;
    }

    public void addDestination(Node destination, Integer distance){
        links.put(destination, distance);
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getName() {
        return nameNode;
    }

    @Override
    public String toString() {
        return "Node: " + nameNode + '\'' +
                ", shortestPath=" + shortestPath +
                ", distance=" + distance ;
    }
}
