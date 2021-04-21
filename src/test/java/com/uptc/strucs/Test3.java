package com.uptc.strucs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        
        Algorithm algorithm = new Algorithm();

        State A = new State("A", null);
        State B = new State("B", null);
        State C = new State("C", null);
        State D = new State("D", null);
        State E = new State("E", null);
        State F = new State("F", null);
        State G = new State("G", null);
        State H = new State("H", null);

        H.isFinal = E.isFinal = G.isFinal = true;
        A.isInitial = true;
        List<State> list = new ArrayList<>(Arrays.asList(A,B,C,D,E,F,G,H));
        list.forEach(algorithm::addState);

        A.addTransition(C, "a");
        A.addTransition(B, "b");

        B.addTransition(D, "a");
        B.addTransition(C, "b");

        C.addTransition(H, "b");

        D.addTransition(E, "b");

        E.addTransition(D, "a");
        E.addTransition(G, "b");

        F.addTransition(G, "a");
        F.addTransition(D, "b");

        G.addTransition(G, "b");

        H.addTransition(C, "a");
        H.addTransition(G, "b");

        algorithm.init();
        
        System.out.println("--------------------------");
        algorithm.getGraph().forEach(x -> {
            System.out.println(x.name);
            x.transitions.forEach(y -> System.out.println(y.state.name + "->" + y.terminalSymbol));
            System.out.println();
        });


    }
    
}
