package org.daniels.examples.gson;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class BookSerializer implements JsonSerializer<Book>{

	@Override
	public JsonElement serialize(Book book, Type typeOfSrc,
			JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("title", book.getName());
		jsonObject.addProperty("ISBN", book.getIsbn());
		
		
		JsonArray array = new JsonArray();
		for (String bookstore :  book.getBookstores()){
			final JsonPrimitive jsonBookStore = new JsonPrimitive(bookstore);
			array.add(jsonBookStore);
		}
		
		jsonObject.add("BOOKSTORES", array);
		
		
	    final JsonElement jsonAuthros = context.serialize(book.getAuthors());
	    jsonObject.add("authors", jsonAuthros);
		
		return jsonObject;
	}
	
}