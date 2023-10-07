package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import s.f;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1511a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1512b;

    l(TextView textView) {
        this.f1511a = (TextView) f.a(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1512b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1511a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void a(TextClassifier textClassifier) {
        this.f1512b = textClassifier;
    }
}
