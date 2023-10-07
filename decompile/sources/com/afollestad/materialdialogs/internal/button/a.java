package com.afollestad.materialdialogs.internal.button;

import ay.f;

public final class a {
    public static final boolean a(DialogActionButtonLayout dialogActionButtonLayout) {
        if (dialogActionButtonLayout == null) {
            return false;
        }
        return ((dialogActionButtonLayout.getVisibleButtons().length == 0) ^ true) || f.a(dialogActionButtonLayout.getCheckBoxPrompt());
    }
}
