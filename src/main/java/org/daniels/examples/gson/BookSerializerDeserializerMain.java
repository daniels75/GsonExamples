package org.daniels.examples.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BookSerializerDeserializerMain {

	public static void main(String[] args){
		Book book = new Book();
		
		book.setIsbn("isbn123");
		book.setName("someName");
		book.addBookstore("bookstore1");
		book.addBookstore("bookstore2");
		
		Author author = new Author();
		author.setId(1);
		author.setName("Daniels");
		book.addAuthor(author);
		
		System.out.println(">>> initalial Book: " + book);
		
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Book.class, new BookSerializer());
		builder.registerTypeAdapter(Author.class, new AuthorSerialiser());
		builder.registerTypeAdapter(Book.class, new BookDeserializer());
		builder.registerTypeAdapter(Author.class, new AuthorDeserializer());
	    
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		
		String bookStr = gson.toJson(book);
		
		System.out.println(bookStr);
		
		Book bookDeserialized = gson.fromJson(bookStr, Book.class);
		
		System.out.println(">>> After deserialization: " + book + " equal: " + book.equals(bookDeserialized));
		
	
		
	}
}


