package shopPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
JSONArray Booksellers;
JSONArray Blacksmiths;
JSONArray Bowyer;
JSONArray Leatherworker;
JSONArray Temple;
JSONArray Tailor;
JSONArray Potions;
JSONArray Magicshops;
JSONArray Jewelers;
JSONArray Generalstores;

Random randomizer = new Random();

//Generates a list of inventory items from JSON
static ItemManager itemManager = new ItemManager();

//Generates inventory then name
	
//Generates Name
public String generateName(ShopTypeEnum shopType)
{
	String output = "";
	
	int randomNum = 1 + randomizer.nextInt(7);

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
	 return (String) Names.get(randomizer.nextInt(Names.size()));
}

private String getNoun()
{
	 return (String) Nouns.get(randomizer.nextInt(Nouns.size()));
}

private String getAdjective()
{
	 return (String) Adjectives.get(randomizer.nextInt(Adjectives.size()));
}

private String getShop(ShopTypeEnum shopType)
{
	String output = "";
	
	switch(shopType)
		{
		case INN:
		output = (String) Inns.get(randomizer.nextInt(Inns.size()));
		break;
		case BLACKSMITH:
		output = (String) Blacksmiths.get(randomizer.nextInt(Blacksmiths.size()));
		break;
		case BOWYER:
		output = (String) Bowyer.get(randomizer.nextInt(Bowyer.size()));
		break;
		case LEATHERWORKER:
		output = (String) Leatherworker.get(randomizer.nextInt(Leatherworker.size()));
		break;
		case TEMPLE:
		output = (String) Temple.get(randomizer.nextInt(Temple.size()));
		break;
		case TAILOR:
		output = (String) Tailor.get(randomizer.nextInt(Tailor.size()));
		break;
		case POTIONS:
		output = (String) Potions.get(randomizer.nextInt(Potions.size()));
		break;
		case MAGICSHOP:
		output = (String) Magicshops.get(randomizer.nextInt(Magicshops.size()));
		break;
		case JEWELER:
		output = (String) Jewelers.get(randomizer.nextInt(Jewelers.size()));
		break;
		case GENERALSTORE:
		output = (String) Generalstores.get(randomizer.nextInt(Generalstores.size()));
		break;
		case BOOKSELLER:
		output = (String) Booksellers.get(randomizer.nextInt(Booksellers.size()));
		break;
		}
	
	return output;
}

//JSON parser
public void parseJSON() throws FileNotFoundException, IOException, ParseException 
{
	// Parse Items First
	itemManager.parseJSON();

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
