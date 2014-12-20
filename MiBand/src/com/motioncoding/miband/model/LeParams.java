package com.motioncoding.miband.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LeParams implements Parcelable {
	public int connIntMin;
	public int connIntMax;
	public int connInt;
	
	public int latency;
	public int timeout;
	public int advInt;

	public static LeParams fromByte(byte[] b) {
		LeParams params = new LeParams();

		params.connIntMax = 0xffff & (0xff & b[0] | (0xff & b[1]) << 8);
		params.connIntMax = 0xffff & (0xff & b[2] | (0xff & b[3]) << 8);
		params.latency = 0xffff & (0xff & b[4] | (0xff & b[5]) << 8);
		params.timeout = 0xffff & (0xff & b[6] | (0xff & b[7]) << 8);
		params.connInt = 0xffff & (0xff & b[8] | (0xff & b[9]) << 8);
		params.advInt = 0xffff & (0xff & b[10] | (0xff & b[11]) << 8);

		params.connIntMin *= 1.25;
		params.connIntMax *= 1.25;
		params.advInt *= 0.625;
		params.timeout *= 10;

		return params;
	}

	protected LeParams() {}
	
    protected LeParams(Parcel in) {
        connIntMin = in.readInt();
        connIntMax = in.readInt();
        latency = in.readInt();
        timeout = in.readInt();
        connInt = in.readInt();
        advInt = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(connIntMin);
        dest.writeInt(connIntMax);
        dest.writeInt(latency);
        dest.writeInt(timeout);
        dest.writeInt(connInt);
        dest.writeInt(advInt);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LeParams> CREATOR = new Parcelable.Creator<LeParams>() {
        @Override
        public LeParams createFromParcel(Parcel in) {
            return new LeParams(in);
        }

        @Override
        public LeParams[] newArray(int size) {
            return new LeParams[size];
        }
    };
}