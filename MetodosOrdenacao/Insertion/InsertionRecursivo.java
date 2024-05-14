package Insertion;

import java.util.Arrays;

public class InsertionRecursivo {
  public static void main(String[] args) {
    int[] array = { 5, 4, 3, 2, 1 };
    ordenar(array, array.length);
    System.out.println("Array ordenado: " + Arrays.toString(array));
  }

  public static void ordenar(int[] array, int n) {
    if (n <= 1) {
      return;
    }
    ordenar(array, n - 1);

    int ultimo = array[n - 1];
    int j = n - 2;
    while (j >= 0 && array[j] > ultimo) {
      array[j + 1] = array[j];
      j--;
    }
    array[j + 1] = ultimo;
  }
}
