package org.daniels.examples.gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class BookDeserializer implements JsonDeserializer<Book> {

	@Override
	public Book deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
	    final JsonObject jsonObject = json.getAsJsonObject();


	    final List<Author> authorList = context.deserialize(jsonObject.get("authors"), new TypeToken<List<Author>>(){}.getType());
	

	    
	    final Author[] authors = context.deserialize(jsonObject.get("authors"), Author[].class);
	    List<Author> list2 = Arrays.asList(authors);
	    

	    
	    
	    final Book book = new Book();
	    book.setName(jsonObject.get("title").getAsString());
	    book.setIsbn(jsonObject.get("ISBN").getAsString());
	    book.setAuthors(authorList);
	    

	    final String[] bookstores = context.deserialize(jsonObject.get("BOOKSTORES"), String[].class);
	    
	    book.setBookstores(Arrays.asList(bookstores));
	    
	    // another way - not used here
		final JsonArray jsonAuthorsArray = jsonObject.get("BOOKSTORES")
				.getAsJsonArray();
		final String[] authors1 = new String[jsonAuthorsArray.size()];
		for (int i = 0; i < authors1.length; i++) {
			final JsonElement jsonAuthor = jsonAuthorsArray.get(i);
			authors1[i] = jsonAuthor.getAsString();
		}
		List<String> list3 = Arrays.asList(authors1);
	    
	    
	    
	    return book;
	}

}
