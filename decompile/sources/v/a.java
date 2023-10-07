package v;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import s.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f34564a = new String[0];

    /* renamed from: v.a$a  reason: collision with other inner class name */
    private static class C0260a {
        static void a(EditorInfo editorInfo, CharSequence charSequence, int i2) {
            editorInfo.setInitialSurroundingSubText(charSequence, i2);
        }
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            C0260a.a(editorInfo, charSequence, 0);
        } else {
            a(editorInfo, charSequence, 0);
        }
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i2) {
        f.a(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            C0260a.a(editorInfo, charSequence, i2);
            return;
        }
        int i3 = (editorInfo.initialSelStart > editorInfo.initialSelEnd ? editorInfo.initialSelEnd : editorInfo.initialSelStart) - i2;
        int i4 = (editorInfo.initialSelStart > editorInfo.initialSelEnd ? editorInfo.initialSelStart : editorInfo.initialSelEnd) - i2;
        int length = charSequence.length();
        if (i2 < 0 || i3 < 0 || i4 > length) {
            b(editorInfo, (CharSequence) null, 0, 0);
        } else if (a(editorInfo.inputType)) {
            b(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            b(editorInfo, charSequence, i3, i4);
        } else {
            a(editorInfo, charSequence, i3, i4);
        }
    }

    private static void a(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        int i4 = i3 - i2;
        int i5 = i4 > 1024 ? 0 : i4;
        int i6 = 2048 - i5;
        double d2 = (double) i6;
        Double.isNaN(d2);
        int min = Math.min(charSequence.length() - i3, i6 - Math.min(i2, (int) (d2 * 0.8d)));
        int min2 = Math.min(i2, i6 - min);
        int i7 = i2 - min2;
        if (a(charSequence, i7, 0)) {
            i7++;
            min2--;
        }
        if (a(charSequence, (i3 + min) - 1, 1)) {
            min--;
        }
        CharSequence concat = i5 != i4 ? TextUtils.concat(new CharSequence[]{charSequence.subSequence(i7, i7 + min2), charSequence.subSequence(i3, min + i3)}) : charSequence.subSequence(i7, min2 + i5 + min + i7);
        int i8 = min2 + 0;
        b(editorInfo, concat, i8, i5 + i8);
    }

    public static void a(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    private static boolean a(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18;
    }

    private static boolean a(CharSequence charSequence, int i2, int i3) {
        if (i3 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i2));
        }
        if (i3 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i2));
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f34564a;
        } else if (editorInfo.extras == null) {
            return f34564a;
        } else {
            String[] stringArray = editorInfo.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
            if (stringArray == null) {
                stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
            }
            return stringArray != null ? stringArray : f34564a;
        }
    }

    private static void b(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }
}
