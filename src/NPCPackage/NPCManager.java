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

public class NPCManager 
{
	//Names
	ArrayList<String> MaleNames = new ArrayList<String>();
	ArrayList<String> FemaleNames = new ArrayList<String>();
	ArrayList<String> Surnames = new ArrayList<String>();
	ArrayList<String> OrcMaleNames = new ArrayList<String>();
	ArrayList<String> OrcFemaleNames = new ArrayList<String>();
	ArrayList<String> OrcSurnames = new ArrayList<String>();
	ArrayList<String> ElfMaleNames = new ArrayList<String>();
	ArrayList<String> ElfFemaleNames = new ArrayList<String>();
	ArrayList<String> ElfSurnames = new ArrayList<String>();
	
	//Traits
	ArrayList<String> Appearance = new ArrayList<String>();
	ArrayList<String> Ability = new ArrayList<String>();
	ArrayList<String> Talent = new ArrayList<String>();
	ArrayList<String> Interaction = new ArrayList<String>();
	ArrayList<String> Mannerism = new ArrayList<String>();
	ArrayList<String> Ideal = new ArrayList<String>();
	ArrayList<String> Bond = new ArrayList<String>();
	ArrayList<String> Flaw = new ArrayList<String>();
	
	public String generate(Races race, Genders gender)
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

	private String generateMaleName(Races race)
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

	private String generateFemaleName(Races race)
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
	    JSONObject nameData = (JSONObject) parser.parse(new FileReader("data/Names.txt"));
	    JSONObject traitData = (JSONObject) parser.parse(new FileReader("data/Traits.txt"));

	    //Grab the Arrays from the JObject as JArrays
	    //Names
	    JSONArray JSONMale = (JSONArray) nameData.get("MaleNames");
	    JSONArray JSONFemale = (JSONArray) nameData.get("FemaleNames");
	    JSONArray JSONSurname = (JSONArray) nameData.get("Surnames");
	    JSONArray JSONOrcMale = (JSONArray) nameData.get("OrcMaleNames");
	    JSONArray JSONOrcFemale = (JSONArray) nameData.get("OrcFemaleNames");
	    JSONArray JSONOrcSurname = (JSONArray) nameData.get("OrcSurnames");	    
	    JSONArray JSONElfMale = (JSONArray) nameData.get("ElfMaleNames");
	    JSONArray JSONElfFemale = (JSONArray) nameData.get("ElfFemaleNames");
	    JSONArray JSONElfSurname = (JSONArray) nameData.get("ElfSurnames");
	    
	    //Traits
	    JSONArray JSONAppearance = (JSONArray) traitData.get("Appearance");
	    JSONArray JSONAbility = (JSONArray) traitData.get("Ability");
	    JSONArray JSONTalent = (JSONArray) traitData.get("Talent");
	    JSONArray JSONInteraction = (JSONArray) traitData.get("Interaction");
	    JSONArray JSONMannerism= (JSONArray) traitData.get("Mannerism");
	    JSONArray JSONIdeal = (JSONArray) traitData.get("Ideal");
	    JSONArray JSONBond = (JSONArray) traitData.get("Bond");
	    JSONArray JSONFlaw = (JSONArray) traitData.get("Flaw");

	    //Convert JArrays to ArrayLists.
	    //Names
	    for(int i = 0; i<JSONMale.size(); i++)
	    	MaleNames.add((String) JSONMale.get(i));
	    for(int i = 0; i<JSONFemale.size(); i++)
	    	FemaleNames.add((String) JSONFemale.get(i));
	    for(int i = 0; i<JSONSurname.size(); i++)
	    	Surnames.add((String) JSONSurname.get(i));
	    for(int i = 0; i<JSONOrcMale.size(); i++)
	    	OrcMaleNames.add((String) JSONOrcMale.get(i));
	    for(int i = 0; i<JSONOrcFemale.size(); i++)
	    	OrcFemaleNames.add((String) JSONOrcFemale.get(i));
	    for(int i = 0; i<JSONOrcSurname.size(); i++)
	    	OrcSurnames.add((String) JSONOrcSurname.get(i));
	    for(int i = 0; i<JSONElfMale.size(); i++)
	    	ElfMaleNames.add((String) JSONElfMale.get(i));
	    for(int i = 0; i<JSONElfFemale.size(); i++)
	    	ElfFemaleNames.add((String) JSONElfFemale.get(i));
	    for(int i = 0; i<JSONElfSurname.size(); i++)
	    	ElfSurnames.add((String) JSONElfSurname.get(i));
	    
	    //Traits
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
