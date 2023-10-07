package jr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.MainViewActivity;
import com.xeagle.android.camera.widgets.ColorPicker;
import com.xeagle.android.camera.widgets.ablum.b;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private Button f29739a;

    /* renamed from: b  reason: collision with root package name */
    private Button f29740b;

    /* renamed from: c  reason: collision with root package name */
    private ColorPicker f29741c;

    /* access modifiers changed from: private */
    public void a() {
        int color = this.f29741c.getColor();
        int argb = Color.argb(255, Color.red(color), Color.green(color), Color.blue(color));
        b.b(getActivity());
        b.a("colorPicker", argb);
        b.a("colorList", Color.argb(20, Color.red(color), Color.green(color), Color.blue(color)));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        FragmentActivity activity = getActivity();
        getActivity();
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.colorpicker_dialogfragment, (ViewGroup) null, false);
        this.f29741c = (ColorPicker) inflate.findViewById(R.id.colorPiker);
        a();
        this.f29739a = (Button) inflate.findViewById(R.id.setColor);
        Button button = (Button) inflate.findViewById(R.id.setCancel);
        this.f29740b = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        this.f29739a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a();
                a.this.dismiss();
                a.this.getActivity().finish();
                a.this.startActivity(new Intent(a.this.getActivity(), MainViewActivity.class));
            }
        });
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        create.getWindow().setGravity(17);
        create.show();
        create.setContentView(inflate);
        return create;
    }

    public void onStart() {
        super.onStart();
        a();
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        a();
    }
}
