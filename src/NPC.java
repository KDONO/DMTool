import java.util.ArrayList;

public class NPC 
{
NameController nameController;	
TraitController traitController;

public NPC(NameController nameController, TraitController traitController )
{
this.nameController = nameController;
this.traitController = traitController;
}

public String generate(Races race, Genders gender)
{
	String name = "";
	
	switch(gender)
	{
		case MALE:
			name = nameController.generateMaleName(race);
		break;
		case FEMALE:
			name = nameController.generateFemaleName(race);
		break;
	}

	ArrayList<String> traits = traitController.generateTraits();
	
	String output = (race+" "+gender+"\n"
			+ name+"\n"
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
