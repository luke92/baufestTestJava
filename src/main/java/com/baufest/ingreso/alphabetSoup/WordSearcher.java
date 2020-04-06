package com.baufest.ingreso.alphabetSoup;

import java.util.HashSet;
import java.util.Set;

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

        Set<Coord> coordsUsed;
     
        coordsUsed = new HashSet<>();       
  	
    	// Recorro las filas de la sopa de letras
    	for(int row = 0; row < soup.length; row++) {
    		 		
    		//recorro las columnas de la fila de la sopa de letras
    		for(int column = 0; column < soup[row].length; column++) {
    			
    			coordsUsed = new HashSet<>();
        		StringBuilder stringBuilder = new StringBuilder();
        		int indexWord = 0;
        		
    			if(existsCharacter(word,indexWord, row,column,coordsUsed)) {
    				stringBuilder.append(word.charAt(0));
    				coordsUsed.add(new Coord(row, column));
    				    				
    				if(wordIsComplete(word,indexWord,row,column,stringBuilder,coordsUsed)) return true;
    			}
    			
    		}
    		
    	}
       	
    	return false; 
       	
    }
    
    private boolean wordIsComplete(String word, int indexWord, int row, int column, StringBuilder stringBuilder, Set<Coord> coordsUsed) {
    	
    	if(isSameWord(stringBuilder, word)) return true;
    	 
    	if(canMoveUp(row, column, coordsUsed)) {
    		
    		if(existsCharacter(word, indexWord + 1, row - 1, column, coordsUsed)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row - 1, column, stringBuilder, coordsUsed);
    			
    		}
    	}
    		
    	if(canMoveDown(row, column, coordsUsed)) {
    		if(existsCharacter(word, indexWord + 1, row + 1, column, coordsUsed)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row + 1, column, stringBuilder, coordsUsed);
    		}
    	}
    	
    	if(canMoveLeft(row, column, coordsUsed)) {
    		if(existsCharacter(word, indexWord + 1, row, column - 1, coordsUsed)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row, column - 1, stringBuilder, coordsUsed);
    		}
    	}
    	
    	if(canMoveRight(row, column, coordsUsed)) {
    		if(existsCharacter(word, indexWord + 1, row, column + 1, coordsUsed)) {
    			stringBuilder.append(word.charAt(indexWord + 1));
    			if(isSameWord(stringBuilder, word)) return true;
    			return wordIsComplete(word, indexWord + 1, row, column + 1, stringBuilder, coordsUsed);
    		}
    	}
    	
    	if(isSameWord(stringBuilder, word)) return true;
    	
    	return false;
    			
    	
    }
    
    private boolean canMoveUp (int row, int column, Set<Coord> coordsUsed) {
    	if((row - 1) < 0) return false;
    	
    	return (!coordsUsed.contains(new Coord(row - 1, column)));
    }
    
    private boolean canMoveDown (int row, int column, Set<Coord> coordsUsed) {
    	if((row + 1) >= soup.length) return false;
    	
    	return (!coordsUsed.contains(new Coord(row + 1, column)));
    }
    
    private boolean canMoveLeft (int row, int column, Set<Coord> coordsUsed) {
    	if((column - 1) < 0) return false;
    	
    	return (!coordsUsed.contains(new Coord(row, column - 1)));
    }
    
    private boolean canMoveRight (int row, int column, Set<Coord> coordsUsed) {
    	if((column + 1) >= soup[0].length) return false;
    	
    	return (!coordsUsed.contains(new Coord(row, column + 1)));
    }
    
    private boolean existsCharacter(String word, int indexWord, int row, int column, Set<Coord> coordsUsed) {
    	coordsUsed.add(new Coord(row, column));
    	return soup[row][column] == word.charAt(indexWord);    	
    }
    
    private boolean isSameWord(StringBuilder stringBuilded, String word) {
    	return (stringBuilded.toString().equalsIgnoreCase(word));
    }
     
}



