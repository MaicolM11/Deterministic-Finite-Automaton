package com.uptc.strucs;

public class AutomatonTest {

    public static void main(String[] args) {
        Automaton automaton = new Automaton();

        automaton.addState("A", null);
        automaton.addState("B", null);
        automaton.addState("C", null);

        State a = automaton.searchState("A").get();
        State b = automaton.searchState("B").get();
        State c = automaton.searchState("C").get();

        automaton.addTransition(a, b, "1");
        automaton.addTransition(a, b, "2");
        automaton.addTransition(a, b, "1"); // exist
        automaton.addTransition(b, a, "1");
        automaton.addTransition(a, c, "1"); // valid not is NFA

        automaton.getGraph().forEach(x -> {
            System.out.println(x.name);
            x.transitions.forEach(y -> System.out.println(y.state.name + "->" + y.terminalSymbol));
            System.out.println();
        });
    }
}
