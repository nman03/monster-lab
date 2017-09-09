package lab11;

import java.io.File;
import java.util.List;

public interface MonsterPersister {
	
	public void saveListToFile(File f, List<MonsterAttack> ma);
	
	public List<MonsterAttack> readListFromFile(File f);

}
