package NPCPackage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TraitController 
{
	ArrayList<String> Appearance = new ArrayList<String>();
	ArrayList<String> Ability = new ArrayList<String>();
	ArrayList<String> Talent = new ArrayList<String>();
	ArrayList<String> Interaction = new ArrayList<String>();
	ArrayList<String> Mannerism = new ArrayList<String>();
	ArrayList<String> Ideal = new ArrayList<String>();
	ArrayList<String> Bond = new ArrayList<String>();
	ArrayList<String> Flaw = new ArrayList<String>();
		
	public ArrayList<String> generateTraits()
	{
		ArrayList<String> output = new ArrayList<String>();		
		output.add("Appearance: "+Appearance.get((int) Math.floor((Math.random() * Appearance.size()))));
		output.add("Ability: "+Ability.get((int) Math.floor((Math.random() * Ability.size()))));
		output.add("Talent: "+Talent.get((int) Math.floor((Math.random() * Talent.size()))));
		output.add("Interaction: "+Interaction.get((int) Math.floor((Math.random() * Interaction.size()))));
		output.add("Mannerism: "+Mannerism.get((int) Math.floor((Math.random() * Mannerism.size()))));
		output.add("Ideal: "+Ideal.get((int) Math.floor((Math.random() * Ideal.size()))));
		output.add("Bond: "+Bond.get((int) Math.floor((Math.random() * Bond.size()))));
		output.add("Flaw: "+Flaw.get((int) Math.floor((Math.random() * Flaw.size()))));	
		return output;
	}

	public void parseJSON() throws FileNotFoundException, IOException, ParseException 
	{
		//Get the JSON file as one JObject
	    JSONParser parser = new JSONParser();
	    
	    try
	    {
	    JSONObject data = (JSONObject) parser.parse(new FileReader("Traits.txt"));
	    
	    //Grab the Arrays from the JObject as JArrays
	    JSONArray JSONAppearance = (JSONArray) data.get("Appearance");
	    JSONArray JSONAbility = (JSONArray) data.get("Ability");
	    JSONArray JSONTalent = (JSONArray) data.get("Talent");
	    JSONArray JSONInteraction = (JSONArray) data.get("Interaction");
	    JSONArray JSONMannerism= (JSONArray) data.get("Mannerism");
	    JSONArray JSONIdeal = (JSONArray) data.get("Ideal");
	    JSONArray JSONBond = (JSONArray) data.get("Bond");
	    JSONArray JSONFlaw = (JSONArray) data.get("Flaw");

	    //Convert JArrays to ArrayLists.
	    for(int i = 0; i<JSONAppearance.size(); i++)
	    	Appearance.add((String) JSONAppearance.get(i));
	    for(int i = 0; i<JSONAbility.size(); i++)
	    	Ability.add((String) JSONAbility.get(i));
	    for(int i = 0; i<JSONTalent.size(); i++)
	    	Talent.add((String) JSONTalent.get(i));
	    for(int i = 0; i<JSONInteraction.size(); i++)
	    	Interaction.add((String) JSONInteraction.get(i));
	    for(int i = 0; i<JSONMannerism.size(); i++)
	    	Mannerism.add((String) JSONMannerism.get(i));
	    for(int i = 0; i<JSONIdeal.size(); i++)
	    	Ideal.add((String) JSONIdeal.get(i));
	    for(int i = 0; i<JSONBond.size(); i++)
	    	Bond.add((String) JSONBond.get(i));
	    for(int i = 0; i<JSONFlaw.size(); i++)
	    	Flaw.add((String) JSONFlaw.get(i));
	    }
	    catch(FileNotFoundException e)
	    {
	        JOptionPane.showMessageDialog(null, e.toString(), "File Not Found Exception. Please place Traits.txt in the same directory as the executable JAR file.",
	                JOptionPane.ERROR_MESSAGE);
	    }
	    catch(Exception e)
	    {
	        JOptionPane.showMessageDialog(null, e.toString(), "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}

}
