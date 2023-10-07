package jw;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import com.xeagle.android.dialogs.p;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String[] f29825a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f29826b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0202a f29827c;

    /* renamed from: jw.a$a  reason: collision with other inner class name */
    public interface C0202a {
        String a(Context context);

        boolean a(String str);

        String[] b(Context context);
    }

    private static class b extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<a> f29831a;

        /* renamed from: b  reason: collision with root package name */
        private final ProgressDialog f29832b;

        public b(a aVar) {
            this.f29831a = new WeakReference<>(aVar);
            ProgressDialog progressDialog = new ProgressDialog(aVar.f29826b);
            this.f29832b = progressDialog;
            progressDialog.setTitle("Processing...");
            progressDialog.setMessage("Please wait.");
            progressDialog.setIndeterminate(true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(String... strArr) {
            a aVar = (a) this.f29831a.get();
            if (aVar == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(aVar.f29827c.a(strArr[0]));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            Context context;
            int i2;
            int i3;
            a aVar = (a) this.f29831a.get();
            if (aVar != null) {
                if (bool.booleanValue()) {
                    context = aVar.f29826b;
                    i3 = R.string.status_file_opened;
                    i2 = 1;
                } else {
                    context = aVar.f29826b;
                    i3 = R.string.error_when_opening_file;
                    i2 = 0;
                }
                Toast.makeText(context, i3, i2).show();
                aVar.a(aVar.f29827c);
            }
            this.f29832b.dismiss();
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            this.f29832b.dismiss();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.f29832b.show();
        }
    }

    /* access modifiers changed from: protected */
    public abstract C0202a a();

    public void a(final Context context) {
        this.f29826b = context;
        C0202a a2 = a();
        this.f29827c = a2;
        String[] b2 = a2.b(context);
        this.f29825a = b2;
        if (b2.length == 0) {
            Toast.makeText(context, R.string.no_files, 0).show();
            return;
        }
        final List asList = Arrays.asList(b2);
        Collections.sort(asList);
        Collections.reverse(asList);
        Log.i("TAG", "openDialog: ====" + asList.size());
        p.a().a((p.b) new p.b() {
            public void a() {
            }

            public void a(int i2) {
                new b(a.this).execute(new String[]{a.this.f29827c.a(context) + ((String) asList.get(i2))});
            }

            public void a(p pVar) {
                pVar.a((List<String>) asList);
            }
        }).show(((AppCompatActivity) context).getSupportFragmentManager(), "listenerList");
    }

    /* access modifiers changed from: protected */
    public abstract void a(C0202a aVar);

    public void onClick(DialogInterface dialogInterface, int i2) {
        new b(this).execute(new String[]{this.f29827c.a(this.f29826b) + this.f29825a[i2]});
    }
}
