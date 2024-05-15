package Estruturas.Listas.DuplamenteEncadeadas;

public class ListaDuplamenteEncadeada<E> {

  private Celula<E> primeiro;
  private Celula<E> ultimo;
  private int tamanho;

  public ListaDuplamenteEncadeada() {

    Celula<E> sentinela = new Celula<>();

    this.primeiro = this.ultimo = sentinela;
    this.tamanho = 0;
  }

  public boolean vazia() {

    return (this.primeiro == this.ultimo);
  }

  public void inserirFinal(E novo) {

    Celula<E> novaCelula = new Celula<>(novo, this.ultimo, null);

    this.ultimo.setProximo(novaCelula);
    this.ultimo = novaCelula;

    this.tamanho++;

  }

  public E removerFinal() {

    Celula<E> removida, penultima;

    if (vazia())
      throw new IllegalStateException("Não foi possível remover o último item da lista: "
          + "a lista está vazia!");

    removida = this.ultimo;

    penultima = this.ultimo.getAnterior();
    penultima.setProximo(null);

    removida.setAnterior(null);

    this.ultimo = penultima;

    this.tamanho--;

    return (removida.getItem());
  }

  public E removerInicio() {

    Celula<E> removida, segunda;

    if (vazia())
      throw new IllegalStateException("Não foi possível remover o primeiro item da lista: "
          + "a lista está vazia!");

    removida = this.primeiro.getProximo();
    segunda = removida.getProximo();

    this.primeiro.setProximo(segunda);
    segunda.setAnterior(this.primeiro);

    removida.setProximo(null);
    removida.setAnterior(null);

    if (removida == this.ultimo) {
      this.ultimo = this.primeiro;
    }

    this.tamanho--;

    return (removida.getItem());
  }

  public E remover(E itemProcurado) {

    Celula<E> atual = this.primeiro.getProximo();

    while (atual != null) {
      if (atual.getItem().equals(itemProcurado)) {
        Celula<E> anterior = atual.getAnterior();
        Celula<E> proximo = atual.getProximo();

        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);

        atual.setAnterior(null);
        atual.setProximo(null);

        if (atual == this.ultimo) {
          this.ultimo = anterior;
        }

        this.tamanho--;

        return (atual.getItem());
      }

      atual = atual.getProximo();
    }

    return null;
  }

  public int obterNumeroItens() {
    return this.tamanho;
  }

  public E localizar(int posicao) {

    if (posicao < 0 || posicao >= this.tamanho)
      throw new IllegalArgumentException("Posição inválida!");

    Celula<E> atual = this.primeiro.getProximo();

    for (int i = 0; i < posicao; i++) {
      atual = atual.getProximo();
    }

    return atual.getItem();
  }

  public void trocar(E itemX, E itemY) {
    Celula<E> atual = this.primeiro.getProximo();
    Celula<E> celulaX = null;
    Celula<E> celulaY = null;

    if (vazia()) {
      throw new IllegalStateException("A lista está vazia!");
    }

    while (atual != null) {
      if (atual.getItem().equals(itemX)) {
        celulaX = atual;
      }

      if (atual.getItem().equals(itemY)) {
        celulaY = atual;
      }

      atual = atual.getProximo();
    }

    if (celulaX == null || celulaY == null) {
      throw new IllegalArgumentException("Os itens " + itemX + " e " + itemY + " não estão na lista!");
    }

    E itemAux = celulaX.getItem();
    celulaX.setItem(celulaY.getItem());
    celulaY.setItem(itemAux);
  }

  public void criarBuracoMatriz(int coluna, int linha) {
    Celula<E> atual = this.primeiro.getProximo();
    Celula<E> celulaColuna = null;
    Celula<E> celulaLinha = null;

    if (vazia()) {
      throw new IllegalStateException("A lista está vazia!");
    }

    while (atual != null) {
      if (atual.getItem().equals(coluna)) {
        celulaColuna = atual;
      }

      if (atual.getItem().equals(linha)) {
        celulaLinha = atual;
      }

      atual = atual.getProximo();
    }

    if (celulaColuna == null || celulaLinha == null) {
      throw new IllegalArgumentException("Os itens " + coluna + " e " + linha + " não estão na lista!");
    }

    Celula<E> buraco = new Celula<>();
    buraco.setAnterior(celulaColuna);
    buraco.setProximo(celulaLinha);

    celulaColuna.setProximo(buraco);
    celulaLinha.setAnterior(buraco);
  }

  public E[] toArray() {
    E[] array = (E[]) new Object[this.tamanho];
    Celula<E> atual = this.primeiro.getProximo();

    for (int i = 0; i < this.tamanho; i++) {
      array[i] = atual.getItem();
      atual = atual.getProximo();
    }

    return array;
  }
}