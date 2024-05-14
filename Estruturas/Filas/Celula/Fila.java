package Estruturas.Filas.Celula;

import java.util.NoSuchElementException;
import Estruturas.Celula;

public class Fila<E> {
  private Celula<E> frente;
  private Celula<E> tras;
  private int tamanho;

  Fila() {
    Celula<E> sentinela = new Celula<E>();
    frente = tras = sentinela;
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

    // Caso o item desenfileirado seja também o último da fila.
    if (primeiro == tras)
      tras = frente;

    tamanho--;
    return item;
  }

  public E consultarPrimeiro() {
    if (vazia()) {
      throw new NoSuchElementException("Nao há nenhum item na fila!");
    }
    return frente.getProximo().getItem();
  }

  public void imprimir() {
    Celula<E> aux;
    if (vazia())
      System.out.println("A fila está vazia!");
    else {
      aux = this.frente.getProximo();
      while (aux != null) {
        System.out.println(aux.getItem());
        aux = aux.getProximo();
      }
    }
  }

  public int obterNumeroItens() {
    return tamanho;
  }

  public int obterNumItensAFrente(E item) {
    Celula<E> aux = frente.getProximo();
    int numItens = 0;
    while (aux != null) {
      if (aux.getItem().equals(item))
        return numItens;
      aux = aux.getProximo();
      numItens++;
    }
    return -1;
  }

  public boolean verificarExistencia(E item) {
    Celula<E> aux = frente.getProximo();
    while (aux != null) {
      if (aux.getItem().equals(item))
        return true;
      aux = aux.getProximo();
    }
    return false;
  }

  public void concatenar(Fila<E> fila) {
    Celula<E> aux = fila.frente.getProximo();
    while (aux != null) {
      enfileirar(aux.getItem());
      aux = aux.getProximo();
    }
  }

  public Fila<E> copiar() {
    Fila<E> novaFila = new Fila<E>();
    Celula<E> aux = frente.getProximo();
    while (aux != null) {
      novaFila.enfileirar(aux.getItem());
      aux = aux.getProximo();
    }
    return novaFila;
  }

  public Fila<E> dividir() {
    Fila<E> novaFila = new Fila<E>();
    Celula<E> aux = frente.getProximo();
    int i = 0;
    while (aux != null) {
      if (i >= tamanho / 2)
        novaFila.enfileirar(aux.getItem());
      aux = aux.getProximo();
      i++;
    }
    return novaFila;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray() {
    E[] array = (E[]) new Object[tamanho];
    Celula<E> aux = frente.getProximo();
    int i = 0;
    while (aux != null) {
      array[i] = aux.getItem();
      aux = aux.getProximo();
      i++;
    }
    return array;
  }
}