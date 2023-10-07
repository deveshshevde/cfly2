package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import t.ac;
import t.c;
import v.b;

final class j {

    private static final class a {
        static boolean a(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ac.a(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }

        /* JADX INFO: finally extract failed */
        static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ac.a((View) textView, new c.a(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }
    }

    static Activity a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    static boolean a(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && ac.z(view) != null) {
            Activity a2 = a(view);
            if (a2 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    return view instanceof TextView ? a.a(dragEvent, (TextView) view, a2) : a.a(dragEvent, view, a2);
                }
            }
        }
        return false;
    }

    static boolean a(TextView textView, int i2) {
        int i3 = 0;
        if ((i2 != 16908322 && i2 != 16908337) || ac.z(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            c.a aVar = new c.a(primaryClip, 1);
            if (i2 != 16908322) {
                i3 = 1;
            }
            ac.a((View) textView, aVar.a(i3).a());
        }
        return true;
    }

    static b.a b(final View view) {
        return new b.a() {
            public boolean a(v.c cVar, int i2, Bundle bundle) {
                if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
                    try {
                        cVar.e();
                        InputContentInfo inputContentInfo = (InputContentInfo) cVar.d();
                        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                    } catch (Exception e2) {
                        Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e2);
                        return false;
                    }
                }
                return ac.a(view, new c.a(new ClipData(cVar.b(), new ClipData.Item(cVar.a())), 2).a(cVar.c()).a(bundle).a()) == null;
            }
        };
    }
}
