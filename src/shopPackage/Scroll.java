package shopPackage;

public class Scroll extends Item
{
	int level;
	
	public Scroll(String name, int level)
	{
		this.name = name;
		this.level = level;
		init();
	}
	
	public void init()
	{
		name = "Scroll of \""+name+"\"";
		type = "SC";	
		setValue();
	}

	public int getLevel() {
		return level;
	}
		
	public void setValue()
	{		
		if(this.level == 0 || this.level == 1)
			value = ((randomizer.nextInt(6)+2)*10) + "gp";
		else if(this.level == 2 || this.level == 3)
			value = ((randomizer.nextInt(6)+1)*100) + "gp";
		else if(this.level == 4 || this.level == 5)
			value = ((randomizer.nextInt(10)+randomizer.nextInt(10)+2)*1000) + "gp";
	}
	
	@Override
	public String toString()
	{
		return "Name: "+name
				+"\nLevel:"+level
				+"\nType: "+type
				+"\nValue:"+value;
	}
	
}
