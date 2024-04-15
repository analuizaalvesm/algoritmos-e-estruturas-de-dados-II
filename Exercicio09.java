
/**
 * Crie um método recursivo que receba uma string, sorteie duas letras
 * minúsculas aleatórias (código ASCII ≥ ’a’ e ≤ ’z’), substitua todas as
 * ocorrências da primeira letra na string pela segunda e retorne a string com
 * as alterações efetuadas. Na saída padrão, para cada linha de entrada,
 * execute o método desenvolvido nesta questão e mostre a string retornada
 * como uma linha de saída. Abaixo, observamos um exemplo de entrada supondo
 * que para a primeira linha as letras sorteadas foram o ’a’ e o ’q’. Para a
 * segunda linha, foram o ’e’ e o ’k’.
 */

/**
 * EXEMPLO DE ENTRADA: 
 o rato roeu a roupa do rei de roma e qwe qwe qwe ewq ewq ewq
 FIM

 EXEMPLO DE SAÍDA:
 o rqto roeu q roupq do rei de romq k qwk qwk qwk kwq kwq kwq
 */

/**
 * A classe Random, da hierarquia de classes de Java, gera números (ou letras)
 * aleatórios e seu atributo "seed" é a semente para geração de números aleatórios. 
 * Nesta questão, por causa da correção automática, "seed" deverá ser quatro.
 */

import java.util.*;

public class Exercicio09 {

  static Scanner entrada = new Scanner(System.in);

  private static String alterarTexto(String txt, char x, char y) {
    if (txt.length() == 0) {
      return "";
    }

    int index = 0;
    char currentCharPosition = txt.charAt(index);

    if (currentCharPosition == x) {
      index++;
      return y + alterarTexto(txt.substring(1), x, y);
    } else {
      index++;
      return currentCharPosition + alterarTexto(txt.substring(1), x, y);
    }
  }

  public static void main(String[] args) {
    String txt = "";
    String txtAlterado = "";
    char x, y;
    Random random = new Random();
    random.setSeed(4);

    while (!((txt = entrada.nextLine()).equals("FIM"))) {
      x = (char) ('a' + (Math.abs(random.nextInt()) % 26));
      y = (char) ('a' + (Math.abs(random.nextInt()) % 26));

      txtAlterado = alterarTexto(txt, x, y);
      System.out.println(txtAlterado);
      txtAlterado = "";
    }
    entrada.close();
  }
}
