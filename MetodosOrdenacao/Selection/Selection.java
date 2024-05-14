package Selection;

import java.util.*;

public class Selection {

    static Scanner scanner;

    static void pausa() {
        System.out.println("Enter para continuar.");
        scanner.nextLine();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void menu() {
        System.out.println("[MENU - ORDENAÇÃO POR SELEÇÃO]");
        System.out.println("1 - Gerar vetor aleatório");
        System.out.println("2 - Gerar vetor manual");
        System.out.println("3 - Ordenar vetor");
        System.out.println("4 - Imprimir vetor");
        System.out.println("5 - Sair");
    }

    public static int[] gerarArrayAleatorio(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
    }

    public static int[] gerarArrayManual(int n, Scanner scanner) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Insira o valor da posição " + i + ": ");
            vetor[i] = scanner.nextInt();
        }
        return vetor;
    }

    public static void trocarPosicao(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static int[] ordenar(int[] vetor) {
        int i, j, menor;
        for (i = 0; i < vetor.length - 1; i++) {
            menor = i;
            for (j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            trocarPosicao(vetor, i, menor);
        }
        return vetor;
    }

    public static void main(String[] args) {
        int tamVetor;
        int opcao = 0;
        int[] vetor = null;
        scanner = new Scanner(System.in);

        try {
            while (opcao != 5) {
                menu();
                System.out.print("Opção selecionada: ");
                opcao = scanner.nextInt();
                limparTela();

                switch (opcao) {
                    case 1:
                        System.out.print("Insira o tamanho do vetor: ");
                        tamVetor = scanner.nextInt();
                        vetor = gerarArrayAleatorio(tamVetor);
                        break;
                    case 2:
                        System.out.print("Insira o tamanho do vetor: ");
                        tamVetor = scanner.nextInt();
                        vetor = gerarArrayManual(tamVetor, scanner);
                        break;
                    case 3:
                        vetor = ordenar(vetor);
                        System.out.print("O vetor foi ordenado com sucesso.\n");
                        pausa();
                    case 4:
                        System.out.println("Vetor: " + Arrays.toString(vetor));
                        break;
                    default:
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERRO!] Opção inválida.");
        } finally {
            scanner.close();
        }
    }
};