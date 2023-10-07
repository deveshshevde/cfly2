package com.xeagle.android.vjoystick.beans;

import android.os.Parcel;
import android.os.Parcelable;
import com.flypro.core.database.PdfInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.h;

public final class PdfBean implements Parcelable {
    public static final Parcelable.Creator<PdfBean> CREATOR = new Creator();
    private ArrayList<PdfInfo> pdfList;

    public static class Creator implements Parcelable.Creator<PdfBean> {
        public final PdfBean createFromParcel(Parcel parcel) {
            h.d(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((PdfInfo) parcel.readParcelable(PdfBean.class.getClassLoader()));
                readInt--;
            }
            return new PdfBean(arrayList);
        }

        public final PdfBean[] newArray(int i2) {
            return new PdfBean[i2];
        }
    }

    public PdfBean() {
        this((ArrayList) null, 1, (f) null);
    }

    public PdfBean(ArrayList<PdfInfo> arrayList) {
        h.d(arrayList, "pdfList");
        this.pdfList = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PdfBean(ArrayList arrayList, int i2, f fVar) {
        this((i2 & 1) != 0 ? new ArrayList() : arrayList);
    }

    public static /* synthetic */ PdfBean copy$default(PdfBean pdfBean, ArrayList<PdfInfo> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = pdfBean.pdfList;
        }
        return pdfBean.copy(arrayList);
    }

    public final ArrayList<PdfInfo> component1() {
        return this.pdfList;
    }

    public final PdfBean copy(ArrayList<PdfInfo> arrayList) {
        h.d(arrayList, "pdfList");
        return new PdfBean(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PdfBean) && h.a((Object) this.pdfList, (Object) ((PdfBean) obj).pdfList);
        }
        return true;
    }

    public final ArrayList<PdfInfo> getPdfList() {
        return this.pdfList;
    }

    public int hashCode() {
        ArrayList<PdfInfo> arrayList = this.pdfList;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final void setPdfList(ArrayList<PdfInfo> arrayList) {
        h.d(arrayList, "<set-?>");
        this.pdfList = arrayList;
    }

    public String toString() {
        return "PdfBean(pdfList=" + this.pdfList + ")";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.d(parcel, "parcel");
        ArrayList<PdfInfo> arrayList = this.pdfList;
        parcel.writeInt(arrayList.size());
        for (PdfInfo writeParcelable : arrayList) {
            parcel.writeParcelable(writeParcelable, i2);
        }
    }
}
