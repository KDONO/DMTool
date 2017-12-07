package shopPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ItemManager 
{

public void parseJSON() throws FileNotFoundException
{
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new FileReader("data/items.json"));
	Item item[] = gson.fromJson(reader, Item[].class);

	for(int i = 0; i<item.length;i++)
	{
		
	}
	
}
}
