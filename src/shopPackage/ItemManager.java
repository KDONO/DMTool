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

//Randomizer
Random randomizer = new Random();

public String displayInventory(ShopTypeEnum shop, WealthEnum wealth)
{
	ArrayList<Item> input = generateInventory(shop, wealth);
	
	ArrayList<Item> weapons = new ArrayList<Item>();
	ArrayList<Item> armor = new ArrayList<Item>();
	ArrayList<Item> general = new ArrayList<Item>();
	ArrayList<Item> tools = new ArrayList<Item>();
	ArrayList<Item> jewelery = new ArrayList<Item>();
	ArrayList<Item> potions = new ArrayList<Item>();
	ArrayList<Item> scrolls = new ArrayList<Item>();
	ArrayList<Item> magic = new ArrayList<Item>();

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
				else if(input.get(i).getType().equals("P"))
				{
					potions.add(input.get(i));
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
						|| input.get(i).getType().equals("RD"))
				{
					magic.add(input.get(i));
				}
				else if(input.get(i).getType().equals("$"))
				{
					jewelery.add(input.get(i));
				}
			}
			else
				{
					magic.add(input.get(i));
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
	if(potions.size() != 0)
		{
		output = output.concat("\n--Potions--");
		for(Item item:potions)
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
	if(scrolls.size() != 0)
		{
		output = output.concat("\n--Scrolls--");
		for(Item item:scrolls)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	if(magic.size() != 0)
		{
		output = output.concat("\n--Magic Items--");
		for(Item item:magic)
			output = output.concat("\n"+item.getName()+", "+determineSale(item));
		}
	return output;
}

public ArrayList<Item> generateInventory(ShopTypeEnum shop, WealthEnum wealth)
{
	ArrayList<Item> output = new ArrayList<Item>();
	
	switch(shop)
	{
		case BLACKSMITH:
		{
			String[] temp = blacksmithInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case BOWYER:
		{
			String[] temp = bowyerInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;		
		case LEATHERWORKER:
		{
			String[] temp = leatherInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case TEMPLE:
		{
			String[] temp = templeInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case GENERALSTORE:
		{
			String[] temp = generalInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case TAILOR:
		{
			String[] temp = tailorInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case JEWELER:
		{
			String[] temp = jewelerInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case POTIONS:
		{
			String[] temp = potionInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
		case MAGICSHOP:
		{
			String[] temp = magicInventory.generateInventory(wealth);
			output = parseInventory(temp);
		}
			break;
	}
			
	return output;
}

public String determineSale(Item item)
{
	int num = randomizer.nextInt(10);
	String output = "";
	
	if(num<2)
	{
		// 25% off (Sale)
		char[] valueArray = item.getValue().toCharArray();
		String number = "";
		String letter = "";
		
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
		char[] valueArray = item.getValue().toCharArray();
		String number = "";
		String letter = "";
		
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

public ArrayList<Item> parseInventory(String[] shopInventory)
{
	ArrayList<Item> output = new ArrayList<Item>();
	
	for(int i = 0; i<10;i++)
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
		//Handle Scrolls, Potions, Magic Items, and Treasure here
	}
	
	return output;
}

public void parseJSON() throws FileNotFoundException
{
	Gson gson = new Gson();
	
	//READ ITEMS FROM JSON
	JsonReader itemReader = new JsonReader(new FileReader("data/items.json"));
	Item item[] = gson.fromJson(itemReader, Item[].class);
	
	itemsArray = item;
	
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
