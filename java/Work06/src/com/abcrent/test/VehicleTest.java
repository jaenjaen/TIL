package com.abcrent.test;

import com.abcrent.child.Limousine;
import com.abcrent.child.Motocycle;
import com.abcrent.child.Truck;
import com.abcrent.parent.Vehicle;
import com.abcrent.service.VehicleManagerImp1;

public class VehicleTest {
	
	public static void printFor(Vehicle[] v) {
		for(int i=0; i<v.length;i++) {
			if(v[i] == null) continue;
			System.out.println(v[i].toString());
		}
	}
	
	public static void main(String[] args) {
		
		VehicleManagerImp1 mgr = VehicleManagerImp1.getInstance();
		mgr.add(new Limousine(100,"리무진0",500000,32));
		mgr.add(new Truck(200, "트럭0",160000,"1t"));
		mgr.add(new Motocycle(300,"오토바이0",50000,2));
		mgr.add(new Limousine(101,"리무진0",500000,32));
		mgr.add(new Truck(201, "트럭1",240000,"2t"));
		mgr.add(new Motocycle(301, "오토바이2",100000,4));
		mgr.add(new Truck(202, "트럭0",160000,"1t"));
		mgr.add(new Motocycle(302, "오토바이1",50000,2));
		
		System.out.println("전체 차량 검색**********");
		printFor(mgr.serchVehicle());
		
		
		System.out.println("\n모델명으로 검색**********");
		printFor(mgr.serchVehicle("오토바이"));
		
		System.out.println("\n차량번호로 검색**********");
		printFor(mgr.serchVehicle(101));
		
		System.out.println("\n가격으로 검색**********");
		printFor(mgr.serchVehicleByPrice(160000));
		
		System.out.println("\n가격변경**********");
		System.out.println(mgr.changePrice(700000, 101).toString());
		
		System.out.println("\n용량변경**********");
		System.out.println(mgr.changeCapacity("2t",202).toString());
		
		System.out.println("\n삭제**********");
		System.out.println(mgr.delete(302)+"\n");
		printFor(mgr.serchVehicle());
		
		System.out.println("\n전체 차량 합산가**********");
		System.out.println(mgr.getAllVehiclePrice()+"원");
		
		System.out.println("\n최고가 차**********");
		printFor(mgr.getHighPrice());
		
		System.out.println("\n최저가 차**********");
		printFor(mgr.getLowPrice());
		
		

	}

}
