package com.abcrent.service;

import com.abcrent.parent.Vehicle;

public interface VehicleManager {
	void add(Vehicle v);
	Vehicle[] serchVehicle();
	Vehicle[] serchVehicle(String model);
	Vehicle[] serchVehicle(int num);
	Vehicle[] serchVehicleByPrice(int Price);
	Vehicle changePrice(int price,int num);
	Vehicle changeCapacity(String capacity,int num);
	String delete(int num);
	int getAllVehiclePrice();
	Vehicle[] getHighPrice();	
	Vehicle[] getLowPrice();

}
