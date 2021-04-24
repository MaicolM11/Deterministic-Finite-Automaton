package com.uptc.strucs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Automaton {

    protected final Set<State> graph;

    public Automaton() {
        this.graph = new HashSet<>();
    }

    public boolean addTransition(State a, State b, String symbol) {
        return a.addTransition(b, symbol);
    }

    public boolean deleteTransition(State a, State b) {
        return a.deleteConnection(b);
    }

    public void deleteState(State state) {
        this.graph.removeIf(x -> x.equals(state));
        this.graph.forEach(x -> x.deleteConnection(state));
    }

    public boolean addState(String name, Point point) {
        return graph.add(new State(name, point));
    }

    public boolean addState(State state) {
        return graph.add(state);
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

    public Optional<State> searchState(Point p) {
        return graph.stream().filter(x -> x.searchCircle(p)).findFirst();
    }

    public List<String> getWeights() {
        List<Transition> result = new ArrayList<>();  // save all transitions
        graph.stream().map(x-> x.transitions).forEach(result::addAll);
        return result.stream().map(x-> x.terminalSymbol).distinct().collect(Collectors.toList());
    }

}
