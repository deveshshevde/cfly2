package hh;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

public interface a {
    Bitmap a(Context context, Uri uri, int i2, int i3) throws Exception;

    void a(Context context, Uri uri, ImageView imageView);

    void b(Context context, Uri uri, ImageView imageView);

    void c(Context context, Uri uri, ImageView imageView);
}
