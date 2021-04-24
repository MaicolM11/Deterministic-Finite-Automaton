package com.uptc.models;

import com.uptc.controllers.ManageAutomaton;

import java.awt.Point;

public class Coordenate extends Point {


	private static final long serialVersionUID = 1L;

	public Coordenate(int x, int y){
        super(x, y);
    }

    public Point getPoint(){
        return this.getLocation();
    }

    public boolean searchCircle(Point d) {
        return d.distance(this) <= ManageAutomaton.RADIO / 2;
    }


}
