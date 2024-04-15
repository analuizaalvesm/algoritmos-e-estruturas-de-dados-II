
/**
 * Exercício 6 - Escreva um código recursivo em JAVA que leia uma ou mais Strings e verifica se elas são palíndromo. 
 * A última linha da entrada é identificada com #.
 */

import java.util.*;

public class Exercicio06 {
  static Scanner entrada;

  public static boolean palindromo(String texto) {
    if (texto.length() <= 1) {
      return true;
    } else if (texto.charAt(0) == texto.charAt(texto.length() - 1)) {
      return palindromo(texto.substring(1, texto.length() - 1));
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    entrada = new Scanner(System.in);
    String texto = entrada.nextLine();

    while (!texto.equals("#")) {
      if (palindromo(texto)) {
        System.out.println("SIM");
      } else {
        System.out.println("NAO");
      }
      texto = entrada.nextLine();
    }
  }
}