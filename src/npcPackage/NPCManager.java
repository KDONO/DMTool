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
    JSONArray MaleNames;
    JSONArray FemaleNames;
    JSONArray Surnames; 
    JSONArray OrcMaleNames;
    JSONArray OrcFemaleNames;
    JSONArray OrcSurnames;
    JSONArray ElfMaleNames; 
    JSONArray ElfFemaleNames;
    JSONArray ElfSurnames;
    
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
			String name = MaleNames.get((int) Math.floor((Math.random() * MaleNames.size()))) 
					+ " " + MaleNames.get((int) Math.floor((Math.random() * MaleNames.size()))) 
					+ " " + Surnames.get((int) Math.floor((Math.random() * Surnames.size()))); 
			output = name;
			}
			break;
			case ORC:
			{
			String name = OrcMaleNames.get((int) Math.floor((Math.random() * OrcMaleNames.size()))) 
					+ " " + OrcMaleNames.get((int) Math.floor((Math.random() * OrcMaleNames.size()))) 
					+ " " + OrcSurnames.get((int) Math.floor((Math.random() * OrcSurnames.size()))); 	
			output = name;
			}
			break;
			case ELF:
			{
			String name = ElfMaleNames.get((int) Math.floor((Math.random() * ElfMaleNames.size()))) 
					+ " " + ElfMaleNames.get((int) Math.floor((Math.random() * ElfMaleNames.size()))) 
					+ " " + ElfSurnames.get((int) Math.floor((Math.random() * ElfSurnames.size()))); 	
			output = name;
			}
			break;
			case HALFORC:
			{
			ArrayList<String> firstname = new ArrayList<>(MaleNames.size() + OrcMaleNames.size());
			firstname.addAll(MaleNames);
			firstname.addAll(OrcMaleNames);
			
			ArrayList<String> lastname = new ArrayList<>(Surnames.size() + OrcSurnames.size());
			lastname.addAll(Surnames);
			lastname.addAll(OrcSurnames);

			String name = firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + lastname.get((int) Math.floor((Math.random() * lastname.size()))); 	
			output = name;
			}
			break;
			case HALFELF:
			{
			ArrayList<String> firstname = new ArrayList<>(MaleNames.size() + ElfMaleNames.size());
			firstname.addAll(MaleNames);
			firstname.addAll(ElfMaleNames);
			
			ArrayList<String> lastname = new ArrayList<>(Surnames.size() + ElfSurnames.size());
			lastname.addAll(Surnames);
			lastname.addAll(ElfSurnames);

			String name = firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + lastname.get((int) Math.floor((Math.random() * lastname.size()))); 	
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
			String name = FemaleNames.get((int) Math.floor((Math.random() * FemaleNames.size()))) 
					+ " " + FemaleNames.get((int) Math.floor((Math.random() * FemaleNames.size()))) 
					+ " " + Surnames.get((int) Math.floor((Math.random() * Surnames.size()))); 
			output = name;
			}
			break;
			case ORC:
			{
			String name = OrcFemaleNames.get((int) Math.floor((Math.random() * OrcFemaleNames.size()))) 
					+ " " + OrcFemaleNames.get((int) Math.floor((Math.random() * OrcFemaleNames.size()))) 
					+ " " + OrcSurnames.get((int) Math.floor((Math.random() * OrcSurnames.size()))); 	
			output = name;
			}
			break;
			case ELF:
			{
			String name = ElfFemaleNames.get((int) Math.floor((Math.random() * ElfFemaleNames.size()))) 
					+ " " + ElfFemaleNames.get((int) Math.floor((Math.random() * ElfFemaleNames.size()))) 
					+ " " + ElfSurnames.get((int) Math.floor((Math.random() * ElfSurnames.size()))); 	
			output = name;
			}
			break;
			case HALFORC:
			{
			ArrayList<String> firstname = new ArrayList<>(FemaleNames.size() + OrcFemaleNames.size());
			firstname.addAll(FemaleNames);
			firstname.addAll(OrcFemaleNames);
			
			ArrayList<String> lastname = new ArrayList<>(Surnames.size() + OrcSurnames.size());
			lastname.addAll(Surnames);
			lastname.addAll(OrcSurnames);

			String name = firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + lastname.get((int) Math.floor((Math.random() * lastname.size()))); 	
			output = name;
			}
			break;
			case HALFELF:
			{
			ArrayList<String> firstname = new ArrayList<>(FemaleNames.size() + ElfFemaleNames.size());
			firstname.addAll(FemaleNames);
			firstname.addAll(ElfFemaleNames);
			
			ArrayList<String> lastname = new ArrayList<>(Surnames.size() + ElfSurnames.size());
			lastname.addAll(Surnames);
			lastname.addAll(ElfSurnames);

			String name = firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + firstname.get((int) Math.floor((Math.random() * firstname.size()))) 
					+ " " + lastname.get((int) Math.floor((Math.random() * lastname.size()))); 	
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
	    MaleNames = (JSONArray) nameData.get("MaleNames");
	    FemaleNames = (JSONArray) nameData.get("FemaleNames");
	    Surnames = (JSONArray) nameData.get("Surnames");
	    OrcMaleNames = (JSONArray) nameData.get("OrcMaleNames");
	    OrcFemaleNames = (JSONArray) nameData.get("OrcFemaleNames");
	    OrcSurnames = (JSONArray) nameData.get("OrcSurnames");	    
	    ElfMaleNames = (JSONArray) nameData.get("ElfMaleNames");
	    ElfFemaleNames = (JSONArray) nameData.get("ElfFemaleNames");
	    ElfSurnames = (JSONArray) nameData.get("ElfSurnames");
	    
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
