package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2807a = (IconCompat) aVar.b(remoteActionCompat.f2807a, 1);
        remoteActionCompat.f2808b = aVar.b(remoteActionCompat.f2808b, 2);
        remoteActionCompat.f2809c = aVar.b(remoteActionCompat.f2809c, 3);
        remoteActionCompat.f2810d = (PendingIntent) aVar.b(remoteActionCompat.f2810d, 4);
        remoteActionCompat.f2811e = aVar.b(remoteActionCompat.f2811e, 5);
        remoteActionCompat.f2812f = aVar.b(remoteActionCompat.f2812f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.a(false, false);
        aVar.a((c) remoteActionCompat.f2807a, 1);
        aVar.a(remoteActionCompat.f2808b, 2);
        aVar.a(remoteActionCompat.f2809c, 3);
        aVar.a((Parcelable) remoteActionCompat.f2810d, 4);
        aVar.a(remoteActionCompat.f2811e, 5);
        aVar.a(remoteActionCompat.f2812f, 6);
    }
}
