package MainPackage;
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

import NPCPackage.Genders;
import NPCPackage.NPC;
import NPCPackage.NPCManager;
import NPCPackage.Races;

import javax.swing.*;
import javax.swing.border.Border;

public class Main extends JFrame 
{
	
//NPC Generation
JLabel genderLabel;
JLabel raceLabel;
JLabel resultLabel;
JComboBox<String> selectGenderBox;
String[] genders = {"Random","Male","Female"};
JComboBox<String> selectRaceBox;
String[] races = {"Random","Human", "Orc", "Half-Orc", "Elf", "Half-Elf"};
JScrollPane npcScrollPane;
JTextArea npcResultField;
JButton npcGenerate;

//Shop Generation
JLabel shopLabel;
JComboBox<String> selectShopType;
String[] shopTypes = {"Blacksmith", "Tavern", "Restaurant", "Inn", "Magic Shop", "Jeweler", "General Store", "Tailors", "Bookseller", "Butchers", "Masons", "Carpenters", "Tanners"};
JLabel shopResult;
JTextArea shopResultField;
JScrollPane shopScrollPane;
JButton shopGenerate;

static NPCManager npcManager;

public static void main(String[]args) throws FileNotFoundException, IOException, ParseException 
{
	//Make place to do stuff.
	new Main();
}
	
//UI Code
public Main() throws FileNotFoundException, IOException, ParseException
{
	//Parse the JSONs
	npcManager = new NPCManager();
	npcManager.parseJSON();
	JPanel windowPanel = new JPanel();
		
	//NPC pane
	JPanel npcPanel = new JPanel();
	Border npcBorder = BorderFactory.createTitledBorder("NPC Generator");
		npcPanel.setBorder(npcBorder);
	genderLabel = new JLabel("Gender:");
	selectGenderBox = new JComboBox<String>(genders);
	raceLabel = new JLabel("Race:");
	selectRaceBox = new JComboBox<String>(races);
	resultLabel = new JLabel("Result:");
	npcResultField = new JTextArea(10, 10);
	npcScrollPane = new JScrollPane(npcResultField);
	npcGenerate = new JButton("Generate");
	GenerateButtonHandler generateButtonHandler = new GenerateButtonHandler();
	npcGenerate.addActionListener(generateButtonHandler);
	
	npcPanel.setLayout(new BoxLayout(npcPanel, BoxLayout.PAGE_AXIS));
	npcPanel.add(genderLabel);
	npcPanel.add(selectGenderBox);
	npcPanel.add(raceLabel);
	npcPanel.add(selectRaceBox);
	npcPanel.add(resultLabel);
	npcPanel.add(npcScrollPane);
	npcPanel.add(npcGenerate);
	npcPanel.setPreferredSize(new Dimension(350,350));
	
	//SHOP STUFF
	JPanel shopPanel = new JPanel();
	Border shopBorder = BorderFactory.createTitledBorder("Shop Generator");
		npcPanel.setBorder(shopBorder);
	shopLabel = new JLabel("Shop Type:");
	selectShopType = new JComboBox<String>(shopTypes);
	shopResult = new JLabel("Result:");
	shopResultField = new JTextArea(10, 10);
	shopScrollPane = new JScrollPane(shopResultField);
	shopGenerate = new JButton("Generate");

	shopPanel.setLayout(new BoxLayout(shopPanel, BoxLayout.PAGE_AXIS));
	shopPanel.add(shopLabel);
	shopPanel.add(selectShopType);
	shopPanel.add(shopResult);
	shopPanel.add(shopScrollPane);
	shopPanel.add(shopGenerate);
	shopPanel.setPreferredSize(new Dimension(350,350));

	//WINDOW STUFF
	JTabbedPane tabbedPane = new JTabbedPane(); 
	windowPanel.add(tabbedPane);
	tabbedPane.setVisible(true);
	tabbedPane.addTab("NPC Generator", npcPanel);
	tabbedPane.addTab("Shop Generator", shopPanel);

	this.setSize(400,500);
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
	
	NPC npc = new NPC(npcManager);

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
	npcResultField.setText(npc.generate(currentRace, currentGender));
	}
}

}


