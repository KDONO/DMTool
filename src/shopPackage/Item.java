package shopPackage;

public class Item 
{
	
	private String name;
	private String type;
	private String value;
	private String rarity;
	private boolean wondrous;
	
	public Item(String name, 
			String type, 
			String value, 
			String rarity,
			boolean wondrous)
	{
		this.name = name;
		this.type = type;
		this.value = value;
		this.rarity = rarity;
		this.wondrous = wondrous;
	}


	
	public String toString()
	{
		return "Name: "+name
				+"\nType: "+type
				+"\nValue:"+value
				+"\nRarity: "+rarity
				+"\nWondrous: "+wondrous;
	}
}
