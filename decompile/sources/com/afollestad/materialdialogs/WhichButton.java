package com.afollestad.materialdialogs;

public enum WhichButton {
    POSITIVE(0),
    NEGATIVE(1),
    NEUTRAL(2);
    

    /* renamed from: d  reason: collision with root package name */
    public static final a f7497d = null;

    /* renamed from: f  reason: collision with root package name */
    private final int f7499f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final WhichButton a(int i2) {
            if (i2 == 0) {
                return WhichButton.POSITIVE;
            }
            if (i2 == 1) {
                return WhichButton.NEGATIVE;
            }
            if (i2 == 2) {
                return WhichButton.NEUTRAL;
            }
            throw new IndexOutOfBoundsException(i2 + " is not an action button index.");
        }
    }

    static {
        f7497d = new a((f) null);
    }

    private WhichButton(int i2) {
        this.f7499f = i2;
    }

    public final int a() {
        return this.f7499f;
    }
}
