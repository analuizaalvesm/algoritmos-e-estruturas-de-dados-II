package Recursividade;

/**
 * Implemente um método, em Java, denominado combinador, que receba duas
 * strings. Esse método deve ser capaz de combinar as duas strings recebidas
 * como parâmetros, alternando as letras de cada string, da seguinte forma:
 * comece com a primeira letra da primeira string, seguida pela primeira letra
 * da segunda string, continue com a segunda letra da primeira string, e assim
 * sucessivamente. As letras restantes da cadeia mais longa devem ser
 * adicionadas ao fim da string resultante, que deve ser retornada. Por exemplo,
 * se as duas strings recebidas como parâmetro forem Too e pCoder, a string
 * resultante deve ser TopCoder.
 */

public class Exercicio12 {

  public static void main(String[] args) {
    String string1 = "Too";
    String string2 = "pCder";
    System.out.println(combinador(string1, string2));
  }

  private static String combinador(String string1, String string2) {
    String result = "";
    int totalSize = string1.length() + string2.length();
    int countA = 0;
    int countB = 0;

    for (int i = 0; i < totalSize; i++) {
      for (int j = countA; j < countA + 2; j++) {
        if (j < string1.length()) {
          result += string1.charAt(j);
        }
      }
      for (int j = countB; j < countB + 2; j++) {
        if (j < string2.length()) {
          result += string2.charAt(j);
        }
      }
      countA += 2;
      countB += 2;
    }
    return result;
  }
}
