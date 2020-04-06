package com.baufest.ingreso.alphabetSoup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class WordSearcher {
	
	
	
    private char soup[][];
    private int rows;
    private int columns;
    private Set<Coord> coordsUsed;
    
    public WordSearcher(char soup[][]){
        this.soup = soup;
        rows = soup.length;
        if(rows > 0) {        	
        	columns = soup[0].length;
        }        	
        else
        	columns = 0;
        
        coordsUsed = new HashSet<>();
                
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
    	
    	if(rows == 0) return false;
    	
    	// Recorro las filas de la sopa de letras
    	for(int row = 0; row < soup.length; row++) {
    		 		
    		//recorro las columnas de la fila de la sopa de letras
    		for(int column = 0; column < soup[row].length; column++) {
    			
    			coordsUsed = new HashSet<>();
        		StringBuilder stringBuilder = new StringBuilder();
        		int indexWord = 0;
        		
    			if(existsCharacter(word,indexWord, row,column)) {
    				stringBuilder.append(word.charAt(0));
    				coordsUsed.add(new Coord(row, column));
    				    				
    				if(wordIsComplete(word,indexWord,row,column,stringBuilder)) return true;
    			}
    			
    		}
    		
    	}
       	
    	return false; 
       	
    }
    
    private boolean wordIsComplete(String word, int indexWord, int row, int column, StringBuilder stringBuilder) {
    	
    	 
    	if(canMoveUp(row, column)) {
    		if(existsCharacter(word, indexWord + 1, row - 1, column)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row - 1, column, stringBuilder);
    			
    		}
    	}
    		
    	if(canMoveDown(row, column)) {
    		if(existsCharacter(word, indexWord + 1, row + 1, column)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row + 1, column, stringBuilder);
    		}
    	}
    	
    	if(canMoveLeft(row, column)) {
    		if(existsCharacter(word, indexWord + 1, row, column - 1)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row, column - 1, stringBuilder);
    		}
    	}
    	
    	if(canMoveRight(row, column)) {
    		if(existsCharacter(word, indexWord + 1, row, column + 1)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row, column + 1, stringBuilder);
    		}
    	}
    	
    	
    	return false;
    			
    	
    }
    
    private boolean canMoveUp (int row, int column) {
    	return (!coordsUsed.contains(new Coord(row - 1, column)) && (row - 1) >= 0);
    }
    
    private boolean canMoveDown (int row, int column) {
    	return (!coordsUsed.contains(new Coord(row + 1, column)) && (row + 1) < this.rows);
    }
    
    private boolean canMoveLeft (int row, int column) {
    	return (!coordsUsed.contains(new Coord(row, column - 1)) && (column - 1) >= 0);
    }
    
    private boolean canMoveRight (int row, int column) {
    	return (!coordsUsed.contains(new Coord(row, column + 1)) && (column + 1) < this.columns);
    }
    
    private boolean existsCharacter(String word, int indexWord, int row, int column) {    	    	
    	return soup[row][column] == word.charAt(indexWord);    	
    }
    
    private boolean isSameWord(StringBuilder stringBuilded, String word) {
    	if(stringBuilded.toString().equalsIgnoreCase(word)) return true;
    	if(stringBuilded.toString().equalsIgnoreCase(reverseString(word))) return true;
    	return false;
    }
    
    private String reverseString(String word) {
    	StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(word);
		return stringBuilder.reverse().toString();
    }
    

    
}



