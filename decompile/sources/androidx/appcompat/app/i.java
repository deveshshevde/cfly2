package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class i {

    /* renamed from: a  reason: collision with root package name */
    private static Field f673a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f674b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f675c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f676d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f677e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f678f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f679g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f680h;

    static void a(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                d(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                c(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                b(resources);
            }
        }
    }

    private static void a(Object obj) {
        if (!f676d) {
            try {
                f675c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f676d = true;
        }
        Class<?> cls = f675c;
        if (cls != null) {
            if (!f678f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f677e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f678f = true;
            }
            Field field = f677e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    private static void b(Resources resources) {
        if (!f674b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f673a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f674b = true;
        }
        Field field = f673a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f674b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f673a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f674b = true;
        }
        Object obj = null;
        Field field = f673a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj != null) {
            a(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f680h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f679g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f680h = true;
        }
        Field field = f679g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f674b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f673a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f674b = true;
                }
                Field field2 = f673a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    a(obj2);
                }
            }
        }
    }
}
