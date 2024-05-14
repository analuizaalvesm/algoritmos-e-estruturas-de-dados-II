package Estruturas.Pilhas.Vetor;

import java.util.NoSuchElementException;

public class Pilha<E> {

  private final E[] pilha;
  private int topo;

  @SuppressWarnings("unchecked")
  public Pilha(int tamanho) {
    pilha = (E[]) new Object[tamanho];
    topo = 0;
  }

  public boolean vazia() {
    return topo == 0;
  }

  private boolean cheia() {
    return topo == pilha.length;
  }

  public void empilhar(E item) {
    if (cheia()) {
      throw new IllegalStateException("Erro ao tentar empilhar o item [" + item + "]. A pilha está cheia!");
    }
    pilha[topo] = item;
    topo++;
  }

  public E desempilhar() {
    E item = consultarTopo();
    topo--;
    return item;
  }

  public E consultarTopo() {
    if (vazia()) {
      throw new NoSuchElementException("Não há nenhum item na pilha.");
    }
    return pilha[topo - 1];
  }
}