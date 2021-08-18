package com.ctci.TreeAndGraph.buildorder;

import java.util.ArrayList;
import java.util.List;

public class main {
    static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private static Project[] orderProjects(List<Project> projects) {
        Project[] order = new Project[projects.size()];
        // adding root to the build order
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            if (current == null)
                return null;
            // remove myself from dependency
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            // add node that have no dependencies
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    private static int addNonDependent(Project[] order, List<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    private static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    public static void main(String[] arg) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        Project[] result = findBuildOrder(projects, dependencies);
        for (Project project : result)
            System.out.println(project.getName());
    }
}
