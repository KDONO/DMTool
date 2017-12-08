package testPackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import shopPackage.ItemManager;

public class Test 
{
public static void main(String args[]) throws FileNotFoundException, IOException, ParseException
{
ItemManager item = new ItemManager();
item.parseJSON();
item.test();
}

}
