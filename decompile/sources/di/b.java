package di;

import android.net.Uri;
import android.provider.ContactsContract;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f26705a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    public static Uri a(int i2) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i2)).build();
    }
}
