package lab11;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AttackMonitor implements Serializable {

	private static final long serialVersionUID = 1L;
	private String monitorName;
	private List<MonsterAttack> monsterAttacks;

	public AttackMonitor(String monitorName) {
		monsterAttacks = new ArrayList<MonsterAttack>();
		this.monitorName = monitorName;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public List<MonsterAttack> getMonsterAttacks() {
		return monsterAttacks;
	}

	public void addMonsterAttack(MonsterAttack monsterAttack) {
		monsterAttacks.add(monsterAttack);
	}

	public void delMonsterAttack(MonsterAttack monsterAttack) {
		monsterAttacks.remove(monsterAttack);
	}

	public void monitor() {

		String[] choices = {"Quit", "Report A Monster Attack", "List Monster Attacks", "Delete A Monster Attack", "Save List of Attacks", " Read List of Attacks"};

		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "Main Menu", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE, null, choices, "null");

			switch (choice) {
			case 0: 
					break;
			case 1: 
					addMonsterAttack();
					break;
			case 2: 
					listMonsterAttacks();
					break;
			case 3: 
					delMonsterAttack();
					break;	
			case 4: 
					saveListOfAttacks();
					break;
			case 5: 
					clearAndCopyFile();
			}
		} while (choice != 0);
	}

	private void listMonsterAttacks() {
		List<MonsterAttack> monsterAttacks = getMonsterAttacks();
		StringBuilder sb = new StringBuilder( "The following attacks were recorded by our " + getMonitorName() + " monitor branch:\n");

		if (monsterAttacks.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no known monster attacks at this time.");
		}

		else {
			for (MonsterAttack ma: monsterAttacks) {
				sb.append(ma + "\n");
			}
			JOptionPane.showMessageDialog(null, sb);
		}

	}

	private void addMonsterAttack() {
		int attackID = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Attack ID number"));
		String attackDate = JOptionPane.showInputDialog("Please enter the date of the attack (mm/dd/yyyy)");
		String monsterName = JOptionPane.showInputDialog("Please enter the name of the monster");
		String attackLocation = JOptionPane.showInputDialog("Please enter the location of the attack");
		int numOfVictims = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of victims"));
		addMonsterAttack(new MonsterAttack(attackID, attackDate, monsterName, attackLocation, numOfVictims));
	}

	private void delMonsterAttack() {
		List<MonsterAttack> monsterAttacks = getMonsterAttacks();

		if (monsterAttacks.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are no known monster attacks at this time.");
		} 

		else {
			int attackID = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Attack ID of the monster attack that you wish to delete"));
			boolean checker = false;

			for (int count = 0 ; count < monsterAttacks.size() ; count++) {
				if (attackID == monsterAttacks.get(count).getAttackID()) {
					delMonsterAttack(monsterAttacks.get(count));
					checker = true;
				}
			}

			if(checker) {
				JOptionPane.showMessageDialog(null, "Attack#" + attackID + " has been deleted.");
			}

			else {
				JOptionPane.showMessageDialog(null, "None matched the Attack ID provided.");
			}	
		}
	}

	private void saveListOfAttacks() {
		BinaryMonsterPersister persister = new BinaryMonsterPersister();
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			persister.saveListToFile(selectedFile, monsterAttacks);
		}
	}

	private void clearAndCopyFile()  {
		BinaryMonsterPersister persister = new BinaryMonsterPersister();
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			monsterAttacks = persister.readListFromFile(selectedFile);
		}
	}
}