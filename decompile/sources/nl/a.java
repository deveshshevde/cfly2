package nl;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

public class a {
    public static StringBuffer a(double d2, NumberFormat numberFormat, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            stringBuffer.append('(');
            stringBuffer.append(d2);
            stringBuffer.append(')');
        } else {
            numberFormat.format(d2, stringBuffer, fieldPosition);
        }
        return stringBuffer;
    }

    public static NumberFormat a() {
        return a(Locale.getDefault());
    }

    public static NumberFormat a(Locale locale) {
        NumberFormat instance = NumberFormat.getInstance(locale);
        instance.setMaximumFractionDigits(2);
        return instance;
    }
}
