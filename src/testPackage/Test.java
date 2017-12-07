package testPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import npcPackage.NPCManager;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import shopPackage.Item;
import shopPackage.ItemManager;
import shopPackage.WealthEnum;
import shopPackage.InventoryManager;
import shopPackage.ShopManager;
import shopPackage.ShopTypeEnum;

public class Test 
{
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
ShopManager shop = new ShopManager();
shop.parseJSON();
}

}
