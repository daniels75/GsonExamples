package org.daniels.examples.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Book {

	private String name;
	private String isbn;
	@SerializedName("bookstores")
	private List<String> bookstores = new ArrayList<String>();

	private List<Author> authors = new ArrayList<Author>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void addBookstore(String bookstore) {
		bookstores.add(bookstore);
	}

	public List<String> getBookstores() {
		return bookstores;
	}

	public void setBookstores(List<String> bookstores) {
		this.bookstores = bookstores;
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}

	public List<Author> getAuthors() {
		return authors;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", isbn=" + isbn + ", bookstores="
				+ bookstores + ", authors=" + authors + "]";
	}

	public void setAuthors(List<Author> authors) {
		this.authors.addAll(authors);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result
				+ ((bookstores == null) ? 0 : bookstores.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookstores == null) {
			if (other.bookstores != null)
				return false;
		} else if (!bookstores.equals(other.bookstores))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
