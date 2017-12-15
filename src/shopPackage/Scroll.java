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
		int temp = 0;

		if(this.level == 0 || this.level == 1)
			temp = ((randomizer.nextInt(6)+2)*10);
		else if(this.level == 2 || this.level == 3)
			temp = ((randomizer.nextInt(6)+1)*100);
		else if(this.level == 4 || this.level == 5)
			temp = ((randomizer.nextInt(10)+randomizer.nextInt(10)+2)*1000);
		else if(this.level == 6 || this.level == 7)
			temp = ((randomizer.nextInt(4)+2)*10000);
		else if(this.level == 8 || this.level == 9)
			temp = (randomizer.nextInt(6)+randomizer.nextInt(6)+2)*25000;
		
		value = String.valueOf(temp/2)+"gp";
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
