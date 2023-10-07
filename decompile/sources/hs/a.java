package hs;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.huantansheng.easyphotos.R;

public class a extends Dialog {
    private a(Context context) {
        super(context);
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
    }

    public static a a(Context context) {
        a aVar = new a(context);
        aVar.setContentView(LayoutInflater.from(context).inflate(R.layout.dialog_loading_easy_photos, (ViewGroup) null));
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        return aVar;
    }

    public void show() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setBackgroundDrawableResource(R.color.transparent_easy_photos);
            window.setGravity(17);
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        super.show();
    }
}
