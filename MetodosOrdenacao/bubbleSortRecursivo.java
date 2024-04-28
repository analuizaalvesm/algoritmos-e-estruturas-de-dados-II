import java.util.Arrays;

public class bubbleSortRecursivo {

    public static void trocarPosicao(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void ordenar(int arr[], int n, int i) {
        if (n == 1)
            return;
        if (i == n - 1) {
            ordenar(arr, n - 1, 0);
            return;
        }
        if (arr[i] > arr[i + 1]) {
            trocarPosicao(arr, i, i + 1);
        }
        ordenar(arr, n, i + 1);
    }

    public static void main(String[] args) {
        int[] vetor = {5, 3, 7, 1};
        int n = vetor.length;
        ordenar(vetor, n, 0);
        System.out.println("Array ordenado: "+ Arrays.toString(vetor));
    }
}
