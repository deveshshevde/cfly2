package org.apache.commons.net.util;

import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListenerList implements Serializable, Iterable<EventListener> {
    private static final long serialVersionUID = -1934227607974228213L;

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<EventListener> f32893a = new CopyOnWriteArrayList<>();

    public int a() {
        return this.f32893a.size();
    }

    public void a(EventListener eventListener) {
        this.f32893a.add(eventListener);
    }

    public Iterator<EventListener> iterator() {
        return this.f32893a.iterator();
    }
}
