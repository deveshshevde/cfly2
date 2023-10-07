package com.xeagle.android.vjoystick.beans;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Objects;

public class BetaMemberBean implements Parcelable {
    public static final Parcelable.Creator<BetaMemberBean> CREATOR = new Parcelable.Creator<BetaMemberBean>() {
        public BetaMemberBean createFromParcel(Parcel parcel) {
            return new BetaMemberBean(parcel);
        }

        public BetaMemberBean[] newArray(int i2) {
            return new BetaMemberBean[i2];
        }
    };
    private ArrayList<MemberData> account;
    private float distance_rate;
    private boolean is_locked;
    private int rtl_distance;

    public static class MemberData implements Parcelable {
        public static final Parcelable.Creator<MemberData> CREATOR = new Parcelable.Creator<MemberData>() {
            public MemberData createFromParcel(Parcel parcel) {
                return new MemberData(parcel);
            }

            public MemberData[] newArray(int i2) {
                return new MemberData[i2];
            }
        };
        private boolean show_watermark;
        private String uid;

        protected MemberData(Parcel parcel) {
            this.uid = parcel.readString();
            this.show_watermark = parcel.readByte() != 0;
        }

        public MemberData(String str, boolean z2) {
            this.uid = str;
            this.show_watermark = z2;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.uid, ((MemberData) obj).uid);
        }

        public String getUid() {
            return this.uid;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.uid});
        }

        public boolean isShow_watermark() {
            return this.show_watermark;
        }

        public void setShow_watermark(boolean z2) {
            this.show_watermark = z2;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public String toString() {
            return "MemberData{uid='" + this.uid + '\'' + ", show_watermark=" + this.show_watermark + '}';
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.uid);
            parcel.writeByte(this.show_watermark ? (byte) 1 : 0);
        }
    }

    protected BetaMemberBean(Parcel parcel) {
        this.is_locked = parcel.readByte() != 0;
        this.distance_rate = parcel.readFloat();
        this.rtl_distance = parcel.readInt();
        this.account = parcel.createTypedArrayList(MemberData.CREATOR);
    }

    public BetaMemberBean(boolean z2, float f2, int i2, ArrayList<MemberData> arrayList) {
        this.is_locked = z2;
        this.distance_rate = f2;
        this.rtl_distance = i2;
        this.account = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<MemberData> getAccount() {
        return this.account;
    }

    public float getDistance_rate() {
        return this.distance_rate;
    }

    public int getRtl_distance() {
        return this.rtl_distance;
    }

    public boolean isIs_locked() {
        return this.is_locked;
    }

    public void setAccount(ArrayList<MemberData> arrayList) {
        this.account = arrayList;
    }

    public void setDistance_rate(float f2) {
        this.distance_rate = f2;
    }

    public void setIs_locked(boolean z2) {
        this.is_locked = z2;
    }

    public void setRtl_distance(int i2) {
        this.rtl_distance = i2;
    }

    public String toString() {
        return "BetaMemberBean{is_locked=" + this.is_locked + ", distance_rate=" + this.distance_rate + ", rtl_distance=" + this.rtl_distance + ", account=" + this.account + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.is_locked ? (byte) 1 : 0);
        parcel.writeFloat(this.distance_rate);
        parcel.writeInt(this.rtl_distance);
        parcel.writeTypedList(this.account);
    }
}
