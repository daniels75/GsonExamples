package org.daniels.examples.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SimpleGson1 {

	public static void main(String[] args){
		Gson gson = new GsonBuilder().create();
		
		gson.toJson("test", System.out);
		gson.toJson(133, System.out);
		

	}
}
