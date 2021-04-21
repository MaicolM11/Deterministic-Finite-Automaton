package com.uptc.strucs;

public class AlgorithmTest {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
       
        algorithm.addState("a", null);
        algorithm.addState("b", null);
        algorithm.addState("c", null);
        algorithm.addState("d", null);
        algorithm.addState("e", null);
        algorithm.addState("f", null);
        algorithm.addState("g", null);

        State a = algorithm.searchState("a").get();
        a.isInitial = true;
        State b = algorithm.searchState("b").get();
        State c = algorithm.searchState("c").get();
        c.isFinal= true;
        State d = algorithm.searchState("d").get();
        State e = algorithm.searchState("e").get();
        State f = algorithm.searchState("f").get(); 
        State g = algorithm.searchState("g").get();
        g.isFinal = true;

        algorithm.addTransition(a, b, "0");
        algorithm.addTransition(b, c, "0");
        algorithm.addTransition(c, c, "0");
        algorithm.addTransition(c, c, "1");
        algorithm.addTransition(b, e, "1");
        algorithm.addTransition(e, e, "0");
        algorithm.addTransition(e, e, "1");

        algorithm.addTransition(d, e, "1");
        algorithm.addTransition(d, a, "0");
        algorithm.addTransition(a, f, "1");
        algorithm.addTransition(f ,e ,"1");
        algorithm.addTransition(f, g, "0");
        algorithm.addTransition(g, g, "0");
        algorithm.addTransition(g, g, "1");
        
        algorithm.getGraph().forEach(x -> {
            System.out.println(x.name);
            x.transitions.forEach(y -> System.out.println(y.state.name + "->" + y.terminalSymbol));
            System.out.println();
        });

        algorithm.init();
        System.out.println("--------------------------");
        algorithm.getGraph().forEach(x -> {
            System.out.println(x.name);
            x.transitions.forEach(y -> System.out.println(y.state.name + "->" + y.terminalSymbol));
            System.out.println();
        });
    }
    
}
