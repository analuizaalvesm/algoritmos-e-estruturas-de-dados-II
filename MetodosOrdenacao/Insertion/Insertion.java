package Insertion;

import java.util.Arrays;

public class Insertion {

  public static int[] ordenar(int[] array, int n) {
    for (int i = 1; i < n; i++) { // Começamos a partir do segundo elemento da lista, ou seja, o item de índice 1.
                                  // Pulamos o primeiro item porque um array de 1 item já está ordenado.
      int keyElement = array[i]; // Elemento que está sendo comparado
      int j = i - 1; // Representa a parcela da lista (itens a esquerda) que já está ordenada
      while ((j >= 0) && (array[j] > keyElement)) { // Se ainda existirem itens a esquerda para serem verificados (j >=
                                                    // 0)
                                                    // e se o elemento que estiver nessa posição à esquerda for maior
                                                    // que o elemento chave, então...
        array[j + 1] = array[j]; // ... avançamos o elemento em 1 posição
        j--; // Decrementamos j para sair do loop
      }
      array[j + 1] = keyElement; // Inserimos o elemento chave na posição correta
    }
    return array;
  }

  public static void main(String[] args) {
    int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
    int n = array.length;
    ordenar(array, n);
    System.out.println("[Insertion Sort] Array ordenado: " + Arrays.toString(array));
  }
}
