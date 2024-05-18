package Estruturas.Exercicios;

import java.util.Scanner;

public class Estacionamento {

  public static class Fila<E> {

    private Celula<E> frente;
    private Celula<E> tras;
    private int tamanho;

    Fila() {
      Celula<E> sentinela = new Celula<E>();
      frente = tras = sentinela;
    }

    public int getTamanho() {
      return tamanho;
    }

    public boolean vazia() {
      return (frente == tras);
    }

    public void enfileirar(E item) {
      Celula<E> novaCelula = new Celula<E>(item);
      tras.setProximo(novaCelula);
      tras = tras.getProximo();
      tamanho++;
    }

    public E desenfileirar() {
      E item = null;
      Celula<E> primeiro;
      item = consultarPrimeiro();
      primeiro = frente.getProximo();
      frente.setProximo(primeiro.getProximo());
      primeiro.setProximo(null);

      if (primeiro == tras) {
        tras = frente;
      }
      tamanho--;

      return item;
    }

    public E consultarPrimeiro() {
      if (vazia()) {
        return null;
      }
      return frente.getProximo().getItem();
    }

    public void imprimir() {
      Celula<E> aux;
      if (vazia()) {
        System.out.println("A fila está vazia!");
      } else {
        aux = this.frente.getProximo();
        while (aux != null) {
          System.out.println(aux.getItem());
          aux = aux.getProximo();
        }
      }
    }
  }

  private static class Celula<T> {

    private final T item;
    private Celula<T> proximo;

    public Celula() {
      this.item = null;
      setProximo(null);
    }

    public Celula(T item) {
      this.item = item;
      setProximo(null);
    }

    public T getItem() {
      return item;
    }

    public Celula<T> getProximo() {
      return proximo;
    }

    public void setProximo(Celula<T> proximo) {
      this.proximo = proximo;
    }
  }

  public static class Carro {
    private String placa;
    private int manobrado;

    public Carro(String placa) {
      this.placa = placa;
      manobrado = 0;
    }

    public String getPlaca() {
      return placa;
    }

    public void manobrou() {
      manobrado++;
    }
  }

  public static void chegou(String placa, Fila<Carro> fila) {
    Carro novoCarro = new Carro(placa);
    fila.enfileirar(novoCarro);
    System.out.println("Carro de placa " + placa + " entrou no estacionamento.");
  }

  public static void partiu(String placa, Fila<Carro> fila) {
    Carro[] carros = new Carro[fila.getTamanho()];
    boolean carroEncontrado = false;
    int index = 0;
    while (!fila.vazia()) {
      String carroAtual = fila.consultarPrimeiro().getPlaca();
      if (carroAtual.equals(placa)) {
        carroEncontrado = true;
        System.out.println("Carro de placa " + placa + " saiu do estacionamento.");
        System.out.println("Esse carro foi manobrado " + fila.desenfileirar().manobrado + " vezes.");
      } else if (!carroEncontrado) {
        fila.consultarPrimeiro().manobrou();
        carros[index++] = fila.desenfileirar();
      } else {
        carros[index++] = fila.desenfileirar();
      }
    }

    if (!carroEncontrado) {
      System.out.println("Carro nao encontrado!");
    }

    for (int i = 0; i < index; i++) {
      fila.enfileirar(carros[i]);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Fila<Carro> fila = new Fila<>();

    String entrada = scanner.nextLine();
    while (!entrada.equals("FIM")) {
      String[] partes = entrada.split(" ");
      String placa = partes[1] + " " + partes[2];
      if (partes[0].equals("C")) {
        chegou(placa, fila);
      }
      if (partes[0].equals("P")) {
        partiu(placa, fila);
      }
      entrada = scanner.nextLine();
    }
    if (entrada.equals("FIM")) {
      while (!fila.vazia()) {
        System.out.println(fila.desenfileirar().placa);
      }
    }
    scanner.close();
  }
}
