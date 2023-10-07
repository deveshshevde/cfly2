package com.xeagle.android.login.pickImage.data;

import androidx.fragment.app.FragmentActivity;
import com.xeagle.android.login.pickImage.data.AbsDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class AllDataSource extends AbsDataSource {
    private CursorDataSource image;
    private final Result result;
    private CursorDataSource video;

    private class Result {
        /* access modifiers changed from: private */
        public AbsDataSource.OnImagesLoadedListener listener1;
        /* access modifiers changed from: private */
        public AbsDataSource.OnImagesLoadedListener listener2;
        /* access modifiers changed from: private */
        public List<ImageFolder> result1;
        /* access modifiers changed from: private */
        public List<ImageFolder> result2;

        Result() {
            this.listener1 = new AbsDataSource.OnImagesLoadedListener(AllDataSource.this) {
                public void onImagesLoaded(List<ImageFolder> list) {
                    Result result = Result.this;
                    if (list == null) {
                        list = Collections.emptyList();
                    }
                    List unused = result.result1 = list;
                    Result.this.check();
                }
            };
            this.listener2 = new AbsDataSource.OnImagesLoadedListener(AllDataSource.this) {
                public void onImagesLoaded(List<ImageFolder> list) {
                    Result result = Result.this;
                    if (list == null) {
                        list = Collections.emptyList();
                    }
                    List unused = result.result2 = list;
                    Result.this.check();
                }
            };
        }

        /* access modifiers changed from: private */
        public void check() {
            if (this.result1 != null && this.result2 != null) {
                ArrayList<ImageFolder> arrayList = new ArrayList<>();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (ImageFolder next : this.result1) {
                    ImageFolder imageFolder = (ImageFolder) linkedHashMap.get(next);
                    if (imageFolder == null) {
                        imageFolder = next.copyPath();
                        linkedHashMap.put(next, imageFolder);
                    }
                    imageFolder.merge(next);
                }
                for (ImageFolder next2 : this.result2) {
                    ImageFolder imageFolder2 = (ImageFolder) linkedHashMap.get(next2);
                    if (imageFolder2 == null) {
                        imageFolder2 = next2.copyPath();
                        linkedHashMap.put(next2, imageFolder2);
                    }
                    imageFolder2.merge(next2);
                }
                arrayList.addAll(linkedHashMap.values());
                for (ImageFolder imageFolder3 : arrayList) {
                    Collections.sort(imageFolder3.images);
                }
                AllDataSource.this.onImagesLoaded(arrayList);
            }
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.result1 = null;
            this.result2 = null;
        }
    }

    AllDataSource(FragmentActivity fragmentActivity, String str) {
        this.image = new ImageDataSource(fragmentActivity, str);
        this.video = new VideoDataSource(fragmentActivity, str);
        Result result2 = new Result();
        this.result = result2;
        this.image.setLoadedListener(result2.listener1);
        this.video.setLoadedListener(result2.listener2);
    }

    public void reload() {
        this.result.reset();
        this.image.reload();
        this.video.reload();
    }

    public void restartLoad() {
        this.result.reset();
        this.image.restartLoad();
        this.video.restartLoad();
    }
}
