package com.marcos.livraria;

import com.marcos.livraria.model.dao.AutorDAO;
import com.marcos.livraria.model.dao.BookDAO;
import com.marcos.livraria.model.dao.DAOFactory;
import com.marcos.livraria.model.entities.Autor;
import com.marcos.livraria.model.entities.Book;
import com.marcos.livraria.util.db.ClassScanner;
import com.marcos.livraria.util.db.DB;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        AutorDAO autorDAO = DAOFactory.createAutorDAO();
        BookDAO bookDAO = DAOFactory.createBookDAO();

        System.out.println("""
                O que você deseja?
                1: ADICIONAR AUTOR
                2: ATUALIZAR AUTOR
                3: DELETAR AUTOR
                4: BUSCAR AUTOR POR ID
                5: ADICIONAR LIVRO
                6: ATUALIZAR LIVRO
                7: DELETAR LIVRO
                8: BUSCAR LIVRO POR ID
                9: SAIR""");

        int escolha = 0;

        while(escolha != 9) {
            System.out.print("ESCOLHA: ");
            escolha = ClassScanner.getScanner().nextInt();
            ClassScanner.getScanner().nextLine();
            try {
                switch (escolha) {
                    case 1: {
                        adicionarAutor(autorDAO);
                        break;
                    }
                    case 2: {
                        System.out.print("Digite o ID do autor que você deseja atualizar: ");
                        int id = ClassScanner.getScanner().nextInt();
                        ClassScanner.getScanner().nextLine();
                        atualizarAutor(autorDAO, id);
                        break;
                    }
                    case 3: {
                        System.out.print("Digite o ID do autor que você deseja deletar: ");
                        int id = ClassScanner.getScanner().nextInt();
                        ClassScanner.getScanner().nextLine();
                        deletarAutor(autorDAO, id);
                        break;
                    }
                    case 4: {
                        System.out.print("Digite o ID do autor que você deseja buscar: ");
                        int id = ClassScanner.getScanner().nextInt();
                        Autor autor = buscarAutorPorId(autorDAO, id);
                        System.out.println(autor);
                        break;
                    }
                    case 5: {
                        adicionarLivro(bookDAO, autorDAO);
                        break;
                    }
                    case 6: {
                        atualizarLivro(bookDAO, autorDAO);
                        break;
                    }
                    case 7: {
                        deletarLivro(bookDAO);
                        break;
                    }
                    case 8: {
                        System.out.println(procurarLivroPorId(bookDAO));
                        break;
                    }
                    default: {
                        System.out.print("PROGRAMA ENCERRADO!");
                        break;
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } finally {
                DB.closeConnection();
            }
        }

        ClassScanner.closeScanner();

    }

    private static Book procurarLivroPorId(BookDAO bookDAO) {
        System.out.print("Digite o ID do livro que deseja buscar: ");
        int id = ClassScanner.getScanner().nextInt();
        return bookDAO.findById(id);
    }

    private static void deletarLivro(BookDAO bookDAO) {
        System.out.print("Digite o ID do livro que deseja deletar: ");
        int id = ClassScanner.getScanner().nextInt();

        bookDAO.deleteById(id);
    }

    private static void atualizarLivro(BookDAO bookDAO, AutorDAO autorDAO) {
        System.out.print("Qual o ID do livro que deseja atualizar? ");
        int id = ClassScanner.getScanner().nextInt();

        Book book = bookDAO.findById(id);

        System.out.print("Novo nome para o título do livro: ");
        ClassScanner.getScanner().nextLine();
        String title = ClassScanner.getScanner().nextLine();

        System.out.print("Novo preço para o livro: ");
        Double price = ClassScanner.getScanner().nextDouble();

        System.out.print("Novo autor (ID) para o livro: ");
        int autorId = ClassScanner.getScanner().nextInt();
        Autor autor = autorDAO.findById(autorId);

        book.setTitle(title);
        book.setPrice(price);
        book.setAutor(autor);

        bookDAO.update(book);
    }

    private static void adicionarLivro(BookDAO bookDAO, AutorDAO autorDAO) {

        System.out.println("Digite o ID do autor do livro que deseja adicionar: ");
        int id = ClassScanner.getScanner().nextInt();
        Autor autor = autorDAO.findById(id);

        System.out.print("Informações do Livro: \nTítulo: ");
        ClassScanner.getScanner().nextLine();
        String title = ClassScanner.getScanner().nextLine();

        System.out.print("Preço: ");
        Double price = ClassScanner.getScanner().nextDouble();

        Book book = new Book.Builder()
                .autor(autor)
                .title(title)
                .price(price)
                .build();

        bookDAO.insert(book);
    }

    private static Autor buscarAutorPorId(AutorDAO autorDAO, int id) {
        return autorDAO.findById(id);
    }

    private static void deletarAutor(AutorDAO autorDAO, int id) {
        autorDAO.deleteById(id);
    }

    private static void atualizarAutor(AutorDAO autorDAO, int id){
        Autor autor = autorDAO.findById(id);

        System.out.print("Novo nome: ");
        String name = ClassScanner.getScanner().nextLine();

        System.out.print("Novo e-mail: ");
        String email = ClassScanner.getScanner().next();

        autor.setName(name);
        autor.setEmail(email);

        autorDAO.update(autor);
    }

    private static void adicionarAutor(AutorDAO autorDAO) {
        System.out.print("Nome do autor: ");
        String name = ClassScanner.getScanner().nextLine();

        System.out.print("E-mail do autor: ");
        String email = ClassScanner.getScanner().next();

        Autor autor = new Autor(null, name, email);

        autorDAO.insert(autor);
    }
}