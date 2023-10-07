package com.xeagle.android.login.pickImage.adapter.vh;

import android.view.View;
import com.xeagle.android.login.pickImage.adapter.ImageSectionAdapter;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.LinkedList;
import java.util.List;

public class SectionModel {
    private final int index;
    private Listener listener;
    private final Shared shared;

    public interface Listener {
        void onChanged();
    }

    public static class Shared {
        /* access modifiers changed from: private */
        public final ImageSectionAdapter.OnImageClickListener clickListener;
        private final List<SectionModel> group = new LinkedList();
        /* access modifiers changed from: private */
        public final List<GLImage> images;
        /* access modifiers changed from: private */
        public final String key;
        /* access modifiers changed from: private */
        public final int offset;

        public Shared(String str, List<GLImage> list, int i2, ImageSectionAdapter.OnImageClickListener onImageClickListener) {
            this.images = list;
            this.key = str;
            this.offset = i2;
            this.clickListener = onImageClickListener;
        }

        /* access modifiers changed from: package-private */
        public void add(SectionModel sectionModel) {
            this.group.add(sectionModel);
        }

        public void changed() {
            for (SectionModel access$400 : this.group) {
                access$400.onChanged();
            }
        }
    }

    private SectionModel(int i2, Shared shared2) {
        this.index = i2;
        this.shared = shared2;
        shared2.add(this);
    }

    public static SectionModel begin(String str, List<GLImage> list, int i2, ImageSectionAdapter.OnImageClickListener onImageClickListener) {
        return new SectionModel(-1, new Shared(str, list, i2, onImageClickListener));
    }

    private int getImagePosition() {
        return this.shared.offset + this.index;
    }

    /* access modifiers changed from: private */
    public void onChanged() {
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onChanged();
        }
    }

    public static SectionModel wrap(int i2, SectionModel sectionModel) {
        return new SectionModel(i2, sectionModel.getShared());
    }

    public GLImage getImage() {
        return (GLImage) this.shared.images.get(this.index);
    }

    public List<GLImage> getImages() {
        return this.shared.images;
    }

    public String getKey() {
        return this.shared.key;
    }

    /* access modifiers changed from: package-private */
    public Shared getShared() {
        return this.shared;
    }

    public void notifyChanged() {
        this.shared.changed();
    }

    public void notifyClicked(View view) {
        if (this.shared.clickListener != null) {
            this.shared.clickListener.onImageItemClick(view, getImage(), getImagePosition());
        }
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }
}
