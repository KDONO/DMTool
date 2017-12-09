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

//All the items that go into the arraylists
Item[] itemsArray;
Scroll[] spellArray;
ArrayList<Item> treasureList = new ArrayList<Item>();
ArrayList<Item> potionList = new ArrayList<Item>();
ArrayList<Item> magicList = new ArrayList<Item>();

//Randomizer
Random randomizer = new Random();

//The method used when printing to the UI
public String displayInventory(ShopTypeEnum shop, WealthEnum wealth)
{
	ArrayList<Item> input = generateInventory(shop, wealth);
	
	//For sorting the items in the display box
	ArrayList<Item> weapons = new ArrayList<Item>();
	ArrayList<Item> armor = new ArrayList<Item>();
	ArrayList<Item> general = new ArrayList<Item>();
	ArrayList<Item> tools = new ArrayList<Item>();
	ArrayList<Item> scrolls = new ArrayList<Item>();
	ArrayList<Item> magic = new ArrayList<Item>();
	ArrayList<Item> potions = new ArrayList<Item>();
	ArrayList<Item> jewelery = new ArrayList<Item>();

	for(int i = 0; i<input.size();i++)
	{
		if(input.get(i).getType() != null)
			{
				if(input.get(i).getType().equals("M") 
						|| input.get(i).getType().equals("SCF") 
						|| input.get(i).getType().equals("R") 
						|| input.get(i).getType().equals("A"))
				{
					weapons.add(input.get(i));
				}
				else if(input.get(i).getType().equals("LA") 
						|| input.get(i).getType().equals("MA")
						|| input.get(i).getType().equals("HA")
						|| input.get(i).getType().equals("S"))
				{
					armor.add(input.get(i));
				}
				else if(input.get(i).getType().equals("SC"))
				{
					scrolls.add(input.get(i));
				}
				else if(input.get(i).getType().equals("G") 
						|| input.get(i).getType().equals("GS") 
						|| input.get(i).getType().equals("TG") 
						|| input.get(i).getType().equals("INS"))
				{
					general.add(input.get(i));
				}
				else if(input.get(i).getType().equals("AT") 
						|| input.get(i).getType().equals("T"))
				{
					tools.add(input.get(i));
				}
				else if(input.get(i).getType().equals("RG") 
						|| input.get(i).getType().equals("WD") 
						|| input.get(i).getType().equals("RD")
						|| input.get(i).getType().equals("MAGIC"))
				{
					magic.add(input.get(i));
				}
				else if(input.get(i).getType().equals("$"))
				{
					jewelery.add(input.get(i));
				}
				else if(input.get(i).getType().equals("P"))
				{
					potions.add(input.get(i));
				}
			}
			}
	
	String output = "";
	
	if(weapons.size() != 0)
		{
		output = output.concat("\n--Weapons--");
		for(Item item:weapons)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(armor.size() != 0)
		{
		output = output.concat("\n--Armor--");
		for(Item item:armor)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(jewelery.size() != 0)
		{
		output = output.concat("\n--Treasure--");
		for(Item item:jewelery)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(general.size() != 0)
		{
		output = output.concat("\n--General Items--");
		for(Item item:general)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(tools.size() != 0)
		{
		output = output.concat("\n--Tools--");
		for(Item item:tools)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(potions.size() != 0)
		{
		output = output.concat("\n--Potions--");
		for(Item item:potions)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(scrolls.size() != 0)
		{
		output = output.concat("\n--Scrolls--");
		for(Item item:scrolls)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(magic.size() != 0)
		{
		System.out.println(magic.size());
		output = output.concat("\n--Magic Items--");
		for(Item item:magic)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	return output;
}

//Returns the final array that is used in displayInventory
public ArrayList<Item> generateInventory(ShopTypeEnum shop, WealthEnum wealth)
{
	ArrayList<Item> output = new ArrayList<Item>();
	
	switch(shop)
	{
		case BLACKSMITH:
		{
			String[] temp = blacksmithInventory.generateInventory(wealth);
			output = generateBasicInventory(10, temp);
		}
			break;
		case BOWYER:
		{
			String[] temp = bowyerInventory.generateInventory(wealth);
			output = generateBasicInventory(5, temp);
		}
			break;		
		case LEATHERWORKER:
		{
			String[] temp = leatherInventory.generateInventory(wealth);
			output = generateBasicInventory(5, temp);
		}
			break;
		case TEMPLE:
		{
			String[] temp = templeInventory.generateInventory(wealth);
			output = generateBasicInventory(10, temp);
		}
			break;
		case GENERALSTORE:
		{
			String[] temp = generalInventory.generateInventory(wealth);
			ArrayList<Scroll> tempScrolls = generateScrolls(wealth, 1); 
			ArrayList<Item> tempPotions = generatePotions(wealth, 2);
			ArrayList<Item> tempMagic = generateMagicItems(wealth,1);

			output = generateBasicInventory(10,temp);
			for(int i = 0; i<tempScrolls.size();i++)
				output.add(tempScrolls.get(i));
			for(int i = 0; i<tempPotions.size();i++)
				output.add(tempPotions.get(i));
			for(int i = 0; i<tempMagic.size();i++)
				output.add(tempMagic.get(i));
		}
			break;
		case TAILOR:
		{
			String[] temp = tailorInventory.generateInventory(wealth);
			output = generateBasicInventory(5,temp);
		}
			break;
		case JEWELER:
		{
			String[] temp = jewelerInventory.generateInventory(wealth);
			ArrayList<Item> tempTreasure = generateTreasure(wealth);
			
			output = generateBasicInventory(2,temp);		
			for(int i = 0; i<tempTreasure.size();i++)
				output.add(tempTreasure.get(i));
		}
			break;
		case POTIONS:
		{
			String[] temp = potionInventory.generateInventory(wealth);
			ArrayList<Item> tempPotions = generatePotions(wealth, 5);

			output = generateBasicInventory(5,temp);
			for(int i = 0; i<tempPotions.size();i++)
				output.add(tempPotions.get(i));
		}
			break;
		case MAGICSHOP:
		{
			String[] temp = magicInventory.generateInventory(wealth);
			ArrayList<Scroll> tempScrolls = generateScrolls(wealth, 5); 
			ArrayList<Item> tempPotions = generatePotions(wealth, 3);
			ArrayList<Item> tempMagic = generateMagicItems(wealth,3);
			
			output = generateBasicInventory(5,temp);
			for(int i = 0; i<tempScrolls.size();i++)
				output.add(tempScrolls.get(i));
			for(int i = 0; i<tempPotions.size();i++)
				output.add(tempPotions.get(i));
			for(int i = 0; i<tempMagic.size();i++)
				output.add(tempMagic.get(i));
		}
		case BOOKSELLER:
		{
			ArrayList<Scroll> tempScrolls = generateScrolls(wealth, 2); 
			for(int i = 0; i<tempScrolls.size();i++)
				output.add(tempScrolls.get(i));
		}
			break;
	}
	return output;
}

//Returns the value of an object as a string, with a 20% chance for it to be on sale (-25%) or marked up (+50%)
public String determineSale(Item item)
{
	int num = randomizer.nextInt(10);
	String output = "";
	String number = "";
	String letter = "";
	
	char[] valueArray;
	
	try
	{
	valueArray = item.getValue().toCharArray();
	}
	catch(Exception NullPointerException)
	{
		item.setValue();
		valueArray = item.getValue().toCharArray();
	}
	
	if(num<2)
	{
		// 25% off (Sale)
		for(int i = 0; i<valueArray.length;i++)
		{
			if(Character.isDigit(valueArray[i]))
				number = number.concat(Character.toString(valueArray[i]));
			else if(Character.isLetter(valueArray[i]))
				letter = letter.concat(Character.toString(valueArray[i]));
		}
		int finalCost = (int) Math.ceil(Integer.parseInt(number)*(.75));
		
		if(finalCost == Integer.parseInt(number))	
			output = item.getValue();
		else 
			output = finalCost + letter + " (Sale)";
	}
	else if(num>=8)
	{
		//50% markup (Marksup)		
		for(int i = 0; i<valueArray.length;i++)
		{
			if(Character.isDigit(valueArray[i]))
				number = number.concat(Character.toString(valueArray[i]));
			else if(Character.isLetter(valueArray[i]))
				letter = letter.concat(Character.toString(valueArray[i]));
		}
		int finalCost = (int) Math.ceil(Integer.parseInt(number)*(1.5));
		
		if(finalCost == Integer.parseInt(number))	
			output = item.getValue();
		else 
			output = finalCost + letter + " (Markup)";
	}
	else
		output = item.getValue();
	
	return output;
}

//Generates a random magic item + Price according to Xanathar's
public void getMagicItem(String Rarity)
{
	//TODO
}

//Generate Inn stuff MAJOR TODO... MAY ALSO NEED ONE FOR BOOKS :[
public void getInnInventory()
{
	//NOT EVEN SURE I NEED THIS? LOL
}

//Used in generateInventory to compare items from the catalog to the actual inventory
public ArrayList<Item> generateBasicInventory(int total, String[] shopInventory)
{
	ArrayList<Item> output = new ArrayList<Item>();
	
	for(int i = 0; i<total;i++)
	{
		boolean found = false;
		int randomnum = randomizer.nextInt(shopInventory.length); 
		int count = 0;
		
		while(found == false && count<itemsArray.length)
		{
			if(shopInventory[randomnum].equals(itemsArray[count].getName()))
				output.add(itemsArray[count]);
			
			count++;
		}
		//Maybe handle Scrolls, Potions, Magic Items, and Treasure here
	}
	
	return output;
}

//Used in generate inventory to generate the inventory of a jewelry store 
public ArrayList<Item> generateTreasure(WealthEnum wealth)
{
	ArrayList<Item> output = new ArrayList<Item>();
	
	switch(wealth)
	{
	case LOW: //Adds treasure elements to an array until the total cost of all items is over 500.
		output = getTreasureArray(500, 100);
	break;
	case MEDIUM:
		output = getTreasureArray(1000, 500);
	break;
	case HIGH:
		output = getTreasureArray(5000, 1000);
	break;
	case PREMIUM:
		output = getTreasureArray(10000, 10000);
	break;
	}
	return output;
}

//Used by generateTreasure to generate the arraylist of inventory items.
public ArrayList<Item> getTreasureArray(int wealth, int min)
{
	ArrayList<Item> output = new ArrayList<Item>();

	int total = 0;
	int index = 0;
	while(total < wealth)
	{
		index = randomizer.nextInt(treasureList.size());
		char[] valueArray = treasureList.get(index).getValue().toCharArray();
		String number = "";
		for(int i = 0; i<valueArray.length;i++)
		{
			if(Character.isDigit(valueArray[i]))
				number = number.concat(Character.toString(valueArray[i]));
		}	
		
		if(Integer.parseInt(number) <= min)
		{
			output.add(treasureList.get(index));
			total+=Integer.parseInt(number);
		}
	}
	
	return output;
}

//Gets a list of random magic scrolls
public ArrayList<Scroll> generateScrolls(WealthEnum wealth, int mod)
{
	ArrayList<Scroll> selection = new ArrayList<Scroll>();
	ArrayList<Scroll> output = new ArrayList<Scroll>();

	//Generate the selection based on wealth
	switch(wealth)
	{
		case LOW: 
		{
			for(int i = 0; i<spellArray.length;i++)
			{
				if(spellArray[i].getLevel() == 0 || spellArray[i].getLevel() == 1)
					selection.add(spellArray[i]);
				
			}
			for(int i = 0; i<randomizer.nextInt(mod);i++)
				output.add(selection.get(randomizer.nextInt(selection.size())));
		}
		break;
		case MEDIUM:
			for(int i = 0; i<spellArray.length;i++)
			{
				if(spellArray[i].getLevel() == 0 || spellArray[i].getLevel() == 1 
						|| spellArray[i].getLevel() == 2)
					selection.add(spellArray[i]);
			}
			for(int i = 0; i<randomizer.nextInt(mod);i++)
				output.add(selection.get(randomizer.nextInt(selection.size())));
		break;
		case HIGH:
			for(int i = 0; i<spellArray.length;i++)
			{
				if(spellArray[i].getLevel() == 0 || spellArray[i].getLevel() == 1 
						|| spellArray[i].getLevel() == 2 || spellArray[i].getLevel() == 3)
					selection.add(spellArray[i]);
			}
			for(int i = 0; i<randomizer.nextInt(mod*2);i++)
				output.add(selection.get(randomizer.nextInt(selection.size())));
		break;
		case PREMIUM:
			{
			for(int i = 0; i<spellArray.length;i++)
			{
				if(spellArray[i].getLevel() == 0 || spellArray[i].getLevel() == 1 
				|| spellArray[i].getLevel() == 2 || spellArray[i].getLevel() == 3
				|| spellArray[i].getLevel() == 4 || spellArray[i].getLevel() == 5)
					selection.add(spellArray[i]);
			}
			for(int i = 0; i<randomizer.nextInt(mod*3);i++)
				output.add(selection.get(randomizer.nextInt(selection.size())));
			}
		break;
		}
	
		//sets type and cost
		for(int i = 0; i<output.size();i++)
			output.get(i).init();
		
	return output;
}

//Generate a list of random potions
public ArrayList<Item> generatePotions(WealthEnum wealth, int mod)
{
	ArrayList<Item> output = new ArrayList<Item>();
	ArrayList<Item> temp = new ArrayList<Item>();

	switch(wealth)
	{
	case LOW:
	{
		for(int i = 0; i<potionList.size();i++)
		{
			if(potionList.get(i).getRarity().equals("Common")
					|| potionList.get(i).getRarity().equals("Uncommon"))
				temp.add(potionList.get(i));
		}
		for(int i = 0; i<randomizer.nextInt(mod);i++)
			output.add(temp.get(randomizer.nextInt(temp.size())));
	}
		break;
	case MEDIUM:
		for(int i = 0; i<potionList.size();i++)
		{
			if(potionList.get(i).getRarity().equals("Common")
					|| potionList.get(i).getRarity().equals("Uncommon")
					|| potionList.get(i).getRarity().equals("Rare"))
				temp.add(potionList.get(i));
		}
		for(int i = 0; i<randomizer.nextInt(mod);i++)
			output.add(temp.get(randomizer.nextInt(temp.size())));
		break;
	case HIGH:
		for(int i = 0; i<potionList.size();i++)
		{
			if(potionList.get(i).getRarity().equals("Common")
					|| potionList.get(i).getRarity().equals("Uncommon")
					|| potionList.get(i).getRarity().equals("Rare")
					|| potionList.get(i).getRarity().equals("Very Rare"))
				temp.add(potionList.get(i));
		}
		for(int i = 0; i<randomizer.nextInt(mod*2);i++)
			output.add(temp.get(randomizer.nextInt(temp.size())));
		break;
	case PREMIUM:
		for(int i = 0; i<randomizer.nextInt(mod*3);i++)
			output.add(potionList.get(randomizer.nextInt(potionList.size())));
		break;
	}
	return output;
}

public ArrayList<Item> generateMagicItems(WealthEnum wealth, int mod)
{
	ArrayList<Item> output = new ArrayList<Item>();
	ArrayList<Item> temp = new ArrayList<Item>();

	switch(wealth)
	{
	case LOW:
	{
		for(int i = 0; i<magicList.size();i++)
		{
			if(magicList.get(i).getRarity().equals("Common")
					|| magicList.get(i).getRarity().equals("Uncommon"))
				temp.add(magicList.get(i));
		}
		for(int i = 0; i<randomizer.nextInt(mod);i++)
			output.add(temp.get(randomizer.nextInt(temp.size())));
	}
		break;
	case MEDIUM:
		for(int i = 0; i<magicList.size();i++)
		{
			if(magicList.get(i).getRarity().equals("Common")
					|| magicList.get(i).getRarity().equals("Uncommon")
					|| magicList.get(i).getRarity().equals("Rare"))
				temp.add(magicList.get(i));
		}
		for(int i = 0; i<randomizer.nextInt(mod);i++)
			output.add(temp.get(randomizer.nextInt(temp.size())));
		break;
	case HIGH:
		for(int i = 0; i<potionList.size();i++)
		{
			if(magicList.get(i).getRarity().equals("Common")
					|| magicList.get(i).getRarity().equals("Uncommon")
					|| magicList.get(i).getRarity().equals("Rare")
					|| magicList.get(i).getRarity().equals("Very Rare"))
				temp.add(magicList.get(i));
		}
		for(int i = 0; i<randomizer.nextInt(mod*2);i++)
			output.add(temp.get(randomizer.nextInt(temp.size())));
		break;
	case PREMIUM:
		for(int i = 0; i<randomizer.nextInt(mod*3);i++)
			output.add(magicList.get(randomizer.nextInt(magicList.size())));
		break;
	}
	
	for(Item item:output)
		item.setType("MAGIC");
	
	return output;
}
//BAM, JSON
public void parseJSON() throws FileNotFoundException
{
	Gson gson = new Gson();
	
	//READ ITEMS FROM JSON
	JsonReader itemReader = new JsonReader(new FileReader("data/items.json"));
	itemsArray = gson.fromJson(itemReader, Item[].class);
		
	for(int i = 0;i<itemsArray.length;i++)
	{
		if(itemsArray[i].getType() != null)
			{
			if(itemsArray[i].getType().equals("$"))
				treasureList.add(itemsArray[i]);
			else if(itemsArray[i].getType().equals("P"))
				potionList.add(itemsArray[i]);
			}
		if(itemsArray[i].getTier()!=null)
			{
			if(itemsArray[i].getTier().equals("Minor") || itemsArray[i].getTier().equals("Major"))
				magicList.add(itemsArray[i]);
			}
	}

	//READ SPELLS FROM JSON
	JsonReader spellReader = new JsonReader(new FileReader("data/spells.json"));
	spellArray = gson.fromJson(spellReader, Scroll[].class);
	
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

//USE THIS TO CONFIRM IF A SHOP OBJECT'S INVENTORY MAPS CORRECTLY TO ITEMS IN THE ITEMS ARRAY.
public void confirmData()
{
	String[] confirmData = magicInventory.generateInventory(WealthEnum.PREMIUM);

	for(int i = 0; i<confirmData.length;i++)
	{
		boolean pass = false;
		int count = 0;
		
		while(pass == false && count<itemsArray.length)
		{
			if(confirmData[i].equals(itemsArray[count].getName()))
			{
				pass = true;
			}
				
			count++;
		}
		
		if(pass == false)
			System.out.println(confirmData[i]+" FAIL");
		else
			System.out.println(confirmData[i]+" Pass");
		
	}

}

}
