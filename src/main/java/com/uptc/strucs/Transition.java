package com.uptc.strucs;

public class Transition implements  Comparable<Transition> {

    protected State state;
    protected String terminalSymbol;

    public Transition(State state, String terminalSymbol) {
        this.state = state;
        this.terminalSymbol = terminalSymbol;
    }

    // valid that not is NFA
    @Override
    public int compareTo(Transition t2) {
        return t2.terminalSymbol.compareTo(this.terminalSymbol);
    }

    
    public String getTerminalSymbol() {
        return terminalSymbol;
    }

    public void setTerminalSymbol(String terminalSymbol) {
        this.terminalSymbol = terminalSymbol;
    }

    public State getState(){
        return state;
    }
}
