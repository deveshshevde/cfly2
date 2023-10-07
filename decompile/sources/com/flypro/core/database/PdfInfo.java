package com.flypro.core.database;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.h;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class PdfInfo implements Parcelable {
    public static final Parcelable.Creator<PdfInfo> CREATOR = new Creator();
    private String file_size;
    private String flag;
    private String image_url;
    private boolean isUpdate;
    private String name;
    private String pdf_url;
    private String version;

    public static class Creator implements Parcelable.Creator<PdfInfo> {
        public final PdfInfo createFromParcel(Parcel parcel) {
            h.d(parcel, "in");
            return new PdfInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        public final PdfInfo[] newArray(int i2) {
            return new PdfInfo[i2];
        }
    }

    public PdfInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, 127, (f) null);
    }

    public PdfInfo(String str, String str2, String str3, String str4, String str5, boolean z2, String str6) {
        h.d(str, "name");
        h.d(str2, "pdf_url");
        h.d(str3, IjkMediaPlayer.OnNativeInvokeListener.ARG_FILE_SIZE);
        h.d(str4, "image_url");
        h.d(str5, "version");
        h.d(str6, "flag");
        this.name = str;
        this.pdf_url = str2;
        this.file_size = str3;
        this.image_url = str4;
        this.version = str5;
        this.isUpdate = z2;
        this.flag = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PdfInfo(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12, java.lang.String r13, int r14, kotlin.jvm.internal.f r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            java.lang.String r0 = ""
            if (r15 == 0) goto L_0x0008
            r15 = r0
            goto L_0x0009
        L_0x0008:
            r15 = r7
        L_0x0009:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r8
        L_0x0010:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r9
        L_0x0017:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r10
        L_0x001e:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r11
        L_0x0025:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002c
            r12 = 1
            r5 = 1
            goto L_0x002d
        L_0x002c:
            r5 = r12
        L_0x002d:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0033
            r14 = r0
            goto L_0x0034
        L_0x0033:
            r14 = r13
        L_0x0034:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.database.PdfInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, int, kotlin.jvm.internal.f):void");
    }

    public static /* synthetic */ PdfInfo copy$default(PdfInfo pdfInfo, String str, String str2, String str3, String str4, String str5, boolean z2, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pdfInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = pdfInfo.pdf_url;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = pdfInfo.file_size;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = pdfInfo.image_url;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = pdfInfo.version;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            z2 = pdfInfo.isUpdate;
        }
        boolean z3 = z2;
        if ((i2 & 64) != 0) {
            str6 = pdfInfo.flag;
        }
        return pdfInfo.copy(str, str7, str8, str9, str10, z3, str6);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.pdf_url;
    }

    public final String component3() {
        return this.file_size;
    }

    public final String component4() {
        return this.image_url;
    }

    public final String component5() {
        return this.version;
    }

    public final boolean component6() {
        return this.isUpdate;
    }

    public final String component7() {
        return this.flag;
    }

    public final PdfInfo copy(String str, String str2, String str3, String str4, String str5, boolean z2, String str6) {
        h.d(str, "name");
        h.d(str2, "pdf_url");
        h.d(str3, IjkMediaPlayer.OnNativeInvokeListener.ARG_FILE_SIZE);
        h.d(str4, "image_url");
        h.d(str5, "version");
        String str7 = str6;
        h.d(str7, "flag");
        return new PdfInfo(str, str2, str3, str4, str5, z2, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PdfInfo)) {
            return false;
        }
        PdfInfo pdfInfo = (PdfInfo) obj;
        return h.a((Object) this.name, (Object) pdfInfo.name) && h.a((Object) this.pdf_url, (Object) pdfInfo.pdf_url) && h.a((Object) this.file_size, (Object) pdfInfo.file_size) && h.a((Object) this.image_url, (Object) pdfInfo.image_url) && h.a((Object) this.version, (Object) pdfInfo.version) && this.isUpdate == pdfInfo.isUpdate && h.a((Object) this.flag, (Object) pdfInfo.flag);
    }

    public final String getFile_size() {
        return this.file_size;
    }

    public final String getFlag() {
        return this.flag;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPdf_url() {
        return this.pdf_url;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pdf_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.file_size;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.image_url;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.version;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z2 = this.isUpdate;
        if (z2) {
            z2 = true;
        }
        int i3 = (hashCode5 + (z2 ? 1 : 0)) * 31;
        String str6 = this.flag;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return i3 + i2;
    }

    public final boolean isUpdate() {
        return this.isUpdate;
    }

    public final void setFile_size(String str) {
        h.d(str, "<set-?>");
        this.file_size = str;
    }

    public final void setFlag(String str) {
        h.d(str, "<set-?>");
        this.flag = str;
    }

    public final void setImage_url(String str) {
        h.d(str, "<set-?>");
        this.image_url = str;
    }

    public final void setName(String str) {
        h.d(str, "<set-?>");
        this.name = str;
    }

    public final void setPdf_url(String str) {
        h.d(str, "<set-?>");
        this.pdf_url = str;
    }

    public final void setUpdate(boolean z2) {
        this.isUpdate = z2;
    }

    public final void setVersion(String str) {
        h.d(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return this.name + ':' + this.pdf_url + ':' + this.file_size + ':' + this.image_url + ':' + this.version + ':' + this.isUpdate + ':' + this.flag;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.d(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.pdf_url);
        parcel.writeString(this.file_size);
        parcel.writeString(this.image_url);
        parcel.writeString(this.version);
        parcel.writeInt(this.isUpdate ? 1 : 0);
        parcel.writeString(this.flag);
    }
}
