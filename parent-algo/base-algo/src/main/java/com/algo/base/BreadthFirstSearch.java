package com.algo.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch {

    public boolean isPathExists(Map<String, LinkedList<String>> routes, String startPoint, String destination ) {
        List<String> queueOfRoutes = new LinkedList<>();

        LinkedList<String> connectedToStartP = routes.get(startPoint);
        queueOfRoutes.addAll(connectedToStartP);

        LinkedList<String> visitedPoints = new LinkedList<>();
        while (!queueOfRoutes.isEmpty()) {
            String point = queueOfRoutes.get(0);
            queueOfRoutes.remove(point);

            if (!visitedPoints.contains(point)) {
                if (point.equals(destination)) {
                    System.out.println("Found destination: " + point);
                    return true;
                } else {
                    if(!queueOfRoutes.isEmpty()){
                        String nextPoint = queueOfRoutes.get(0);
                        LinkedList<String> listOfConnectedRoutes = routes.get(nextPoint);
                        queueOfRoutes.addAll(listOfConnectedRoutes);
                        visitedPoints.add(point);
                    }
                }
            }
        }
        System.out.println("Destination not existed");
        return false;
    }
}
