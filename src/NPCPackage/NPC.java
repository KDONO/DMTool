package NPCPackage;
import java.util.ArrayList;

public class NPC 
{
NPCManager npcManager;	

public NPC(NPCManager nameController)
{
this.npcManager = nameController;
}

public String generate(Races race, Genders gender)
{
	String name = "";
	
	switch(gender)
	{
		case MALE:
			name = npcManager.generateMaleName(race);
		break;
		case FEMALE:
			name = npcManager.generateFemaleName(race);
		break;
	}

	ArrayList<String> traits = npcManager.generateTraits();
	
	String output = (name+" ("+race+" "+gender+")\n"
			+ traits.get(0) + "\n"
			+ traits.get(1) + "\n"
			+ traits.get(2) + "\n"
			+ traits.get(3) + "\n"
			+ traits.get(4) + "\n"
			+ traits.get(5) + "\n"
			+ traits.get(6) + "\n"
			+ traits.get(7)) ; 
			
	System.out.println(output);
	return output;
}

}
