package shopPackage;

import java.util.Random;

public class Item 
{
	static Random randomizer = new Random();

	protected String name;
	protected String type;
	protected String value;
	protected String rarity;
	protected String tier;
	
	public Item(String name, 
			String type, 
			String value, 
			String rarity,
			String tier)
	{
		this.name = name;
		this.type = type;
		this.value = value;
		this.rarity = rarity;
		this.tier = tier;
	}
	
	public Item() {}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getValue() 
	{
		return value;
	}

	public String getRarity() {
		return rarity;
	}

	public String getTier() {
		return tier;
	}
	
	//For potions
	public void setValue()
	{		
		if(this.rarity.equals("Common"))
			value = (50+randomizer.nextInt(100))+"gp"; 
		else if(this.rarity.equals("Uncommon"))
			value = (100+randomizer.nextInt(250))+"gp"; 
		else if(this.rarity.equals("Rare"))
			value = (250+randomizer.nextInt(500))+"gp"; 
		else if(this.rarity.equals("Very Rare"))
			value = (500+randomizer.nextInt(1000))+"gp"; 
		else if(this.rarity.equals("Legendary"))
			value = (100+randomizer.nextInt(5000))+"gp"; 
		else
			value = (50+randomizer.nextInt(100))+"gp"; 
	}
		
	@Override
	public String toString()
	{
		return "Name: "+name
				+"\nType: "+type
				+"\nValue:"+value
				+"\nRarity: "+rarity
				+"\nTier: "+tier;
	}
}
