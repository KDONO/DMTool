package shopPackage;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
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
