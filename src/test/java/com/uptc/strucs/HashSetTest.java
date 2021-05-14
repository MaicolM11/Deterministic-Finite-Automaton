package com.uptc.strucs;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// Creamos un array
		ArrayList<String> array = new ArrayList<String>();
		// Agregamos y repetimos varios valores
		array.add("@JaverosAnonimos en Twitter");
		array.add("www.JaverosAnonimos.tk");
		array.add("www.JaverosAnonimos.blogspot.com");

		// Creamos un objeto HashSet
		HashSet<String> hs = new HashSet<String>();

		// Lo cargamos con los valores del array, esto hace quite los repetidos
		hs.addAll(array);

		if (array.size() == hs.size()) {
			System.out.println("No contiene elementos repetidos");
		} else if (array.size() != hs.size()) {
			System.out.println(
					"Contiene elementos repetidos. Size of array: " + array.size() + " Size of hash: " + hs.size());
		}

	}

}
