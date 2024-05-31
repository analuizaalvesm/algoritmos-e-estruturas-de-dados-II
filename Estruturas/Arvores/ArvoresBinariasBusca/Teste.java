package Estruturas.Arvores.ArvoresBinariasBusca;

public class Teste {
    public static void main(String[] args) {
        ABB<Integer> arvore = new ABB<Integer>();
        arvore.adicionar(10);
        arvore.adicionar(5);
        arvore.adicionar(15);
        arvore.adicionar(3);
        arvore.adicionar(7);
        arvore.adicionar(20);
        arvore.adicionar(12);

        System.out.println("Pre-Ordem: ");
        arvore.caminhamentoPreOrdem();

        System.out.println("\nIn-Ordem: ");
        arvore.caminhamentoEmOrdem();

        System.out.println("\nPos-Ordem: ");
        arvore.caminhamentoPosOrdem();

        System.out.println("\nBusca: ");
        System.out.println(arvore.pequisar(3));

        System.out.println("\nRemover: ");
        arvore.remover(8);
        arvore.caminhamentoEmOrdem();



    }   
}
