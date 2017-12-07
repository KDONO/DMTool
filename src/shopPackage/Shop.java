package shopPackage;

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
public void setName(String name) {
	this.name = name;
}
public String[] getLow() {
	return low;
}
public void setLow(String[] low) {
	this.low = low;
}
public String[] getMedium() {
	return medium;
}
public void setMedium(String[] medium) {
	this.medium = medium;
}
public String[] getHigh() {
	return high;
}
public void setHigh(String[] high) {
	this.high = high;
}
public String[] getPremium() {
	return premium;
}
public void setPremium(String[] premium) {
	this.premium = premium;
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
