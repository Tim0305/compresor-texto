package compresor;

import java.util.ArrayList;
import java.util.List;

public class Compresor {

    private static List<DatosIteracionCompresion> listDatosIteracionCompresions = new ArrayList<>();

    public static String comprimir(String texto) {

        int length = texto.length();
        int startIndexArray = 0;
        int endIndexArray = 0;

        for (int i = 0; i < length; i++) {
            /*
            Cuando el indice del arreglo que se utiliza para comparar llegue a mas qu 7 se incrementa el indice de
            inicio del mismo array para que en total sean 7 caracteres a comparar
             */
            if (i > 7) {
                startIndexArray++;
            }

            /*
            Cuando el indice del final del arreglo de la cadena original llegue al final del string
            tenemos que evitar que el indice incremente
             */
            if (endIndexArray >= length - 1) {
                endIndexArray = length - 1;
            } else {
                endIndexArray = i + 5; // 5 porque requiero de 6 caracteres 0 - 5
            }

            /*
            Cuerpo del metodo para comprimir el texto de acuerdo a los indices

            Arreglo de comparacion = texto[startIndexArray] -> texto [i - 1]
            Arreglo del texto original = texto[i] -> texto[endIndexArray]
             */
            int repeticiones = 0;
            char c = texto.charAt(i);
            System.out.println(c);
            System.out.println("Start: " + startIndexArray);
            System.out.println("End: " + endIndexArray);
            int posicion = existsInArray(texto, startIndexArray, i - 1, c);
            System.out.println(posicion);
            if (posicion != -1) {
                for (i++; i < endIndexArray; i++) {
                    c = texto.charAt(i);
                    if (existsInArray(texto, startIndexArray, i - 1, c) != -1) {
                        repeticiones++;
                    } else {
                        listDatosIteracionCompresions.add(new DatosIteracionCompresion(c, getPosition(posicion, startIndexArray, i - 1), repeticiones));
                        break;
                    }

                }
            } else {
                DatosIteracionCompresion dto = new DatosIteracionCompresion(c, 0, 0);
                System.out.println(dto);
                listDatosIteracionCompresions.add(dto);
            }
        }
        listDatosIteracionCompresions.forEach(c -> System.out.println(c));
        return null;
    }

    private static int getPosition(int index, int startIndex, int endIndex) {
        return startIndex - index;
        // 0 1 2 3 4 5 6
        // 6 5 4 3 2 1
    }

    private static int existsInArray(String array, int startIndex, int endIndex, char c) {
        for (int i = startIndex; i <= endIndex; i++) {
            if (array.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
