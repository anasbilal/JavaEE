package com.anas.tef.hibernate;

import java.util.List;

import com.anas.tef.hibernate.service.BookService;
import com.anas.tef.hibernate.model.Book;



public class Main {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		Book book1 = new Book("1", "Das Handbuch zu Java 7", "Guido Krüger, Heiko Hansen");
		Book book2 = new Book("2", "Java von Kopf bis Fuß", "Sierra, Kathy");
		Book book3 = new Book("3", "Java-Intensivkurs", " Marco Block");
		System.out.println("*** Persist - Start ***");
		bookService.persist(book1);
		bookService.persist(book2);
		bookService.persist(book3);
		List<Book> books1 = bookService.findAll();
		System.out.println("Folgende Bücher sind gespeichert: ");
		for (Book b : books1) {
			System.out.println("-" + b.toString());
		}
		System.out.println("*** Persist - Ende ***");
		System.out.println("*** Update - Start ***");
		book1.setTitle("Das Handbuch zu Java 8");
		bookService.update(book1);
		System.out.println("Buch aktualisiert ist: " +bookService.findById(book1.getId()).toString());
		System.out.println("*** Update - Ende ***");
		System.out.println("*** Finde - Start ***");
		String id1 = book1.getId();
		Book gesucht = bookService.findById(id1);
		System.out.println("Buch mit der id " + id1 + " ist =>" + gesucht.toString());
		System.out.println("*** Finde - Ende ***");
		System.out.println("*** Lösche - Start ***");
		String id3 = book3.getId();
		bookService.delete(id3);
		System.out.println("Buch mit id " + id3 + " gelöscht.");
		System.out.println("Anzahl der Bücher: " + bookService.findAll().size() + ".");
		System.out.println("*** Löschen - Ende ***");
		System.out.println("*** Finde alle Bücher - Start ***");
		List<Book> books2 = bookService.findAll();
		System.out.println("Folgende Bücher gefunden :");
		for (Book b : books2) {
			System.out.println("-" + b.toString());
		}
		System.out.println("*** Finde alle Bücher - Ende ***");
		System.out.println("*** Lösche alle - Start ***");
		bookService.deleteAll();
		System.out.println("Anzahl der Bücher: " + bookService.findAll().size());
		System.out.println("*** Lösche alle - Ende ***");
		 System.exit(0);
	}

}
