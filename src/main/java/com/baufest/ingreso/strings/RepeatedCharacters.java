package com.baufest.ingreso.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     *     Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     *     Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
        Map<Character,Integer> mapCharacters = new HashMap<Character,Integer>();
        for (char caracter : cadena.toCharArray()) {
        	if(caracter == ' ') continue;
			if(!mapCharacters.containsKey(caracter))
				mapCharacters.put(caracter, 1);
			else {
				mapCharacters.replace(caracter, mapCharacters.get(caracter) + 1);
			}
		}
        
        Set<Integer> cantidadApariciones = new HashSet<Integer>();
        
        for (int cantidad : mapCharacters.values()) {
        	if(!cantidadApariciones.contains(cantidad)) {
        		cantidadApariciones.add(cantidad);
        	}
        }
                
        int cantidadInicial = 0;
        
        if(cantidadApariciones.size() > 2) return false;
        
        for(int cantidad : cantidadApariciones) {
        	if(cantidadInicial == 0) cantidadInicial = cantidad;
        	if ((cantidadInicial - cantidad) < -1 || (cantidadInicial - cantidad) > 1) {
        		return false;
        	}
        }
        
        return true;
    }

}
