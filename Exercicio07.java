
/**
 * Crie um método recursivo que receba uma string como parâmetro e retorne
 * outra correspondente à entrada de forma cifrada. Neste exercício, suponha a
 * chave de ciframento três. A entrada termina com a leitura de “FIM”. Na
 * saída padrão, para cada linha de entrada, escreva uma linha com a mensagem
 * criptografada.
 */

import java.util.*;

public class Exercicio07 {

  static Scanner entrada;

  public static String cifrarTexto(String texto) {
    if (texto.length() == 0) {
      return "";
    } else {
      return (char) (texto.charAt(0) + 3) + cifrarTexto(texto.substring(1));
    }
  }

  public static void main(String[] args) {
    entrada = new Scanner(System.in);
    String texto = entrada.nextLine();

    while (!texto.equals("FIM")) {
      System.out.println(cifrarTexto(texto));
      texto = entrada.nextLine();
    }
  }
}
