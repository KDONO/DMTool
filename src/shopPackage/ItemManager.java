package shopPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ItemManager 
{
//Inventory Objects that hold the total inventory
Shop blacksmithInventory;
Shop bowyerInventory;
Shop leatherInventory;
Shop templeInventory;
Shop generalInventory;
Shop tailorInventory;
Shop jewelerInventory;
Shop potionInventory;
Shop magicInventory;

//Hold the actual item objects
ArrayList<Item> Jewels = new ArrayList<Item>(); // Jewels
ArrayList<Item> Weapons = new ArrayList<Item>(); // Weapons and foci
ArrayList<Item> Armor = new ArrayList<Item>(); // Armor and Shields
ArrayList<Item> Potions = new ArrayList<Item>(); // All Potions
ArrayList<Item> Scrolls = new ArrayList<Item>(); // All Scrolls
ArrayList<Item> General = new ArrayList<Item>(); //General goods, game sets
ArrayList<Item> Tools = new ArrayList<Item>(); // tools and artisan's tools
ArrayList<Item> Magic = new ArrayList<Item>(); //Rings, Rods, Staves, anything with a tier :O
Item[] alltheitems;

// Generates random inventory
public void test()
{
	String[] test = leatherInventory.generateInventory(WealthEnum.LOW);
// PLEASE TEST THAT ALL STRINGS IN INVENTORY WILL MAP TO A ITEM IN THE ITEM ARRAYS HERE. USE ITEM[]

	for(int i = 0; i<alltheitems.length;i++)
	{
		boolean pass = false;
		int count = 0;
		
		while(pass == false)
		{
			if(alltheitems[i].getName().equals(test[count]));
				pass = true;
				
			count++;
		}
		
		if(pass == false)
			System.out.println(alltheitems[i].getName()+" FAIL");
		
		else
			System.out.println("Pass");
		
	}
}

public ArrayList<String> generateInventory(ShopTypeEnum shop, WealthEnum wealth)
{
	ArrayList<String> output = new ArrayList<String>();
	String[] temp = null;
	
	switch(shop)
	{
		case BLACKSMITH:
			temp = blacksmithInventory.generateInventory(wealth); 
		break;
		case BOWYER:
			temp = bowyerInventory.generateInventory(wealth);
		break;		
		case LEATHERWORKER:
			temp = leatherInventory.generateInventory(wealth);
		break;
		case TEMPLE:
			temp = leatherInventory.generateInventory(wealth);
		break;
		case GENERALSTORE:
			temp = generalInventory.generateInventory(wealth);
		break;
		case TAILOR:
			temp = tailorInventory.generateInventory(wealth);
		break;
		case JEWELER:
			temp = jewelerInventory.generateInventory(wealth);
		break;
		case POTIONS:
			temp = potionInventory.generateInventory(wealth);
		break;
		case MAGICSHOP:
			temp = magicInventory.generateInventory(wealth);
		break;
	}
			
	return output;
}

public void parseJSON() throws FileNotFoundException
{
	Gson gson = new Gson();
	
	//READ ITEMS FROM JSON
	JsonReader itemReader = new JsonReader(new FileReader("data/items.json"));
	Item item[] = gson.fromJson(itemReader, Item[].class);
	
	alltheitems = item;
	
	for(int i = 0; i<item.length;i++)
	{
		String type = item[i].getType();

		if(type != null)
		{
			if(type.equals("M") || type.equals("SCF") || type.equals("R") || type.equals("A"))
				Weapons.add(item[i]);
			else if(type.equals("LA") || type.equals("MA")|| type.equals("HA")|| type.equals("S"))
				Armor.add(item[i]);
			else if(type.equals("P"))
				Potions.add(item[i]);
			else if(type.equals("SC"))
				Scrolls.add(item[i]);
			else if(type.equals("G") || type.equals("GS") || type.equals("TG") || type.equals("INS"))
				General.add(item[i]);
			else if(type.equals("AT") || type.equals("T"))
				Tools.add(item[i]);
			else if(type.equals("RG") || type.equals("WD") || type.equals("RD"))
				Magic.add(item[i]);
			else if(type.equals("$"))
				Jewels.add(item[i]);
		}
		else
			Magic.add(item[i]);
	}
	
	//READ INVENTORY FROM JSON
	JsonReader inventoryReader = new JsonReader(new FileReader("data/Inventory.json"));
	Shop[] shop = gson.fromJson(inventoryReader, Shop[].class);
	
	for(int i = 0; i< shop.length; i++)
	{
		switch(shop[i].getName())
		{
		case "Blacksmith":
			blacksmithInventory = shop[i]; 
			break;
		case "Bowyer":
			bowyerInventory = shop[i]; 
			break;
		case "Leather":
			leatherInventory = shop[i]; 
			break;
		case "Temple":
			templeInventory = shop[i]; 
			break;
		case "General":
			generalInventory = shop[i]; 
			break;
		case "Tailor":
			tailorInventory = shop[i]; 
			break;
		case "Jeweler":
			jewelerInventory = shop[i]; 
			break;
		case "Potion":
			potionInventory = shop[i]; 
			break;
		case "Magic":
			magicInventory = shop[i]; 
			break;
		}
	}

}
}
