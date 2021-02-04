package com.algo.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch {

    public boolean isPathExists(Map<String, LinkedList<String>> routes, String startPoint, String destination ) {
        List<String> queueOfRoutes = new LinkedList<>();

        LinkedList<String> listOfConnectedRoutesWithStartPoint = routes.get(startPoint);
        queueOfRoutes.addAll(listOfConnectedRoutesWithStartPoint);

        LinkedList<String> routeChecked = new LinkedList<>();

        while (!queueOfRoutes.isEmpty()) {
            String currentPoint = queueOfRoutes.get(0);
            queueOfRoutes.remove(currentPoint);

            if (!routeChecked.contains(currentPoint)) {
                if (currentPoint.equals(destination)) {
                    System.out.println("Found destination: " + currentPoint);
                    return true;
                } else {
                    if(!queueOfRoutes.isEmpty()){
                        String nextPoint = queueOfRoutes.get(0);
                        LinkedList<String> listOfConnectedRoutes = routes.get(nextPoint);
                        queueOfRoutes.addAll(listOfConnectedRoutes);
                        routeChecked.add(currentPoint);
                    }
                }
            }
        }
        System.out.println("Destination not existed");
        return false;
    }
}
