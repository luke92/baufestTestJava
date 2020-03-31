# Examen de nivelación de Baufest
## Consideraciones generales
- Para resolver los ejercicios en general alcanza con implementar un métodos. De todas maneras, está permitido agregar métodos, clases, interfaces o lo que consideres necesario
- Para verificar la implementación se pueden ejecutar los test correspondientes a cada ejercicio. Los tests se encuentran en el package correspondiente al ejercicio dentro de src/test/

## Ejercicio 1: Sorting

Para realizar este ejercicio se debe modificar el archivo Sorting.java del paquete com.baufest.ingreso.sorting .

a.	Implementar el método `ordenarPorPuntuacionYNombre`, para ordenar los jugadores en una lista. Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.  
b.	Implementar el método `ordenarPorPuntuacionPerdidasYNombre`, similar al del punto a) pero que tenga en cuenta las pérdidas de un jugador. Cuando 2 jugadores tienen igual cantidad de puntos, el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el nombre de manera ascendente.  

## Ejercicio 2: Caracteres repetidos
Para realizar este ejercicio se debe modificar el archivo RepeatedCharacters.java del paquete com.baufest.ingreso.strings.

El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:

1- Todos los caracteres aparecen la misma cantidad de veces.<br>

    Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     
2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     
    Ejemplos: "aabbccc", "aabbc", "aaaaccccc"


## Ejercicio 3: Alphabet Soup

Para realizar este ejercicio se debe modificar el archivo WordSearcher.java del paquete com.baufest.ingreso.alphabetSoup .

### Objetivo

El objetivo de este ejercicio es implementar una función que determine si una palabra está en una sopa de letras.

### Reglas
- Las palabras pueden estar dispuestas direcciones horizontal o vertical, _no_ en diagonal.
- Las palabras pueden estar orientadas en cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
para abajo o viceversa.
- El cambio de dirección puede estar a media palabra, de modo que, por ejemplo, parte de la palabra
esté horizontal y de izquierda a derecha, parte esté vertical y de arriba hacia abajo, y otra parte horizontal
de derecha a la izquierda.

A continuación se muestran un par de ejemplos:

**Horizontal**

X X X X X X X  
P A L A B R A  
X X X X X X X   
X X X X X X X   
X X X X X X X

**Vertical**

A X X X X X X  
R X X X X X X   
B X X X X X X  
A X X X X X X   
L X X X X X X  
A X X X X X X  
P X X X X X X  

**Horizontal y Vertical**

X X P X X X X X    
X X A X X X X X    
X X L X X X X X   
X X A B R A X X    
X X X X X X X X   

X X X X X X X X  
X A R B X X X X  
X X X A X X X X   
X X X L A P X X  
X X X X X X X X   
