package com.xeagle.android.sobot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xeagle.android.dialogs.s;
import iy.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SobotWebViewActivity extends AppCompatActivity {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static WebView f24306d;

    /* renamed from: a  reason: collision with root package name */
    String f24307a;

    /* renamed from: b  reason: collision with root package name */
    Uri f24308b;

    /* renamed from: c  reason: collision with root package name */
    String f24309c = "";

    /* renamed from: e  reason: collision with root package name */
    private ValueCallback<Uri> f24310e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ValueCallback<Uri[]> f24311f;

    /* renamed from: g  reason: collision with root package name */
    private String f24312g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f24313h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f24314i;

    class a extends WebViewClient {
        a() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    public interface b {
        void a();
    }

    public class c extends WebChromeClient {
        public c() {
        }

        public void onHideCustomView() {
            SobotWebViewActivity.f24306d.setVisibility(0);
            SobotWebViewActivity.this.f24313h.setVisibility(8);
            SobotWebViewActivity.this.f24313h.removeAllViews();
            super.onHideCustomView();
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            SobotWebViewActivity.this.f24314i.setText(str);
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            SobotWebViewActivity.f24306d.setVisibility(8);
            SobotWebViewActivity.this.f24313h.setVisibility(0);
            SobotWebViewActivity.this.f24313h.addView(view);
            super.onShowCustomView(view, customViewCallback);
        }

        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            SobotWebViewActivity.this.a((b) new b() {
                public void a() {
                    String[] acceptTypes = fileChooserParams.getAcceptTypes();
                    ValueCallback unused = SobotWebViewActivity.this.f24311f = valueCallback;
                    if (acceptTypes == null || acceptTypes.length == 0) {
                        SobotWebViewActivity.this.a();
                    } else if ("image/*".equals(acceptTypes[0])) {
                        SobotWebViewActivity.this.f();
                    } else {
                        SobotWebViewActivity.this.g();
                    }
                }
            });
            return true;
        }
    }

    private int a(BitmapFactory.Options options, int i2, int i3) {
        int b2 = b(options, i2, i3);
        if (b2 > 8) {
            return ((b2 + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < b2) {
            i4 <<= 1;
        }
        return i4;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i2);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    private Bitmap a(String str, Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return null;
        }
        int width = windowManager.getDefaultDisplay().getWidth();
        options.inSampleSize = a(options, width, windowManager.getDefaultDisplay().getHeight() * width);
        options.inJustDecodeBounds = false;
        return a(BitmapFactory.decodeFile(str, options), a(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r10 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r10 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.net.Uri a(android.content.Intent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            android.content.CursorLoader r8 = new android.content.CursorLoader
            android.content.Context r2 = r9.getApplicationContext()
            android.net.Uri r3 = r10.getData()
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            android.database.Cursor r10 = r8.loadInBackground()
            r1 = 0
            if (r10 != 0) goto L_0x001f
            return r1
        L_0x001f:
            int r0 = r10.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            r10.moveToFirst()     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            if (r0 == 0) goto L_0x003c
            java.lang.String r2 = r9.f24309c     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            java.io.File r0 = com.xeagle.android.sobot.b.a(r0, r2)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            if (r10 == 0) goto L_0x003b
            r10.close()
        L_0x003b:
            return r0
        L_0x003c:
            java.lang.String r0 = "获取图片失败"
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r9, r0, r2)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            r0.show()     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            if (r10 == 0) goto L_0x0056
            goto L_0x0053
        L_0x0049:
            r0 = move-exception
            if (r10 == 0) goto L_0x004f
            r10.close()
        L_0x004f:
            throw r0
        L_0x0050:
            if (r10 == 0) goto L_0x0056
        L_0x0053:
            r10.close()
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.sobot.SobotWebViewActivity.a(android.content.Intent):android.net.Uri");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        f24306d.goBack();
        finish();
    }

    /* access modifiers changed from: private */
    public void a(final b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.CAMERA");
        com.permissionx.guolindev.b.a(this).a(arrayList).a().a((iw.b) new iw.b() {
            public void onExplainReason(iy.c cVar, List<String> list, boolean z2) {
                Log.i("newUI", "onExplainReason: ");
                SobotWebViewActivity sobotWebViewActivity = SobotWebViewActivity.this;
                cVar.a(new s(sobotWebViewActivity, R.style.dialog, sobotWebViewActivity.getString(R.string.permission_title), SobotWebViewActivity.this.getString(R.string.bt_allow), SobotWebViewActivity.this.getString(R.string.bt_deny), list));
            }
        }).a((iw.c) new iw.c() {
            public void onForwardToSettings(d dVar, List<String> list) {
                SobotWebViewActivity sobotWebViewActivity = SobotWebViewActivity.this;
                dVar.a(new s(sobotWebViewActivity, R.style.dialog, sobotWebViewActivity.getString(R.string.permission_forward_title), SobotWebViewActivity.this.getString(R.string.bt_allow), SobotWebViewActivity.this.getString(R.string.bt_deny), list));
            }
        }).a((iw.d) new iw.d() {
            public void onResult(boolean z2, List<String> list, List<String> list2) {
                if (z2) {
                    ToastUtils.showLong((CharSequence) SobotWebViewActivity.this.getString(R.string.permission_all_allow));
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        });
    }

    private int b(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5;
        double d2 = (double) options.outWidth;
        double d3 = (double) options.outHeight;
        if (i3 == -1) {
            i4 = 1;
        } else {
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) i3;
            Double.isNaN(d4);
            i4 = (int) Math.ceil(Math.sqrt((d2 * d3) / d4));
        }
        if (i2 == -1) {
            i5 = 128;
        } else {
            double d5 = (double) i2;
            Double.isNaN(d2);
            Double.isNaN(d5);
            double floor = Math.floor(d2 / d5);
            Double.isNaN(d3);
            Double.isNaN(d5);
            i5 = (int) Math.min(floor, Math.floor(d3 / d5));
        }
        if (i5 < i4) {
            return i4;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? i4 : i5;
    }

    private void d() {
        ValueCallback<Uri> valueCallback = this.f24310e;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Uri.EMPTY);
        }
        ValueCallback<Uri[]> valueCallback2 = this.f24311f;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(new Uri[0]);
        }
        this.f24310e = null;
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            ValueCallback<Uri> valueCallback = this.f24310e;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(Uri.EMPTY);
            }
            ValueCallback<Uri[]> valueCallback2 = this.f24311f;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(new Uri[0]);
            }
            this.f24310e = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Uri uri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        String str = kx.d.t(getApplicationContext()) + "temp/" + System.currentTimeMillis() + ".jpg";
        getSharedPreferences("sobotConfig", 0).edit().putString("sobot_imagePaths", str).apply();
        File file = new File(str);
        file.getParentFile().mkdirs();
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".fileProvider", file);
        } else {
            uri = Uri.fromFile(file);
        }
        this.f24308b = uri;
        intent.putExtra("output", this.f24308b);
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: private */
    public void g() {
        b.a(this.f24309c);
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 2);
    }

    public int a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (b.a()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setItems(new String[]{getString(R.string.take_photo), getString(R.string.tab_album)}, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (i2 == 0) {
                        SobotWebViewActivity.this.f();
                    } else if (i2 == 1) {
                        SobotWebViewActivity.this.g();
                    }
                    SobotWebViewActivity sobotWebViewActivity = SobotWebViewActivity.this;
                    sobotWebViewActivity.f24309c = kx.d.t(SobotWebViewActivity.this.getApplicationContext()) + "compress.jpg";
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    SobotWebViewActivity.this.e();
                }
            });
            builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    SobotWebViewActivity.this.e();
                }
            });
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return (getWindow().getAttributes().flags & 1024) == 1024;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri[] uriArr;
        if (i2 == 1) {
            File file = new File(getSharedPreferences("sobotConfig", 0).getString("sobot_imagePaths", ""));
            if (file.exists()) {
                try {
                    a(file.getAbsolutePath(), getApplicationContext()).compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file.getAbsolutePath()));
                    ValueCallback<Uri> valueCallback = this.f24310e;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(this.f24308b);
                    }
                    ValueCallback<Uri[]> valueCallback2 = this.f24311f;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(new Uri[]{this.f24308b});
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            } else {
                ToastUtils.showLong((CharSequence) getString(R.string.select_image_again));
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                if (this.f24311f == null) {
                    super.onActivityResult(i2, i3, intent);
                    return;
                }
                if (i3 == -1) {
                    if (intent == null) {
                        String str = this.f24307a;
                        if (str != null) {
                            uriArr = new Uri[]{Uri.parse(str)};
                            this.f24311f.onReceiveValue(uriArr);
                            this.f24311f = null;
                            return;
                        }
                    } else {
                        String dataString = intent.getDataString();
                        if (dataString != null) {
                            uriArr = new Uri[]{Uri.parse(dataString)};
                            this.f24311f.onReceiveValue(uriArr);
                            this.f24311f = null;
                            return;
                        }
                    }
                }
                uriArr = null;
                this.f24311f.onReceiveValue(uriArr);
                this.f24311f = null;
                return;
            }
            return;
        } else if (!(intent == null || intent.getData() == null)) {
            ValueCallback<Uri> valueCallback3 = this.f24310e;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(a(intent));
            }
            ValueCallback<Uri[]> valueCallback4 = this.f24311f;
            if (valueCallback4 != null) {
                valueCallback4.onReceiveValue(new Uri[]{a(intent)});
            }
            this.f24310e = null;
            return;
        }
        d();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.sobot_webview_layout);
        if (b()) {
            a.a((Activity) this);
        }
        this.f24313h = (FrameLayout) findViewById(R.id.flVideoContainer);
        this.f24312g = getIntent().getStringExtra("address");
        Log.i("Sobot", "onCreate:====address=== " + this.f24312g);
        f24306d = (WebView) findViewById(R.id.sobot_view);
        this.f24314i = (TextView) findViewById(R.id.tv_title);
        findViewById(R.id.ib_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SobotWebViewActivity.this.a(view);
            }
        });
        f24306d.getSettings().setJavaScriptEnabled(true);
        f24306d.getSettings().setCacheMode(2);
        f24306d.getSettings().setAllowFileAccess(true);
        f24306d.getSettings().setNeedInitialFocus(true);
        f24306d.getSettings().setSupportZoom(true);
        f24306d.getSettings().setBuiltInZoomControls(true);
        f24306d.getSettings().setLoadWithOverviewMode(true);
        f24306d.getSettings().setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT > 11) {
            f24306d.getSettings().setDisplayZoomControls(false);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        f24306d.setWebChromeClient(new c());
        f24306d.setWebViewClient(new a());
        f24306d.loadUrl(this.f24312g);
        f24306d.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(str));
                SobotWebViewActivity.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebView webView = f24306d;
        if (webView != null) {
            webView.removeAllViews();
            f24306d.destroy();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        WebView webView = f24306d;
        if (webView != null) {
            webView.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = f24306d;
        if (webView != null) {
            webView.onResume();
        }
    }
}
