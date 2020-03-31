package com.baufest.ingreso.sorting;

import java.util.List;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {
		
		jugadores.sort((jugador1, jugador2) -> {
	        if (jugador1.getPuntuacion() != jugador2.getPuntuacion()) {
	            return jugador2.getPuntuacion() - jugador1.getPuntuacion();
	        } else {
	            return jugador1.getNombre().compareTo(jugador2.getNombre());
	        }
		}); 	

		return jugadores;
	}

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
     * nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores){
        //TODO: resolver
        throw new UnsupportedOperationException();
	}
	
}
