package com.xeagle.android.login.pickImage.data;

import ac.a;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.content.b;
import androidx.loader.content.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;

public abstract class CursorDataSource extends AbsDataSource implements a.C0001a<Cursor> {
    private static final int LOADER_ALL = 0;
    private static final int LOADER_CATEGORY = 1;
    private FragmentActivity activity;
    private ArrayList<ImageFolder> imageFolders = new ArrayList<>();
    /* access modifiers changed from: private */
    public final c loader;
    private a loaderManager;

    CursorDataSource(FragmentActivity fragmentActivity, String str) {
        c cVar;
        this.activity = fragmentActivity;
        a supportLoaderManager = fragmentActivity.getSupportLoaderManager();
        this.loaderManager = supportLoaderManager;
        if (str == null) {
            cVar = supportLoaderManager.a(getId(0), (Bundle) null, this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(GLImage.KEY_PATH, str);
            cVar = this.loaderManager.a(getId(1), bundle, this);
        }
        this.loader = cVar;
    }

    private void parserData(Cursor cursor) {
        ArrayList<GLImage> arrayList = new ArrayList<>();
        parserRealData(cursor, arrayList, this.imageFolders);
        if (cursor.getCount() > 0) {
            ImageFolder imageFolder = new ImageFolder();
            imageFolder.name = this.activity.getResources().getString(R.string.all_images);
            imageFolder.path = "/";
            imageFolder.cover = arrayList.size() > 0 ? arrayList.get(0) : GLImage.Builder.newBuilder().build();
            imageFolder.images = arrayList;
            this.imageFolders.add(0, imageFolder);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getBaseId();

    /* access modifiers changed from: protected */
    public int getId(int i2) {
        return getBaseId() + i2;
    }

    /* access modifiers changed from: protected */
    public abstract Uri getMediaStoreUri();

    /* access modifiers changed from: protected */
    public abstract String[] getProjection();

    /* access modifiers changed from: protected */
    public abstract String getSelection();

    /* access modifiers changed from: protected */
    public abstract String[] getSelectionArgs();

    public boolean manuallyControlLoader() {
        return false;
    }

    public c<Cursor> onCreateLoader(int i2, Bundle bundle) {
        return new b(this.activity, getMediaStoreUri(), getProjection(), getSelection(), getSelectionArgs(), "date_added DESC");
    }

    public void onLoadFinished(c<Cursor> cVar, Cursor cursor) {
        this.imageFolders.clear();
        if (cursor != null) {
            parserData(cursor);
        }
        onImagesLoaded(this.imageFolders);
        if (manuallyControlLoader()) {
            cVar.t();
        }
    }

    public void onLoaderReset(c<Cursor> cVar) {
        System.out.println("--------");
    }

    /* access modifiers changed from: protected */
    public abstract void parserRealData(Cursor cursor, ArrayList<GLImage> arrayList, ArrayList<ImageFolder> arrayList2);

    public void reload() {
        if (manuallyControlLoader()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    CursorDataSource.this.loader.q();
                    CursorDataSource.this.loader.s();
                }
            }, 1000);
        }
    }

    public void restartLoad() {
        c cVar = this.loader;
        if (cVar != null) {
            cVar.w();
            this.loader.q();
        }
    }
}
