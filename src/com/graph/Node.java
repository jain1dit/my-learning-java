package com.graph;

public class Node {
    public String name;
    public Node[] children;
    public State state;

    public Iterable<? extends Node> getAdjacent() {
        return null;
    }
}
