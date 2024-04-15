
/**
 * Crie um método recursivo que receba uma string contendo uma expressão booleana e os 
 * valores de suas entradas e retorne um número inteiro indicando se a expressão é verdadeira ou falsa. 
 * Cada string da entrada padrão é composta por um número inteiro n, que indica o número de entradas da 
 * expressão booleana corrente.
 * Em seguida, a string contém n valores binários (um para cada entrada) e a expressão booleana. 
 * Na saída padrão, para cada linha de entrada, escreva uma linha de saída com 1 ou 0, indicando 
 * se a expressão corrente é verdadeira ou falsa.
 * 
 * Exemplos:
 * Eentrada: 2 0 0 and(not(A) , not(B))
 * Saída: 1
 * 
 * Entrada: 3 0 0 0 and(or(A , B) , not(and(B , C)))
 * Saída: 0
 */

import java.util.Scanner;

public class Exercicio11 {
  static Scanner entrada;

  private static String verificarExpressao(String expressaoBooleana, int tam) {
    char[] exp = expressaoBooleana.toCharArray();
    int index = expressaoNumerica(exp, tam);
    ultimoParenteses(exp, index, 0, 0, tam);
    return String.valueOf(exp[index]);
  }

  private static int expressaoNumerica(char[] exp, int tam) {
    int A = exp[2];
    int B = exp[4];
    int C = exp[6];

    int index = 6;
    if (exp[0] == '3') {
      index = 8;
    }

    for (int i = tam; i >= index; i--) {
      if (exp[i] == 'A') {
        exp[i] = (char) A;
      } else if (exp[i] == 'B') {
        exp[i] = (char) B;
      } else if (exp[i] == 'C') {
        exp[i] = (char) C;
      }
    }

    return index;
  }

  private static int primeiroParenteses(char[] exp, int fechaParentese) {
    int abreParentese;
    if (exp[fechaParentese] == '(') {
      abreParentese = fechaParentese;
    } else {
      abreParentese = primeiroParenteses(exp, fechaParentese - 1);
    }
    return abreParentese;
  }

  private static void ultimoParenteses(char[] exp, int posInicial, int abreParentese,
      int fechaParentese, int posFinal) {

    if (exp[posInicial] == ')') {
      fechaParentese = posInicial;
      abreParentese = primeiroParenteses(exp, fechaParentese - 1);
      verificarOperacao(exp, abreParentese, fechaParentese);
    }

    if (posInicial < posFinal) {
      ultimoParenteses(exp, posInicial + 1, abreParentese, fechaParentese, posFinal);
    }

    if (posInicial == posFinal) {
      System.out.println(exp[fechaParentese]);
      return;
    }
  }

  private static void verificarOperacao(char[] exp, int abreParentese, int fechaParentese) {
    char operador = exp[abreParentese - 1];
    switch (operador) {
      case 't':
        operadorNot(exp, abreParentese - 3, fechaParentese);
        break;
      case 'd':
        exp[fechaParentese] = '1';
        operadorAnd(exp, abreParentese - 3, fechaParentese);
        break;
      case 'r':
        exp[fechaParentese] = '0';
        operadorOr(exp, abreParentese - 2, fechaParentese);
        break;
    }
  }

  private static void operadorNot(char[] exp, int abreParentese, int fechaParentese) {
    if (exp[abreParentese] == '0') {
      exp[fechaParentese] = '1';
    } else if (exp[abreParentese] == '1') {
      exp[fechaParentese] = '0';
    }
    exp[abreParentese] = ' ';
    if (abreParentese < fechaParentese - 1) {
      operadorNot(exp, abreParentese + 1, fechaParentese);
    }
  }

  private static void operadorAnd(char[] exp, int abreParentese, int fechaParentese) {
    if (exp[abreParentese] == '0') {
      exp[fechaParentese] = '0';
    }
    exp[abreParentese] = ' ';
    if (abreParentese < fechaParentese - 1) {
      operadorAnd(exp, abreParentese + 1, fechaParentese);
    }
  }

  private static void operadorOr(char[] exp, int abreParentese, int fechaParentese) {
    if (exp[abreParentese] == '1') {
      exp[fechaParentese] = '1';
    }
    exp[abreParentese] = ' ';
    if (abreParentese < fechaParentese - 1) {
      operadorOr(exp, abreParentese + 1, fechaParentese);
    }
  }

  public static void main(String[] args) {
    entrada = new Scanner(System.in);
    String expressaoBooleana = entrada.nextLine();
    while (expressaoBooleana.length() > 1) {
      verificarExpressao(expressaoBooleana, expressaoBooleana.length() - 1);
      expressaoBooleana = entrada.nextLine();
    }
  }
}