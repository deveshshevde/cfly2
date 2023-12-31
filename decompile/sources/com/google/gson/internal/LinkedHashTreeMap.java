package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    Node<K, V>[] table;
    int threshold;

    static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        AvlBuilder() {
        }

        /* access modifiers changed from: package-private */
        public void add(Node<K, V> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int i2 = this.leavesToSkip;
            if (i2 > 0) {
                int i3 = this.size;
                if ((i3 & 1) == 0) {
                    this.size = i3 + 1;
                    this.leavesToSkip = i2 - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            int i4 = this.size + 1;
            this.size = i4;
            int i5 = this.leavesToSkip;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.size = i4 + 1;
                this.leavesToSkip = i5 - 1;
                this.leavesSkipped++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.size & i7) == i7) {
                    int i8 = this.leavesSkipped;
                    if (i8 == 0) {
                        Node<K, V> node2 = this.stack;
                        Node<K, V> node3 = node2.parent;
                        Node<K, V> node4 = node3.parent;
                        node3.parent = node4.parent;
                        this.stack = node3;
                        node3.left = node4;
                        node3.right = node2;
                        node3.height = node2.height + 1;
                        node4.parent = node3;
                        node2.parent = node3;
                    } else {
                        if (i8 == 1) {
                            Node<K, V> node5 = this.stack;
                            Node<K, V> node6 = node5.parent;
                            this.stack = node6;
                            node6.right = node5;
                            node6.height = node5.height + 1;
                            node5.parent = node6;
                        } else if (i8 != 2) {
                        }
                        this.leavesSkipped = 0;
                    }
                    i6 *= 2;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void reset(int i2) {
            this.leavesToSkip = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        /* access modifiers changed from: package-private */
        public Node<K, V> root() {
            Node<K, V> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        AvlIterator() {
        }

        public Node<K, V> next() {
            Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.parent;
            node.parent = null;
            Node<K, V> node3 = node.right;
            while (true) {
                Node<K, V> node4 = node2;
                node2 = node3;
                Node<K, V> node5 = node4;
                if (node2 != null) {
                    node2.parent = node5;
                    node3 = node2.left;
                } else {
                    this.stackTop = node5;
                    return node;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void reset(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (node != null) {
                node.parent = node2;
                node2 = node;
                node = node.left;
            }
            this.stackTop = node2;
        }
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public Map.Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        public boolean remove(Object obj) {
            Node findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public K next() {
                    return nextNode().key;
                }
            };
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned = null;
        Node<K, V> next;

        LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.header.next;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }

        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.header;
        }

        /* access modifiers changed from: package-private */
        public final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            if (node == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedHashTreeMap.this.modCount == this.expectedModCount) {
                this.next = node.next;
                this.lastReturned = node;
                return node;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                LinkedHashTreeMap.this.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static final class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(Node<K, V> node, K k2, int i2, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k2;
            this.hash = i2;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x002e
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.key
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x002e
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x002e
            L_0x001c:
                V r0 = r3.value
                java.lang.Object r4 = r4.getValue()
                if (r0 != 0) goto L_0x0027
                if (r4 != 0) goto L_0x002e
                goto L_0x002d
            L_0x0027:
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x002e
            L_0x002d:
                r1 = 1
            L_0x002e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedHashTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            K k2 = this.key;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v2 = this.value;
            if (v2 != null) {
                i2 = v2.hashCode();
            }
            return hashCode ^ i2;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }

        public V setValue(V v2) {
            V v3 = this.value;
            this.value = v2;
            return v3;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.header = new Node<>();
        Node<K, V>[] nodeArr = new Node[16];
        this.table = nodeArr;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    private void doubleCapacity() {
        Node<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[(length * 2)];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            Node<K, V> node = nodeArr[i2];
            if (node != null) {
                avlIterator.reset(node);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    Node next = avlIterator.next();
                    if (next == null) {
                        break;
                    } else if ((next.hash & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                avlBuilder.reset(i3);
                avlBuilder2.reset(i4);
                avlIterator.reset(node);
                while (true) {
                    Node next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    } else if ((next2.hash & length) == 0) {
                        avlBuilder.add(next2);
                    } else {
                        avlBuilder2.add(next2);
                    }
                }
                Node<K, V> node2 = null;
                nodeArr2[i2] = i3 > 0 ? avlBuilder.root() : null;
                int i5 = i2 + length;
                if (i4 > 0) {
                    node2 = avlBuilder2.root();
                }
                nodeArr2[i5] = node2;
            }
        }
        return nodeArr2;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(Node<K, V> node, boolean z2) {
        while (node != null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            int i2 = 0;
            int i3 = node2 != null ? node2.height : 0;
            int i4 = node3 != null ? node3.height : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                int i6 = node5 != null ? node5.height : 0;
                if (node4 != null) {
                    i2 = node4.height;
                }
                int i7 = i2 - i6;
                if (i7 != -1 && (i7 != 0 || z2)) {
                    rotateRight(node3);
                }
                rotateLeft(node);
                if (z2) {
                    return;
                }
            } else if (i5 == 2) {
                Node<K, V> node6 = node2.left;
                Node<K, V> node7 = node2.right;
                int i8 = node7 != null ? node7.height : 0;
                if (node6 != null) {
                    i2 = node6.height;
                }
                int i9 = i2 - i8;
                if (i9 != 1 && (i9 != 0 || z2)) {
                    rotateLeft(node2);
                }
                rotateRight(node);
                if (z2) {
                    return;
                }
            } else if (i5 == 0) {
                node.height = i3 + 1;
                if (z2) {
                    return;
                }
            } else {
                node.height = Math.max(i3, i4) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            int i2 = node.hash;
            Node<K, V>[] nodeArr = this.table;
            nodeArr[i2 & (nodeArr.length - 1)] = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node3.left;
        Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int i2 = 0;
        node.height = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        int i3 = node.height;
        if (node5 != null) {
            i2 = node5.height;
        }
        node3.height = Math.max(i3, i2) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node2.left;
        Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int i2 = 0;
        node.height = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        int i3 = node.height;
        if (node4 != null) {
            i2 = node4.height;
        }
        node2.height = Math.max(i3, i2) + 1;
    }

    private static int secondaryHash(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        Node<K, V> node2 = node.next;
        while (node2 != node) {
            Node<K, V> node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet entrySet2 = this.entrySet;
        if (entrySet2 != null) {
            return entrySet2;
        }
        LinkedHashTreeMap<K, V>.EntrySet entrySet3 = new EntrySet();
        this.entrySet = entrySet3;
        return entrySet3;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> find(K k2, boolean z2) {
        int i2;
        Node<K, V> node;
        Node<K, V> node2;
        Comparator<? super K> comparator2 = this.comparator;
        Node<K, V>[] nodeArr = this.table;
        int secondaryHash = secondaryHash(k2.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            Comparable comparable = comparator2 == NATURAL_ORDER ? (Comparable) k2 : null;
            while (true) {
                K k3 = node3.key;
                int compareTo = comparable != null ? comparable.compareTo(k3) : comparator2.compare(k2, k3);
                if (compareTo == 0) {
                    return node3;
                }
                Node<K, V> node4 = compareTo < 0 ? node3.left : node3.right;
                if (node4 == null) {
                    node = node3;
                    i2 = compareTo;
                    break;
                }
                node3 = node4;
            }
        } else {
            node = node3;
            i2 = 0;
        }
        if (!z2) {
            return null;
        }
        Node<K, V> node5 = this.header;
        if (node != null) {
            node2 = new Node<>(node, k2, secondaryHash, node5, node5.prev);
            if (i2 < 0) {
                node.left = node2;
            } else {
                node.right = node2;
            }
            rebalance(node, true);
        } else if (comparator2 != NATURAL_ORDER || (k2 instanceof Comparable)) {
            node2 = new Node<>(node, k2, secondaryHash, node5, node5.prev);
            nodeArr[length] = node2;
        } else {
            throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return node2;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.value, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet keySet2 = this.keySet;
        if (keySet2 != null) {
            return keySet2;
        }
        LinkedHashTreeMap<K, V>.KeySet keySet3 = new KeySet();
        this.keySet = keySet3;
        return keySet3;
    }

    public V put(K k2, V v2) {
        Objects.requireNonNull(k2, "key == null");
        Node find = find(k2, true);
        V v3 = find.value;
        find.value = v2;
        return v3;
    }

    public V remove(Object obj) {
        Node removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void removeInternal(Node<K, V> node, boolean z2) {
        int i2;
        if (z2) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node.parent;
        int i3 = 0;
        if (node2 == null || node3 == null) {
            if (node2 != null) {
                replaceInParent(node, node2);
                node.left = null;
            } else if (node3 != null) {
                replaceInParent(node, node3);
                node.right = null;
            } else {
                replaceInParent(node, (Node<K, V>) null);
            }
            rebalance(node4, false);
            this.size--;
            this.modCount++;
            return;
        }
        Node<K, V> last = node2.height > node3.height ? node2.last() : node3.first();
        removeInternal(last, false);
        Node<K, V> node5 = node.left;
        if (node5 != null) {
            i2 = node5.height;
            last.left = node5;
            node5.parent = last;
            node.left = null;
        } else {
            i2 = 0;
        }
        Node<K, V> node6 = node.right;
        if (node6 != null) {
            i3 = node6.height;
            last.right = node6;
            node6.parent = last;
            node.right = null;
        }
        last.height = Math.max(i2, i3) + 1;
        replaceInParent(node, last);
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> removeInternalByKey(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }
}
