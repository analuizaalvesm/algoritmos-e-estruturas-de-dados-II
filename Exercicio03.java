
/**
 * Exercício 3 - Escreva um código recursivo em JAVA que calcula a divisão de um número inteiro através de subtrações sucessivas.
 */

import java.util.*;

public class Exercicio03 {

  static Scanner entrada;

  /**
   * Método que calcula a divisão de um número inteiro através de subtrações
   * sucessivas.
   * 
   * @param dividendo -> número a ser dividido
   * @param divisor   -> número pelo qual o dividendo será dividido
   * @return res -> resultado da divisão
   */
  public static int divisao(int dividendo, int divisor) {
    int res;
    if (dividendo < divisor) { // Condição de parada -> quando o dividendo for menor que o divisor, a divisão
                               // sempre será 0.
      res = 0;
    } else {
      res = 1 + divisao(dividendo - divisor, divisor);
    }
    return res;
  }

  public static void main(String[] args) {
    entrada = new Scanner(System.in);
    int dividendo = entrada.nextInt();
    int divisor = entrada.nextInt();
    System.out.println(divisao(dividendo, divisor));
  }
}