package Estruturas.Exercicios;

import java.io.*;
import java.util.*;

class Celula<T> {

  private T item;
  private Celula<T> anterior;
  private Celula<T> proximo;

  public Celula() {
    this.item = null;
    setAnterior(null);
    setProximo(null);
  }

  public Celula(T item) {
    this.item = item;
    setAnterior(null);
    setProximo(null);
  }

  public Celula(T item, Celula<T> anterior, Celula<T> proximo) {
    this.item = item;
    this.anterior = anterior;
    this.proximo = proximo;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public Celula<T> getAnterior() {
    return anterior;
  }

  public void setAnterior(Celula<T> anterior) {
    this.anterior = anterior;
  }

  public Celula<T> getProximo() {
    return proximo;
  }

  public void setProximo(Celula<T> proximo) {
    this.proximo = proximo;
  }
}

class ListaDuplamenteEncadeada<E> {

  private Celula<E> primeiro;
  private Celula<E> ultimo;
  private int tamanho;

  public ListaDuplamenteEncadeada() {
    Celula<E> sentinela = new Celula<>();
    this.primeiro = this.ultimo = sentinela;
    this.tamanho = 0;
  }

  public Celula<E> getPrimeiro() {
    return primeiro;
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

  public E localizarElemento(int posicao) {
    Celula<E> atual = this.primeiro.getProximo();

    if (posicao < 0 || posicao >= this.tamanho)
      throw new IndexOutOfBoundsException("Não foi possível obter o item da lista: "
          + "a posição informada é inválida!");

    for (int i = 0; i < posicao; i++)
      atual = atual.getProximo();

    return atual.getItem();
  }

  public void trocarElemento(int posicao, E novo) {
    if (posicao < 0 || posicao >= this.tamanho)
      throw new IndexOutOfBoundsException("Não foi possível alterar o item da lista: "
          + "a posição informada é inválida!");

    Celula<E> atual = this.primeiro.getProximo();
    for (int i = 0; i < posicao; i++)
      atual = atual.getProximo();

    atual.setItem(novo);
  }

  public int tamanho() {
    return this.tamanho;
  }
}

public class Acomodacao {

  // #region Atributos

  private int roomId;
  private int hostId;
  private String roomType;
  private String country;
  private String city;
  private String neighborhood;
  private int reviews;
  private double overallSatisfaction;
  private int accommodates;
  private double bedrooms;
  private double price;
  private String propertyType;
  static Scanner scanner;

  // #endregion

  // #region Construtores

  public Acomodacao() {
    this.roomId = 0;
    this.hostId = 0;
    this.roomType = "";
    this.country = "";
    this.city = "";
    this.neighborhood = "";
    this.reviews = 0;
    this.overallSatisfaction = 0.0;
    this.accommodates = 0;
    this.bedrooms = 0.0;
    this.price = 0.0;
    this.propertyType = "";
  }

  public Acomodacao(int roomId, int hostId, String roomType, String country, String city, String neighborhood,
      int reviews,
      double overallSatisfaction, int accommodates, double bedrooms, double price, String propertyType) {
    this.roomId = roomId;
    this.hostId = hostId;
    this.roomType = roomType;
    this.country = country;
    this.city = city;
    this.neighborhood = neighborhood;
    this.reviews = reviews;
    this.overallSatisfaction = overallSatisfaction;
    this.accommodates = accommodates;
    this.bedrooms = bedrooms;
    this.price = price;
    this.propertyType = propertyType;
  }

  // #endregion

  // #region Getters e Setters

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public int getHostId() {
    return hostId;
  }

  public void setHostId(int hostId) {
    this.hostId = hostId;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public int getReviews() {
    return reviews;
  }

  public void setReviews(int reviews) {
    this.reviews = reviews;
  }

  public double getOverallSatisfaction() {
    return overallSatisfaction;
  }

  public void setOverallSatisfaction(double overallSatisfaction) {
    this.overallSatisfaction = overallSatisfaction;
  }

  public int getAccommodates() {
    return accommodates;
  }

  public void setAccommodates(int accommodates) {
    this.accommodates = accommodates;
  }

  public double getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(double bedrooms) {
    this.bedrooms = bedrooms;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  // #endregion

  // #region Métodos de Negócio

  /**
   * Método que clona uma acomodação.
   * 
   * @return acomodação clonada
   */
  public Acomodacao clone() {
    return new Acomodacao(this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighborhood,
        this.reviews, this.overallSatisfaction, this.accommodates, this.bedrooms, this.price, this.propertyType);
  }

  /**
   * Método que imprime os dados formatados da acomodação.
   */
  public void imprimir(int posicao) {
    System.out.println("[" + posicao + "]" + " [" + this.roomId + " ## " + this.hostId + " ## " + this.roomType + " ## "
        + this.country
        + " ## "
        + this.city + " ## " + this.neighborhood + " ## " + this.reviews + " ## " + this.overallSatisfaction + " ## "
        + this.accommodates + " ## " + this.bedrooms + " ## " + this.price + " ## " + this.propertyType + "]");
  }

  /**
   * Método que recebe uma String de dados da acomodação, divide pelo caractere de
   * espaço e armazena o dado em sua respectiva variável.
   * 
   * @param entrada String única da linha do arquivo contendo os dados da
   *                acomodação
   */
  public void ler(String entrada) {
    String[] entradaPadrao = entrada.split("\t");
    setRoomId(Integer.parseInt(entradaPadrao[0]));
    setHostId(Integer.parseInt(entradaPadrao[1]));
    setRoomType(entradaPadrao[2]);
    setCountry(entradaPadrao[3]);
    setCity(entradaPadrao[4]);
    setNeighborhood(entradaPadrao[5]);
    setReviews(Integer.parseInt(entradaPadrao[6]));
    setOverallSatisfaction(Double.parseDouble(entradaPadrao[7]));
    setAccommodates(Integer.parseInt(entradaPadrao[8]));
    setBedrooms(Double.parseDouble(entradaPadrao[9]));
    setPrice(Double.parseDouble(entradaPadrao[10]));
    setPropertyType(entradaPadrao[11]);
  }

  /**
   * Método que lê o arquivo e armazena os dados tratados em um vetor de
   * acomodações.
   * 
   * @param arquivo     diretório do arquivo
   * @param acomodacoes vetor de acomodações
   * @throws IOException exceção de leitura de arquivo
   */
  public static void lerArquivo(String arquivo, ListaDuplamenteEncadeada<Acomodacao> acomodacoes) throws IOException {
    try (BufferedReader lerArquivo = new BufferedReader(new FileReader(arquivo))) {
      String line;
      lerArquivo.readLine();
      while ((line = lerArquivo.readLine()) != null) {
        Acomodacao acomodacao = new Acomodacao();
        acomodacao.ler(line);
        acomodacoes.inserirFinal(acomodacao);
      }
      lerArquivo.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }

  public static void trocarPosicao(ListaDuplamenteEncadeada<Acomodacao> acomodacoes, int i, int j) {
    Acomodacao temp = acomodacoes.localizarElemento(i);
    acomodacoes.trocarElemento(i, acomodacoes.localizarElemento(j));
    acomodacoes.trocarElemento(j, temp);
  }

  public static int particionar(ListaDuplamenteEncadeada<Acomodacao> acomodacoes, int comeco, int fim) {
    Acomodacao pivo = acomodacoes.localizarElemento(fim);
    int i = comeco - 1;
    for (int j = comeco; j < fim; j++) {
      if (acomodacoes.localizarElemento(j).price < pivo.price) {
        i++;
        trocarPosicao(acomodacoes, i, j);
      }
      if (acomodacoes.localizarElemento(j).price == pivo.price &&
          acomodacoes.localizarElemento(j).roomType.compareTo(pivo.roomType) < 0) {
        i++;
        trocarPosicao(acomodacoes, i, j);
      }
      if (acomodacoes.localizarElemento(j).price == pivo.price
          && acomodacoes.localizarElemento(j).roomType.equals(pivo.roomType)
          && acomodacoes.localizarElemento(j).roomId < pivo.roomId) {
        i++;
        trocarPosicao(acomodacoes, i, j);
      }
    }

    trocarPosicao(acomodacoes, i + 1, fim);
    return (i + 1);
  }

  public static void ordenar(ListaDuplamenteEncadeada<Acomodacao> acomodacoes, int comeco, int fim) {
    int part;
    if (comeco < fim) {
      part = particionar(acomodacoes, comeco, fim);
      ordenar(acomodacoes, comeco, part - 1);
      ordenar(acomodacoes, part + 1, fim);
    }
  }

  // #endregion

  public static void main(String[] args) throws IOException {
    String arquivo = "dados_airbnb.txt";
    scanner = new Scanner(System.in);
    ListaDuplamenteEncadeada<Acomodacao> acomodacoes = new ListaDuplamenteEncadeada<>();
    lerArquivo(arquivo, acomodacoes);

    int numQuartos = scanner.nextInt();
    ListaDuplamenteEncadeada<Acomodacao> quartosFiltrados = new ListaDuplamenteEncadeada<>();

    for (int i = 0; i < numQuartos; i++) {
      String busca = scanner.next();
      Celula<Acomodacao> atual = acomodacoes.getPrimeiro().getProximo();
      while (atual != null) {
        if (atual.getItem().getRoomId() == Integer.parseInt(busca)) {
          quartosFiltrados.inserirFinal(atual.getItem());
          break;
        }
        atual = atual.getProximo();
      }
    }
    ordenar(quartosFiltrados, 0, quartosFiltrados.tamanho() - 1);

    Celula<Acomodacao> atual = quartosFiltrados.getPrimeiro().getProximo();
    int posicao = 0;
    while (atual != null) {
      atual.getItem().imprimir(posicao);
      atual = atual.getProximo();
      posicao++;
    }
    scanner.close();
  }
}