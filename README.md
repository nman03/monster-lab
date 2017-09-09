# monster-lab

Complete the Monster Attack project by doing the following:

- Add a method to AttackMonitor that saves the list of attacks to a comma separated values file. Iterate through the list, and for each attack, get each field using the getters from MonsterAttack. Write each value to the file, following each one except the last with a comma. Save the date as a single String in the format MM/DD/YYYY. After you have written out all the data for one attack, write out a newline. Add an item to the main menu that calls this method.

- Add a method that clears the list of monster attacks, then reads data from a .csv file, uses it to instantiate MonsterAttack objects, and adds the attacks to the list. This method must be able to read the files you write out in the method described above. You will need to use String's split() method here. Add an item to the main menu that calls this method. Make sure you can input attack data, save to a file, quit the program, start the program again, read your output file, and show the data from the file.

- Use an interface called MonsterPersister that includes a method to save a list of MonsterAttacks to a binary file and one to read a list of MonsterAttacks from a file and return the list. Implement the interface with the class BinaryMonsterPersister.
