package com.motioncoding.miband.model;

import java.util.Calendar;

public class Battery {
	public int mBatteryLevel;
	public int mCycles;
	public Calendar mLastCharged;
	public Status mStatus;

	public static Battery fromByte(byte[] b) {
		Battery battery = new Battery();
		battery.mBatteryLevel = b[0];
		battery.mStatus = Status.fromByte(b[9]);
		battery.mLastCharged = Calendar.getInstance();
		
		battery.mLastCharged.set(Calendar.YEAR, b[1]+2000);
		battery.mLastCharged.set(Calendar.MONTH, b[2]);
		battery.mLastCharged.set(Calendar.DATE, b[3]);
		
		battery.mLastCharged.set(Calendar.HOUR_OF_DAY, b[4]);
		battery.mLastCharged.set(Calendar.MINUTE, b[5]);
		battery.mLastCharged.set(Calendar.SECOND, b[6]);
		
		battery.mCycles = 0xffff & (0xff & b[7] | (0xff & b[8]) << 8);
		return battery;
	}
	
	@Override
	public String toString() {
		return String.format("Level: %s Cycles: %s State: %s Last Charged: %s", mBatteryLevel, mCycles, mStatus.toString(), mLastCharged.toString());
	}

	static enum Status {
		LOW, FULL, CHARGING, NOT_CHARGING;

		public static Status fromByte(byte b) {
			switch (b) {
			case 1:
				return LOW;
			case 2:
				return CHARGING;
			case 3:
				return FULL;
			case 4:
				return NOT_CHARGING;

			default:
				return null;
			}
		}
	}
}