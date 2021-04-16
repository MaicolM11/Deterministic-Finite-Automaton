package com.uptc.strucs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Algorithm extends Automaton {

    enum Results {
        NE, M, NM
    };

    Algorithm(){
        super();
        table = new ArrayList<>();
    }

    private List<PairTable> table;

    void init() {
        table.clear();
        makeTable();
        checkDistinc();
        checkTransitions(); // recursivo
    }

    private void checkTransitions() {
        int cont = 0;
        for (PairTable pairTable : table) {
            if (!pairTable.isCheck)
                if (checkPair(pairTable))
                    cont++;
        }
        if (cont > 0)
            checkTransitions();
        else
            makeAutomaton();
    }

    private void makeAutomaton() {
        // for pairStates
            // mirar las conexiones hacia el par estados que se reduces -> nuevo estado entran 
            // mirar conexiones del par de estados ->  nuevo estado ->  salen
            // eliminar las conexiones que hay con el par de estados
    }

    private boolean checkPair(PairTable pairTable) {
        List<Results> results = new ArrayList<>();

        for (String value : getWeights()) {
            Optional<Transition> findTransitionA = pairTable.a.transitions.stream()
                    .filter(x -> x.terminalSymbol.equals(value)).findFirst();

            Optional<Transition> findTransitionB = pairTable.b.transitions.stream()
                    .filter(x -> x.terminalSymbol.equals(value)).findFirst();

            Transition a = findTransitionA.orElse(null);
            Transition b = findTransitionB.orElse(null);

            if (a == null || b == null) {
                results.add(Results.NE);
            } else {
                Optional<PairTable> findPair = table.stream().filter(x -> x.areEquals(a.state, b.state)).findFirst();
                if (findPair.isEmpty())
                    results.add(Results.NE);
                else if (findPair.get().isCheck)
                    results.add(Results.M);
                else
                    results.add(Results.NM);
            }
        }
        boolean result = results.stream().filter(x -> x == Results.M).findFirst().isPresent();
        if (result) {
            pairTable.isCheck = true;
            return true;
        }
        return false;
    }

    private void checkDistinc() {
        table.stream().filter(x -> x.areDistinc()).forEach(x-> x.isCheck = true);
    }

    private void makeTable() {
        Object[] states = this.getGraph().stream().sorted((a,b)-> a.name.compareTo(b.name)).toArray();
        List<PairTable> table = new ArrayList<>();
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < i; j++) {
                table.add(new PairTable((State)states[i], (State)states[j]));
            }
        }
        this.table = table;
    }

    class PairTable {

        State a, b;
        boolean isCheck;

        PairTable(State a, State b) {
            this.a = a;
            this.b = b;
            this.isCheck = false;
        }

        boolean areDistinc() {
            return (a.isFinal && !b.isFinal) || (!a.isFinal && b.isFinal);
        }

        boolean areEquals(State a, State b) {
            return (this.a.name.equals(a.name) && this.b.name.equals(b.name))
                    || (this.a.name.equals(b.name) && this.b.name.equals(a.name));
        }

        @Override
        public String toString() {
            return a.name +" - " + b.name;
        }
    }

}
