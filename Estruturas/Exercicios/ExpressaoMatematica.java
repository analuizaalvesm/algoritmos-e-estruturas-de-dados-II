package Estruturas.Exercicios;

import java.util.NoSuchElementException;
import java.util.Scanner;

// Célula da pilha
class Celula<T> {
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

  public Celula(T item, Celula<T> proximo) {
    this.item = item;
    this.proximo = proximo;
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

// Pilha
class Pilha<E> {
  private Celula<E> topo;
  private Celula<E> fundo;

  public Pilha() {
    Celula<E> sentinela = new Celula<E>();
    fundo = sentinela;
    topo = sentinela;
  }

  public boolean vazia() {
    return fundo == topo;
  }

  public void empilhar(E item) {
    topo = new Celula<E>(item, topo);
  }

  public E desempilhar() {
    E desempilhado = consultarTopo();
    topo = topo.getProximo();
    return desempilhado;
  }

  public E consultarTopo() {
    if (vazia()) {
      throw new NoSuchElementException("Nao há nenhum item na pilha!");
    }
    return topo.getItem();
  }
}

public class ExpressaoMatematica {
  private static boolean operador(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
  }

  private static int precedeOperador(char op) {
    switch (op) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      default:
        return 0;
    }
  }

  public static String converter(String expressao) {
    StringBuilder npr = new StringBuilder();
    Pilha<Character> pilha = new Pilha<>();

    for (int i = 0; i < expressao.length(); i++) {
      char caractereAtual = expressao.charAt(i);

      if (Character.isLetterOrDigit(caractereAtual)) {
        npr.append(caractereAtual);
      } else if (operador(caractereAtual)) {
        while (!pilha.vazia() && precedeOperador(pilha.consultarTopo()) >= precedeOperador(caractereAtual)) {
          npr.append(pilha.desempilhar());
        }
        pilha.empilhar(caractereAtual);
      } else if (caractereAtual == '(') {
        pilha.empilhar(caractereAtual);
      } else if (caractereAtual == ')') {
        while (!pilha.vazia() && pilha.consultarTopo() != '(') {
          npr.append(pilha.desempilhar());
        }
        pilha.desempilhar();
      }
    }
    while (!pilha.vazia()) {
      npr.append(pilha.desempilhar());
    }
    return npr.toString().replace("", " ").trim();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String expressao = scanner.nextLine();
    while (!expressao.equals("FIM")) {
      System.out.println(converter(expressao));
      expressao = scanner.nextLine();
    }
    scanner.close();
  }
}
