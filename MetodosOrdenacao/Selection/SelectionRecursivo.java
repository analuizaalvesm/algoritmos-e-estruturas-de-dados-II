package Selection;

import java.util.Arrays;

public class SelectionRecursivo {

    public static void trocarPosicao(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void ordenar(int[] vetor, int n) {
        if (n == 0) {
            return;
        }
        int menor = encontrarMenor(vetor, n, n);
        trocarPosicao(vetor, n, menor);
        ordenar(vetor, n - 1);
    }

    public static int encontrarMenor(int[] vetor, int n, int menorIndex) {
        if (n == 0) {
            return menorIndex;
        }
        if (vetor[n - 1] < vetor[menorIndex]) {
            menorIndex = n - 1;
        }
        return encontrarMenor(vetor, n - 1, menorIndex);
    }

    public static void main(String[] args) {
        int[] vetor = { 5, 3, 7, 1 };
        int n = vetor.length;
        ordenar(vetor, n - 1);
        System.out.println("Array ordenado: " + Arrays.toString(vetor));
    }
}
