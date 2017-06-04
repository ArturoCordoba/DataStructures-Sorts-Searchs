package search;

import datastructures.LinkedList;

/**
 * Created by Arturo on 30/5/2017.
 * Clase que implementa diferentes algoritmos de busqueda
 * @param <T> Tipo de dato abstracto
 */
public class SearchAlgorithms<T extends Comparable<T>> {
    /**
     * Metodo que retorna la posicion en la list de un elemento ingresado
     * @param list Lista en la que se realiza la busqueda
     * @param element Elemento que se desea buscar en la lista
     * @return La posicion del elemento en la lista, -1 si el elemento no esta en la lista
     */
    public int binarySearch(LinkedList list, T element){
        int first = 0;
        int last = list.getSize() - 1;
        int center;

        while(first <= last){
            center = (first + last) / 2;
            T centerValue = (T) list.getElement(center).getDataT();

            if(element.compareTo(centerValue) == 0){ //Se ha encontrado el elemento
                return center; //Se retorna la posicion del elemento
            } else if(element.compareTo(centerValue) < 0){
                last = center - 1; //Nos desplazamos hacia la izquierda
            } else{
                first = center + 1; //Nos desplazamos hacia la derecha
            }
        }
        return -1; //No se encontró el elemento
    }

    /**
     * Metodo que retorna la posicion en la list de un elemento ingresado
     * @param list Lista en la que se realiza la busqueda
     * @param element Elemento que se desea buscar en la lista
     * @return La posicion del elemento en la lista, -1 si el elemento no esta en la lista
     */
    public int interpolationSearch(LinkedList list, T element){
        int middle;
        int low = 0;
        int high = list.getSize() - 1;
        T middleValue;

        while(low <= high){
            middle = low + (((Integer)element - (int)list.getElement(low).getDataT()) * (high -low)) / ((int)list.getElement(high).getDataT() - (int)list.getElement(low).getDataT());
            middleValue = (T) list.getElement(middle).getDataT();

            if(element.compareTo(middleValue) == 0){ //Se ha encontrado el elemento
                return middle; //Se retorna la posicion del elemento
            } else if(element.compareTo(middleValue) < 0){
                high = middle - 1; //Nos desplazamos hacia la izquierda
            } else{
                low = middle + 1; //Nos desplazamos hacia la derecha
            }
        }
        return -1; //No se encontró el elemento
    }


}
