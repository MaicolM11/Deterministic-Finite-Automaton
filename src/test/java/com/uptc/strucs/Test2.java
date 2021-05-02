package com.uptc.strucs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Point;


public class Test2 {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        State q0 = new State("q0", new Point());
        State q1 = new State("q1", new Point());
        State q2 = new State("q2", new Point());
        State q3 = new State("q3", new Point());
        State q4 = new State("q4", new Point());
        State q5 = new State("q5", new Point());
        State q6 = new State("q6", new Point());
        State q7 = new State("q7", new Point());
        
        List<State> list = new ArrayList<>(Arrays.asList(q0,q1,q2,q3,q4,q5,q6,q7));
        list.forEach(algorithm::addState);

        q0.isInitial = true;
        q2.isFinal = true;

        q0.addTransition(q5, "a");
        q0.addTransition(q1, "b");
        
        q1.addTransition(q2, "a");
        q1.addTransition(q6, "b");
        
        q2.addTransition(q2, "a");
        q2.addTransition(q0, "b");
        
        q3.addTransition(q6, "a");
        q3.addTransition(q2, "b");
        
        q4.addTransition(q5, "a");
        q4.addTransition(q7, "b");
        
        q5.addTransition(q6, "a");
        q5.addTransition(q2, "b");
        
        q6.addTransition(q4, "a");
        q6.addTransition(q6, "b");
        
        q7.addTransition(q2, "a");
        q7.addTransition(q6, "b");
        
        algorithm.init();
        System.out.println("--------------------------");
        algorithm.getGraph().forEach(x -> {
            System.out.println(x.name);
            x.transitions.forEach(y -> System.out.println(y.state.name + "->" + y.terminalSymbol));
            System.out.println();
        });
    }
}
