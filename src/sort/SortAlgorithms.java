package sort;

import datastructures.LinkedList;
import datastructures.Node;

/**
 * Created by Arturo on 30/5/2017.
 * Clase que implementa diferentes algoritmos de ordenamiento
 */
public class SortAlgorithms {
    /**
     * Metodo que implementa el algoritmo de ordenamiento burbuja
     * @param list Lista que se desea ordenar
     */
    public static void bubbleSort(LinkedList list){
        for(int i = list.getSize() - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(list.getElement(j).getDataT().compareTo(list.getElement(j + 1).getDataT()) > 0){
                    Node node1 = list.getElement(j);
                    Node node2 = list.getElement(j + 1);
                    Node temp = new Node(node1.getDataT());
                    node1.setDataT(node2.getDataT());
                    node2.setDataT(temp.getDataT());
                }
            }
        }
    }

    /**
     * Metodo que implementa el algoritmo de ordenamiento por seleccion
     * @param list Lista que se desea ordenar
     */
    public static void selectionSort(LinkedList list){
        for(int i = 0; i < list.getSize() - 1; i++){

            //Se busca la posicion del elemento menor en la list
            int posMin = i;
            for (int x = i; x < list.getSize(); x++) {
                if (list.getElement(posMin).getDataT().compareTo(list.getElement(x).getDataT()) > 0) {
                    posMin = x;
                }
            }
            //Se hace un swap de los elementos
            Node node1 = list.getElement(i);
            Node node2 = list.getElement(posMin);
            Node temp = new Node(node1.getDataT());
            node1.setDataT(node2.getDataT());
            node2.setDataT(temp.getDataT());
        }
    }

    /**
     * Metodo que implementa el algoritmo de ordenamiento por insercion
     * @param list Lista que se desea ordenar
     */
    public static void insertionSort(LinkedList list){
        for(int i = 1; i < list.getSize(); i++){
            Node aux = new Node(list.getElement(i).getDataT());

            for(int x = i - 1; x >= 0; x--){
                if(list.getElement(x).getDataT().compareTo(aux.getDataT()) > 0){
                    Node node1 = list.getElement(x + 1);
                    Node node2 = list.getElement(x);
                    node1.setDataT(node2.getDataT());
                    node2.setDataT(aux.getDataT());
                }
            }
        }
    }

    /**
     * Metodo que implementa el algoritmo de ordenamiento ShellSort
     * @param list Lista que se desea ordenar
     */
    public static void shellSort(LinkedList list){
        int jump = list.getSize() / 2;

        while(jump > 0){
            for(int i = jump; i < list.getSize(); i++){
                int j = i - jump;
                while (j >= 0){
                    int k = j + jump;
                    if(list.getElement(j).getDataT().compareTo(list.getElement(k).getDataT()) < 0){
                        j = -1; //Se romple el ciclo
                    } else{
                        Node node1 = list.getElement(j);
                        Node node2 = list.getElement(k);
                        Node aux = new Node(list.getElement(j).getDataT());

                        node1.setDataT(node2.getDataT());
                        node2.setDataT(aux.getDataT());
                        j -= jump;
                    }
                }
            }
            jump = jump / 2;
        }
    }

    /**
     * Metodo que implementa el algoritmo de ordenamiento MergeSort
     * @param list Lista que se desea ordenar
     * @return La lista ordenada
     */
    public static LinkedList mergeSort(LinkedList list){
        if(list.getSize() > 1){ //Hay algo que ordenar
            int nElementsLeft = list.getSize() / 2;
            int nElementsRight = list.getSize() - nElementsLeft;
            LinkedList leftList = new LinkedList(); //Lista de los elementos a la izquierda
            LinkedList rightList = new LinkedList(); //Lista de los elemento a la derecha

            //Copiamos los elementos de la izquierda pertenecientes a la list original
            for(int i = 0; i < nElementsLeft; i++){
                leftList.insertElement(list.getElement(i).getDataT(), i);
            }
            //Copiamos los elementos de la derecha pertenecientes a la list original
            for(int i = nElementsLeft; i < list.getSize(); i++){
                rightList.insertElement(list.getElement(i).getDataT(), i - nElementsLeft);
            }

            leftList = mergeSort(leftList);
            rightList = mergeSort(rightList);

            int i = 0;
            int j = 0;
            int k = 0;
            while(leftList.getSize() != j && rightList.getSize() != k){
                Node node1 = list.getElement(i);
                if(leftList.getElement(j).getDataT().compareTo(rightList.getElement(k).getDataT()) < 0){
                    Node node2 = leftList.getElement(j);
                    node1.setDataT(node2.getDataT());
                    i++;
                    j++;
                } else{
                    Node node2 = rightList.getElement(k);
                    node1.setDataT(node2.getDataT());
                    i++;
                    k++;
                }
            }
            //Se unen las listas
            while (leftList.getSize() != j){
                Node node1 = list.getElement(i);
                Node node2 = leftList.getElement(j);
                node1.setDataT(node2.getDataT());
                i++;
                j++;
            }
            while (rightList.getSize() != k){
                Node node1 = list.getElement(i);
                Node node2 = rightList.getElement(k);
                node1.setDataT(node2.getDataT());
                i++;
                k++;
            }
        }
        return list;
    }

    /**
     * Metodo que implementa el algoritmo de ordenamiento QuickSort
     * @param list Lista que se desea ordenar
     */
    public static void quickSort(LinkedList list){
        quickSort(list, 0, list.getSize() - 1);
    }

    /**
     * Metodo que implementa el algoritmo de ordenamiento QuickSort
     * @param list Lista que se desea ordenar
     * @param first Posicion del primer elemento en la sublista actual
     * @param last Posicion del ultimo elemento en la sublista actual
     */
    private static void quickSort(LinkedList list, int first, int last){
        int i = first;
        int j = last;
        Node pivot = list.getElement((first + last) / 2);
        do{
            while(list.getElement(i).getDataT().compareTo(pivot.getDataT()) < 0){
                i++;
            }
            while(list.getElement(j).getDataT().compareTo(pivot.getDataT()) > 0){
                j--;
            }

            //Se hace el intercambio
            if(i <= j){
                Node node1 = list.getElement(i);
                Node node2 = list.getElement(j);
                Node aux = new Node(node1.getDataT());

                node1.setDataT(node2.getDataT());
                node2.setDataT(aux.getDataT());
                i++;
                j--;
            }

        } while (i <= j);
        if(first < j){
            quickSort(list, first, j);
        }
        if(i < last){
            quickSort(list, i, last);
        }
    }

    /**
     * Metodo para ordenar una list utilizando el algoritmo RadixSort
     * @param list Lista que se desea ordenar
     */
    public static void radixSort(LinkedList list) {
        // Se encuentra el numero mayor para conocer la cantidad maxima de digitos
        int m = getMax(list);

        //Se hace el ordenamiento segun el exponente actual
        for (int exp = 1; m/exp > 0; exp *= 10)
            radixSort(list, exp);
    }

    /**
     * Metodo para obtener el valor maximo en la lista
     * @param list Lista de la cual se desea obtener el valor maximo
     * @return El valor maximo
     */
    private static int getMax(LinkedList list){
        int max = (int) list.getElement(0).getDataT();
        for(int i = 1; i < list.getSize(); i++){
            if(list.getElement(i).getDataT().compareTo(max) > 0){
                max = (int) list.getElement(i).getDataT();
            }
        }
        return max;
    }

    /**
     * Metodo que cuenta la cantidad de ocurrencias de un digito segun la posicion del digito actual
     * @param list Lista que se desea ordenar
     * @param exp Exponente actual
     */
    private static void radixSort(LinkedList list, int exp){
        LinkedList output = new LinkedList();
        LinkedList count = new LinkedList(); //Lista de ocurrencias

        //Se construye la list de ocurrencias
        for(int j = 0; j < 10; j++){
            count.insertAtEnd(0);
        }

        //Se construye la list de salida
        for(int j = 0; j < list.getSize(); j++){
            output.insertAtEnd(0);
        }

        int i;

        //Se calcula la list de ocurrencias de los digitos que se estan analizando
        for(i = 0; i < list.getSize(); i++){
            int pos = ((int)list.getElement(i).getDataT() / exp) % 10;
            count.setElement((int)count.getElement(pos).getDataT() + 1, pos);
        }

        //Cambiamos count para que ahora contenga la posicion real de este digito en el output
        for(i = 1; i < 10; i++){
            count.setElement((int)count.getElement(i).getDataT() + (int)count.getElement(i - 1).getDataT(), i);
        }

        //Se construye la list ordenada por el digito actual
        for(i = list.getSize() - 1; i >= 0; i--){
            int pos = ((int)list.getElement(i).getDataT() / exp) % 10;
            output.setElement(list.getElement(i).getDataT(), (int)count.getElement(pos).getDataT() - 1);
            count.setElement((int)count.getElement(pos).getDataT() - 1, pos);
        }

        //Se copian los elementos de la list ordenada por el digito actual a la list original
        for(i = 0; i < list.getSize(); i++){
            list.setElement(output.getElement(i).getDataT(), i);
        }
    }
}
