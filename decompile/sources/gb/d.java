package gb;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

final class d {
    public static e a(e eVar, String[] strArr, Map<String, e> map) {
        if (eVar == null && strArr == null) {
            return null;
        }
        int i2 = 0;
        if (eVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (eVar == null && strArr.length > 1) {
            e eVar2 = new e();
            int length = strArr.length;
            while (i2 < length) {
                eVar2.a(map.get(strArr[i2]));
                i2++;
            }
            return eVar2;
        } else if (eVar != null && strArr != null && strArr.length == 1) {
            return eVar.a(map.get(strArr[0]));
        } else {
            if (!(eVar == null || strArr == null || strArr.length <= 1)) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    eVar.a(map.get(strArr[i2]));
                    i2++;
                }
            }
            return eVar;
        }
    }

    static String a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != 10) {
            spannableStringBuilder.append(10);
        }
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, e eVar) {
        Object obj;
        if (eVar.a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(eVar.a()), i2, i3, 33);
        }
        if (eVar.b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (eVar.c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (eVar.f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(eVar.e()), i2, i3, 33);
        }
        if (eVar.h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(eVar.g()), i2, i3, 33);
        }
        if (eVar.d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(eVar.d()), i2, i3, 33);
        }
        if (eVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(eVar.j()), i2, i3, 33);
        }
        int k2 = eVar.k();
        if (k2 == 1) {
            obj = new AbsoluteSizeSpan((int) eVar.l(), true);
        } else if (k2 == 2) {
            obj = new RelativeSizeSpan(eVar.l());
        } else if (k2 == 3) {
            obj = new RelativeSizeSpan(eVar.l() / 100.0f);
        } else {
            return;
        }
        spannableStringBuilder.setSpan(obj, i2, i3, 33);
    }
}
