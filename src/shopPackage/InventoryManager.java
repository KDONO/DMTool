package shopPackage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryManager 
{
	JSONArray baseBlacksmith;
	JSONArray lowBlacksmith;
	JSONArray medBlacksmith;
	JSONArray highBlacksmith;
	
	JSONArray baseBowyer;
	JSONArray lowBowyer;
	JSONArray medBowyer;
	JSONArray highBowyer;

	JSONArray baseTemple;
	JSONArray lowTemple;
	JSONArray medTemple;
	JSONArray highTemple;

	JSONArray baseLeather;
	JSONArray lowLeather;
	JSONArray medLeather;
	JSONArray highLeather;
	
	JSONArray baseGeneral;
	JSONArray lowGeneral;
	JSONArray medGeneral;
	JSONArray highGeneral;
	
	JSONArray baseTailor;
	JSONArray lowTailor;
	JSONArray medTailor;
	JSONArray highTailor;

	JSONArray baseJeweler;
	JSONArray lowJeweler;
	JSONArray medJeweler;
	JSONArray highJeweler;

	JSONArray basePotion;
	JSONArray lowPotion;
	JSONArray medPotion;
	JSONArray highPotion;

	JSONArray baseMagic;
	JSONArray lowMagic;
	JSONArray medMagic;
	JSONArray highMagic;

//Returns an arraylist of possible inventory based on the avenue
public ArrayList<String> getInventory(ShopTypeEnum shop, WealthEnum ave)
{
	ArrayList<String> output = new ArrayList<String>();

	JSONArray baseInventory = null;
	JSONArray lowInventory = null;
	JSONArray medInventory = null;
	JSONArray highInventory = null;

	switch(shop)
	{
	case INN:
	{
		output = null;
	}
	case BOOKSELLER:
	{
		output = null;
	}

	break;
	case BLACKSMITH:
	{
		baseInventory = baseBlacksmith;
		lowInventory = lowBlacksmith;
		medInventory = medBlacksmith;
		highInventory = highBlacksmith;
	}
	break;
	case BOWYER:
	{
		baseInventory = baseBowyer;
		lowInventory = lowBowyer;
		medInventory = medBowyer;
		highInventory = highBowyer;
	}
	break;
	case LEATHERWORKER:
	{
		baseInventory = baseLeather;
		lowInventory = lowLeather;
		medInventory = medLeather;
		highInventory = highLeather;
	}
	break;

	case TEMPLE:
	{
		baseInventory = baseBowyer;
		lowInventory = lowBowyer;
		medInventory = medBowyer;
		highInventory = highBowyer;
	}
	break;
	case GENERALSTORE:
	{
		baseInventory = baseGeneral;
		lowInventory = lowGeneral;
		medInventory = medGeneral;
		highInventory = highGeneral;
	}
	break;
	case TAILOR:
	{
		baseInventory = baseTailor;
		lowInventory = lowTailor;
		medInventory = medTailor;
		highInventory = highTailor;
	}
	break;
	case JEWELER:
	{
		baseInventory = baseJeweler;
		lowInventory = lowJeweler;
		medInventory = medJeweler;
		highInventory = highJeweler;
	}
	break;
	case POTIONS:
	{
		baseInventory = basePotion;
		lowInventory = lowPotion;
		medInventory = medPotion;
		highInventory = highPotion;
	}
	break;
	case MAGICSHOP:
	{
		baseInventory = baseMagic;
		lowInventory = lowMagic;
		medInventory = medMagic;
		highInventory = highMagic;
	}
	break;

	}
	
	switch(ave)
	{
		case BASE:
		{
			output = baseInventory;
		}
		break;
		case LOW:
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			for(int i = 0; i< baseInventory.size();i++)
				temp.add((String) baseInventory.get(i));
			for(int j = 0; j<lowInventory.size();j++)
				temp.add((String) lowInventory.get(j));
			
			output = temp;
		}
		break;
		case MEDIUM:
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			for(int i = 0; i< baseInventory.size();i++)
				temp.add((String) baseInventory.get(i));
			for(int j = 0; j<lowInventory.size();j++)
				temp.add((String) lowInventory.get(j));
			for(int k = 0; k<medInventory.size();k++)
				temp.add((String) medInventory.get(k));
			
			output = temp;
		}
		break;
		case HIGH:
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			for(int i = 0; i< baseInventory.size();i++)
				temp.add((String) baseInventory.get(i));		
			for(int j = 0; j<lowInventory.size();j++)
				temp.add((String) lowInventory.get(j));	
			for(int k = 0; k<medInventory.size();k++)
				temp.add((String) medInventory.get(k));
			for(int l = 0; l<highInventory.size();l++)
				temp.add((String) highInventory.get(l));
			output = temp;
		}
		break;
	}
	return output;
}	
public void parseJSON() throws FileNotFoundException, IOException, ParseException 
{
	//Get the JSON file as one JObject
    JSONParser parser = new JSONParser();

    try
    {
    JSONObject data = (JSONObject) parser.parse(new FileReader("data/Inventory.json"));

    //Grab the Arrays from the JObject as JArrays
    baseBlacksmith  = (JSONArray) data.get("BaseBlacksmith");
    lowBlacksmith  = (JSONArray) data.get("LowBlacksmith");
    medBlacksmith  = (JSONArray) data.get("MedBlacksmith");
    highBlacksmith  = (JSONArray) data.get("HighBlacksmith");
    
    baseBowyer  = (JSONArray) data.get("BaseBowyer");
    lowBowyer  = (JSONArray) data.get("LowBowyer");
    medBowyer  = (JSONArray) data.get("MedBowyer");
    highBowyer  = (JSONArray) data.get("HighBowyer");

    baseLeather = (JSONArray) data.get("BaseLeather");
    lowLeather = (JSONArray) data.get("LowLeather");
    medLeather = (JSONArray) data.get("MedLeather");
    highLeather = (JSONArray) data.get("HighLeather");

    baseTemple = (JSONArray) data.get("BaseTemple");
    lowTemple = (JSONArray) data.get("LowTemple");
    medTemple = (JSONArray) data.get("MedTemple");
    highTemple = (JSONArray) data.get("HighTemple");
    
    baseGeneral= (JSONArray) data.get("BaseGeneral");
    lowGeneral= (JSONArray) data.get("LowGeneral");
    medGeneral= (JSONArray) data.get("MedGeneral");
    highGeneral= (JSONArray) data.get("HighGeneral");

    baseTailor= (JSONArray) data.get("BaseTailor");
    lowTailor= (JSONArray) data.get("LowTailor");
    medTailor= (JSONArray) data.get("MedTailor");
    highTailor= (JSONArray) data.get("HighTailor");

    baseJeweler= (JSONArray) data.get("BaseJeweler");
    lowJeweler= (JSONArray) data.get("LowJeweler");
    medJeweler= (JSONArray) data.get("MedJeweler");
    highJeweler= (JSONArray) data.get("HighJeweler");
    
    basePotion= (JSONArray) data.get("BasePotion");
    lowPotion= (JSONArray) data.get("LowPotion");
    medPotion= (JSONArray) data.get("MedPotion");
    highPotion= (JSONArray) data.get("HighPotion");

    baseMagic= (JSONArray) data.get("BaseMagic");
    lowMagic= (JSONArray) data.get("LowMagic");
    medMagic= (JSONArray) data.get("MedMagic");
    highMagic= (JSONArray) data.get("HighMagic");

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
