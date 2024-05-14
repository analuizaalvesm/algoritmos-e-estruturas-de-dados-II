package Recursividade;

/**
 * Exercício 1 - Escreva um código recursivo em JAVA que conte os dígitos de um número inteiro.
 **/

import java.util.Scanner;

public class Exercicio01 {

  Scanner entrada;

  /**
   * Método recursivo que conta os dígitos de um número inteiro.
   * 
   * @param n -> número inteiro
   * @return -> quantidade de dígitos
   */
  public static int contarDigitos(int n) {
    int res;
    if (n <= 10) { // Condição de parada -> Se o número escolhido for menor do que 10, ele só tem 1
                   // dígito.
      res = 1;
    } else {
      res = 1 + contarDigitos(n / 10); // Remove o último dígito do número e chama a função novamente.
    }
    return res;
  }

  public static void main(String[] args) {
    int n;
    Scanner entrada = new Scanner(System.in);
    n = entrada.nextInt();
    System.out.println(contarDigitos(n));
    entrada.close();
  }
}