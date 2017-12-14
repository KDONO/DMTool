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
		int temp = 0;

		if(this.rarity.equals("Common"))
			temp = ((randomizer.nextInt(6)+2)*10);
		else if(this.rarity.equals("Uncommon"))
			temp = ((randomizer.nextInt(6)+1)*100);
		else if(this.rarity.equals("Rare"))
			temp = ((randomizer.nextInt(10)+randomizer.nextInt(10)+2)*1000);
		else if(this.rarity.equals("Very Rare"))
			temp = ((randomizer.nextInt(4)+2)*10000);
		else if(this.rarity.equals("Legendary"))
			temp = (randomizer.nextInt(6)+randomizer.nextInt(6)+2)*25000;
		
		if(this.type.equals("P"))
		{
			value = String.valueOf(temp/2)+"gp";
		}
		else
			value = String.valueOf(temp)+"gp";
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
