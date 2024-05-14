package Estruturas.Pilhas.Celula;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Pilha<Integer> pilha = new Pilha<Integer>();
    Pilha<Integer> pilha2 = new Pilha<Integer>();

    pilha.empilhar(1);
    pilha.empilhar(2);
    pilha.empilhar(3);
    pilha.empilhar(4);
    pilha.empilhar(5);

    pilha2.empilhar(6);
    pilha2.empilhar(7);
    pilha2.empilhar(8);
    pilha2.empilhar(9);
    pilha2.empilhar(10);

    System.out.println("Pilha 1: " + Arrays.toString(pilha.toArray()));
    System.out.println("Pilha 2: " + Arrays.toString(pilha2.toArray()));

    pilha2.concatenar(pilha);

    System.out.println("Pilha concatenada: " + Arrays.toString(pilha2.toArray()));

    System.out.println("Primeiro item da pilha: " + pilha2.consultarTopo());

    pilha2.inverterPilha();

    System.out.println("Pilha invertida: " + Arrays.toString(pilha2.toArray()));
  }
}
