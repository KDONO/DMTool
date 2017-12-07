package shopPackage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class InventoryManager 
{
	Shop Blacksmith;
	Shop Bowyer;
	Shop Leather;
	Shop Temple;
	Shop General;
	Shop Tailor;
	Shop Jeweler;
	Shop Potion;
	Shop Magic;
	
	public ArrayList<String>getInventory()
	{
		ArrayList<String> test = new ArrayList<String>();
		test.add("Test");
		return test ;
	}
	public void parseJSON() throws FileNotFoundException
	{
		//Generate the raw array of item objects from JSON
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader("data/Inventory.json"));
		Shop[] shop = gson.fromJson(reader, Shop[].class);
		
		for(int i = 0; i< shop.length; i++)
		{
			switch(shop[i].getName())
			{
			case "Blacksmith":
				Blacksmith = shop[i]; 
				break;
			case "Bowyer":
				Bowyer = shop[i]; 
				break;
			case "Leather":
				Leather = shop[i]; 
				break;
			case "Temple":
				Temple = shop[i]; 
				break;
			case "General":
				General = shop[i]; 
				break;
			case "Tailor":
				Tailor = shop[i]; 
				break;
			case "Jeweler":
				Jeweler = shop[i]; 
				break;
			case "Potion":
				Potion = shop[i]; 
				break;
			case "Magic":
				Magic = shop[i]; 
				break;
			}
		}
	}
}
