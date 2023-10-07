package at;

import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import kotlin.jvm.internal.h;

public final class a {
    public static final DialogActionButton a(b bVar, WhichButton whichButton) {
        DialogActionButton[] actionButtons;
        DialogActionButton dialogActionButton;
        h.c(bVar, "$this$getActionButton");
        h.c(whichButton, "which");
        DialogActionButtonLayout buttonsLayout = bVar.b().getButtonsLayout();
        if (buttonsLayout != null && (actionButtons = buttonsLayout.getActionButtons()) != null && (dialogActionButton = actionButtons[whichButton.a()]) != null) {
            return dialogActionButton;
        }
        throw new IllegalStateException("The dialog does not have an attached buttons layout.");
    }
}
