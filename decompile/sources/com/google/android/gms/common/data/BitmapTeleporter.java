package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f17674a;

    /* renamed from: b  reason: collision with root package name */
    ParcelFileDescriptor f17675b;

    /* renamed from: c  reason: collision with root package name */
    final int f17676c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f17677d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17678e = false;

    /* renamed from: f  reason: collision with root package name */
    private File f17679f;

    BitmapTeleporter(int i2, ParcelFileDescriptor parcelFileDescriptor, int i3) {
        this.f17674a = i2;
        this.f17675b = parcelFileDescriptor;
        this.f17676c = i3;
    }

    private static final void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close stream", e2);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        if (this.f17675b == null) {
            Bitmap bitmap = (Bitmap) m.a(this.f17677d);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            File file = this.f17679f;
            if (file != null) {
                try {
                    File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        this.f17675b = ParcelFileDescriptor.open(createTempFile, AMapEngineUtils.MAX_P20_WIDTH);
                        createTempFile.delete();
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            dataOutputStream.writeInt(array.length);
                            dataOutputStream.writeInt(bitmap.getWidth());
                            dataOutputStream.writeInt(bitmap.getHeight());
                            dataOutputStream.writeUTF(bitmap.getConfig().toString());
                            dataOutputStream.write(array);
                            a(dataOutputStream);
                        } catch (IOException e2) {
                            throw new IllegalStateException("Could not write into unlinked file", e2);
                        } catch (Throwable th) {
                            a(dataOutputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        throw new IllegalStateException("Temporary file is somehow already deleted");
                    }
                } catch (IOException e3) {
                    throw new IllegalStateException("Could not create temporary file", e3);
                }
            } else {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
        }
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17674a);
        a.a(parcel, 2, (Parcelable) this.f17675b, i2 | 1, false);
        a.a(parcel, 3, this.f17676c);
        a.a(parcel, a2);
        this.f17675b = null;
    }
}
