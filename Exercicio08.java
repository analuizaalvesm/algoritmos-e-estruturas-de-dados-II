
/**
 * Crie um método recursivo que receba uma string como parâmetro e retorne true se essa for um palíndromo. 
 * A entrada do programa termina com a leitura de “FIM”. 
 * Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NAO indicando se a entrada corresponde a um palíndromo ou não. 
 * Destaca-se que uma linha de entrada pode conter caracteres não-letras.
 */

import java.util.*;

public class Exercicio08 {
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

    while (!texto.equals("FIM")) {
      if (palindromo(texto)) {
        System.out.println("SIM");
      } else {
        System.out.println("NAO");
      }
      texto = entrada.nextLine();
    }
  }
}
