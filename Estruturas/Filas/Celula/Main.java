package Estruturas.Filas.Celula;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Fila<Integer> fila = new Fila<Integer>();
    Fila<Integer> fila2 = new Fila<Integer>();

    fila.enfileirar(1);
    fila.enfileirar(2);
    fila.enfileirar(3);
    fila.enfileirar(4);
    fila.enfileirar(5);

    fila2.enfileirar(6);
    fila2.enfileirar(7);
    fila2.enfileirar(8);
    fila2.enfileirar(9);
    fila2.enfileirar(10);

    System.out.println("Fila 1: " + Arrays.toString(fila.toArray()));
    System.out.println("Fila 2: " + Arrays.toString(fila2.toArray()));

    fila2.concatenar(fila);

    System.out.println("Fila concatenada: " + Arrays.toString(fila2.toArray()));

    System.out.println("Primeiro item da fila: " + fila2.consultarPrimeiro());

  }
}
