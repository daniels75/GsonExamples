package org.daniels.examples.gson.desc;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DescriptonMain {

	public static void main(String [] args){
        final BookMarkFolderDescription rootFolder = new BookMarkFolderDescription();
        
        BookMarkFolderDescription folder1 = new BookMarkFolderDescription("Folder1");
        rootFolder.addDescription(folder1);
        BookMarkDescription bookmark2 = new BookMarkDescription("BookMark2");
        folder1.addDescription(bookmark2);
        
        Description desc1 = new Description("daniels1");
        rootFolder.addDescription(desc1);
        
        BookMarkDescription bookmark1 = new BookMarkDescription("HIST_RK");
        rootFolder.addDescription(bookmark1);
        
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Description.class, new DescriptionAdapter());
        
        builder.setPrettyPrinting();
        Gson gson = builder.excludeFieldsWithoutExposeAnnotation().create();
        final String json = gson.toJson(rootFolder, Description.class);
        
        //String bookStr = gson.toJson(rootFolder);
        //System.out.println(bookStr);
        
        System.out.println(json);
	}
}
