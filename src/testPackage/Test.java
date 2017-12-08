package testPackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import shopPackage.Item;
import shopPackage.ItemManager;
import shopPackage.WealthEnum;

public class Test 
{
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
ItemManager item = new ItemManager();
item.parseJSON();
//ArrayList<Item> test = item.getTreasureList(WealthEnum.HIGH);

//for(int i = 0; i<test.size();i++)
//	System.out.println(test.toString());
	
}

}
