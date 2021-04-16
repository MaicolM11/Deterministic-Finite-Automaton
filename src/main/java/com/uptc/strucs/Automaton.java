package com.uptc.strucs;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Automaton {

    private final Set<State> graph;
    private final Map<String, Integer> symbols;

    public Automaton() {
        this.graph = new HashSet<>();
        this.symbols = new HashMap<>();
    }

    public boolean addTransition(State a, State b, String symbol) {
        int count = this.symbols.getOrDefault(symbol, 0) + 1;
        this.symbols.put(symbol, count);
        return a.addTransition(b, symbol);
    }

    public boolean deleteTransition(State a, State b) {
        /*
         * int count = this.symbols.getOrDefault(symbol, 0) - 1;
         * this.symbols.put(symbol, count);
         */
        return true;
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

    public List<String> getWeights() {
        return symbols.entrySet().stream().filter(e -> e.getValue() > 0).map(x -> x.getKey())
                .collect(Collectors.toList());
    }
}
