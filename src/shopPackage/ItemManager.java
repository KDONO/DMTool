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

public class ItemManager 
{
	JSONArray BaseBlacksmith;
	JSONArray RuralBlacksmith;
	JSONArray UrbanBlacksmith;
	JSONArray PremiumBlacksmith;
	
	JSONArray BaseBowyer;
	JSONArray RuralBowyer;
	JSONArray UrbanBowyer;
	JSONArray PremiumBowyer;

	JSONArray BaseTemple;
	JSONArray RuralTemple;
	JSONArray UrbanTemple;
	JSONArray PremiumTemple;

	JSONArray BaseLeather;
	JSONArray RuralLeather;
	JSONArray UrbanLeather;
	JSONArray PremiumLeather;
	
	JSONArray BaseGeneral;
	JSONArray RuralGeneral;
	JSONArray UrbanGeneral;
	JSONArray PremiumGeneral;
	
	JSONArray BaseTailor;
	JSONArray RuralTailor;
	JSONArray UrbanTailor;
	JSONArray PremiumTailor;

	JSONArray BaseJeweler;
	JSONArray RuralJeweler;
	JSONArray UrbanJeweler;
	JSONArray PremiumJeweler;

	JSONArray BasePotion;
	JSONArray RuralPotion;
	JSONArray UrbanPotion;
	JSONArray PremiumPotion;

	JSONArray BaseMagic;
	JSONArray RuralMagic;
	JSONArray UrbanMagic;
	JSONArray PremiumMagic;

//Returns an arraylist of possible inventory based on the avenue
public ArrayList<String> getInventory(ShopTypeEnum shop, AvenueEnum ave)
{
	ArrayList<String> output = new ArrayList<String>();

	JSONArray baseInventory = null;
	JSONArray ruralInventory = null;
	JSONArray urbanInventory = null;
	JSONArray premiumInventory = null;

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
		baseInventory = BaseBlacksmith;
		ruralInventory = RuralBlacksmith;
		urbanInventory = UrbanBlacksmith;
		premiumInventory = PremiumBlacksmith;
	}
	break;
	case BOWYER:
	{
		baseInventory = BaseBowyer;
		ruralInventory = RuralBowyer;
		urbanInventory = UrbanBowyer;
		premiumInventory = PremiumBowyer;
	}
	break;
	case LEATHERWORKER:
	{
		baseInventory = BaseLeather;
		ruralInventory = RuralLeather;
		urbanInventory = UrbanLeather;
		premiumInventory = PremiumLeather;
	}
	break;

	case TEMPLE:
	{
		baseInventory = BaseBowyer;
		ruralInventory = RuralBowyer;
		urbanInventory = UrbanBowyer;
		premiumInventory = PremiumBowyer;
	}
	break;
	case GENERALSTORE:
	{
		baseInventory = BaseGeneral;
		ruralInventory = RuralGeneral;
		urbanInventory = UrbanGeneral;
		premiumInventory = PremiumGeneral;
	}
	break;
	case TAILOR:
	{
		baseInventory = BaseTailor;
		ruralInventory = RuralTailor;
		urbanInventory = UrbanTailor;
		premiumInventory = PremiumTailor;
	}
	break;
	case JEWELER:
	{
		baseInventory = BaseJeweler;
		ruralInventory = RuralJeweler;
		urbanInventory = UrbanJeweler;
		premiumInventory = PremiumJeweler;
	}
	break;
	case POTIONS:
	{
		baseInventory = BasePotion;
		ruralInventory = RuralPotion;
		urbanInventory = UrbanPotion;
		premiumInventory = PremiumPotion;
	}
	break;
	case MAGICSHOP:
	{
		baseInventory = BaseMagic;
		ruralInventory = RuralMagic;
		urbanInventory = UrbanMagic;
		premiumInventory = PremiumMagic;
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
		case RURAL:
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			for(int i = 0; i< baseInventory.size();i++)
				temp.add((String) baseInventory.get(i));
			for(int j = 0; j<ruralInventory.size();j++)
				temp.add((String) ruralInventory.get(j));
			
			output = temp;
		}
		break;
		case URBAN:
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			for(int i = 0; i< baseInventory.size();i++)
				temp.add((String) baseInventory.get(i));
			for(int j = 0; j<ruralInventory.size();j++)
				temp.add((String) ruralInventory.get(j));
			for(int k = 0; k<urbanInventory.size();k++)
				temp.add((String) urbanInventory.get(k));
			
			output = temp;
		}
		break;
		case PREMIUM:
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			for(int i = 0; i< baseInventory.size();i++)
				temp.add((String) baseInventory.get(i));		
			for(int j = 0; j<ruralInventory.size();j++)
				temp.add((String) ruralInventory.get(j));	
			for(int k = 0; k<urbanInventory.size();k++)
				temp.add((String) urbanInventory.get(k));
			for(int l = 0; l<premiumInventory.size();l++)
				temp.add((String) premiumInventory.get(l));
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
    BaseBlacksmith  = (JSONArray) data.get("BaseBlacksmith");
    RuralBlacksmith  = (JSONArray) data.get("RuralBlacksmith");
    UrbanBlacksmith  = (JSONArray) data.get("UrbanBlacksmith");
    PremiumBlacksmith  = (JSONArray) data.get("PremiumBlacksmith");
    
    BaseBowyer  = (JSONArray) data.get("BaseBowyer");
    RuralBowyer  = (JSONArray) data.get("RuralBowyer");
    UrbanBowyer  = (JSONArray) data.get("UrbanBowyer");
    PremiumBowyer  = (JSONArray) data.get("PremiumBowyer");

    BaseLeather = (JSONArray) data.get("BaseLeather");
    RuralLeather = (JSONArray) data.get("RuralLeather");
    UrbanLeather = (JSONArray) data.get("UrbanLeather");
    PremiumLeather = (JSONArray) data.get("PremiumLeather");

    BaseTemple = (JSONArray) data.get("BaseTemple");
    RuralTemple = (JSONArray) data.get("RuralTemple");
    UrbanTemple = (JSONArray) data.get("UrbanTemple");
    PremiumTemple = (JSONArray) data.get("PremiumTemple");
    
    BaseGeneral= (JSONArray) data.get("BaseGeneral");
    RuralGeneral= (JSONArray) data.get("RuralGeneral");
    UrbanGeneral= (JSONArray) data.get("UrbanGeneral");
    PremiumGeneral= (JSONArray) data.get("PremiumGeneral");

    BaseTailor= (JSONArray) data.get("BaseTailor");
    RuralTailor= (JSONArray) data.get("RuralTailor");
    UrbanTailor= (JSONArray) data.get("UrbanTailor");
    PremiumTailor= (JSONArray) data.get("PremiumTailor");

    BaseJeweler= (JSONArray) data.get("BaseJeweler");
    RuralJeweler= (JSONArray) data.get("RuralJeweler");
    UrbanJeweler= (JSONArray) data.get("UrbanJeweler");
    PremiumJeweler= (JSONArray) data.get("PremiumJeweler");
    
    BasePotion= (JSONArray) data.get("BasePotion");
    RuralPotion= (JSONArray) data.get("RuralPotion");
    UrbanPotion= (JSONArray) data.get("UrbanPotion");
    PremiumPotion= (JSONArray) data.get("PremiumPotion");

    BaseMagic= (JSONArray) data.get("BaseMagic");
    RuralMagic= (JSONArray) data.get("RuralMagic");
    UrbanMagic= (JSONArray) data.get("UrbanMagic");
    PremiumMagic= (JSONArray) data.get("PremiumMagic");

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
