package f;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class i implements Window.Callback {

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f27074b;

    public i(Window.Callback callback) {
        if (callback != null) {
            this.f27074b = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f27074b;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f27074b.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f27074b.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f27074b.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f27074b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f27074b.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f27074b.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f27074b.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f27074b.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f27074b.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f27074b.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f27074b.onCreatePanelMenu(i2, menu);
    }

    public View onCreatePanelView(int i2) {
        return this.f27074b.onCreatePanelView(i2);
    }

    public void onDetachedFromWindow() {
        this.f27074b.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f27074b.onMenuItemSelected(i2, menuItem);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f27074b.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.f27074b.onPanelClosed(i2, menu);
    }

    public void onPointerCaptureChanged(boolean z2) {
        this.f27074b.onPointerCaptureChanged(z2);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f27074b.onPreparePanel(i2, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        this.f27074b.onProvideKeyboardShortcuts(list, menu, i2);
    }

    public boolean onSearchRequested() {
        return this.f27074b.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f27074b.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f27074b.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z2) {
        this.f27074b.onWindowFocusChanged(z2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f27074b.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.f27074b.onWindowStartingActionMode(callback, i2);
    }
}
