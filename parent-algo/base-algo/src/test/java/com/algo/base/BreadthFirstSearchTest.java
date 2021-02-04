package com.algo.base;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BreadthFirstSearchTest {

    @Test
    public void testBSF(){
        Map<String, LinkedList<String>> routes = new HashMap<>();
        routes.put("you", new LinkedList<String>(){{add("alice"); add("bob"); add("claire");}});
        routes.put("bob", new LinkedList<String>(){{add("anuj"); add("peggy");}});
        routes.put("alice", new LinkedList<String>(){{add("peggy");}});
        routes.put("claire", new LinkedList<String>(){{add("thom"); add("john");}});
        routes.put("anuj", new LinkedList<>());
        routes.put("peggy", new LinkedList<>());
        routes.put("thom", new LinkedList<>());
        routes.put("john", new LinkedList<>());

        BreadthFirstSearch bsf = new BreadthFirstSearch();
        assertFalse(bsf.isPathExists(routes, "you", "joh")); // Not existed
        assertTrue(bsf.isPathExists(routes, "you", "john"));
        assertTrue(bsf.isPathExists(routes, "you", "claire"));
    }

}