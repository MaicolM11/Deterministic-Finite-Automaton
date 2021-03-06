package com.uptc.strucs;

import java.awt.Point;
import java.util.Set;
import java.util.TreeSet;

import com.uptc.models.Coordenate;

public class State extends Coordenate {

	private static final long serialVersionUID = 1L;
	protected String name;
    protected Set<Transition> transitions;
    protected boolean isInitial;
    protected boolean isFinal;
    
    //algortihm
    protected boolean isCombinated;
    protected State newState;

    public State(){
        super(0, 0);
        this.isFinal = false;
        this.isInitial = false;
    }

    public State (String name, Point point) {
        super(point.x, point.y);
        this.name = name;
        this.transitions = new TreeSet<>();
        isCombinated = false;
        this.isFinal = false;
        this.isInitial = false;
    }

    public boolean addTransition(State conn, String terminalSymbol) {
        return this.transitions.add(new Transition(conn, terminalSymbol));
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public boolean deleteConnection(State state) {
        return transitions.removeIf(x -> x.state.equals(state));
    }



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isInitial
	 */
	public boolean isInitial() {
		return isInitial;
	}

	/**
	 * @param isInitial the isInitial to set
	 */
	public void setInitial(boolean isInitial) {
		this.isInitial = isInitial;
	}

	/**
	 * @return the isFinal
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * @param isFinal the isFinal to set
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

    public Set<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(Set<Transition> transitions) {
        this.transitions = transitions;
    }
	/**
	 * Siguiente transicion a un simbolo dado
	 * @param symbol
	 * @return
	 */
    public State getNextTransition(String symbol) {
    	for (Transition current : this.transitions) {
    		System.out.println("Comparando acutual: " + current.terminalSymbol + " Symbol: " + symbol);
    		if(current.terminalSymbol.compareTo(symbol) == 0) {
    			return current.state;
    		}
    	}
    	return null;
    }
    
}
