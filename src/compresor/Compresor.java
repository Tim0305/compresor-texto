package compresor;

import java.util.ArrayList;
import java.util.List;

public class Compresor {

    private static List<DatosIteracionCompresion> listDatosIteracionCompresions = new ArrayList<>();
    private static int startIndexArray;
    private static int endIndexArray;
    private static int index;
    private static int length;

    public static String comprimir(String texto) {

        length = texto.length();
        index = 0;
        startIndexArray = 0;
        endIndexArray = index + 5;

        int posicionCaracter = 0;
        int repeticiones = 0;
        char caracter = 0;

        for (index = 0; index < length; recorrerArreglo(repeticiones + 1)) {

            /*
            Cuerpo del metodo para comprimir el texto de acuerdo a los indices

            Arreglo de comparacion = texto[startIndexArray] -> texto [i - 1]
            Arreglo del texto original = texto[i] -> texto[endIndexArray]
             */
            repeticiones = 0;
            caracter = texto.charAt(index);
            System.out.println(caracter);
            posicionCaracter = existsInArray(texto, startIndexArray, index - 1, caracter);

            if (posicionCaracter != -1) {
                repeticiones++;
                posicionCaracter = getPosition(posicionCaracter, startIndexArray, index - 1);
//                for (int i = index + 1; i <= endIndexArray; i++) {
//
//                    caracter = texto.charAt(i);
//                    System.out.println(caracter);
//                    if (existsInArray(texto, startIndexArray, index - 1, caracter) != -1) {
//                        repeticiones++;
//
//                        // Determinar si el caracter es el ultimo
//                        if (i == endIndexArray) {
//                            System.out.println(i);
//                            // Caracter de termino
//                            caracter = 0;
//                            listDatosIteracionCompresions.add(new DatosIteracionCompresion(caracter, posicionCaracter, repeticiones));
//                        }
//                    } else {
//                        listDatosIteracionCompresions.add(new DatosIteracionCompresion(caracter, posicionCaracter, repeticiones));
//                        break;
//                    }
//                }

                repeticiones = getRepeticiones(startIndexArray, endIndexArray, index, texto);

                if (index + repeticiones > endIndexArray) {
                    listDatosIteracionCompresions.add(new DatosIteracionCompresion((char) 0, posicionCaracter, repeticiones));
                } else {
                    listDatosIteracionCompresions.add(new DatosIteracionCompresion(texto.charAt(repeticiones + index), posicionCaracter, repeticiones));
                }

            } else {
                DatosIteracionCompresion dto = new DatosIteracionCompresion(caracter, 0, 0);
                listDatosIteracionCompresions.add(dto);
            }
        }
        listDatosIteracionCompresions.forEach(c -> System.out.println(c));
        return null;
    }

    private static int getPosition(int index, int startIndex, int endIndex) {
        return endIndex - index + 1;
    }

    private static int existsInArray(String array, int startIndex, int endIndex, char c) {
        for (int i = startIndex; i <= endIndex; i++) {
            if (array.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    private static int getRepeticiones(int startIndex, int endIndex, int index, String text) {
        int repeticiones = 0;
        for (int i = index, j = startIndex; i <= endIndex; i++, j++) {
            if (text.charAt(i) != text.charAt(j)) {
                break;
            } else {
                repeticiones++;
            }
        }

        return repeticiones;
    }

    private static void recorrerArreglo(int pos) {

        endIndexArray += pos;

        if (endIndexArray >= length - 1) {
            endIndexArray = length - 1;
        }

        index += pos;

        if (index >= endIndexArray) {
            index = endIndexArray;
        }

        /*
            Cuando el indice del arreglo que se utiliza para comparar llegue a mas qu 7 se incrementa el indice de
            inicio del mismo array para que en total sean 7 caracteres a comparar
         */
        if (index > 7) {
            startIndexArray += pos;
        }
        /*
            Cuando el indice del final del arreglo de la cadena original llegue al final del string
            tenemos que evitar que el indice incremente
         */
//
//        System.out.println("Index: " + index);
//        System.out.println("Start: " + startIndexArray);
//        System.out.println("End: " + endIndexArray);
    }
}
