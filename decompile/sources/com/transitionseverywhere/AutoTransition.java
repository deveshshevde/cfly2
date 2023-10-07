package com.transitionseverywhere;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        n();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
    }

    private void n() {
        a(1);
        b((Transition) new Fade(2)).b((Transition) new ChangeBounds()).b((Transition) new Fade(1));
    }
}
