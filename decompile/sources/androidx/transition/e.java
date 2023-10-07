package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.v;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

public class e extends v {
    private static boolean a(Transition transition) {
        return !a((List) transition.f()) || !a((List) transition.h()) || !a((List) transition.i());
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    public void a(ViewGroup viewGroup, Object obj) {
        v.a(viewGroup, (Transition) obj);
    }

    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).a((Transition.b) new Transition.b() {
                public Rect a(Transition transition) {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    public void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).a((Transition.b) new Transition.b() {
                public Rect a(Transition transition) {
                    return rect;
                }
            });
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> g2 = transitionSet.g();
        g2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(g2, arrayList.get(i2));
        }
        g2.add(view);
        arrayList.add(view);
        a((Object) transitionSet, arrayList);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).a((Transition.c) new u() {
            public void b(Transition transition) {
                transition.b((Transition.c) this);
            }

            public void e(Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    e.this.b(obj, (ArrayList<View>) arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    e.this.b(obj2, (ArrayList<View>) arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    e.this.b(obj3, (ArrayList<View>) arrayList6, (ArrayList<View>) null);
                }
            }
        });
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int s2 = transitionSet.s();
                while (i2 < s2) {
                    a((Object) transitionSet.b(i2), arrayList);
                    i2++;
                }
            } else if (!a(transition) && a((List) transition.g())) {
                int size = arrayList.size();
                while (i2 < size) {
                    transition.c(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.g().clear();
            transitionSet.g().addAll(arrayList2);
            b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().a(transition).a(transition2).a(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.a(transition);
        }
        transitionSet.a(transition3);
        return transitionSet;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).c(view);
        }
    }

    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).a((Transition.c) new Transition.c() {
            public void a(Transition transition) {
            }

            public void b(Transition transition) {
                transition.b((Transition.c) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList.get(i2)).setVisibility(0);
                }
            }

            public void c(Transition transition) {
            }

            public void d(Transition transition) {
            }

            public void e(Transition transition) {
            }
        });
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int s2 = transitionSet.s();
            while (i2 < s2) {
                b((Object) transitionSet.b(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!a(transition)) {
            List<View> g2 = transition.g();
            if (g2.size() == arrayList.size() && g2.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i2 < size) {
                    transition.c(arrayList2.get(i2));
                    i2++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.d(arrayList.get(size2));
                }
            }
        }
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    public void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }
}
