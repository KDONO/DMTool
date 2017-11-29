package ShopPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ShopController
{
ArrayList<String> Names = new ArrayList<String>();
ArrayList<String> Adjectives = new ArrayList<String>();
ArrayList<String> Nouns = new ArrayList<String>();
	
/*
 * Ideas for formats
 * 
 * Name's
 * 
 * Name & Name's
 * 
 * The Adjective Noun
 * 
 * The Noun & Noun
 * 
 * The Noun's
 * 
 */

public String getName()
{
	 return Names.get((int) Math.floor((Math.random() * Names.size())));
}

public String getNouns()
{
	 return Nouns.get((int) Math.floor((Math.random() * Nouns.size())));
}

public String getAdjective()
{
	 return Adjectives.get((int) Math.floor((Math.random() * Adjectives.size())));
}

public void parseJSON() throws FileNotFoundException, IOException, ParseException 
{
	//Get the JSON file as one JObject
    JSONParser parser = new JSONParser();
    
    try
    {
    JSONObject data = (JSONObject) parser.parse(new FileReader("shopNames.txt"));

    //Grab the Arrays from the JObject as JArrays
    JSONArray JSONNames  = (JSONArray) data.get("Names");
    JSONArray JSONAdjectives = (JSONArray) data.get("Adjectives");
    JSONArray JSONNouns = (JSONArray) data.get("Nouns");

    //Convert JArrays to ArrayLists.
    for(int i = 0; i<JSONNames.size(); i++)
    	Names.add((String) JSONNames.get(i));
    for(int i = 0; i<JSONAdjectives.size(); i++)
    	Adjectives.add((String) JSONAdjectives.get(i));
    for(int i = 0; i<JSONNouns.size(); i++)
    	Nouns.add((String) JSONNouns.get(i));

    }
    catch(FileNotFoundException e)
    {
        JOptionPane.showMessageDialog(null, e.toString(), "File Not Found Exception. Please place Names.txt in the same directory as the executable JAR file.",
                JOptionPane.ERROR_MESSAGE);
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
    }
	}
}
