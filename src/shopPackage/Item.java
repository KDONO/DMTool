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
