package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.widget.w;
import m.a;

public final class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final PorterDuff.Mode f1488a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static f f1489b;

    /* renamed from: c  reason: collision with root package name */
    private w f1490c;

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (f.class) {
            a2 = w.a(i2, mode);
        }
        return a2;
    }

    public static synchronized void a() {
        synchronized (f.class) {
            if (f1489b == null) {
                f fVar = new f();
                f1489b = fVar;
                fVar.f1490c = w.a();
                f1489b.f1490c.a((w.f) new w.f() {

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f1491a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f1492b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f1493c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f1494d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f1495e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

                    /* renamed from: f  reason: collision with root package name */
                    private final int[] f1496f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                    private ColorStateList a(Context context) {
                        return b(context, aa.a(context, R.attr.colorButtonNormal));
                    }

                    private void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
                        if (q.c(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = f.f1488a;
                        }
                        drawable.setColorFilter(f.a(i2, mode));
                    }

                    private boolean a(int[] iArr, int i2) {
                        for (int i3 : iArr) {
                            if (i3 == i2) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList b(Context context) {
                        return b(context, 0);
                    }

                    private ColorStateList b(Context context, int i2) {
                        int a2 = aa.a(context, R.attr.colorControlHighlight);
                        int c2 = aa.c(context, R.attr.colorButtonNormal);
                        return new ColorStateList(new int[][]{aa.f1386a, aa.f1389d, aa.f1387b, aa.f1393h}, new int[]{c2, a.a(a2, i2), a.a(a2, i2), i2});
                    }

                    private LayerDrawable b(w wVar, Context context, int i2) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
                        Drawable a2 = wVar.a(context, R.drawable.abc_star_black_48dp);
                        Drawable a3 = wVar.a(context, R.drawable.abc_star_half_black_48dp);
                        if ((a2 instanceof BitmapDrawable) && a2.getIntrinsicWidth() == dimensionPixelSize && a2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable2 = (BitmapDrawable) a2;
                            bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            a2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            a2.draw(canvas);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
                        if ((a3 instanceof BitmapDrawable) && a3.getIntrinsicWidth() == dimensionPixelSize && a3.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) a3;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            a3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            a3.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    private ColorStateList c(Context context) {
                        return b(context, aa.a(context, R.attr.colorAccent));
                    }

                    private ColorStateList d(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList b2 = aa.b(context, R.attr.colorSwitchThumbNormal);
                        if (b2 == null || !b2.isStateful()) {
                            iArr[0] = aa.f1386a;
                            iArr2[0] = aa.c(context, R.attr.colorSwitchThumbNormal);
                            iArr[1] = aa.f1390e;
                            iArr2[1] = aa.a(context, R.attr.colorControlActivated);
                            iArr[2] = aa.f1393h;
                            iArr2[2] = aa.a(context, R.attr.colorSwitchThumbNormal);
                        } else {
                            iArr[0] = aa.f1386a;
                            iArr2[0] = b2.getColorForState(iArr[0], 0);
                            iArr[1] = aa.f1390e;
                            iArr2[1] = aa.a(context, R.attr.colorControlActivated);
                            iArr[2] = aa.f1393h;
                            iArr2[2] = b2.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    public ColorStateList a(Context context, int i2) {
                        if (i2 == R.drawable.abc_edit_text_material) {
                            return c.a.a(context, R.color.abc_tint_edittext);
                        }
                        if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
                            return c.a.a(context, R.color.abc_tint_switch_track);
                        }
                        if (i2 == R.drawable.abc_switch_thumb_material) {
                            return d(context);
                        }
                        if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                            return a(context);
                        }
                        if (i2 == R.drawable.abc_btn_borderless_material) {
                            return b(context);
                        }
                        if (i2 == R.drawable.abc_btn_colored_material) {
                            return c(context);
                        }
                        if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                            return c.a.a(context, R.color.abc_tint_spinner);
                        }
                        if (a(this.f1492b, i2)) {
                            return aa.b(context, R.attr.colorControlNormal);
                        }
                        if (a(this.f1495e, i2)) {
                            return c.a.a(context, R.color.abc_tint_default);
                        }
                        if (a(this.f1496f, i2)) {
                            return c.a.a(context, R.color.abc_tint_btn_checkable);
                        }
                        if (i2 == R.drawable.abc_seekbar_thumb_material) {
                            return c.a.a(context, R.color.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    public PorterDuff.Mode a(int i2) {
                        if (i2 == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    public Drawable a(w wVar, Context context, int i2) {
                        int i3;
                        if (i2 == R.drawable.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{wVar.a(context, R.drawable.abc_cab_background_internal_bg), wVar.a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                        }
                        if (i2 == R.drawable.abc_ratingbar_material) {
                            i3 = R.dimen.abc_star_big;
                        } else if (i2 == R.drawable.abc_ratingbar_indicator_material) {
                            i3 = R.dimen.abc_star_medium;
                        } else if (i2 != R.drawable.abc_ratingbar_small_material) {
                            return null;
                        } else {
                            i3 = R.dimen.abc_star_small;
                        }
                        return b(wVar, context, i3);
                    }

                    public boolean a(Context context, int i2, Drawable drawable) {
                        LayerDrawable layerDrawable;
                        Drawable findDrawableByLayerId;
                        int i3;
                        if (i2 == R.drawable.abc_seekbar_track_material) {
                            layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(16908288), aa.a(context, R.attr.colorControlNormal), f.f1488a);
                            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                            i3 = R.attr.colorControlNormal;
                        } else if (i2 != R.drawable.abc_ratingbar_material && i2 != R.drawable.abc_ratingbar_indicator_material && i2 != R.drawable.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(16908288), aa.c(context, R.attr.colorControlNormal), f.f1488a);
                            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                            i3 = R.attr.colorControlActivated;
                        }
                        a(findDrawableByLayerId, aa.a(context, i3), f.f1488a);
                        a(layerDrawable.findDrawableByLayerId(16908301), aa.a(context, R.attr.colorControlActivated), f.f1488a);
                        return true;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.f.f1488a
                            int[] r1 = r6.f1491a
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0017
                            int r2 = androidx.appcompat.R.attr.colorControlNormal
                        L_0x0014:
                            r8 = -1
                        L_0x0015:
                            r1 = 1
                            goto L_0x0044
                        L_0x0017:
                            int[] r1 = r6.f1493c
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x0022
                            int r2 = androidx.appcompat.R.attr.colorControlActivated
                            goto L_0x0014
                        L_0x0022:
                            int[] r1 = r6.f1494d
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x002d
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L_0x0014
                        L_0x002d:
                            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                            if (r8 != r1) goto L_0x003c
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            goto L_0x0015
                        L_0x003c:
                            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                            if (r8 != r1) goto L_0x0041
                            goto L_0x0014
                        L_0x0041:
                            r8 = -1
                            r1 = 0
                            r2 = 0
                        L_0x0044:
                            if (r1 == 0) goto L_0x0061
                            boolean r1 = androidx.appcompat.widget.q.c(r9)
                            if (r1 == 0) goto L_0x0050
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x0050:
                            int r7 = androidx.appcompat.widget.aa.a((android.content.Context) r7, (int) r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.f.a((int) r7, (android.graphics.PorterDuff.Mode) r0)
                            r9.setColorFilter(r7)
                            if (r8 == r3) goto L_0x0060
                            r9.setAlpha(r8)
                        L_0x0060:
                            return r5
                        L_0x0061:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f.AnonymousClass1.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }
                });
            }
        }
    }

    static void a(Drawable drawable, ad adVar, int[] iArr) {
        w.a(drawable, adVar, iArr);
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f1489b == null) {
                a();
            }
            fVar = f1489b;
        }
        return fVar;
    }

    public synchronized Drawable a(Context context, int i2) {
        return this.f1490c.a(context, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i2, boolean z2) {
        return this.f1490c.a(context, i2, z2);
    }

    public synchronized void a(Context context) {
        this.f1490c.a(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i2) {
        return this.f1490c.b(context, i2);
    }
}
