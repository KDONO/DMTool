package shopPackage;

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
	
JSONArray Names;
JSONArray Adjectives;
JSONArray Nouns;

JSONArray Inns;
JSONArray Blacksmiths;
JSONArray Bowyer;
JSONArray Leatherworker;
JSONArray Temple;
JSONArray Tailor;
JSONArray Potions;
JSONArray Magicshops;
JSONArray Jewelers;
JSONArray Generalstores;
JSONArray Booksellers;

public String generate(ShopTypeEnum shopType)
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
	 return (String) Names.get((int) Math.floor((Math.random() * Names.size())));
}

private String getNoun()
{
	 return (String) Nouns.get((int) Math.floor((Math.random() * Nouns.size())));
}

private String getAdjective()
{
	 return (String) Adjectives.get((int) Math.floor((Math.random() * Adjectives.size())));
}

private String getShop(ShopTypeEnum shopType)
{
	String output = "";
	
	switch(shopType)
		{
		case INN:
		output = (String) Inns.get((int) Math.floor((Math.random() * Inns.size())));
		break;
		case BLACKSMITH:
		output = (String) Blacksmiths.get((int) Math.floor((Math.random() * Blacksmiths.size())));
		break;
		case BOWYER:
		output = (String) Bowyer.get((int) Math.floor((Math.random() * Bowyer.size())));
		break;
		case LEATHERWORKER:
		output = (String) Leatherworker.get((int) Math.floor((Math.random() * Leatherworker.size())));
		break;
		case TEMPLE:
		output = (String) Temple.get((int) Math.floor((Math.random() * Temple.size())));
		break;
		case TAILOR:
		output = (String) Tailor.get((int) Math.floor((Math.random() * Tailor.size())));
		break;
		case POTIONS:
		output = (String) Potions.get((int) Math.floor((Math.random() * Potions.size())));
		break;
		case MAGICSHOP:
		output = (String) Magicshops.get((int) Math.floor((Math.random() * Magicshops.size())));
		break;
		case JEWELER:
		output = (String) Jewelers.get((int) Math.floor((Math.random() * Jewelers.size())));
		break;
		case GENERALSTORE:
		output = (String) Generalstores.get((int) Math.floor((Math.random() * Generalstores.size())));
		break;
		case BOOKSELLER:
		output = (String) Booksellers.get((int) Math.floor((Math.random() * Booksellers.size())));
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
    JSONObject data = (JSONObject) parser.parse(new FileReader("data/ShopNames.json"));

    //Grab the Arrays from the JObject as JArrays
    Names  = (JSONArray) data.get("Names");
    Adjectives = (JSONArray) data.get("Adjectives");
    Nouns = (JSONArray) data.get("Nouns");
    Inns = (JSONArray) data.get("Inns");
    Blacksmiths = (JSONArray) data.get("Blacksmiths");
    Bowyer = (JSONArray) data.get("Bowyer");
    Leatherworker = (JSONArray) data.get("Leatherworker");
    Temple = (JSONArray) data.get("Temple");
    Tailor= (JSONArray) data.get("Tailor");
    Potions = (JSONArray) data.get("Potions");
    Magicshops = (JSONArray) data.get("Magicshops");
    Jewelers = (JSONArray) data.get("Jewelers");
    Generalstores = (JSONArray) data.get("Generalstores");
    Booksellers = (JSONArray) data.get("Booksellers");
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
