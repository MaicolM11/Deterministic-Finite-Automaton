package com.uptc.controllers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.Optional;

import com.uptc.strucs.Automaton;
import com.uptc.strucs.State;

/**
 * Se pintan los automatas
 * @author santiago
 *
 */
public class ManageAutomaton {
	
	private Automaton automaton;
	private int cont;
	public static int RADIO = 50;
	private static  Color yellow = new Color(255,255,150);
	private static ManageAutomaton INSTANCE;
	
	private ManageAutomaton() {
		this.automaton = new Automaton();
		this.cont = 0;
	}
	
	public static ManageAutomaton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ManageAutomaton();
		}
		return INSTANCE;
	}
	
	/**
	 * Dibuja un estado y le asigna un nombre
	 * @param graphics
	 * @param posx
	 * @param posy
	 */
	public void drawState(Graphics graphics, int posx , int posy) {
		graphics.setColor(Color.BLACK);
		graphics.fillOval(posx ,posy ,RADIO , RADIO);
		graphics.fillOval(posx, posy, RADIO, RADIO);
		String stateName = "q" + cont;
		graphics.drawString(stateName , posx + (RADIO /3), posy + (RADIO / 2));
		this.automaton.addState(new State(stateName, new Point(posx, posy)));
		cont++;
	}
	
	/**
	 * @return the automaton
	 */
	public Automaton getAutomaton() {
		return automaton;
	}

	/**
	 * @param automaton the automaton to set
	 */
	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}
	
	/**
	 * Un nuevo estado es agregado a la lista
	 * @param posx
	 * @param posy
	 */
	public void addState(int posx , int posy) {
		this.automaton.addState(new State("q" + cont , new Point(posx, posy)));
		cont++;
	}
	
	/**
	 * Se recorre la lista de estados
	 * y se redibuja
	 * @param g
	 */
	public void redibujarEstados(Graphics g) {
		Iterator<State> it = this.automaton.getGraph().iterator();
		 while(it.hasNext()){
			 drawState(g, it.next());
		 }
	}
	
	/**
	 * Se dibuja un estado en pantalla
	 * @param g
	 * @param state
	 */
	public void drawState(Graphics g , State state) {
		g.setColor(yellow);
		Point po = state.getPoint();
		g.fillOval(po.x -(RADIO/2),po.y-(RADIO/2) ,RADIO , RADIO);
		g.setColor(Color.BLACK);
		g.drawOval(po.x-(RADIO/2), po.y-(RADIO/2), RADIO, RADIO);
		g.drawString(state.getName() , state.getPoint().x , state.getPoint().y );
	}

	public Optional<State> searchState(Point point){
		return this.automaton.searchState(point);
	}
	
}
