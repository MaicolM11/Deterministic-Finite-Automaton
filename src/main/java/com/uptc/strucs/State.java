package com.uptc.strucs;

import java.awt.Point;

import java.util.Set;
import java.util.TreeSet;

public class State {

    protected String name;
    protected Set<Transition> transitions;
    protected boolean isInitial;
    protected boolean isFinal;

    public State (String name, Point point){
        this.name = name;
        this.transitions = new TreeSet<>();
    }

    public boolean addTransition(State conn, String terminalSymbol) {
        return this.transitions.add(new Transition(conn, terminalSymbol));
    }

    @Override
    public String toString() {
        return name;
    }
}
