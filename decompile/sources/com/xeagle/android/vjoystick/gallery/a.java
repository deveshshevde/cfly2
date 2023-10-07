package com.xeagle.android.vjoystick.gallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.OpenVideoActivity;
import com.xeagle.android.dialogs.b;
import com.xeagle.android.newUI.activity.ExoPlayerActivity;
import com.xeagle.android.vjoystick.gallery.c;
import hf.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kx.d;

public class a extends BaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f25295a;

    /* renamed from: b  reason: collision with root package name */
    private List<List<d>> f25296b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0158a f25297c;

    /* renamed from: com.xeagle.android.vjoystick.gallery.a$a  reason: collision with other inner class name */
    public interface C0158a {
        void onLongClick();
    }

    private class b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public TextView f25306b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ScrollGridView f25307c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public c f25308d;

        private b() {
        }
    }

    public a(Context context) {
        this.f25295a = context;
    }

    /* access modifiers changed from: private */
    public void a(int i2, List<d> list, b bVar) {
        if (!c.a()) {
            final String a2 = list.get(i2).a();
            final List<d> list2 = list;
            final int i3 = i2;
            final b bVar2 = bVar;
            com.xeagle.android.dialogs.b.a(this.f25295a.getString(R.string.warning), this.f25295a.getString(R.string.string_video_msg), this.f25295a.getString(R.string.dialog_share), this.f25295a.getString(R.string.activity_view), this.f25295a.getString(R.string.activity_delete), new b.a() {
                public void a() {
                    if (a.this.a(true, a2)) {
                        list2.remove(i3);
                        ToastUtils.showShort((int) R.string.local_video_del);
                        b bVar = bVar2;
                        if (bVar != null && bVar.f25308d != null) {
                            bVar2.f25308d.notifyDataSetChanged();
                        }
                    }
                }

                public void b() {
                    Intent intent;
                    if (a2.contains("local_")) {
                        intent = new Intent(a.this.f25295a, OpenVideoActivity.class);
                        intent.putExtra("open_video", a2);
                        intent.putExtra("video_info", a2);
                    } else {
                        intent = new Intent(a.this.f25295a, ExoPlayerActivity.class);
                        intent.putExtra("open_video", a2);
                        intent.putExtra("video_info", a2);
                        intent.putExtra("hide_ctrl_btn", true);
                    }
                    a.this.f25295a.startActivity(intent);
                }

                public void c() {
                    File file = new File(a2);
                    if (file.exists()) {
                        Uri uriForFile = Build.VERSION.SDK_INT >= 30 ? FileProvider.getUriForFile(a.this.f25295a, "com.cfly.uav_pro.fileProvider", file) : Uri.fromFile(file);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.STREAM", uriForFile);
                        intent.setType("video/*");
                        a.this.f25295a.startActivity(Intent.createChooser(intent, a.this.f25295a.getString(R.string.string_share_to)));
                    }
                }
            }).show(((AppCompatActivity) this.f25295a).getSupportFragmentManager(), "Local Video");
        }
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z2, String str) {
        File file = new File(str);
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(d.p(this.f25295a));
            sb.append(com.flypro.core.util.d.b("file://" + str));
            String sb2 = sb.toString();
            if (sb2 != null) {
                File file2 = null;
                if (sb2.contains("mp4")) {
                    file2 = new File(sb2.replace("mp4", "jpg"));
                }
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public void a() {
        boolean z2 = false;
        for (List<d> it2 : this.f25296b) {
            for (d dVar : it2) {
                if (dVar.b()) {
                    z2 = true;
                    a(dVar.d(), dVar.a());
                }
            }
        }
        if (z2) {
            ToastUtils.showShort((int) R.string.local_file_del);
        }
    }

    public void a(C0158a aVar) {
        this.f25297c = aVar;
    }

    public void a(List<List<d>> list) {
        this.f25296b.clear();
        if (list != null) {
            this.f25296b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z2) {
        for (List<d> it2 : this.f25296b) {
            for (d a2 : it2) {
                a2.a(z2);
            }
        }
        notifyDataSetChanged();
    }

    public void b() {
        for (List<d> it2 : this.f25296b) {
            for (d dVar : it2) {
                dVar.a(false);
                dVar.b(false);
            }
        }
        notifyDataSetChanged();
    }

    public void b(boolean z2) {
        for (List<d> it2 : this.f25296b) {
            for (d b2 : it2) {
                b2.b(z2);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        List<List<d>> list = this.f25296b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i2) {
        return this.f25296b.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        final b bVar;
        View view2;
        if (view == null) {
            bVar = new b();
            view2 = LayoutInflater.from(this.f25295a).inflate(R.layout.list_item, (ViewGroup) null, false);
            TextView unused = bVar.f25306b = (TextView) view2.findViewById(R.id.grid_info);
            ScrollGridView unused2 = bVar.f25307c = (ScrollGridView) view2.findViewById(R.id.gridView);
            c unused3 = bVar.f25308d = new c();
            bVar.f25308d.a((c.a) new c.a() {
                public void a(List<d> list, int i2) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (d a2 : list) {
                        arrayList.add(a2.a());
                    }
                    Intent intent = new Intent(a.this.f25295a, PhotoPreviewActivity.class);
                    intent.putExtra("pic_pos", i2);
                    intent.putExtra("shared_name", "img" + i2);
                    intent.putStringArrayListExtra("list", arrayList);
                    a.this.f25295a.startActivity(intent);
                }

                public boolean a() {
                    if (a.this.f25297c == null) {
                        return true;
                    }
                    a.this.f25297c.onLongClick();
                    return true;
                }

                public void b(List<d> list, int i2) {
                    a.this.a(i2, list, bVar);
                }
            });
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        List list = this.f25296b.get(i2);
        if (list == null || list.isEmpty()) {
            this.f25296b.remove(i2);
            notifyDataSetChanged();
            return view2;
        }
        bVar.f25308d.a((List<d>) list);
        String a2 = ((d) list.get(0)).a();
        int lastIndexOf = a2.lastIndexOf("_");
        bVar.f25306b.setText(a2.substring(lastIndexOf + 1, lastIndexOf + 9));
        bVar.f25307c.setAdapter(bVar.f25308d);
        return view2;
    }
}
