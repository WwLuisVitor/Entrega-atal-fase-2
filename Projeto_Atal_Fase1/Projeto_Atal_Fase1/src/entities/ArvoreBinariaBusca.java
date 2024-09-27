package entities;

public class ArvoreBinariaBusca {
    
    class Node {
        Livro livro;
        Node esquerda, direita;

        public Node(Livro livro) {
            this.livro = livro;
            esquerda = direita = null;
        }
    }

    private Node raiz;
    private Livro[] livrosInseridos; 
    private int tamanhoLivros; 
    public ArvoreBinariaBusca() {
        raiz = null;
        livrosInseridos = new Livro[10]; 
        tamanhoLivros = 0; 
    }

    public void adicionar(Livro livro) {
        raiz = adicionarRecursivo(raiz, livro);
        if (tamanhoLivros < livrosInseridos.length) {
            livrosInseridos[tamanhoLivros] = livro; 
            tamanhoLivros++;
        } else {
            System.out.println("Limite de livros atingido!");
        }
    }

    private Node adicionarRecursivo(Node atual, Livro livro) {
        if (atual == null) {
            return new Node(livro);
        }

        if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, livro);
        } else if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) > 0) {
            atual.direita = adicionarRecursivo(atual.direita, livro);
        }

        return atual;
    }

    public Livro buscar(String titulo) {
        return buscarRecursivo(raiz, titulo);
    }

    private Livro buscarRecursivo(Node atual, String titulo) {
        if (atual == null) {
            return null;
        }

        if (titulo.equalsIgnoreCase(atual.livro.getTitulo())) {
            return atual.livro;
        }

        return titulo.compareToIgnoreCase(atual.livro.getTitulo()) < 0
            ? buscarRecursivo(atual.esquerda, titulo)
            : buscarRecursivo(atual.direita, titulo);
    }

    public void listar() {
        for (int i = 0; i < tamanhoLivros; i++) {
            System.out.println(livrosInseridos[i]);
        }
    }

    public void recomendarPorAno(int anoInicial, int anoFinal) {
        System.out.println("Recomendando livros publicados entre " + anoInicial + " e " + anoFinal + ":");
        recomendarPorAnoRecursivo(raiz, anoInicial, anoFinal);
    }

    private void recomendarPorAnoRecursivo(Node atual, int anoInicial, int anoFinal) {
        if (atual != null) {
            recomendarPorAnoRecursivo(atual.esquerda, anoInicial, anoFinal);

            if (atual.livro.getAno() >= anoInicial && atual.livro.getAno() <= anoFinal) {
                System.out.println(atual.livro);
            }

            recomendarPorAnoRecursivo(atual.direita, anoInicial, anoFinal);
        }
    }

    public void ordenarPorAutor() {
        for (int i = 0; i < tamanhoLivros - 1; i++) {
            for (int j = i + 1; j < tamanhoLivros; j++) {
                if (livrosInseridos[j].getAutor().compareToIgnoreCase(livrosInseridos[i].getAutor()) < 0) {
                    Livro temp = livrosInseridos[i];
                    livrosInseridos[i] = livrosInseridos[j];
                    livrosInseridos[j] = temp;
                }
            }
        }
    }

    public void listarPorAutor() {
        ordenarPorAutor(); 
        listar(); 
    }

    public int getSize() {
        return getSizeRecursivo(raiz);
    }

    private int getSizeRecursivo(Node atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + getSizeRecursivo(atual.esquerda) + getSizeRecursivo(atual.direita);
    }
}
