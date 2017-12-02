package testPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import shopPackage.AvenueEnum;
import shopPackage.ItemManager;
import shopPackage.ShopManager;
import shopPackage.ShopTypeEnum;

public class Test 
{
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
	ItemManager im = new ItemManager();
	
	im.parseJSON();
	
	ArrayList<String> array = im.getInventory(ShopTypeEnum.MAGICSHOP, AvenueEnum.PREMIUM);
			
	for(int i = 0; i<array.size();i++)
		System.out.println(array.get(i));
}	

}
