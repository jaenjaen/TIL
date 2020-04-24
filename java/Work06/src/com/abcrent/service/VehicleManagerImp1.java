package com.abcrent.service;

import com.abcrent.child.Truck;
import com.abcrent.parent.Vehicle;

/**
 * 
 * @author Jaeeun Lee
 *
 */
public class VehicleManagerImp1 implements VehicleManager {

	Vehicle[] vs;
	int idx;
	
	
	private static VehicleManagerImp1 mgr = new VehicleManagerImp1();
	private VehicleManagerImp1() {
		vs = new Vehicle[100];
	}
	public static VehicleManagerImp1 getInstance() {return mgr;}
	
	
	
	public void add(Vehicle v) {
		vs[idx++] = v;
	};
	
	
	public Vehicle[] serchVehicle() {
		Vehicle[] vhcs = new Vehicle[idx];
		for(int i=0; i<idx; i++) {
			vhcs[i] = vs[i];
		}
		return vhcs;
	};
	
	
	public Vehicle[] serchVehicle(String model) {
		Vehicle[] vhcs = new Vehicle[idx];
		
		for(int i=0; i<idx; i++) {
		if(vs[i].getModel().contains(model)) vhcs[i] = vs[i];
		}
		return vhcs;
	};
	
	
	public Vehicle[] serchVehicle(int num) {
		Vehicle[] vhcs = new Vehicle[idx];
		
		for(int i=0; i<idx; i++) {
		if(vs[i].getNum() == num) vhcs[i] = vs[i];
		}
		return vhcs;
	};
	
	
	public Vehicle[] serchVehicleByPrice(int price) {
		Vehicle[] vhcs = new Vehicle[idx];
		
		for(int i=0; i<idx; i++) {
		if(vs[i].getPrice() == price) vhcs[i] = vs[i];
		}
		return vhcs;
	};
	
	
	public Vehicle changePrice(int price,int num){
		Vehicle vhc = null;
		for(int i=0; i<idx; i++) {
			if(vs[i].getNum() == num) {
				vs[i].setPrice(price);
				vhc = vs[i];
			}
		}
		
		return vhc;
	};
	
	
	public Vehicle changeCapacity(String capacity,int num){
		Vehicle vhc = null;
		for(int i=0; i<idx; i++) {
			if(vs[i].getNum() == num) {
				((Truck)vs[i]).setCapacity(capacity);
				vhc = vs[i];
			}
		}
		
		return vhc;
		};
		
		
	public String delete(int num){
		for(int i=0; i<idx; i++) {
			if(vs[i].getNum() == num) {
				for(int j = i; j<idx; j++) {
					swap(vs[j],vs[j+1]);
				}
			}
		}
		vs[idx--] = null;
		return num+"는 삭제되었습니다.";};
		
		
	public int getAllVehiclePrice(){
		int total =0;
		for(Vehicle v : vs) if(v != null) total += v.getPrice();
		return total;
	};
	
	
	public Vehicle[] getHighPrice(){
		Vehicle[] vhc = new Vehicle[idx];
		int high = vs[0].getPrice();
		
		for (Vehicle v : vs) {
			if(v == null) break;
			if(v.getPrice()> high) high = v.getPrice();
		}
		
		for(int i =0; i< idx; i++) {
			 if(vs[i] == null) break;
			 if(vs[i].getPrice() == high) vhc[i] = vs[i];
		}
		
		return vhc;
	};
	
	
	public Vehicle[] getLowPrice(){
		Vehicle[] vhc = new Vehicle[idx];
		int low = vs[0].getPrice();
		
		for (Vehicle v : vs) {
			if(v == null) break;
			if(v.getPrice() < low) low = v.getPrice();
		}
		
		for(int i =0; i< idx; i++) {
			 if(vs[i] == null) break;
			 if(vs[i].getPrice() == low) vhc[i] = vs[i];
		}
		
		return vhc;
	}
	
	private void swap(Vehicle a, Vehicle b) {
		Vehicle tmp = null;
		
		tmp = a;
		a = b;
		b = tmp;
	}

}
