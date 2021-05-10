package Wrappers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileHandler {

    public static String fileName = "node.json";
    static JsonObject jsonObject;

    public static void readFile() {
        JsonParser jsonParser = new JsonParser();

        try (FileReader reader = new FileReader(fileName)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonObject = (JsonObject) obj;

        } catch (Exception exception) {


        }
    }
/*
    public static String print()
        {
           JsonObject parent = (JsonObject) jsonObject.get("Root");
          String s= parent.get("firstChild").getAsString();
          return s;
        }*/

    
}