package npcPackage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NPCManager 
{
	//Names
    JSONArray MHumanNames;
    JSONArray FHumanNames;
    JSONArray SHumanNames; 
    
    JSONArray MDwarfNames; 
    JSONArray FDwarfNames;
    JSONArray SDwarfNames;
    
    JSONArray MGnomeNames; 
    JSONArray FGnomeNames;
    JSONArray SGnomeNames;
    
    JSONArray MHalflingNames; 
    JSONArray FHalflingNames;
    JSONArray SHalflingNames;
    
    JSONArray MOrcNames;
    JSONArray FOrcNames;
    JSONArray SOrcNames;
    
    JSONArray MElfNames; 
    JSONArray FElfNames;
    JSONArray SElfNames;    
    
    JSONArray MTieflingNames; 
    JSONArray FTieflingNames;
    JSONArray VTieflingNames;
    
    JSONArray MDragonbornNames; 
    JSONArray FDragonbornNames;
    JSONArray SDragonbornNames;

    //Traits
    JSONArray Appearance;
    JSONArray Ability;
    JSONArray Talent;
    JSONArray Interaction;
    JSONArray Mannerism;
    JSONArray Ideal;
    JSONArray Bond;
    JSONArray Flaw;
	
	public String generate(RaceEnum race, GenderEnum gender)
	{
		String name = "";
		
		switch(gender)
		{
			case MALE:
				name = generateMaleName(race);
			break;
			case FEMALE:
				name = generateFemaleName(race);
			break;
		}

		ArrayList<String> traits = generateTraits();
		
		String output = (name+" ("+race+" "+gender+")\n"
				+ traits.get(0) + "\n"
				+ traits.get(1) + "\n"
				+ traits.get(2) + "\n"
				+ traits.get(3) + "\n"
				+ traits.get(4) + "\n"
				+ traits.get(5) + "\n"
				+ traits.get(6) + "\n"
				+ traits.get(7)) ; 
				
//		System.out.println(output);
		return output;
	}

	private String generateMaleName(RaceEnum race)
	{
		String output = "";
		switch(race)
		{
			case HUMAN:
			{
			String name = MHumanNames.get((int) Math.floor((Math.random() * MHumanNames.size()))) 
					+ " " + SHumanNames.get((int) Math.floor((Math.random() * SHumanNames.size()))); 
			output = name;
			}
			break;
			case ORC:
			{
			String name = MOrcNames.get((int) Math.floor((Math.random() * MOrcNames.size()))) 
					+ " " + SOrcNames.get((int) Math.floor((Math.random() * SOrcNames.size()))); 	
			output = name;
			}
			break;
			case ELF:
			{
			String name = MElfNames.get((int) Math.floor((Math.random() * MElfNames.size()))) 
					+ " " + SElfNames.get((int) Math.floor((Math.random() * SElfNames.size()))); 	
			output = name;
			}
			break;
			case DWARF:
			{
			String name = MDwarfNames.get((int) Math.floor((Math.random() * MDwarfNames.size()))) 
					+ " " + SDwarfNames.get((int) Math.floor((Math.random() * SDwarfNames.size()))); 	
			output = name;
			}
			break;
			case GNOME:
			{
			String name = MGnomeNames.get((int) Math.floor((Math.random() * MGnomeNames.size()))) 
					+ " " + SGnomeNames.get((int) Math.floor((Math.random() * SGnomeNames.size()))); 	
			output = name;
			}
			break;
			case HALFLING:
			{
			String name = MHalflingNames.get((int) Math.floor((Math.random() * MHalflingNames.size()))) 
					+ " " + SHalflingNames.get((int) Math.floor((Math.random() * SHalflingNames.size()))); 	
			output = name;
			}
			break;
			case DRAGONBORN:
			{
			String name = MDragonbornNames.get((int) Math.floor((Math.random() * MDragonbornNames.size()))) 
					+ " " + SDragonbornNames.get((int) Math.floor((Math.random() * SDragonbornNames.size()))); 	
			output = name;
			}
			break;
			case TIEFLING:
			{
			String name = "\""+VTieflingNames.get((int) Math.floor((Math.random() * VTieflingNames.size()))) 
					+ "\" " + MTieflingNames.get((int) Math.floor((Math.random() * MTieflingNames.size()))); 	
			output = name;
			}
			break;
		}
		return output;
	}

	private String generateFemaleName(RaceEnum race)
	{
		String output = "";
		switch(race)
		{
			case HUMAN:
			{
			String name = FHumanNames.get((int) Math.floor((Math.random() * FHumanNames.size()))) 
					+ " " + SHumanNames.get((int) Math.floor((Math.random() * SHumanNames.size()))); 
			output = name;
			}
			break;
			case ORC:
			{
			String name = FOrcNames.get((int) Math.floor((Math.random() * FOrcNames.size()))) 
					+ " " + SOrcNames.get((int) Math.floor((Math.random() * SOrcNames.size()))); 	
			output = name;
			}
			break;
			case ELF:
			{
			String name = FElfNames.get((int) Math.floor((Math.random() * FElfNames.size()))) 
					+ " " + SElfNames.get((int) Math.floor((Math.random() * SElfNames.size()))); 	
			output = name;
			}
			break;
			case DWARF:
			{
			String name = FDwarfNames.get((int) Math.floor((Math.random() * FDwarfNames.size()))) 
					+ " " + SDwarfNames.get((int) Math.floor((Math.random() * SDwarfNames.size()))); 	
			output = name;
			}
			break;
			case GNOME:
			{
			String name = FGnomeNames.get((int) Math.floor((Math.random() * FGnomeNames.size()))) 
					+ " " + SGnomeNames.get((int) Math.floor((Math.random() * SGnomeNames.size()))); 	
			output = name;
			}
			break;
			case HALFLING:
			{
			String name = FHalflingNames.get((int) Math.floor((Math.random() * FHalflingNames.size()))) 
					+ " " + SHalflingNames.get((int) Math.floor((Math.random() * SHalflingNames.size()))); 	
			output = name;
			}
			break;
			case DRAGONBORN:
			{
			String name = FDragonbornNames.get((int) Math.floor((Math.random() * FDragonbornNames.size()))) 
					+ " " + SDragonbornNames.get((int) Math.floor((Math.random() * SDragonbornNames.size()))); 	
			output = name;
			}
			break;
			case TIEFLING:
			{
			String name = "\""+VTieflingNames.get((int) Math.floor((Math.random() * VTieflingNames.size()))) 
					+ "\" " + FTieflingNames.get((int) Math.floor((Math.random() * FTieflingNames.size()))); 	
			output = name;
			}
			break;

		}
		return output;
	}
	
	private ArrayList<String> generateTraits()
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

	// Parses the Names.txt file into the String Arrays
	public void parseJSON() throws FileNotFoundException, IOException, ParseException 
	{
		//Get the JSON file as one JObject
	    JSONParser parser = new JSONParser();
	    
	    try
	    {
	    JSONObject nameData = (JSONObject) parser.parse(new FileReader("data/NpcNames.json"));
	    JSONObject traitData = (JSONObject) parser.parse(new FileReader("data/Traits.json"));

	    //Grab the Arrays from the JObject as JArrays
	    //Names
	    MHumanNames = (JSONArray) nameData.get("MHuman");
	    FHumanNames = (JSONArray) nameData.get("FHuman");
	    SHumanNames = (JSONArray) nameData.get("SHuman");	  
	    
	    MOrcNames = (JSONArray) nameData.get("MOrc");
	    FOrcNames = (JSONArray) nameData.get("FOrc");
	    SOrcNames = (JSONArray) nameData.get("SOrc");	
	    
	    MElfNames = (JSONArray) nameData.get("MElf");
	    FElfNames = (JSONArray) nameData.get("FElf");
	    SElfNames = (JSONArray) nameData.get("SElf");	
	    
	    MDwarfNames = (JSONArray) nameData.get("MDwarf");
	    FDwarfNames = (JSONArray) nameData.get("FDwarf");
	    SDwarfNames = (JSONArray) nameData.get("SDwarf");
	    
	    MGnomeNames = (JSONArray) nameData.get("MGnome");
	    FGnomeNames = (JSONArray) nameData.get("FGnome");
	    SGnomeNames = (JSONArray) nameData.get("SGnome");
	    
	    MHalflingNames = (JSONArray) nameData.get("MHalfling");
	    FHalflingNames = (JSONArray) nameData.get("FHalfling");
	    SHalflingNames = (JSONArray) nameData.get("SHalfling");	 
	    
	    MTieflingNames = (JSONArray) nameData.get("MTiefling");
	    FTieflingNames = (JSONArray) nameData.get("FTiefling");
	    VTieflingNames = (JSONArray) nameData.get("VTiefling");	    
	    
	    MDragonbornNames = (JSONArray) nameData.get("MDragonborn");
	    FDragonbornNames = (JSONArray) nameData.get("FDragonborn");
	    SDragonbornNames = (JSONArray) nameData.get("SDragonborn");	    


	    //Traits
	    Appearance = (JSONArray) traitData.get("Appearance");
	    Ability = (JSONArray) traitData.get("Ability");
	    Talent = (JSONArray) traitData.get("Talent");
	    Interaction = (JSONArray) traitData.get("Interaction");
	    Mannerism= (JSONArray) traitData.get("Mannerism");
	    Ideal = (JSONArray) traitData.get("Ideal");
	    Bond = (JSONArray) traitData.get("Bond");
	    Flaw = (JSONArray) traitData.get("Flaw");
	    
	    }

	    catch(FileNotFoundException e)
	    {
	        JOptionPane.showMessageDialog(null, e.toString(), "File Not Found Exception. Please place Names.txt in the same directory as the executable JAR file.",
	                JOptionPane.ERROR_MESSAGE);
	    }
	    catch(Exception e)
	    {
	        JOptionPane.showMessageDialog(null, e.toString(), "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
}
