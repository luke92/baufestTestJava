package com.baufest.ingreso.alphabetSoup;

import java.util.Arrays;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]){
        this.soup = soup;
    }

    /**
     * El objetivo de este ejercicio es implementar una función que determine si una palabra está en una sopa de letras.
     *
     * ### Reglas
     * - Las palabras pueden estar dispuestas direcciones horizontal o vertical, _no_ en diagonal.
     * - Las palabras pueden estar orientadas en cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
     * para abajo o viceversa.
     * - El cambio de dirección puede estar a media palabra, de modo que, por ejemplo, parte de la palabra
     * esté horizontal y de izquierda a derecha, parte esté vertical y de arriba hacia abajo, y otra parte horizontal
     * de derecha a la izquierda.
     *
     * @param word	Palabra a buscar en la sopa de letras.
     *
     * @return {@link Boolean}	true si la palabra se encuentra
     * en la sopa de letras.
     * */
    public boolean isPresent(String word) {               	
       	if(soup.length == 0) return false;       	
       	boolean wordIsPresentHorizontal = existsHorizontal(word);
       	boolean wordIsPresentVertical = existsVertical(word);       	
    	return wordIsPresentHorizontal || wordIsPresentVertical;
    }
    
    private boolean existsHorizontal(String word) {    	
    	for(int i = 0; i < soup.length; i++) {
    		String rowString = Arrays.toString(soup[i]);
    		if(rowString.contains(word)) return true;
    		if(rowString.contains(reverseString(word))) return true;
    	}
    	return false;
    }
    
    private boolean existsVertical(String word) {    	
    	for(int j = 0; j < soup[0].length; j++) {
    		StringBuilder stringBuilder = new StringBuilder();
    		for(int i = 0; i < soup.length; i++) {
    			stringBuilder.append(soup[i][j]);
    		}
    		if(stringBuilder.indexOf(word) >= 0) return true;
    		if(stringBuilder.indexOf(reverseString(word)) >=0) return true;
    	}
    	return false;
    }
    
    private String reverseString(String word) {
    	StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(word);
		return stringBuilder.reverse().toString();
    }
    
}
