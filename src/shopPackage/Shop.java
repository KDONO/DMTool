package shopPackage;

import java.util.Random;

public class Shop 
{
String name;

String[] low;
String[] medium;
String[] high;
String[] premium;

public Shop(String name, 
		String[] low,
		String[] medium,
		String[] high,
		String[] premium)
		{
			this.name = name;
			this.low = low;
			this.medium = medium;
			this.high = high;
			this.premium = premium;
		}

public String getName() {
	return name;
}
public String[] getLow() {
	return low;
}
public String[] getMedium() {
	return medium;
}
public String[] getHigh() {
	return high;
}
public String[] getPremium() {
	return premium;
}

//returns the total inventory
public String[] generateInventory(WealthEnum wealth)
{
	String[]output = null;
	switch(wealth)
	{
	case LOW:
	{
		output = low;
	}
	break;
	case MEDIUM:
	{
		String []temp  = combine(low, medium);
		output = temp;
	}
	break;
	case HIGH:
	{
		String []temp1  = combine(low, medium);
		String[] temp2 = combine(temp1,high);
		
		output = temp2;
	}
	break;
	case PREMIUM:
	{		
		String []temp1  = combine(low, medium);
		String[] temp2 = combine(temp1,high);
		String[] temp3 = combine(temp2,premium);

		output = temp3;
	}
	break;
	}
	return output;
}

public String[] combine(String[] Array1, String[] Array2)
{
	String[] output = new String[Array1.length+Array2.length];
	
	for(int i = 0; i <Array1.length;i++)
		output[i] = Array1[i];
	
	for(int j = 0; j<Array2.length;j++)
		output[j+Array1.length] = Array2[j];
	
	return output;
}

public String toString()
{
	return "Name: "+name
			+"\n Low: "+low
			+"\n Medium: "+medium
			+"\n High: "+high
			+"\n Premium: "+premium;
}
}
