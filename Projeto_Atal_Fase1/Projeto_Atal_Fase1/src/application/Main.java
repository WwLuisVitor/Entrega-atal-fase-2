package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import entities.Livro;
import entities.ArvoreBinariaBusca;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvoreLivros = new ArvoreBinariaBusca(); 
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            showMenu();
            System.out.print("Digite o numero da opcao que voce deseja: ");
            String op = sc.nextLine();
            switch (op) {
            case "1":
                System.out.print("Digite o nome do Autor: ");
                String autor = sc.nextLine();
                System.out.print("Digite o titulo do livro: ");
                String titulo = sc.nextLine();
                int ano = 0;
                boolean anoValido = false;
                while (!anoValido) {
                    System.out.print("Digite o ano de publicacao: ");
                    try {
                        ano = sc.nextInt();
                        anoValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Digite um valor valido para o ano!");
                        sc.next(); 
                    }
                }
                sc.nextLine(); 
                Livro livro = new Livro(autor, titulo, ano);
                arvoreLivros.adicionar(livro); 
                break;
            case "2":
                System.out.println();
                arvoreLivros.listar(); 
                break;
            case "3":
                System.out.print("Digite o titulo do livro que voce deseja: ");
                String t = sc.nextLine();
                System.out.println();
                Livro livroBuscado = arvoreLivros.buscar(t); 
                if (livroBuscado != null) {
                    System.out.println(livroBuscado);
                } else {
                    System.out.println("Nenhum livro com este titulo encontrado!");
                }
                break;
            case "4":
                boolean anoIniValidoRec = false;
                int anoInicial = 0;
                while (!anoIniValidoRec) {
                    System.out.print("Digite o ano inicial: ");
                    try {
                    	anoInicial = sc.nextInt();
                    	anoIniValidoRec = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Digite um valor valido para o ano!");
                        sc.next(); 
                    }
                }
                sc.nextLine(); 
                
                boolean anoFinValidoRec = false;
                int anoFinal = 0;
                while (!anoFinValidoRec) {
                    System.out.print("Digite o ano final: ");
                    try {
                    	anoFinal = sc.nextInt();
                    	anoFinValidoRec = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Digite um valor valido para o ano!");
                        sc.next(); 
                    }
                }
                sc.nextLine(); 
                arvoreLivros.recomendarPorAno(anoInicial, anoFinal); 
                break;
            case "5":
                arvoreLivros.listarPorAutor(); 
                break;
            case "6":
                System.out.println("Fim da aplicacao!");
                rodando = false;
                break;
            default:
                System.out.println("Ops! Esta opcao nao existe, por favor escolha uma de 1 a 6!");
                break;
            }
        }
        sc.close();
    }

    public static void showMenu() {
        System.out.println(".:.:.:.:.:.:.:.:.:..:.:.:.:.:.:.:.:.:.");
        System.out.println();
        System.out.println("1) Adicionar Livro");
        System.out.println("2) Listar Livros");
        System.out.println("3) Buscar Livro");
        System.out.println("4) Recomendar Livros por Ano");
        System.out.println("5) Ordenar Livros");
        System.out.println("6) Sair");
        System.out.println();
        System.out.println(".:.:.:.:.:.:.:.:.:..:.:.:.:.:.:.:.:.:.");
        System.out.println();
    }
}
