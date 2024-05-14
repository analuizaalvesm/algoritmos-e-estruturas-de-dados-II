package Recursividade;

public class Exercicio13 {

  /**
   * Método recursivo que recebe um número inteiro positivo ímpar (n) e imprime
   * todos
   * os números ímpares de 1 até n em ordem crescente.
   * 
   * @param n
   * @return
   */
  public static void imprimirImpares(int n) {

    if (n > 0) {
      imprimirImpares(n - 1);
      if (n % 2 != 0) {
        System.out.println(n);
      }
    }
  }

  public static void main(String[] args) {
    imprimirImpares(7);
  }
}
