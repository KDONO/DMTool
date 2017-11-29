import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NameController 
{
	ArrayList<String> MaleNames = new ArrayList<String>();
	ArrayList<String> FemaleNames = new ArrayList<String>();
	ArrayList<String> Surnames = new ArrayList<String>();

	ArrayList<String> OrcMaleNames = new ArrayList<String>();
	ArrayList<String> OrcFemaleNames = new ArrayList<String>();
	ArrayList<String> OrcSurnames = new ArrayList<String>();

	ArrayList<String> ElfMaleNames = new ArrayList<String>();
	ArrayList<String> ElfFemaleNames = new ArrayList<String>();
	ArrayList<String> ElfSurnames = new ArrayList<String>();
	
	public String generateMaleName(Races race)
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

	public String generateFemaleName(Races race)
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

	// Parses the Names.txt file into the String Arrays
	public void parseJSON() throws FileNotFoundException, IOException, ParseException 
	{
		//Get the JSON file as one JObject
	    JSONParser parser = new JSONParser();
	    
	    try
	    {
	    JSONObject data = (JSONObject) parser.parse(new FileReader("Names.txt"));
	    
	    //Grab the Arrays from the JObject as JArrays
	    JSONArray JSONMale = (JSONArray) data.get("MaleNames");
	    JSONArray JSONFemale = (JSONArray) data.get("FemaleNames");
	    JSONArray JSONSurname = (JSONArray) data.get("Surnames");
	    
	    JSONArray JSONOrcMale = (JSONArray) data.get("OrcMaleNames");
	    JSONArray JSONOrcFemale = (JSONArray) data.get("OrcFemaleNames");
	    JSONArray JSONOrcSurname = (JSONArray) data.get("OrcSurnames");
	    
	    JSONArray JSONElfMale = (JSONArray) data.get("ElfMaleNames");
	    JSONArray JSONElfFemale = (JSONArray) data.get("ElfFemaleNames");
	    JSONArray JSONElfSurname = (JSONArray) data.get("ElfSurnames");

	    //Convert JArrays to ArrayLists.
	    for(int i = 0; i<JSONMale.size(); i++)
	    {
	    	MaleNames.add((String) JSONMale.get(i));
	    }
	    for(int i = 0; i<JSONFemale.size(); i++)
	    {
	    	FemaleNames.add((String) JSONFemale.get(i));
	    }
	    for(int i = 0; i<JSONSurname.size(); i++)
	    {
	    	Surnames.add((String) JSONSurname.get(i));
	    }
	    
	    for(int i = 0; i<JSONOrcMale.size(); i++)
	    {
	    	OrcMaleNames.add((String) JSONOrcMale.get(i));
	    }
	    for(int i = 0; i<JSONOrcFemale.size(); i++)
	    {
	    	OrcFemaleNames.add((String) JSONOrcFemale.get(i));
	    }
	    for(int i = 0; i<JSONOrcSurname.size(); i++)
	    {
	    	OrcSurnames.add((String) JSONOrcSurname.get(i));
	    }
	    
	    for(int i = 0; i<JSONElfMale.size(); i++)
	    {
	    	ElfMaleNames.add((String) JSONElfMale.get(i));
	    }
	    for(int i = 0; i<JSONElfFemale.size(); i++)
	    {
	    	ElfFemaleNames.add((String) JSONElfFemale.get(i));
	    }
	    for(int i = 0; i<JSONElfSurname.size(); i++)
	    {
	    	ElfSurnames.add((String) JSONElfSurname.get(i));
	    }
	    
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
