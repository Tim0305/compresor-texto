package compresortexto;

import lz77.compresor.Compresor;
import lz77.PaqueteService;
import java.util.List;
import java.util.Scanner;
import lz77.Lz77Compresor;

public class CompresorTexto {

    public static void main(String[] args) {

        /*
        TODO:
        1. Comprimir
            1.1 Obtener el texto
            1.2 Obtener la salida generada equivalente al texto comprimido
            1.3 Imprimir la salida

        2. Descomprimir
            2.1 Obtener el código
            2.2 Obtener la salida generada equivalente al texto
            2.3 Imprimir la salida
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************************************");
        System.out.println("           Compresor de texto");
        System.out.println("*****************************************");

        System.out.println();
        System.out.println("(q) para salir");
        System.out.println();

        // Variables
        String op;
        String input;
        while (true) {

            System.out.println("[1] Comprimir");
            System.out.println("[2] Descomprimir");
            System.out.println();
            System.out.print("-> ");
            op = scanner.nextLine();
            System.out.println();

            switch (op) {
                case "q":
                    return;

                case "1":
                    // Comprimir
                    System.out.print("Ingrese el texto que quiere comprimir: ");
                    input = scanner.nextLine();
                    System.out.print("Resultado: ");
                    System.out.println(Lz77Compresor.comprimir(input));
                    break;

                case "2":
                    // Descomprimir
                    System.out.print("Ingrese el codigo que quiere descomprimir: ");
                    input = scanner.nextLine();
                    System.out.print("Resultado: ");
                    System.out.println(Lz77Compresor.descomprimir(input));
                    break;
                default:
                    System.out.println(String.format("La opcion '%s' no es valida", op));
            }

            System.out.println();
        }
    }
}
