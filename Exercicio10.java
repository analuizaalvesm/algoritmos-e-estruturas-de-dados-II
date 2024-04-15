
/**
 * Crie um método recursivo que receba uma string e retorne true se a mesma for
 * composta somente por vogais. Crie outro método recursivo que receba uma
 * string e retorne true se a mesma for composta somente por consoantes. Crie um
 * terceiro método recursivo que receba uma string e retorne true se a mesma
 * corresponder a um número inteiro. Crie um quarto método recursivo que receba
 * uma string e retorne true se a mesma corresponder a um número real. Na saída
 * padrão, para cada linha de entrada, escreva outra de saída da seguinte forma
 * X1 X2 X3 X4 onde cada Xi é um booleano indicando se a entrada é: composta
 * somente por vogais (X1); composta somente por consoantes (X2); um número
 * inteiro (X3); um número real (X4). Se Xi for verdadeiro, seu valor deverá ser
 * SIM; caso contrário, NAO.
 */

import java.util.*;

public class Exercicio10 {
  static Scanner entrada = new Scanner(System.in);

  public static boolean isVogal(String txt) {
    if (txt.length() == 0) {
      return true;
    } else {
      char c = txt.toLowerCase().charAt(0);
      if (c == 32 || c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
        return isVogal(txt.substring(1));
      } else {
        return false;
      }
    }
  }

  public static boolean isConsoante(String txt) {
    if (txt.length() == 0) {
      return true;
    } else {
      char c = txt.toLowerCase().charAt(0);
      if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
        return false;
      } else if (c < 97 || c > 122) {
        return false;
      } else {
        return isConsoante(txt.substring(1));
      }
    }
  }

  public static boolean isInteiro(String txt) {
    if (txt.length() == 0) {
      return true;
    } else {
      if (txt.matches("[0-9]*") && !txt.matches("[.|,]*")) {
        return isInteiro(txt.substring(1));
      } else {
        return false;
      }
    }

  }

  public static boolean isReal(String txt) {
    if (txt.length() == 0) {
      return true;
    } else {
      if (txt.matches("[+-]?([0-9]*[.|,])?[0-9]*")) {
        return isReal(txt.substring(1));
      } else {
        return false;
      }
    }
  }

  public static void main(String[] args) {
    String txt;

    while (!((txt = entrada.nextLine()).equals("FIM"))) {
      if (isVogal(txt)) {
        System.out.print("SIM ");
      } else {
        System.out.print("NAO ");
      }
      if (isConsoante(txt)) {
        System.out.print("SIM ");
      } else {
        System.out.print("NAO ");
      }
      if (isInteiro(txt)) {
        System.out.print("SIM ");
      } else {
        System.out.print("NAO ");
      }
      if (isReal(txt)) {
        System.out.print("SIM");
      } else {
        System.out.print("NAO");
      }
      System.out.println("");
    }
  }
}
