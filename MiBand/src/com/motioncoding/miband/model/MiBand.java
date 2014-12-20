package com.motioncoding.miband.model;

import java.util.Observable;

import com.motioncoding.debugging.L;


public class MiBand extends Observable {

	public String mBTAddress;
	public int mSteps;
	public String mName;
	public Battery mBattery;
	public LeParams mLeParams;
	
	
	
	public void setName(String name) {
		mName = name;
		L.i("setting "+name+" as BLE name");
		setChanged();
		notifyObservers();
	}
	
	public void setSteps(int steps) {
		mSteps = steps;
		L.i("setting "+steps+" steps");
		setChanged();
		notifyObservers();
	}
	
	public void setBattery(Battery battery) {
		mBattery = battery;
		L.i(battery.toString());
		setChanged();
		notifyObservers();
	}

	public void setLeParams(LeParams params) {
		mLeParams = params;
	}
	
}
