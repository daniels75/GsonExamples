package org.daniels.examples.gson.desc;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.daniels.examples.gson.Author;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
 
public class DescriptionAdapter implements JsonSerializer<Description>, JsonDeserializer<Description> {
    @Override
    public JsonElement serialize(Description src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        final JsonElement children = context.serialize(getChildren(src), new TypeToken<List<Description>>(){}.getType());
        jsonObject.add("type", new JsonPrimitive(resolveClass(src)));
        jsonObject.add("name", new JsonPrimitive(src.getName()));
        jsonObject.add("children", children);
        
        
        //jsonObject.add("fields", context.serialize(src));
        //jsonObject.add("name", new JsonPrimitive(src.getName()));
        
        
//        final JsonElement jsonAuthros = context.serialize(src);
//	    jsonObject.add("authors", jsonAuthros);
        
        return jsonObject;
    }
 
    public List<Description> getChildren(Description src){
    	List<Description> list = new ArrayList<Description>();
    	if (src instanceof BookMarkFolderDescription){
    		BookMarkFolderDescription folder = (BookMarkFolderDescription)src;
    		list.addAll(folder.getChildren());
    	}
    	
    	return list;
    }
    
    private String resolveClass(Description src) {
        if (src instanceof BookMarkFolderDescription) {
            return "folder";
        } else {
            return "bookmark";
        }
    }

    @Override
    public Description deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");
 
        try {
            return context.deserialize(element, Class.forName("org.daniels.examples.gson.desc." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }
}