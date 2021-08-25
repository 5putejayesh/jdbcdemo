package comp.demoSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOps {

	void writeData(String fname, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fname);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void readData(String fname) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList list = null;
		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			list = (ArrayList) obj;

			for (Object o : list)
				System.out.println(o);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null)
					fis.close();
				if(ois!=null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
