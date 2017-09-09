package lab11;

import java.io.Serializable;

public class MonsterAttack implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int attackID;
	private int month;
	private int day;
	private int year;
	private String date;
	private String monsterName;
	private String attackLocation;
	private int numOfVictims;

	public MonsterAttack(int attackID, String date, String monsterName, String attackLocation, int numOfVictims) {
		this.attackID = attackID;
		this.month = Integer.parseInt(date.substring(0, date.indexOf('/')));
		this.day = Integer.parseInt(date.substring(date.indexOf('/') + 1, date.lastIndexOf('/')));
		this.year = Integer.parseInt(date.substring(date.lastIndexOf('/') + 1));
		this.monsterName = monsterName;
		this.attackLocation = attackLocation;
		this.numOfVictims = numOfVictims;
	}

	public int getAttackID() {
		return attackID;
	}

	public void setAttackID(int attackID) {
		this.attackID = attackID;
	}
	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getAttackLocation() {
		return attackLocation;
	}

	public void setAttackLocation(String attackLocation) {
		this.attackLocation = attackLocation;
	}

	public int getNumOfVictims() {
		return numOfVictims;
	}

	public void setNumOfVictims(int numOfVictims) {
		this.numOfVictims = numOfVictims;
	}

	public String toString() {
		return "Attack# " + attackID + " occurred on " + month + "/" + day + "/" + year + ". " + monsterName + " attacked " + attackLocation + ", resulting in " + numOfVictims + 
				" tragic fatalities.";
	}			
}