package stream.object.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import stream.object.vo.Car;

/*
 * 직렬화 / 역직렬화 기능을 모두 다 담아놓음
 * 자동차를 여러개 던지고 여러개 받을 수 있다.
 * 백대든 천대든 하나에 묶어서 던져야 함
 */
public class CarService {
	
	//직렬화 기능
	public void OutputCar(ArrayList<Car> list, String path) throws Exception{
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(list);
		oos.close();
	}
	
	//역직렬화 기능
	public ArrayList<Car> InputCar(String path) throws Exception{
		ArrayList<Car> list = null;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		list = (ArrayList<Car>) ois.readObject();
		
		ois.close();
		return list;
		
	}
}
