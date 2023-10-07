package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.e;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    private final InternalRewinder f10159a;

    private static final class InternalRewinder {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f10160a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f10160a = parcelFileDescriptor;
        }

        /* access modifiers changed from: package-private */
        public ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.f10160a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f10160a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    public static final class a implements e.a<ParcelFileDescriptor> {
        public e<ParcelFileDescriptor> a(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f10159a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void b() {
    }

    /* renamed from: d */
    public ParcelFileDescriptor a() throws IOException {
        return this.f10159a.rewind();
    }
}
