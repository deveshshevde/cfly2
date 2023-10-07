package bs;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.util.List;

public class e implements g<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5988a;

    public e(Context context) {
        this.f5988a = context.getApplicationContext();
    }

    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return b(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.f5988a.getPackageName())) {
            return this.f5988a;
        }
        try {
            return this.f5988a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f5988a.getPackageName())) {
                return this.f5988a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    public s<Drawable> a(Uri uri, int i2, int i3, f fVar) {
        Context a2 = a(uri, uri.getAuthority());
        return d.a(b.a(this.f5988a, a2, a(a2, uri)));
    }

    public boolean a(Uri uri, f fVar) {
        return uri.getScheme().equals("android.resource");
    }
}
