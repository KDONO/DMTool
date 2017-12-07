package testPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import npcPackage.NPCManager;

import org.json.simple.parser.ParseException;

import shopPackage.WealthEnum;
import shopPackage.InventoryManager;
import shopPackage.ShopManager;
import shopPackage.ShopTypeEnum;

public class Test 
{
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
/*
	ItemManager im = new ItemManager();
	
	im.parseJSON();
	
	ArrayList<String> array = im.getInventory(ShopTypeEnum.MAGICSHOP, AvenueEnum.PREMIUM);
			
	for(int i = 0; i<array.size();i++)
		System.out.println(array.get(i));
*/
	
NPCManager npc = new NPCManager();

npc.parseJSON();


}	

}
