package Recursividade;

/**
 * Exercício 02 - Escreva um código recursivo em JAVA para somar os dígitos de
 * um número inteiro.
 */

import java.util.*;

public class Exercicio02 {

  Scanner entrada;

  /**
   * Método recursivo que soma os dígitos de um número inteiro.
   * 
   * @param n -> número inteiro
   * @return -> soma dos dígitos
   */
  public static int somaDigitos(int n) {
    int res;
    if (n < 10) { // Condição de parada -> Se o número escolhido for menor do que 10, a soma dos
                  // dígitos é ele mesmo.
      res = n;
    } else {
      res = n % 10 + somaDigitos(n / 10); // Primeiramente calculamos o quociente da divisão do número por 10 para pegar
                                          // o último dígito do número. Depois disso, somamos o último dígito com a
                                          // chamada recursiva da função, passando o número dividido por 10 (que remove
                                          // o último dígito do número) como
                                          // parâmetro. Ex: 123 -> 3 + somaDigitos(12) -> 3 + 2 + somaDigitos(1) -> 3 +
                                          // 2 + 1 = 6
    }
    return res;
  }

  public static void main(String[] args) {
    int n;
    Scanner entrada = new Scanner(System.in);
    n = entrada.nextInt();
    System.out.println(somaDigitos(n));
    entrada.close();
  }
}