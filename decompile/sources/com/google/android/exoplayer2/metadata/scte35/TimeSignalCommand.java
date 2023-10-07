package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.q;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: a */
        public TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f15963a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15964b;

    private TimeSignalCommand(long j2, long j3) {
        this.f15963a = j2;
        this.f15964b = j3;
    }

    static long a(q qVar, long j2) {
        long h2 = (long) qVar.h();
        if ((128 & h2) != 0) {
            return 8589934591L & ((((h2 & 1) << 32) | qVar.n()) + j2);
        }
        return -9223372036854775807L;
    }

    static TimeSignalCommand a(q qVar, long j2, aa aaVar) {
        long a2 = a(qVar, j2);
        return new TimeSignalCommand(a2, aaVar.b(a2));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f15963a);
        parcel.writeLong(this.f15964b);
    }
}
