package Quick;

import java.util.Arrays;

public class Quick {

  public static void ordenar(int[] vetor, int inicio, int fim) {
    if (inicio < fim) {
      int posicaoPivo = separar(vetor, inicio, fim);
      ordenar(vetor, inicio, posicaoPivo - 1);
      ordenar(vetor, posicaoPivo + 1, fim);
    }
  }

  private static int separar(int[] vetor, int inicio, int fim) {
    int pivo = vetor[inicio];
    int i = inicio + 1, f = fim;
    while (i <= f) {
      if (vetor[i] <= pivo) {
        i++;
      } else if (pivo < vetor[f]) {
        f--;
      } else {
        int troca = vetor[i];
        vetor[i] = vetor[f];
        vetor[f] = troca;
        i++;
        f--;
      }
    }
    vetor[inicio] = vetor[f];
    vetor[f] = pivo;
    return f;
  }

  public static void main(String[] args) {
    int[] vetor = { 5, 3, 7, 1 };
    ordenar(vetor, 0, vetor.length - 1);
    System.out.println("Array ordenado: " + Arrays.toString(vetor));
  }
}
