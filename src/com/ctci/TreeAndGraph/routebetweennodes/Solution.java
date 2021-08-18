package com.ctci.TreeAndGraph.routebetweennodes;

import com.graph.Graph;
import com.graph.Node;
import com.graph.State;

import java.util.LinkedList;

public class Solution {

    boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;
        //operates as queue
        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); //i.e. dequeue()
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end)
                            return true;
                    } else {
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            u.state = State.Visited;
        }
        return false;
    }
}
