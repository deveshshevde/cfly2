package av;

import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import kotlin.jvm.internal.h;

public final class a {
    public static final CheckBox a(b bVar) {
        AppCompatCheckBox checkBoxPrompt;
        h.c(bVar, "$this$getCheckBoxPrompt");
        DialogActionButtonLayout buttonsLayout = bVar.b().getButtonsLayout();
        if (buttonsLayout != null && (checkBoxPrompt = buttonsLayout.getCheckBoxPrompt()) != null) {
            return checkBoxPrompt;
        }
        throw new IllegalStateException("The dialog does not have an attached buttons layout.");
    }
}
