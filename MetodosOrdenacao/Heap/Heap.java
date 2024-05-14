package Heap;

import java.util.Arrays;

public class Heap {
  void sort(int[] array, int n) {

    // Criando outro vetor, com todos os elementos do vetor anterior reposicionados
    // (uma posição a frente)
    // de forma a ignorar a posição zero
    int[] tmp = new int[n + 1];
    for (int i = 0; i < n; i++) {
      tmp[i + 1] = array[i];
    }

    // Contrução do heap
    for (int tamHeap = 2; tamHeap <= n; tamHeap++) {
      constroi(tmp, tamHeap);
    }

    // Ordenação propriamente dita
    int tamHeap = n;
    while (tamHeap > 1) {
      troca(tmp, 1, tamHeap--);
      reconstroi(tmp, tamHeap);
    }

    // Alterar o vetor para voltar à posição zero
    for (int i = 0; i < n; i++) {
      array[i] = tmp[i + 1];
    }
  }

  void constroi(int[] array, int tamHeap) {

    for (int i = tamHeap; i > 1 && array[i] > array[i / 2]; i /= 2) {
      troca(array, i, i / 2);
    }
  }

  void reconstroi(int[] array, int tamHeap) {

    int i = 1;

    while (i <= (tamHeap / 2)) {
      int filho = getMaiorFilho(array, i, tamHeap);
      if (array[i] < array[filho]) {
        troca(array, i, filho);
        i = filho;
      } else {
        i = tamHeap;
      }
    }
  }

  int getMaiorFilho(int[] array, int i, int tamHeap) {

    int filho;

    if (2 * i == tamHeap || array[2 * i] > array[2 * i + 1]) {
      filho = 2 * i;
    } else {
      filho = 2 * i + 1;
    }
    return filho;
  }

  void troca(int[] array, int i, int j) {

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
    int n = array.length;
    Heap hs = new Heap();
    hs.sort(array, n);
    System.out.print("[Heap Sort] Array ordenado: " + Arrays.toString(array));
  }
}