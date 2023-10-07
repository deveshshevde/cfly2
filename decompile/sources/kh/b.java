package kh;

import android.content.res.Resources;
import android.graphics.Bitmap;

public interface b {

    public static class a implements b {
        public float getAlpha() {
            return 1.0f;
        }

        public float getAnchorU() {
            return 0.0f;
        }

        public float getAnchorV() {
            return 0.0f;
        }

        public Bitmap getIcon(Resources resources) {
            return null;
        }

        public float getInfoWindowAnchorU() {
            return 0.0f;
        }

        public float getInfoWindowAnchorV() {
            return 0.0f;
        }

        public int getInfoWindowOffsetX() {
            return 0;
        }

        public int getInfoWindowOffsetY() {
            return 0;
        }

        public ef.a getPosition() {
            return null;
        }

        public float getRotation() {
            return 0.0f;
        }

        public String getSnippet() {
            return null;
        }

        public String getTitle() {
            return null;
        }

        public boolean isDraggable() {
            return false;
        }

        public boolean isFlat() {
            return false;
        }

        public boolean isVisible() {
            return false;
        }

        public void setPosition(ef.a aVar) {
        }
    }

    float getAlpha();

    float getAnchorU();

    float getAnchorV();

    Bitmap getIcon(Resources resources);

    float getInfoWindowAnchorU();

    float getInfoWindowAnchorV();

    ef.a getPosition();

    float getRotation();

    String getSnippet();

    String getTitle();

    boolean isDraggable();

    boolean isFlat();

    boolean isVisible();

    void setPosition(ef.a aVar);
}
