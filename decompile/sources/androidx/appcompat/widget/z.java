package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.b;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
import w.c;

class z extends c implements View.OnClickListener {

    /* renamed from: j  reason: collision with root package name */
    private final SearchView f1606j;

    /* renamed from: k  reason: collision with root package name */
    private final SearchableInfo f1607k;

    /* renamed from: l  reason: collision with root package name */
    private final Context f1608l;

    /* renamed from: m  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1609m;

    /* renamed from: n  reason: collision with root package name */
    private final int f1610n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1611o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f1612p = 1;

    /* renamed from: q  reason: collision with root package name */
    private ColorStateList f1613q;

    /* renamed from: r  reason: collision with root package name */
    private int f1614r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f1615s = -1;

    /* renamed from: t  reason: collision with root package name */
    private int f1616t = -1;

    /* renamed from: u  reason: collision with root package name */
    private int f1617u = -1;

    /* renamed from: v  reason: collision with root package name */
    private int f1618v = -1;

    /* renamed from: w  reason: collision with root package name */
    private int f1619w = -1;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1620a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1621b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1622c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1623d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1624e;

        public a(View view) {
            this.f1620a = (TextView) view.findViewById(16908308);
            this.f1621b = (TextView) view.findViewById(16908309);
            this.f1622c = (ImageView) view.findViewById(16908295);
            this.f1623d = (ImageView) view.findViewById(16908296);
            this.f1624e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public z(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1606j = searchView;
        this.f1607k = searchableInfo;
        this.f1610n = searchView.getSuggestionCommitIconResId();
        this.f1608l = context;
        this.f1609m = weakHashMap;
    }

    private Drawable a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1609m.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1609m.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1608l.getResources());
        }
        Drawable b2 = b(componentName);
        if (b2 != null) {
            constantState = b2.getConstantState();
        }
        this.f1609m.put(flattenToShortString, constantState);
        return b2;
    }

    private Drawable a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1608l.getPackageName() + "/" + parseInt;
            Drawable b2 = b(str2);
            if (b2 != null) {
                return b2;
            }
            Drawable a2 = b.a(this.f1608l, parseInt);
            a(str2, a2);
            return a2;
        } catch (NumberFormatException unused) {
            Drawable b3 = b(str);
            if (b3 != null) {
                return b3;
            }
            Drawable b4 = b(Uri.parse(str));
            a(str, b4);
            return b4;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private void a(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1609m.put(str, drawable.getConstantState());
        }
    }

    private Drawable b(ComponentName componentName) {
        String nameNotFoundException;
        PackageManager packageManager = this.f1608l.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            nameNotFoundException = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
            Log.w("SuggestionsAdapter", nameNotFoundException);
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            nameNotFoundException = e2.toString();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable b(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.a((android.net.Uri) r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f1608l     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.b(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable b(String str) {
        Drawable.ConstantState constantState = this.f1609m.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.f1613q == null) {
            TypedValue typedValue = new TypedValue();
            this.f1608l.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f1613q = this.f1608l.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1613q, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable c() {
        Drawable a2 = a(this.f1607k.getSearchActivity());
        return a2 != null ? a2 : this.f1608l.getPackageManager().getDefaultActivityIcon();
    }

    private void d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    private Drawable e(Cursor cursor) {
        int i2 = this.f1617u;
        if (i2 == -1) {
            return null;
        }
        Drawable a2 = a(cursor.getString(i2));
        return a2 != null ? a2 : c();
    }

    private Drawable f(Cursor cursor) {
        int i2 = this.f1618v;
        if (i2 == -1) {
            return null;
        }
        return a(cursor.getString(i2));
    }

    /* access modifiers changed from: package-private */
    public Cursor a(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f1608l.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1606j.getVisibility() == 0 && this.f1606j.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.f1607k, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Drawable a(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1608l.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a2 = super.a(context, cursor, viewGroup);
        a2.setTag(new a(a2));
        ((ImageView) a2.findViewById(R.id.edit_query)).setImageResource(this.f1610n);
        return a2;
    }

    public void a(int i2) {
        this.f1612p = i2;
    }

    public void a(Cursor cursor) {
        if (this.f1611o) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1614r = cursor.getColumnIndex("suggest_text_1");
                this.f1615s = cursor.getColumnIndex("suggest_text_2");
                this.f1616t = cursor.getColumnIndex("suggest_text_2_url");
                this.f1617u = cursor.getColumnIndex("suggest_icon_1");
                this.f1618v = cursor.getColumnIndex("suggest_icon_2");
                this.f1619w = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    public void a(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i2 = this.f1619w;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.f1620a != null) {
            a(aVar.f1620a, (CharSequence) a(cursor, this.f1614r));
        }
        if (aVar.f1621b != null) {
            String a2 = a(cursor, this.f1616t);
            CharSequence b2 = a2 != null ? b((CharSequence) a2) : a(cursor, this.f1615s);
            if (TextUtils.isEmpty(b2)) {
                if (aVar.f1620a != null) {
                    aVar.f1620a.setSingleLine(false);
                    aVar.f1620a.setMaxLines(2);
                }
            } else if (aVar.f1620a != null) {
                aVar.f1620a.setSingleLine(true);
                aVar.f1620a.setMaxLines(1);
            }
            a(aVar.f1621b, b2);
        }
        if (aVar.f1622c != null) {
            a(aVar.f1622c, e(cursor), 4);
        }
        if (aVar.f1623d != null) {
            a(aVar.f1623d, f(cursor), 8);
        }
        int i4 = this.f1612p;
        if (i4 == 2 || (i4 == 1 && (i3 & 1) != 0)) {
            aVar.f1624e.setVisibility(0);
            aVar.f1624e.setTag(aVar.f1620a.getText());
            aVar.f1624e.setOnClickListener(this);
            return;
        }
        aVar.f1624e.setVisibility(8);
    }

    public CharSequence b(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (this.f1607k.shouldRewriteQueryFromData() && (a3 = a(cursor, "suggest_intent_data")) != null) {
            return a3;
        }
        if (!this.f1607k.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a2;
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = b(this.f1608l, a(), viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f1620a.setText(e2.toString());
            }
            return b2;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.f1608l, a(), viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f1620a.setText(e2.toString());
            }
            return a2;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        d(a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        d(a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1606j.a((CharSequence) tag);
        }
    }
}
