package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class UiMessageUtils implements Handler.Callback {
    private static final boolean DEBUG = UtilsBridge.isAppDebug();
    private static final String TAG = "UiMessageUtils";
    private final List<UiMessageCallback> mDefensiveCopyList;
    private final Handler mHandler;
    private final SparseArray<List<UiMessageCallback>> mListenersSpecific;
    private final List<UiMessageCallback> mListenersUniversal;
    private final UiMessage mMessage;

    private static final class LazyHolder {
        /* access modifiers changed from: private */
        public static final UiMessageUtils INSTANCE = new UiMessageUtils();

        private LazyHolder() {
        }
    }

    public static final class UiMessage {
        private Message mMessage;

        private UiMessage(Message message) {
            this.mMessage = message;
        }

        /* access modifiers changed from: private */
        public void setMessage(Message message) {
            this.mMessage = message;
        }

        public int getId() {
            return this.mMessage.what;
        }

        public Object getObject() {
            return this.mMessage.obj;
        }

        public String toString() {
            return "{ id=" + getId() + ", obj=" + getObject() + " }";
        }
    }

    public interface UiMessageCallback {
        void handleMessage(UiMessage uiMessage);
    }

    private UiMessageUtils() {
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mMessage = new UiMessage((Message) null);
        this.mListenersSpecific = new SparseArray<>();
        this.mListenersUniversal = new ArrayList();
        this.mDefensiveCopyList = new ArrayList();
    }

    public static UiMessageUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private void logMessageHandling(UiMessage uiMessage) {
        Objects.requireNonNull(uiMessage, "Argument 'msg' of type UiMessage (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List list = this.mListenersSpecific.get(uiMessage.getId());
        if ((list == null || list.size() == 0) && this.mListenersUniversal.size() == 0) {
            Log.w(TAG, "Delivering FAILED for message ID " + uiMessage.getId() + ". No listeners. " + uiMessage.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Delivering message ID ");
        sb.append(uiMessage.getId());
        sb.append(", Specific listeners: ");
        if (list == null || list.size() == 0) {
            sb.append(0);
        } else {
            sb.append(list.size());
            sb.append(" [");
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(((UiMessageCallback) list.get(i2)).getClass().getSimpleName());
                if (i2 < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        sb.append(", Universal listeners: ");
        synchronized (this.mListenersUniversal) {
            if (this.mListenersUniversal.size() == 0) {
                sb.append(0);
            } else {
                sb.append(this.mListenersUniversal.size());
                sb.append(" [");
                for (int i3 = 0; i3 < this.mListenersUniversal.size(); i3++) {
                    sb.append(this.mListenersUniversal.get(i3).getClass().getSimpleName());
                    if (i3 < this.mListenersUniversal.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("], Message: ");
            }
        }
        sb.append(uiMessage.toString());
        Log.v(TAG, sb.toString());
    }

    public void addListener(int i2, UiMessageCallback uiMessageCallback) {
        Objects.requireNonNull(uiMessageCallback, "Argument 'listener' of type UiMessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.mListenersSpecific) {
            List list = this.mListenersSpecific.get(i2);
            if (list == null) {
                list = new ArrayList();
                this.mListenersSpecific.put(i2, list);
            }
            if (!list.contains(uiMessageCallback)) {
                list.add(uiMessageCallback);
            }
        }
    }

    public void addListener(UiMessageCallback uiMessageCallback) {
        Objects.requireNonNull(uiMessageCallback, "Argument 'listener' of type UiMessageCallback (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.mListenersUniversal) {
            if (!this.mListenersUniversal.contains(uiMessageCallback)) {
                this.mListenersUniversal.add(uiMessageCallback);
            } else if (DEBUG) {
                Log.w(TAG, "Listener is already added. " + uiMessageCallback.toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        this.mMessage.setMessage(message);
        if (DEBUG) {
            logMessageHandling(this.mMessage);
        }
        synchronized (this.mListenersSpecific) {
            List list = this.mListenersSpecific.get(message.what);
            if (list != null) {
                if (list.size() == 0) {
                    this.mListenersSpecific.remove(message.what);
                } else {
                    this.mDefensiveCopyList.addAll(list);
                    for (UiMessageCallback handleMessage : this.mDefensiveCopyList) {
                        handleMessage.handleMessage(this.mMessage);
                    }
                    this.mDefensiveCopyList.clear();
                }
            }
        }
        synchronized (this.mListenersUniversal) {
            if (this.mListenersUniversal.size() > 0) {
                this.mDefensiveCopyList.addAll(this.mListenersUniversal);
                for (UiMessageCallback handleMessage2 : this.mDefensiveCopyList) {
                    handleMessage2.handleMessage(this.mMessage);
                }
                this.mDefensiveCopyList.clear();
            }
        }
        this.mMessage.setMessage((Message) null);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeListener(int r5, com.blankj.utilcode.util.UiMessageUtils.UiMessageCallback r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Argument 'listener' of type UiMessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it"
            java.util.Objects.requireNonNull(r6, r0)
            android.util.SparseArray<java.util.List<com.blankj.utilcode.util.UiMessageUtils$UiMessageCallback>> r0 = r4.mListenersSpecific
            monitor-enter(r0)
            android.util.SparseArray<java.util.List<com.blankj.utilcode.util.UiMessageUtils$UiMessageCallback>> r1 = r4.mListenersSpecific     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x006a }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0046
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x006a }
            if (r2 != 0) goto L_0x0046
            boolean r2 = DEBUG     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0042
            boolean r2 = r1.contains(r6)     // Catch:{ all -> 0x006a }
            if (r2 != 0) goto L_0x0042
            java.lang.String r1 = "UiMessageUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r2.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "Trying to remove specific listener that is not registered. ID "
            r2.append(r3)     // Catch:{ all -> 0x006a }
            r2.append(r5)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = ", "
            r2.append(r5)     // Catch:{ all -> 0x006a }
            r2.append(r6)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x006a }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x006a }
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x0042:
            r1.remove(r6)     // Catch:{ all -> 0x006a }
            goto L_0x0068
        L_0x0046:
            boolean r1 = DEBUG     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = "UiMessageUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r2.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "Trying to remove specific listener that is not registered. ID "
            r2.append(r3)     // Catch:{ all -> 0x006a }
            r2.append(r5)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = ", "
            r2.append(r5)     // Catch:{ all -> 0x006a }
            r2.append(r6)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x006a }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UiMessageUtils.removeListener(int, com.blankj.utilcode.util.UiMessageUtils$UiMessageCallback):void");
    }

    public void removeListener(UiMessageCallback uiMessageCallback) {
        Objects.requireNonNull(uiMessageCallback, "Argument 'listener' of type UiMessageCallback (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.mListenersUniversal) {
            if (DEBUG && !this.mListenersUniversal.contains(uiMessageCallback)) {
                Log.w(TAG, "Trying to remove a listener that is not registered. " + uiMessageCallback.toString());
            }
            this.mListenersUniversal.remove(uiMessageCallback);
        }
    }

    public void removeListeners(int i2) {
        List list;
        if (DEBUG && ((list = this.mListenersSpecific.get(i2)) == null || list.size() == 0)) {
            Log.w(TAG, "Trying to remove specific listeners that are not registered. ID " + i2);
        }
        synchronized (this.mListenersSpecific) {
            this.mListenersSpecific.delete(i2);
        }
    }

    public final void send(int i2) {
        this.mHandler.sendEmptyMessage(i2);
    }

    public final void send(int i2, Object obj) {
        Objects.requireNonNull(obj, "Argument 'obj' of type Object (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i2, obj));
    }
}
