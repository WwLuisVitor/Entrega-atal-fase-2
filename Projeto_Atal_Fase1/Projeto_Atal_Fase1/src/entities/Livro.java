package entities;

public class Livro implements Comparable<Livro> {
    private String autor;
    private String titulo;
    private int ano;

    public Livro(String autor, String titulo, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareToIgnoreCase(outroLivro.getTitulo());
    }

    @Override
    public String toString() {
        return "Livro -> autor: " + autor + " | título: " + titulo + " | ano: " + ano;
    }
}
