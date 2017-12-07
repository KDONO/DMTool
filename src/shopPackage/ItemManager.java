package shopPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ItemManager 
{

ArrayList<Item> Jewels = new ArrayList<Item>(); // Jewels
ArrayList<Item> Weapons = new ArrayList<Item>(); // Weapons and foci
ArrayList<Item> Armor = new ArrayList<Item>(); // Armor and Shields
ArrayList<Item> Potions = new ArrayList<Item>(); // All Potions
ArrayList<Item> Scrolls = new ArrayList<Item>(); // All Scrolls
ArrayList<Item> General = new ArrayList<Item>(); //General goods, game sets
ArrayList<Item> Tools = new ArrayList<Item>(); // tools and artisan's tools
ArrayList<Item> Magic = new ArrayList<Item>(); //Rings, Rods, Staves, anything with a tier :O

public static enum itemTypes {$, G, AT, T, RD, R, RG, S, HA, MA, LA, P, 
						SCF, GS, M, INS, SC, WD, MNT, TAH, VEH, TG, A};

public void parseJSON() throws FileNotFoundException
{
	//Generate the raw array of item objects from JSON
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new FileReader("data/items.json"));
	Item item[] = gson.fromJson(reader, Item[].class);

	//Sort to arraylists.
	for(int i = 0; i<item.length;i++)
	{
		String type = item[i].getType();
		
		if(type == "$")
			Jewels.add(item[i]);
		if(type == "M" || type == "SCF" || type == "R" || type == "A")
			Weapons.add(item[i]);
		if(type == "LA" || type == "MA"|| type == "HA"|| type == "S")
			Armor.add(item[i]);
		if(type == "P")
			Potions.add(item[i]);
		if(type == "SC")
			Scrolls.add(item[i]);
		if(type == "G" || type == "GS" || type == "TG" || type == "INS")
			General.add(item[i]);
		if(type == "AT" || type == "T")
			Tools.add(item[i]);
		if(type == "RG" || type == "WD" || type == "RD")
			Magic.add(item[i]);
	}
}
}
