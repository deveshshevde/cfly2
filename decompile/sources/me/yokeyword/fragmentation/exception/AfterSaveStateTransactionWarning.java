package me.yokeyword.fragmentation.exception;

import android.util.Log;

public class AfterSaveStateTransactionWarning extends RuntimeException {
    public AfterSaveStateTransactionWarning(String str) {
        super("Warning: Perform this " + str + " action after onSaveInstanceState!");
        Log.w("Fragmentation", getMessage());
    }
}
