import java.util.Arrays;

public class bubbleSort {
  public static int[] sort(int[] array, int n) {
    for (int i = (n - 1); i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
    int n = array.length;
    array = sort(array, n);
    System.out.println("[Bubble Sort] Array ordenado: " + Arrays.toString(array));
  }
}
