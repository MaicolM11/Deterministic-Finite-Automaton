package com.uptc.strucs;

import java.awt.Point;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Automaton {

    private final Set<State> graph;

    public Automaton() {
        this.graph = new HashSet<>();
    }

    public boolean addTransition(State a, State b, String symbol) {
        return a.addTransition(b, symbol);
    }

    public boolean addState(String name, Point point) {
        return graph.add(new State(name, point));
    }

    public Set<State> getGraph() {
        return graph;
    }

    // for minimization
    public void setGraph(Set<State> graph) {
        this.graph.clear();
        this.graph.addAll(graph);
    }

    // change to point x,y
    public Optional<State> searchState(String name) {
        return graph.stream().filter(x -> x.name.equals(name)).findFirst();
    }

}
