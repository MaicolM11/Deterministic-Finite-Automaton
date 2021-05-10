package com.uptc.controllers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.QuadCurve2D;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.uptc.strucs.Algorithm;
import com.uptc.strucs.State;
import com.uptc.strucs.Transition;

/**
 * Se pintan los automatas
 * 
 * @author santiago
 *
 */
public class ManageAutomaton extends Algorithm {

	public static int RADIO = 50;
	private static Color yellow = new Color(255, 255, 150);
	private static ManageAutomaton INSTANCE;
	private Optional<State> lastSelected;

	private ManageAutomaton() {
		super();
	}

	public static ManageAutomaton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ManageAutomaton();
		}
		return INSTANCE;
	}

	/**
	 * Un nuevo estado es agregado a la lista
	 * 
	 * @param posx
	 * @param posy
	 */
	public void addState(int posx, int posy) {
		this.addState(new State("q" + this.graph.size(), new Point(posx, posy)));
	}

	/**
	 * Se recorre la lista de estados y se redibuja
	 * 
	 * @param g
	 */
	public void redibujarEstados(Graphics g) {
		Iterator<State> it = getGraph().iterator();
		while (it.hasNext()) {
			drawState(g, it.next());
		}
	}

	public void redrawTransition(Graphics g) {
		getGraph().forEach(x -> {
			Map<State, Set<String>> values = x.getTransitions().stream()
				.collect(Collectors.groupingBy(
					Transition::getState, 
					Collectors.mapping(Transition::getTerminalSymbol, Collectors.toSet())));
			values.forEach((k, v) -> drawTransition(g, x, k, v.stream().collect(Collectors.joining(", "))));
		});
	}

	private void drawTransition(Graphics g, State a, State b, String t) {
		
		double centerx = (a.getX() + b.getX()) / 2.0;
		double centery = (a.getY() + b.getY()) / 2.0;
		double lengthx = b.x - a.x;
		double lengthy = b.y - a.y;
		double length = Math.sqrt(lengthx * lengthx + lengthy * lengthy);
		double factorx = (length == 0.0) ? 0.0 : (lengthx / length);
		double factory = (length == 0.0) ? 0.0 : (lengthy / length);
		int pointCX = (int) (centerx + 30 * factory);
		
		int pointCY = (int) (centery - 30 * factorx);

		Graphics2D G2D = (Graphics2D) g;
		G2D.setColor(Color.black);
		G2D.setStroke(new BasicStroke(1.0f));
		
		if(a.equals(b)){
			Point i = new Point((int)(b.getX() - RADIO/ 2 + 5), (int)(b.getY()- RADIO / 2 + 10));
			Point f = new Point((int)(b.getX() + RADIO/ 2 - 5), (int)(b.getY()- RADIO / 2 + 10));
			QuadCurve2D QC2D = new QuadCurve2D.Double(
						i.getX(), 
						i.getY(), 
						pointCX, 
						a.getY() - 100, 
						f.getX(), 
						f.getY()
						);

			G2D.draw(QC2D);
			g.drawString(t, pointCX, a.y - 60);
			g.drawLine(f.x, f.y, f.x - 7, f.y -10);
			g.drawLine(f.x, f.y, f.x + 3, f.y - 10);
			return;
		}

		QuadCurve2D QC2D = new QuadCurve2D.Double(a.getX(), a.getY(), pointCX, pointCY, b.getX(), b.getY());
		G2D.draw(QC2D);
		paintArrow(g, b, pointCX, pointCY);
		g.drawString(t, pointCX, pointCY);
	}



	private void paintArrow(Graphics g, State init, double pointCX, double pointCY) {
		double angle = Math.atan2(pointCX - init.x, pointCY - init.y);
		Point initP = new Point((int) (Math.sin(angle) * RADIO / 2) + init.x,
				(int) (Math.cos(angle) * RADIO / 2) + init.y);
		angle += Math.PI / 10;
		int endX = (int) (Math.sin(angle) * 15) + initP.x;
		int endY = (int) (Math.cos(angle) * 15) + initP.y;
		g.drawLine(initP.x, initP.y, endX, endY);
		angle -= 2.0 * Math.PI / 10;
		endX = (int) (Math.sin(angle) * 15) + initP.x;
		endY = (int) (Math.cos(angle) * 15) + initP.y;
		g.drawLine(initP.x, initP.y, endX, endY);
	}

	/**
	 * Se dibuja un estado en pantalla
	 * 
	 * @param g
	 * @param state
	 */
	public void drawState(Graphics g, State state) {
		g.setColor(yellow);
		Point po = state.getPoint();
		g.fillOval(po.x - (RADIO / 2), po.y - (RADIO / 2), RADIO, RADIO);
		g.setColor(Color.BLACK);
		g.drawOval(po.x - (RADIO / 2), po.y - (RADIO / 2), RADIO, RADIO);
		g.drawString(state.getName(), state.getPoint().x - 10, state.getPoint().y + 5);
		if (state.isInitial()) {
			this.drawInitialState(g, state.getPoint().x, state.getPoint().y);
		}
		if (state.isFinal()) {
			this.drawFinalState(g, state.getPoint().x, state.getPoint().y);
		}
	}

	/**
	 * 
	 * @param g
	 * @param xInitial
	 * @param yInitial
	 */
	private void drawInitialState(Graphics g, int xInitial, int yInitial) {
		int xPoly[] = { xInitial - RADIO, xInitial - RADIO / 2, xInitial - RADIO };
		int yPoly[] = { yInitial - RADIO / 2, yInitial, yInitial + RADIO / 2 };
		Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
		g.drawPolygon(poly);
	}

	private void drawFinalState(Graphics g, int xInitial, int yInitial) {
		g.drawOval(xInitial - (RADIO / 2) + 5, yInitial - (RADIO / 2) + 5, RADIO - (RADIO / 5), RADIO - (RADIO / 5));
	}

	public Optional<State> searchState(Point point) {
		this.lastSelected = super.searchState(point);
		return super.searchState(point);
	}

	/**
	 * Si es inicial lo desmarca como inicial y viceversa
	 */
	public void changeToInitial() {
		if (this.lastSelected.isPresent()) {
			State s = this.lastSelected.get();
			s.setInitial(!s.isInitial());
		}
	}

	/**
	 * Cambia a estado final si no es final y viceversa
	 */
	public void changeToFinal() {
		if (this.lastSelected.isPresent()) {
			State s = this.lastSelected.get();
			s.setFinal(!s.isFinal());
		}
	}

	public void deleteState(Point point) {
		searchState(point).ifPresent(this::deleteState);
	}

}
