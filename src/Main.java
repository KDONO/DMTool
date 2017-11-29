import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.border.Border;

public class Main extends JFrame 
{
JLabel genderLabel;
JLabel raceLabel;
JLabel resultLabel;
JComboBox<String> selectGenderBox;
String[] genders = {"Random","Male","Female"};
JComboBox<String> selectRaceBox;
String[] races = {"Random","Human", "Orc", "Half-Orc", "Elf", "Half-Elf"};
JScrollPane scrollpane;
JTextArea resultField;
JButton generate;

static NameController nameController;
static TraitController traitController;
public static void main(String[]args) throws FileNotFoundException, IOException, ParseException 
{
	//Make place to do stuff.
	new Main();
}
	
//UI Code
public Main() throws FileNotFoundException, IOException, ParseException
{
	//Parse the JSONs
	nameController = new NameController();
	nameController.parseJSON();
	traitController = new TraitController();
	traitController.parseJSON();	
	JPanel windowPanel = new JPanel();
	
	JPanel mainPanel = new JPanel();
	Border mainBorder = BorderFactory.createTitledBorder("Name Generator");
		mainPanel.setBorder(mainBorder);
	genderLabel = new JLabel("Gender:");
	selectGenderBox = new JComboBox<String>(genders);
	raceLabel = new JLabel("Race:");
	selectRaceBox = new JComboBox<String>(races);
	resultLabel = new JLabel("Result:");
	resultField = new JTextArea(10, 10);
	scrollpane = new JScrollPane(resultField);
	generate = new JButton("Generate");
	GenerateButtonHandler generateButtonHandler = new GenerateButtonHandler();
	generate.addActionListener(generateButtonHandler);
	
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
	
	mainPanel.add(genderLabel);
	mainPanel.add(selectGenderBox);
	mainPanel.add(raceLabel);
	mainPanel.add(selectRaceBox);
	mainPanel.add(resultLabel);
	mainPanel.add(scrollpane);
	mainPanel.add(generate);
	mainPanel.setPreferredSize(new Dimension(350,350));
	windowPanel.add(mainPanel);
	
	this.setSize(400,400);
	this.setTitle("Name Generator");
	this.setResizable(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.add(windowPanel);
	this.setVisible(true);
	
	System.out.println("Test \n Also test");
}

public class GenerateButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{	
	Races currentRace = Races.RANDOM;
	Genders currentGender = Genders.RANDOM;
	
	NPC npc = new NPC(nameController, traitController);

	switch(selectRaceBox.getSelectedItem().toString())
		{
		case "Human":
			currentRace = Races.HUMAN;
		break;
		case "Elf":
			currentRace = Races.ELF;
		break;
		case "Half-Elf":
			currentRace = Races.HALFELF;
		break;
		case "Orc":
			currentRace = Races.ORC;
		break;
		case "Half-Orc":
			currentRace = Races.HALFORC;
		break;
		case "Random":
		{
			int randomNum = 1 + (int)(Math.random() * 5);
			if(randomNum == 1)
				currentRace = Races.HUMAN;
			if(randomNum == 2)
				currentRace = Races.ELF;
			if(randomNum == 3)
				currentRace = Races.HALFELF;
			if(randomNum == 4)
				currentRace = Races.ORC;
			if(randomNum == 5)
				currentRace = Races.HALFORC;
		}
		break;
		}
	
	switch(selectGenderBox.getSelectedItem().toString())
	{
		case "Male":
			currentGender = Genders.MALE;
		break;
		case "Female":
			currentGender = Genders.FEMALE;
		break;
		case "Random":
		{
			int randomNum = 1 + (int)(Math.random() * 2);
			if(randomNum == 1)
				currentGender = Genders.MALE;
			if(randomNum == 2)
				currentGender = Genders.FEMALE;
		}
		break;
	}

	resultField.setText(npc.generate(currentRace, currentGender));

	}
}

}


