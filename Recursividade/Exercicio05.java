package Recursividade;

/**
 * Exercício 5 - Escreva um código recursivo em JAVA que calcula o n-ésimo número da série de fibonacci (0, 1, 1, 2, 3, 5...).
 */

import java.util.Scanner;

public class Exercicio05 {
  static Scanner entrada;

  public static int fibonacci(int n) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static String verificarSequencia(int n) {
    StringBuilder sequence = new StringBuilder();
    for (int i = 1; i < n + 1; i++) {
      sequence.append(fibonacci(i)).append(" ");
    }
    return sequence.toString();
  }

  public static void main(String[] args) {
    entrada = new Scanner(System.in);
    int n = entrada.nextInt();
    System.out.println(fibonacci(n));
  }
}
