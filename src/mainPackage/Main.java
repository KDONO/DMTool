package mainPackage;
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

import npcPackage.*;
import shopPackage.*;

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
String[] races = {"Random","Human", "Elf", "Dwarf", "Gnome", "Halfling", "Orc", "Dragonborn","Tiefling"};
JScrollPane npcScrollPane;
JTextArea npcResultField;
JButton npcGenerate;

//Shop Generation
JLabel shopLabel;
JComboBox<String> selectShopType;
JLabel avenueLabel;
JComboBox<String> selectWealthLevel;
String[] shopTypes = {"Blacksmith", "Inn", "Bowyer", "Leatherworker", "Temple", "Tailor", "Potions", "Magic Shop", "Jeweler", "General Store", "Bookseller"};
String[] wealthTypes = {"Base","Low","Medium","High"};
JLabel shopResult;
JTextArea shopResultField;
JScrollPane shopScrollPane;
JButton shopGenerate;

static NPCManager npcManager;
static ShopManager shopManager;

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
	shopManager = new ShopManager();
	shopManager.parseJSON();
	
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
	NpcGenerateButtonHandler npcGenerateButtonHandler = new NpcGenerateButtonHandler();
	npcGenerate.addActionListener(npcGenerateButtonHandler);
	
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
	avenueLabel = new JLabel("Wealth Level:");
	selectWealthLevel = new JComboBox<String>(wealthTypes);
	shopResult = new JLabel("Result:");
	shopResultField = new JTextArea(10, 10);
	shopScrollPane = new JScrollPane(shopResultField);
	shopGenerate = new JButton("Generate");
	ShopGenerateButtonHandler shopGenerateButtonHandler = new ShopGenerateButtonHandler();
	shopGenerate.addActionListener(shopGenerateButtonHandler);

	shopPanel.setLayout(new BoxLayout(shopPanel, BoxLayout.PAGE_AXIS));
	shopPanel.add(shopLabel);
	shopPanel.add(selectShopType);
	shopPanel.add(avenueLabel);
	shopPanel.add(selectWealthLevel);
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

	this.setSize(400,450);
	this.setTitle("Name Generator");
	this.setResizable(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.add(windowPanel);
	this.setVisible(true);
}

public class NpcGenerateButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{	
	RaceEnum currentRace = RaceEnum.RANDOM;
	GenderEnum currentGender = GenderEnum.RANDOM;
	
	switch(selectRaceBox.getSelectedItem().toString())
		{
		case "Human":
			currentRace = RaceEnum.HUMAN;
		break;
		case "Elf":
			currentRace = RaceEnum.ELF;
		break;
		case "Orc":
			currentRace = RaceEnum.ORC;
		break;
		case "Dwarf":
			currentRace = RaceEnum.DWARF;
		break;
		case "Gnome":
			currentRace = RaceEnum.GNOME;
		break;
		case "Halfling":
			currentRace = RaceEnum.HALFLING;
		break;
		case "Dragonborn":
			currentRace = RaceEnum.DRAGONBORN;
		break;
		case "Tiefling":
			currentRace = RaceEnum.TIEFLING;
		break;
		case "Random":
		{
			int randomNum = 1 + (int)(Math.random() * 8);
			if(randomNum == 1)
				currentRace = RaceEnum.HUMAN;
			if(randomNum == 2)
				currentRace = RaceEnum.ELF;
			if(randomNum == 3)
				currentRace = RaceEnum.ORC;
			if(randomNum == 4)
				currentRace = RaceEnum.DWARF;
			if(randomNum == 5)
				currentRace = RaceEnum.HALFLING;
			if(randomNum == 6)
				currentRace = RaceEnum.GNOME;
			if(randomNum == 7)
				currentRace = RaceEnum.TIEFLING;
			if(randomNum == 8)
				currentRace = RaceEnum.DRAGONBORN;
		}
		break;
		}
	
	switch(selectGenderBox.getSelectedItem().toString())
	{
		case "Male":
			currentGender = GenderEnum.MALE;
		break;
		case "Female":
			currentGender = GenderEnum.FEMALE;
		break;
		case "Random":
		{
			int randomNum = 1 + (int)(Math.random() * 2);
			if(randomNum == 1)
				currentGender = GenderEnum.MALE;
			if(randomNum == 2)
				currentGender = GenderEnum.FEMALE;
		}
		break;
	}
	npcResultField.setText(npcManager.generate(currentRace, currentGender));
	}
}

public class ShopGenerateButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{	
		ShopTypeEnum currentShop = ShopTypeEnum.INN;
		WealthEnum currentAvenue= WealthEnum.BASE;

		switch(selectWealthLevel.getSelectedItem().toString())
		{
		case "Base":
			currentAvenue = WealthEnum.BASE;
			break;
		case "Rural":
			currentAvenue = WealthEnum.LOW;
			break;
		case "Urban":
			currentAvenue = WealthEnum.MEDIUM;
			break;
		case "Premium":
			currentAvenue = WealthEnum.HIGH;
			break;
		}

		switch(selectShopType.getSelectedItem().toString())
		{
		case "Inn":
			currentShop = ShopTypeEnum.INN;
			break;
		case "Blacksmith":
			currentShop = ShopTypeEnum.BLACKSMITH;
			break;
		case "Bowyer":
			currentShop = ShopTypeEnum.BOWYER;
			break;
		case "Leatherworker":
			currentShop = ShopTypeEnum.LEATHERWORKER;
			break;
		case "Temple":
			currentShop = ShopTypeEnum.TEMPLE;
			break;
		case "Tailor":
			currentShop = ShopTypeEnum.TAILOR;
			break;
		case "Potions":
			currentShop = ShopTypeEnum.POTIONS;
			break;
		case "Magic Shop":
			currentShop = ShopTypeEnum.MAGICSHOP;
			break;
		case "Jeweler":
			currentShop = ShopTypeEnum.JEWELER;
			break;
		case "General Store":
			currentShop = ShopTypeEnum.GENERALSTORE;
			break;
		case "Bookseller":
			currentShop = ShopTypeEnum.BOOKSELLER;
			break;
		}
		shopResultField.setText(shopManager.generateShop(currentShop, currentAvenue));
	}
}

}


