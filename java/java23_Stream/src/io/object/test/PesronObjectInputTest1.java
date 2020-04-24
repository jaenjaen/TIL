package io.object.test;

/*
 * 역직렬화  == DataPack
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PesronObjectInputTest1 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\person.obj"));
		Person p = (Person) ois.readObject();
		System.out.println(p);
	}
}
