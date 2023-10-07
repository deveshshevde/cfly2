package com.xeagle.android.login.pickImage.data;

import java.util.List;

public abstract class AbsDataSource {
    public String filePath;
    private OnImagesLoadedListener loadedListener;
    public String type;

    public interface OnImagesLoadedListener {
        void onImagesLoaded(List<ImageFolder> list);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public void onImagesLoaded(List<ImageFolder> list) {
        OnImagesLoadedListener onImagesLoadedListener = this.loadedListener;
        if (onImagesLoadedListener != null) {
            onImagesLoadedListener.onImagesLoaded(list);
        }
    }

    public abstract void reload();

    public abstract void restartLoad();

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setLoadedListener(OnImagesLoadedListener onImagesLoadedListener) {
        this.loadedListener = onImagesLoadedListener;
    }

    public void setType(String str) {
        this.type = str;
    }
}
