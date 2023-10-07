package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.cy;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.dm;
import com.amap.api.mapcore.util.dn;
import com.amap.api.mapcore.util.p;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";
    private static int nextId;

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(cy.a.marker_default.name() + ".png");
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker(float f2) {
        try {
            float f3 = (float) ((((int) (f2 + 15.0f)) / 30) * 30);
            if (f3 > 330.0f) {
                f3 = 330.0f;
            } else if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            String str = "";
            if (f3 == 0.0f) {
                str = "RED";
            } else if (f3 == 30.0f) {
                str = "ORANGE";
            } else if (f3 == 60.0f) {
                str = "YELLOW";
            } else if (f3 == 120.0f) {
                str = "GREEN";
            } else if (f3 == 180.0f) {
                str = "CYAN";
            } else if (f3 == 210.0f) {
                str = "AZURE";
            } else if (f3 == 240.0f) {
                str = "BLUE";
            } else if (f3 == 270.0f) {
                str = "VIOLET";
            } else if (f3 == 300.0f) {
                str = "MAGENTA";
            } else if (f3 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + ".png");
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(dl.a(context, str));
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable th) {
            dl.a(th);
            String str2 = dm.f8272f;
            dn.b(str2, "read bitmap from assets failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            if (nextId == Integer.MAX_VALUE) {
                nextId = 0;
            }
            StringBuilder sb = new StringBuilder(ICON_ID_PREFIX);
            int i2 = nextId + 1;
            nextId = i2;
            sb.append(i2);
            return new BitmapDescriptor(bitmap, sb.toString());
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8272f;
            dn.b(str, "read bitmap from bitmap failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            dl.a(decodeStream);
            return fromBitmap;
        } catch (Throwable th) {
            dl.a(th);
            String str2 = dm.f8272f;
            dn.b(str2, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            dl.a(th);
            String str2 = dm.f8272f;
            dn.b(str2, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i2) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i2)));
            }
            return null;
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8272f;
            dn.b(str, "read bitmap from res failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(dl.a((View) frameLayout));
        } catch (Throwable th) {
            dl.a(th);
            String str = dm.f8272f;
            dn.b(str, "read bitmap from view failed " + th.getMessage());
            return null;
        }
    }

    public static Context getContext() {
        return p.f9676a;
    }
}
