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

public class ShopManager
{
ArrayList<String> Names = new ArrayList<String>();
ArrayList<String> Adjectives = new ArrayList<String>();
ArrayList<String> Nouns = new ArrayList<String>();

ArrayList<String> Inns = new ArrayList<String>();
ArrayList<String> Blacksmiths = new ArrayList<String>();
ArrayList<String> Magicshops = new ArrayList<String>();
ArrayList<String> Jewelers = new ArrayList<String>();
ArrayList<String> Generalstores = new ArrayList<String>();
ArrayList<String> Booksellers = new ArrayList<String>();
	
public String generate(ShopTypes shopType)
{
	String output = "";
	
	int randomNum = 1 + (int)(Math.random() * 7);

	//Determines the format
	switch(randomNum)
	{
	case 1: //Name's Shop
		output = (getName()+"'s "+getShop(shopType));
		break;
	case 2: //Name & Name's Shop
		output = (getName() + " & " + getName()+"'s "+getShop(shopType));
		break;
	case 3: //The Adjective Noun
		output = ("The "+getAdjective() + " " + getName()+" "+getShop(shopType));
		break;
	case 4: //The Noun & Noun
		output = ("The "+getNoun() + " & " + getNoun()+" "+getShop(shopType));
		break;
	case 5: //The Noun's
		output = ("The "+getNoun()+" "+getShop(shopType));
		break;
	case 6: //Name's Adjective Noun
		output = (getName()+"'s "+getAdjective()+" "+getNoun()+" "+getShop(shopType));
		break;
	case 7: //Adjective Name's
		output = (getAdjective()+" "+getName()+"'s "+getShop(shopType));
		break;
	}
	return output;
}

//Generators
private String getName()
{
	 return Names.get((int) Math.floor((Math.random() * Names.size())));
}

private String getNoun()
{
	 return Nouns.get((int) Math.floor((Math.random() * Nouns.size())));
}

private String getAdjective()
{
	 return Adjectives.get((int) Math.floor((Math.random() * Adjectives.size())));
}

private String getShop(ShopTypes shopType)
{
	String output = "";
	
	switch(shopType)
		{
		case INN:
		output = Inns.get((int) Math.floor((Math.random() * Inns.size())));
		break;
		case BLACKSMITH:
		output = Blacksmiths.get((int) Math.floor((Math.random() * Blacksmiths.size())));
		break;
		case MAGICSHOP:
		output = Magicshops.get((int) Math.floor((Math.random() * Magicshops.size())));
		break;
		case JEWELER:
		output = Jewelers.get((int) Math.floor((Math.random() * Jewelers.size())));
		break;
		case GENERALSTORE:
		output = Generalstores.get((int) Math.floor((Math.random() * Generalstores.size())));
		break;
		case BOOKSELLER:
		output = Booksellers.get((int) Math.floor((Math.random() * Booksellers.size())));
		break;
		}
	
	return output;
}

//JSON parser
public void parseJSON() throws FileNotFoundException, IOException, ParseException 
{
	//Get the JSON file as one JObject
    JSONParser parser = new JSONParser();
    
    try
    {
    JSONObject data = (JSONObject) parser.parse(new FileReader("data/ShopNames.txt"));

    //Grab the Arrays from the JObject as JArrays
    JSONArray JSONNames  = (JSONArray) data.get("Names");
    JSONArray JSONAdjectives = (JSONArray) data.get("Adjectives");
    JSONArray JSONNouns = (JSONArray) data.get("Nouns");
    
    JSONArray JSONInns = (JSONArray) data.get("Inns");
    JSONArray JSONBlacksmiths = (JSONArray) data.get("Blacksmiths");
    JSONArray JSONMagicshops = (JSONArray) data.get("Magicshops");
    JSONArray JSONJewelers = (JSONArray) data.get("Jewelers");
    JSONArray JSONGeneralstores = (JSONArray) data.get("Generalstores");
    JSONArray JSONBooksellers = (JSONArray) data.get("Booksellers");

    //Convert JArrays to ArrayLists.
    for(int i = 0; i<JSONNames.size(); i++)
    	Names.add((String) JSONNames.get(i));
    for(int i = 0; i<JSONAdjectives.size(); i++)
    	Adjectives.add((String) JSONAdjectives.get(i));
    for(int i = 0; i<JSONNouns.size(); i++)
    	Nouns.add((String) JSONNouns.get(i));
    
    for(int i = 0; i<JSONInns.size(); i++)
    	Inns.add((String) JSONInns.get(i));
    for(int i = 0; i<JSONBlacksmiths.size(); i++)
    	Blacksmiths.add((String) JSONBlacksmiths.get(i));
    for(int i = 0; i<JSONMagicshops.size(); i++)
    	Magicshops.add((String) JSONMagicshops.get(i));
    for(int i = 0; i<JSONJewelers.size(); i++)
    	Jewelers.add((String) JSONJewelers.get(i));
    for(int i = 0; i<JSONGeneralstores.size(); i++)
    	Generalstores.add((String) JSONGeneralstores.get(i));
    for(int i = 0; i<JSONBooksellers.size(); i++)
    	Booksellers.add((String) JSONBooksellers.get(i));


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
