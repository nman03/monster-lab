package lab11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class BinaryMonsterPersister implements MonsterPersister {
	
	@Override
	public void saveListToFile(File f, List<MonsterAttack> ma) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			out.writeObject(ma);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MonsterAttack> readListFromFile(File f) {
		ObjectInputStream in = null;
		List<MonsterAttack> ma = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(f)));
			ma = (List<MonsterAttack>) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ma;
	}

}