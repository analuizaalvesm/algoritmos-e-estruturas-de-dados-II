
/**
 * Exercício 4 - Escreva um código recursivo em JAVA que calcula o resto da divisão de um número inteiro usando subtrações sucessivas.
 */

import java.util.*;

public class Exercicio04 {

  static Scanner entrada;

  public static int restoDivisao(int dividendo, int divisor) {
    if (dividendo < divisor) {
      return dividendo;
    }
    return restoDivisao(dividendo - divisor, divisor);
  }

  public static void main(String[] args) {
    entrada = new Scanner(System.in);
    int dividendo = entrada.nextInt();
    int divisor = entrada.nextInt();
    System.out.println(restoDivisao(dividendo, divisor));
  }
}