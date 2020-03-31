package com.baufest.ingreso.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortingTest {
	
	@Test
	public void sort1Completo() {
		Jugador p1 = new Jugador("Matias", 100);
		Jugador p2 = new Jugador("Alejandro", 100);
		Jugador p3 = new Jugador("Enzo", 50);
		Jugador p4 = new Jugador("Junior", 75);
		Jugador p5 = new Jugador("Pablo", 150);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(p1);
		jugadores.add(p2);
		jugadores.add(p3);
		jugadores.add(p4);
		jugadores.add(p5);
		
		List<Jugador> jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
		
		Jugador p1Sort = new Jugador("Pablo", 150);
		Jugador p2Sort = new Jugador("Alejandro", 100);
		Jugador p3Sort = new Jugador("Matias", 100);
		Jugador p4Sort = new Jugador("Junior", 75);
		Jugador p5Sort = new Jugador("Enzo", 50);
		List<Jugador> jugadoresSort = new ArrayList<Jugador>();
		jugadoresSort.add(p1Sort);
		jugadoresSort.add(p2Sort);
		jugadoresSort.add(p3Sort);
		jugadoresSort.add(p4Sort);
		jugadoresSort.add(p5Sort);
		
		
		for (Jugador jugador : jugadores) {
			System.out.println(jugador);
		}
		
		
		for (Jugador jugador : jugadoresResult) {
			System.out.println(jugador);
		}
		
		for (Jugador jugador : jugadoresSort) {
			System.out.println(jugador);
		}

        assertEquals(jugadoresSort.size(), jugadoresResult.size());
        assertEquals(jugadoresSort.get(0).getNombre(), jugadoresResult.get(0).getNombre());
        assertEquals(jugadoresSort.get(1).getNombre(), jugadoresResult.get(1).getNombre());
        assertEquals(jugadoresSort.get(2).getNombre(), jugadoresResult.get(2).getNombre());
        assertEquals(jugadoresSort.get(3).getNombre(), jugadoresResult.get(3).getNombre());
        assertEquals(jugadoresSort.get(4).getNombre(), jugadoresResult.get(4).getNombre());
		
		jugadores = new ArrayList<Jugador>();
		jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
		assertTrue(jugadoresResult.isEmpty());
		
		jugadores = new ArrayList<Jugador>();
		jugadores.add(p1);
		jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getNombre(), jugadoresResult.get(0).getNombre());
	}

	@Test
	public void sort1Vacio() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		List<Jugador> jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
		assertTrue(jugadoresResult.isEmpty());
	}

	@Test
	public void sort1Unico() {
		Jugador p1 = new Jugador("Matias", 100);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(p1);
		List<Jugador> jugadoresResult = Sorting.ordenarPorPuntuacionYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getNombre(), jugadoresResult.get(0).getNombre());
	}

	@Test
	public void sort2Completo() {
		
		Jugador p1 = new Jugador("Matias", 100, 3);
		Jugador p2 = new Jugador("Alejandro", 100, 4);
		Jugador p3 = new Jugador("Enzo", 75, 5);
		Jugador p4 = new Jugador("Junior", 75, 30);
		Jugador p5 = new Jugador("Pablo", 150, 0);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(p1);
		jugadores.add(p2);
		jugadores.add(p3);
		jugadores.add(p4);
		jugadores.add(p5);
		
		List<Jugador> jugadoresResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(jugadores);
		
		Jugador p1Sort = new Jugador("Pablo", 150, 0);
		Jugador p2Sort = new Jugador("Matias", 100, 3);
		Jugador p3Sort = new Jugador("Alejandro", 100, 4);
		Jugador p4Sort = new Jugador("Enzo", 75, 5);
		Jugador p5Sort = new Jugador("Junior", 75, 30);
		
		List<Jugador> jugadoresSort = new ArrayList<Jugador>();
		jugadoresSort.add(p1Sort);
		jugadoresSort.add(p2Sort);
		jugadoresSort.add(p3Sort);
		jugadoresSort.add(p4Sort);
		jugadoresSort.add(p5Sort);


        assertEquals(jugadoresSort.size(), jugadoresResult.size());
        assertEquals(jugadoresSort.get(0).getNombre(), jugadoresResult.get(0).getNombre());
        assertEquals(jugadoresSort.get(1).getNombre(), jugadoresResult.get(1).getNombre());
        assertEquals(jugadoresSort.get(2).getNombre(), jugadoresResult.get(2).getNombre());
        assertEquals(jugadoresSort.get(3).getNombre(), jugadoresResult.get(3).getNombre());
        assertEquals(jugadoresSort.get(4).getNombre(), jugadoresResult.get(4).getNombre());
	}

    @Test
    public void sort2Vacio() {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        List<Jugador> jugadoresResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(jugadores);
        assertTrue(jugadoresResult.isEmpty());
    }

    @Test
    public void sort2Unico() {
        Jugador p1 = new Jugador("Matias", 100);
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(p1);
        List<Jugador> jugadoresResult = Sorting.ordenarPorPuntuacionPerdidasYNombre(jugadores);
        assertEquals(1, jugadoresResult.size());
        assertEquals(p1.getNombre(), jugadoresResult.get(0).getNombre());
    }


}
