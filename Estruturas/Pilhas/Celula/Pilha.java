package Estruturas.Pilhas.Celula;

import java.util.NoSuchElementException;
import Estruturas.Celula;

public class Pilha<E> {
  private Celula<E> topo;
  private Celula<E> fundo;
  private int tamanho;

  public Pilha() {
    Celula<E> sentinela = new Celula<E>();
    fundo = sentinela;
    topo = sentinela;
  }

  /**
   * Método que verifica se a pilha está vazia.
   * 
   * @return boolean - Retorna true se a pilha estiver vazia, caso contrário,
   *         retorna false.
   */
  public boolean vazia() {
    return fundo == topo;
  }

  /**
   * Método que empilha um item na pilha.
   * 
   * @param item - Item a ser adicionado no topo da pilha.
   */
  public void empilhar(E item) {
    topo = new Celula<E>(item, topo);
    tamanho++;
  }

  /**
   * Método que desempilha um item da pilha.
   * 
   * @return E - Item removido do topo da fila.
   */
  public E desempilhar() {
    E desempilhado = consultarTopo();
    topo = topo.getProximo();
    tamanho--;
    return desempilhado;
  }

  /**
   * Método que retorna o item do topo da pilha.
   * 
   * @return E - Item do topo da pilha.
   */
  public E consultarTopo() {
    if (vazia()) {
      throw new NoSuchElementException("Nao há nenhum item na pilha!");
    }
    return topo.getItem();
  }

  public int obterNumeroItens() {
    return tamanho;
  }

  /**
   * Método que concatena os elementos de uma pilha com a pilha atual.
   * 
   * @param pilha - Pilha a ser concatenada.
   */
  public void concatenar(Pilha<E> pilha) {
    Pilha<E> pilhaAux = new Pilha<>();
    if (pilha.vazia()) {
      return;
    }

    while (!vazia()) {
      pilhaAux.empilhar(desempilhar());
    }
    while (!pilha.vazia()) {
      pilhaAux.empilhar(pilha.desempilhar());
    }
    while (!pilhaAux.vazia()) {
      empilhar(pilhaAux.desempilhar());
    }
  }

  /**
   * Método que inverte os elementos da pilha.
   */
  public void inverterPilha() {
    Celula<E> novaCelula = fundo; // Cria uma nova célula (variável de controle) que aponta para o fundo
    Celula<E> celula = topo; // Cria uma célula (variável de controle) que aponta para o topo
    while (celula != fundo) { // Enquanto a célula não for o fundo a pilha não está vazia
      novaCelula.setProximo(new Celula<E>(celula.getItem(), novaCelula.getProximo()));
      celula = celula.getProximo();
    }
    topo = novaCelula.getProximo();
  }

  /**
   * Método que retorna um array com os elementos da pilha.
   * 
   * @return E[] - Array com os elementos da pilha.
   */
  @SuppressWarnings("unchecked")
  public E[] toArray() {
    E[] array = (E[]) new Object[tamanho];
    Celula<E> celula = topo;
    for (int i = 0; i < tamanho; i++) {
      array[i] = celula.getItem();
      celula = celula.getProximo();
    }
    return array;
  }
}