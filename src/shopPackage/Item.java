package shopPackage;

import java.util.Random;

public class Item 
{
	
	private String name;
	private String type;
	private String value;
	private String rarity;
	private String tier;
	
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
