package ci;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ci.b;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class a<T, K extends b> extends RecyclerView.Adapter<K> {
    public static final int ALPHAIN = 1;
    public static final int EMPTY_VIEW = 1365;
    public static final int FOOTER_VIEW = 819;
    public static final int HEADER_VIEW = 273;
    public static final int LOADING_VIEW = 546;
    public static final int SCALEIN = 2;
    public static final int SLIDEIN_BOTTOM = 3;
    public static final int SLIDEIN_LEFT = 4;
    public static final int SLIDEIN_RIGHT = 5;
    protected static final String TAG = "a";
    private boolean footerViewAsFlow;
    private boolean headerViewAsFlow;
    protected Context mContext;
    private cj.b mCustomAnimation;
    protected List<T> mData;
    private int mDuration;
    private FrameLayout mEmptyLayout;
    /* access modifiers changed from: private */
    public boolean mEnableLoadMoreEndClick;
    private boolean mFirstOnlyEnable;
    private boolean mFootAndEmptyEnable;
    private LinearLayout mFooterLayout;
    private boolean mHeadAndEmptyEnable;
    private LinearLayout mHeaderLayout;
    private Interpolator mInterpolator;
    private boolean mIsUseEmpty;
    private int mLastPosition;
    protected LayoutInflater mLayoutInflater;
    protected int mLayoutResId;
    private boolean mLoadMoreEnable;
    /* access modifiers changed from: private */
    public cl.a mLoadMoreView;
    private boolean mLoading;
    private cm.a<T> mMultiTypeDelegate;
    private boolean mNextLoadEnable;
    private C0069a mOnItemChildClickListener;
    private b mOnItemChildLongClickListener;
    private c mOnItemClickListener;
    private d mOnItemLongClickListener;
    private boolean mOpenAnimationEnable;
    private int mPreLoadNumber;
    private RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public e mRequestLoadMoreListener;
    private cj.b mSelectAnimation;
    /* access modifiers changed from: private */
    public f mSpanSizeLookup;
    private int mStartUpFetchPosition;
    private boolean mUpFetchEnable;
    private g mUpFetchListener;
    private boolean mUpFetching;

    /* renamed from: ci.a$a  reason: collision with other inner class name */
    public interface C0069a {
        void a(a aVar, View view, int i2);
    }

    public interface b {
        boolean a(a aVar, View view, int i2);
    }

    public interface c {
        void onItemClick(a aVar, View view, int i2);
    }

    public interface d {
        boolean a(a aVar, View view, int i2);
    }

    public interface e {
        void a();
    }

    public interface f {
        int a(GridLayoutManager gridLayoutManager, int i2);
    }

    public interface g {
        void a();
    }

    public a(int i2) {
        this(i2, (List) null);
    }

    public a(int i2, List<T> list) {
        this.mNextLoadEnable = false;
        this.mLoadMoreEnable = false;
        this.mLoading = false;
        this.mLoadMoreView = new cl.b();
        this.mEnableLoadMoreEndClick = false;
        this.mFirstOnlyEnable = true;
        this.mOpenAnimationEnable = false;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = 300;
        this.mLastPosition = -1;
        this.mSelectAnimation = new cj.a();
        this.mIsUseEmpty = true;
        this.mStartUpFetchPosition = 1;
        this.mPreLoadNumber = 1;
        this.mData = list == null ? new ArrayList<>() : list;
        if (i2 != 0) {
            this.mLayoutResId = i2;
        }
    }

    public a(List<T> list) {
        this(0, list);
    }

    private void addAnimation(RecyclerView.v vVar) {
        if (!this.mOpenAnimationEnable) {
            return;
        }
        if (!this.mFirstOnlyEnable || vVar.getLayoutPosition() > this.mLastPosition) {
            cj.b bVar = this.mCustomAnimation;
            if (bVar == null) {
                bVar = this.mSelectAnimation;
            }
            for (Animator startAnim : bVar.a(vVar.itemView)) {
                startAnim(startAnim, vVar.getLayoutPosition());
            }
            this.mLastPosition = vVar.getLayoutPosition();
        }
    }

    private void autoLoadMore(int i2) {
        if (getLoadMoreViewCount() != 0 && i2 >= getItemCount() - this.mPreLoadNumber && this.mLoadMoreView.a() == 1) {
            this.mLoadMoreView.a(2);
            if (!this.mLoading) {
                this.mLoading = true;
                if (getRecyclerView() != null) {
                    getRecyclerView().post(new Runnable() {
                        public void run() {
                            a.this.mRequestLoadMoreListener.a();
                        }
                    });
                } else {
                    this.mRequestLoadMoreListener.a();
                }
            }
        }
    }

    private void autoUpFetch(int i2) {
        g gVar;
        if (isUpFetchEnable() && !isUpFetching() && i2 <= this.mStartUpFetchPosition && (gVar = this.mUpFetchListener) != null) {
            gVar.a();
        }
    }

    private void bindViewClickListener(final b bVar) {
        View view;
        if (bVar != null && (view = bVar.itemView) != null) {
            if (getOnItemClickListener() != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        a.this.getOnItemClickListener().onItemClick(a.this, view, bVar.getLayoutPosition() - a.this.getHeaderLayoutCount());
                    }
                });
            }
            if (getOnItemLongClickListener() != null) {
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        return a.this.getOnItemLongClickListener().a(a.this, view, bVar.getLayoutPosition() - a.this.getHeaderLayoutCount());
                    }
                });
            }
        }
    }

    private void checkNotNull() {
        if (getRecyclerView() == null) {
            throw new RuntimeException("please bind recyclerView first!");
        }
    }

    private void compatibilityDataSizeChanged(int i2) {
        List<T> list = this.mData;
        if ((list == null ? 0 : list.size()) == i2) {
            notifyDataSetChanged();
        }
    }

    private K createGenericKInstance(Class cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{View.class});
                declaredConstructor.setAccessible(true);
                return (b) declaredConstructor.newInstance(new Object[]{view});
            }
            Constructor declaredConstructor2 = cls.getDeclaredConstructor(new Class[]{getClass(), View.class});
            declaredConstructor2.setAccessible(true);
            return (b) declaredConstructor2.newInstance(new Object[]{this, view});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private ck.a getExpandableItem(int i2) {
        Object item = getItem(i2);
        if (isExpandable(item)) {
            return (ck.a) item;
        }
        return null;
    }

    private int getFooterViewPosition() {
        int i2 = 1;
        if (getEmptyViewCount() != 1) {
            return getHeaderLayoutCount() + this.mData.size();
        }
        if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
            i2 = 2;
        }
        if (this.mFootAndEmptyEnable) {
            return i2;
        }
        return -1;
    }

    private int getHeaderViewPosition() {
        return (getEmptyViewCount() != 1 || this.mHeadAndEmptyEnable) ? 0 : -1;
    }

    private Class getInstancedGenericKClass(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (b.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            }
        }
        return null;
    }

    private int getItemPosition(T t2) {
        List<T> list;
        if (t2 == null || (list = this.mData) == null || list.isEmpty()) {
            return -1;
        }
        return this.mData.indexOf(t2);
    }

    private K getLoadingView(ViewGroup viewGroup) {
        K createBaseViewHolder = createBaseViewHolder(getItemView(this.mLoadMoreView.c(), viewGroup));
        createBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.mLoadMoreView.a() == 3) {
                    a.this.notifyLoadMoreToLoading();
                }
                if (a.this.mEnableLoadMoreEndClick && a.this.mLoadMoreView.a() == 4) {
                    a.this.notifyLoadMoreToLoading();
                }
            }
        });
        return createBaseViewHolder;
    }

    /* access modifiers changed from: private */
    public int getTheBiggestNumber(int[] iArr) {
        int i2 = -1;
        if (!(iArr == null || iArr.length == 0)) {
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasSubItems(ck.a r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.List r2 = r2.b()
            if (r2 == 0) goto L_0x0011
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0011
            r0 = 1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ci.a.hasSubItems(ck.a):boolean");
    }

    private void openLoadMore(e eVar) {
        this.mRequestLoadMoreListener = eVar;
        this.mNextLoadEnable = true;
        this.mLoadMoreEnable = true;
        this.mLoading = false;
    }

    private int recursiveCollapse(int i2) {
        Object item = getItem(i2);
        int i3 = 0;
        if (!isExpandable(item)) {
            return 0;
        }
        ck.a aVar = (ck.a) item;
        if (aVar.a()) {
            List b2 = aVar.b();
            for (int size = b2.size() - 1; size >= 0; size--) {
                Object obj = b2.get(size);
                int itemPosition = getItemPosition(obj);
                if (itemPosition >= 0) {
                    if (obj instanceof ck.a) {
                        i3 += recursiveCollapse(itemPosition);
                    }
                    this.mData.remove(itemPosition);
                    i3++;
                }
            }
        }
        return i3;
    }

    private int recursiveExpand(int i2, List list) {
        int size = (i2 + list.size()) - 1;
        int size2 = list.size() - 1;
        int i3 = 0;
        while (size2 >= 0) {
            if (list.get(size2) instanceof ck.a) {
                ck.a aVar = (ck.a) list.get(size2);
                if (aVar.a() && hasSubItems(aVar)) {
                    List b2 = aVar.b();
                    int i4 = size + 1;
                    this.mData.addAll(i4, b2);
                    i3 += recursiveExpand(i4, b2);
                }
            }
            size2--;
            size--;
        }
        return i3;
    }

    private void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Deprecated
    public void add(int i2, T t2) {
        addData(i2, t2);
    }

    public void addData(int i2, T t2) {
        this.mData.add(i2, t2);
        notifyItemInserted(i2 + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(int i2, Collection<? extends T> collection) {
        this.mData.addAll(i2, collection);
        notifyItemRangeInserted(i2 + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public void addData(T t2) {
        this.mData.add(t2);
        notifyItemInserted(this.mData.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(Collection<? extends T> collection) {
        this.mData.addAll(collection);
        notifyItemRangeInserted((this.mData.size() - collection.size()) + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public int addFooterView(View view) {
        return addFooterView(view, -1, 1);
    }

    public int addFooterView(View view, int i2) {
        return addFooterView(view, i2, 1);
    }

    public int addFooterView(View view, int i2, int i3) {
        int footerViewPosition;
        LinearLayout linearLayout;
        RecyclerView.LayoutParams layoutParams;
        if (this.mFooterLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.mFooterLayout = linearLayout2;
            if (i3 == 1) {
                linearLayout2.setOrientation(1);
                linearLayout = this.mFooterLayout;
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                linearLayout2.setOrientation(0);
                linearLayout = this.mFooterLayout;
                layoutParams = new RecyclerView.LayoutParams(-2, -1);
            }
            linearLayout.setLayoutParams(layoutParams);
        }
        int childCount = this.mFooterLayout.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.mFooterLayout.addView(view, i2);
        if (this.mFooterLayout.getChildCount() == 1 && (footerViewPosition = getFooterViewPosition()) != -1) {
            notifyItemInserted(footerViewPosition);
        }
        return i2;
    }

    public int addHeaderView(View view) {
        return addHeaderView(view, -1);
    }

    public int addHeaderView(View view, int i2) {
        return addHeaderView(view, i2, 1);
    }

    public int addHeaderView(View view, int i2, int i3) {
        int headerViewPosition;
        LinearLayout linearLayout;
        RecyclerView.LayoutParams layoutParams;
        if (this.mHeaderLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.mHeaderLayout = linearLayout2;
            if (i3 == 1) {
                linearLayout2.setOrientation(1);
                linearLayout = this.mHeaderLayout;
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                linearLayout2.setOrientation(0);
                linearLayout = this.mHeaderLayout;
                layoutParams = new RecyclerView.LayoutParams(-2, -1);
            }
            linearLayout.setLayoutParams(layoutParams);
        }
        int childCount = this.mHeaderLayout.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.mHeaderLayout.addView(view, i2);
        if (this.mHeaderLayout.getChildCount() == 1 && (headerViewPosition = getHeaderViewPosition()) != -1) {
            notifyItemInserted(headerViewPosition);
        }
        return i2;
    }

    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() == null) {
            setRecyclerView(recyclerView);
            getRecyclerView().setAdapter(this);
            return;
        }
        throw new RuntimeException("Don't bind twice");
    }

    public int collapse(int i2) {
        return collapse(i2, true, true);
    }

    public int collapse(int i2, boolean z2) {
        return collapse(i2, z2, true);
    }

    public int collapse(int i2, boolean z2, boolean z3) {
        int headerLayoutCount = i2 - getHeaderLayoutCount();
        ck.a expandableItem = getExpandableItem(headerLayoutCount);
        if (expandableItem == null) {
            return 0;
        }
        int recursiveCollapse = recursiveCollapse(headerLayoutCount);
        expandableItem.a(false);
        int headerLayoutCount2 = headerLayoutCount + getHeaderLayoutCount();
        if (z3) {
            if (z2) {
                notifyItemChanged(headerLayoutCount2);
                notifyItemRangeRemoved(headerLayoutCount2 + 1, recursiveCollapse);
            } else {
                notifyDataSetChanged();
            }
        }
        return recursiveCollapse;
    }

    /* access modifiers changed from: protected */
    public abstract void convert(K k2, T t2);

    /* access modifiers changed from: protected */
    public K createBaseViewHolder(View view) {
        Class cls = getClass();
        Class cls2 = null;
        while (cls2 == null && cls != null) {
            cls2 = getInstancedGenericKClass(cls);
            cls = cls.getSuperclass();
        }
        K bVar = cls2 == null ? new b(view) : createGenericKInstance(cls2, view);
        return bVar != null ? bVar : new b(view);
    }

    /* access modifiers changed from: protected */
    public K createBaseViewHolder(ViewGroup viewGroup, int i2) {
        return createBaseViewHolder(getItemView(i2, viewGroup));
    }

    public void disableLoadMoreIfNotFullPage() {
        checkNotNull();
        disableLoadMoreIfNotFullPage(getRecyclerView());
    }

    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView) {
        RecyclerView.h layoutManager;
        Runnable r1;
        setEnableLoadMore(false);
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            if (layoutManager instanceof LinearLayoutManager) {
                final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                r1 = new Runnable() {
                    public void run() {
                        if (linearLayoutManager.r() + 1 != a.this.getItemCount()) {
                            a.this.setEnableLoadMore(true);
                        }
                    }
                };
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                final StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                r1 = new Runnable() {
                    public void run() {
                        int[] iArr = new int[staggeredGridLayoutManager.i()];
                        staggeredGridLayoutManager.a(iArr);
                        if (a.this.getTheBiggestNumber(iArr) + 1 != a.this.getItemCount()) {
                            a.this.setEnableLoadMore(true);
                        }
                    }
                };
            } else {
                return;
            }
            recyclerView.postDelayed(r1, 50);
        }
    }

    public void enableLoadMoreEndClick(boolean z2) {
        this.mEnableLoadMoreEndClick = z2;
    }

    public int expand(int i2) {
        return expand(i2, true, true);
    }

    public int expand(int i2, boolean z2) {
        return expand(i2, z2, true);
    }

    public int expand(int i2, boolean z2, boolean z3) {
        int headerLayoutCount = i2 - getHeaderLayoutCount();
        ck.a expandableItem = getExpandableItem(headerLayoutCount);
        int i3 = 0;
        if (expandableItem == null) {
            return 0;
        }
        if (!hasSubItems(expandableItem)) {
            expandableItem.a(false);
            return 0;
        }
        if (!expandableItem.a()) {
            List b2 = expandableItem.b();
            int i4 = headerLayoutCount + 1;
            this.mData.addAll(i4, b2);
            expandableItem.a(true);
            i3 = recursiveExpand(i4, b2) + 0 + b2.size();
        }
        int headerLayoutCount2 = headerLayoutCount + getHeaderLayoutCount();
        if (z3) {
            if (z2) {
                notifyItemChanged(headerLayoutCount2);
                notifyItemRangeInserted(headerLayoutCount2 + 1, i3);
            } else {
                notifyDataSetChanged();
            }
        }
        return i3;
    }

    public int expandAll(int i2, boolean z2) {
        return expandAll(i2, true, !z2);
    }

    public int expandAll(int i2, boolean z2, boolean z3) {
        Object item;
        int headerLayoutCount = i2 - getHeaderLayoutCount();
        int i3 = headerLayoutCount + 1;
        Object item2 = i3 < this.mData.size() ? getItem(i3) : null;
        ck.a expandableItem = getExpandableItem(headerLayoutCount);
        if (expandableItem == null || !hasSubItems(expandableItem)) {
            return 0;
        }
        int expand = expand(getHeaderLayoutCount() + headerLayoutCount, false, false);
        while (i3 < this.mData.size() && (item = getItem(i3)) != item2) {
            if (isExpandable(item)) {
                expand += expand(getHeaderLayoutCount() + i3, false, false);
            }
            i3++;
        }
        if (z3) {
            if (z2) {
                notifyItemRangeInserted(headerLayoutCount + getHeaderLayoutCount() + 1, expand);
            } else {
                notifyDataSetChanged();
            }
        }
        return expand;
    }

    public void expandAll() {
        for (int size = (this.mData.size() - 1) + getHeaderLayoutCount(); size >= getHeaderLayoutCount(); size--) {
            expandAll(size, false, false);
        }
    }

    public List<T> getData() {
        return this.mData;
    }

    /* access modifiers changed from: protected */
    public int getDefItemViewType(int i2) {
        cm.a<T> aVar = this.mMultiTypeDelegate;
        return aVar != null ? aVar.a(this.mData, i2) : super.getItemViewType(i2);
    }

    public View getEmptyView() {
        return this.mEmptyLayout;
    }

    public int getEmptyViewCount() {
        FrameLayout frameLayout = this.mEmptyLayout;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.mIsUseEmpty || this.mData.size() != 0) ? 0 : 1;
    }

    public LinearLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    public int getFooterLayoutCount() {
        LinearLayout linearLayout = this.mFooterLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Deprecated
    public int getFooterViewsCount() {
        return getFooterLayoutCount();
    }

    public LinearLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    public int getHeaderLayoutCount() {
        LinearLayout linearLayout = this.mHeaderLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Deprecated
    public int getHeaderViewsCount() {
        return getHeaderLayoutCount();
    }

    public T getItem(int i2) {
        if (i2 < this.mData.size()) {
            return this.mData.get(i2);
        }
        return null;
    }

    public int getItemCount() {
        int i2 = 1;
        if (getEmptyViewCount() == 1) {
            if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
                i2 = 2;
            }
            return (!this.mFootAndEmptyEnable || getFooterLayoutCount() == 0) ? i2 : i2 + 1;
        }
        return getLoadMoreViewCount() + getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    /* access modifiers changed from: protected */
    public View getItemView(int i2, ViewGroup viewGroup) {
        return this.mLayoutInflater.inflate(i2, viewGroup, false);
    }

    public int getItemViewType(int i2) {
        if (getEmptyViewCount() == 1) {
            boolean z2 = this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0;
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? EMPTY_VIEW : FOOTER_VIEW : z2 ? EMPTY_VIEW : FOOTER_VIEW : z2 ? HEADER_VIEW : EMPTY_VIEW;
        }
        int headerLayoutCount = getHeaderLayoutCount();
        if (i2 < headerLayoutCount) {
            return HEADER_VIEW;
        }
        int i3 = i2 - headerLayoutCount;
        int size = this.mData.size();
        return i3 < size ? getDefItemViewType(i3) : i3 - size < getFooterLayoutCount() ? FOOTER_VIEW : LOADING_VIEW;
    }

    public int getLoadMoreViewCount() {
        if (this.mRequestLoadMoreListener == null || !this.mLoadMoreEnable) {
            return 0;
        }
        return ((this.mNextLoadEnable || !this.mLoadMoreView.b()) && this.mData.size() != 0) ? 1 : 0;
    }

    public int getLoadMoreViewPosition() {
        return getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
    }

    public cm.a<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    public final C0069a getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final b getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final c getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final d getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public int getParentPosition(T t2) {
        int itemPosition = getItemPosition(t2);
        if (itemPosition == -1) {
            return -1;
        }
        int c2 = t2 instanceof ck.a ? ((ck.a) t2).c() : SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if (c2 == 0) {
            return itemPosition;
        }
        if (c2 == -1) {
            return -1;
        }
        while (itemPosition >= 0) {
            T t3 = this.mData.get(itemPosition);
            if (t3 instanceof ck.a) {
                ck.a aVar = (ck.a) t3;
                if (aVar.c() >= 0 && aVar.c() < c2) {
                    return itemPosition;
                }
            }
            itemPosition--;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public View getViewByPosition(int i2, int i3) {
        checkNotNull();
        return getViewByPosition(getRecyclerView(), i2, i3);
    }

    public View getViewByPosition(RecyclerView recyclerView, int i2, int i3) {
        b bVar;
        if (recyclerView == null || (bVar = (b) recyclerView.d(i2)) == null) {
            return null;
        }
        return bVar.c(i3);
    }

    public boolean isExpandable(T t2) {
        return t2 != null && (t2 instanceof ck.a);
    }

    public void isFirstOnly(boolean z2) {
        this.mFirstOnlyEnable = z2;
    }

    /* access modifiers changed from: protected */
    public boolean isFixedViewType(int i2) {
        return i2 == 1365 || i2 == 273 || i2 == 819 || i2 == 546;
    }

    public boolean isFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public boolean isHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public boolean isLoadMoreEnable() {
        return this.mLoadMoreEnable;
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public boolean isUpFetchEnable() {
        return this.mUpFetchEnable;
    }

    public boolean isUpFetching() {
        return this.mUpFetching;
    }

    public void isUseEmpty(boolean z2) {
        this.mIsUseEmpty = z2;
    }

    public void loadMoreComplete() {
        if (getLoadMoreViewCount() != 0) {
            this.mLoading = false;
            this.mNextLoadEnable = true;
            this.mLoadMoreView.a(1);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void loadMoreEnd() {
        loadMoreEnd(false);
    }

    public void loadMoreEnd(boolean z2) {
        if (getLoadMoreViewCount() != 0) {
            this.mLoading = false;
            this.mNextLoadEnable = false;
            this.mLoadMoreView.a(z2);
            if (z2) {
                notifyItemRemoved(getLoadMoreViewPosition());
                return;
            }
            this.mLoadMoreView.a(4);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void loadMoreFail() {
        if (getLoadMoreViewCount() != 0) {
            this.mLoading = false;
            this.mLoadMoreView.a(3);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void notifyLoadMoreToLoading() {
        if (this.mLoadMoreView.a() != 2) {
            this.mLoadMoreView.a(1);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.h layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.a((GridLayoutManager.b) new GridLayoutManager.b() {
                public int getSpanSize(int i2) {
                    int itemViewType = a.this.getItemViewType(i2);
                    if (itemViewType == 273 && a.this.isHeaderViewAsFlow()) {
                        return 1;
                    }
                    if (itemViewType == 819 && a.this.isFooterViewAsFlow()) {
                        return 1;
                    }
                    if (a.this.mSpanSizeLookup != null) {
                        return a.this.isFixedViewType(itemViewType) ? gridLayoutManager.b() : a.this.mSpanSizeLookup.a(gridLayoutManager, i2 - a.this.getHeaderLayoutCount());
                    }
                    if (a.this.isFixedViewType(itemViewType)) {
                        return gridLayoutManager.b();
                    }
                    return 1;
                }
            });
        }
    }

    public void onBindViewHolder(K k2, int i2) {
        autoUpFetch(i2);
        autoLoadMore(i2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType != 0) {
            if (itemViewType == 273) {
                return;
            }
            if (itemViewType == 546) {
                this.mLoadMoreView.a((b) k2);
                return;
            } else if (itemViewType == 819 || itemViewType == 1365) {
                return;
            }
        }
        convert(k2, getItem(i2 - getHeaderLayoutCount()));
    }

    /* access modifiers changed from: protected */
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i2) {
        int i3 = this.mLayoutResId;
        cm.a<T> aVar = this.mMultiTypeDelegate;
        if (aVar != null) {
            i3 = aVar.a(i2);
        }
        return createBaseViewHolder(viewGroup, i3);
    }

    public K onCreateViewHolder(ViewGroup viewGroup, int i2) {
        K k2;
        View view;
        Context context = viewGroup.getContext();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        if (i2 != 273) {
            if (i2 == 546) {
                k2 = getLoadingView(viewGroup);
            } else if (i2 == 819) {
                view = this.mFooterLayout;
            } else if (i2 != 1365) {
                k2 = onCreateDefViewHolder(viewGroup, i2);
                bindViewClickListener(k2);
            } else {
                view = this.mEmptyLayout;
            }
            k2.a(this);
            return k2;
        }
        view = this.mHeaderLayout;
        k2 = createBaseViewHolder(view);
        k2.a(this);
        return k2;
    }

    public void onViewAttachedToWindow(K k2) {
        super.onViewAttachedToWindow(k2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            setFullSpan(k2);
        } else {
            addAnimation(k2);
        }
    }

    public void openLoadAnimation() {
        this.mOpenAnimationEnable = true;
    }

    public void openLoadAnimation(int i2) {
        cj.b bVar;
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = null;
        if (i2 == 1) {
            bVar = new cj.a();
        } else if (i2 == 2) {
            bVar = new cj.c();
        } else if (i2 == 3) {
            bVar = new cj.d();
        } else if (i2 == 4) {
            bVar = new cj.e();
        } else if (i2 == 5) {
            bVar = new cj.f();
        } else {
            return;
        }
        this.mSelectAnimation = bVar;
    }

    public void openLoadAnimation(cj.b bVar) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = bVar;
    }

    public void remove(int i2) {
        this.mData.remove(i2);
        int headerLayoutCount = i2 + getHeaderLayoutCount();
        notifyItemRemoved(headerLayoutCount);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(headerLayoutCount, this.mData.size() - headerLayoutCount);
    }

    public void removeAllFooterView() {
        if (getFooterLayoutCount() != 0) {
            this.mFooterLayout.removeAllViews();
            int footerViewPosition = getFooterViewPosition();
            if (footerViewPosition != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public void removeAllHeaderView() {
        if (getHeaderLayoutCount() != 0) {
            this.mHeaderLayout.removeAllViews();
            int headerViewPosition = getHeaderViewPosition();
            if (headerViewPosition != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public void removeFooterView(View view) {
        int footerViewPosition;
        if (getFooterLayoutCount() != 0) {
            this.mFooterLayout.removeView(view);
            if (this.mFooterLayout.getChildCount() == 0 && (footerViewPosition = getFooterViewPosition()) != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public void removeHeaderView(View view) {
        int headerViewPosition;
        if (getHeaderLayoutCount() != 0) {
            this.mHeaderLayout.removeView(view);
            if (this.mHeaderLayout.getChildCount() == 0 && (headerViewPosition = getHeaderViewPosition()) != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public void replaceData(Collection<? extends T> collection) {
        List<T> list = this.mData;
        if (collection != list) {
            list.clear();
            this.mData.addAll(collection);
        }
        notifyDataSetChanged();
    }

    @Deprecated
    public void setAutoLoadMoreSize(int i2) {
        setPreLoadNumber(i2);
    }

    public void setData(int i2, T t2) {
        this.mData.set(i2, t2);
        notifyItemChanged(i2 + getHeaderLayoutCount());
    }

    public void setDuration(int i2) {
        this.mDuration = i2;
    }

    public void setEmptyView(int i2) {
        checkNotNull();
        setEmptyView(i2, getRecyclerView());
    }

    public void setEmptyView(int i2, ViewGroup viewGroup) {
        setEmptyView(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    public void setEmptyView(View view) {
        boolean z2;
        int i2 = 0;
        if (this.mEmptyLayout == null) {
            this.mEmptyLayout = new FrameLayout(view.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
            }
            this.mEmptyLayout.setLayoutParams(layoutParams);
            z2 = true;
        } else {
            z2 = false;
        }
        this.mEmptyLayout.removeAllViews();
        this.mEmptyLayout.addView(view);
        this.mIsUseEmpty = true;
        if (z2 && getEmptyViewCount() == 1) {
            if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
                i2 = 1;
            }
            notifyItemInserted(i2);
        }
    }

    public void setEnableLoadMore(boolean z2) {
        int loadMoreViewCount = getLoadMoreViewCount();
        this.mLoadMoreEnable = z2;
        int loadMoreViewCount2 = getLoadMoreViewCount();
        if (loadMoreViewCount == 1) {
            if (loadMoreViewCount2 == 0) {
                notifyItemRemoved(getLoadMoreViewPosition());
            }
        } else if (loadMoreViewCount2 == 1) {
            this.mLoadMoreView.a(1);
            notifyItemInserted(getLoadMoreViewPosition());
        }
    }

    public int setFooterView(View view) {
        return setFooterView(view, 0, 1);
    }

    public int setFooterView(View view, int i2) {
        return setFooterView(view, i2, 1);
    }

    public int setFooterView(View view, int i2, int i3) {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i2) {
            return addFooterView(view, i2, i3);
        }
        this.mFooterLayout.removeViewAt(i2);
        this.mFooterLayout.addView(view, i2);
        return i2;
    }

    public void setFooterViewAsFlow(boolean z2) {
        this.footerViewAsFlow = z2;
    }

    /* access modifiers changed from: protected */
    public void setFullSpan(RecyclerView.v vVar) {
        if (vVar.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) vVar.itemView.getLayoutParams()).a(true);
        }
    }

    public void setHeaderAndEmpty(boolean z2) {
        setHeaderFooterEmpty(z2, false);
    }

    public void setHeaderFooterEmpty(boolean z2, boolean z3) {
        this.mHeadAndEmptyEnable = z2;
        this.mFootAndEmptyEnable = z3;
    }

    public int setHeaderView(View view) {
        return setHeaderView(view, 0, 1);
    }

    public int setHeaderView(View view, int i2) {
        return setHeaderView(view, i2, 1);
    }

    public int setHeaderView(View view, int i2, int i3) {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i2) {
            return addHeaderView(view, i2, i3);
        }
        this.mHeaderLayout.removeViewAt(i2);
        this.mHeaderLayout.addView(view, i2);
        return i2;
    }

    public void setHeaderViewAsFlow(boolean z2) {
        this.headerViewAsFlow = z2;
    }

    public void setLoadMoreView(cl.a aVar) {
        this.mLoadMoreView = aVar;
    }

    public void setMultiTypeDelegate(cm.a<T> aVar) {
        this.mMultiTypeDelegate = aVar;
    }

    public void setNewData(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mData = list;
        if (this.mRequestLoadMoreListener != null) {
            this.mNextLoadEnable = true;
            this.mLoadMoreEnable = true;
            this.mLoading = false;
            this.mLoadMoreView.a(1);
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
    }

    public void setNotDoAnimationCount(int i2) {
        this.mLastPosition = i2;
    }

    public void setOnItemChildClickListener(C0069a aVar) {
        this.mOnItemChildClickListener = aVar;
    }

    public void setOnItemChildLongClickListener(b bVar) {
        this.mOnItemChildLongClickListener = bVar;
    }

    public void setOnItemClickListener(c cVar) {
        this.mOnItemClickListener = cVar;
    }

    public void setOnItemLongClickListener(d dVar) {
        this.mOnItemLongClickListener = dVar;
    }

    @Deprecated
    public void setOnLoadMoreListener(e eVar) {
        openLoadMore(eVar);
    }

    public void setOnLoadMoreListener(e eVar, RecyclerView recyclerView) {
        openLoadMore(eVar);
        if (getRecyclerView() == null) {
            setRecyclerView(recyclerView);
        }
    }

    public void setPreLoadNumber(int i2) {
        if (i2 > 1) {
            this.mPreLoadNumber = i2;
        }
    }

    public void setSpanSizeLookup(f fVar) {
        this.mSpanSizeLookup = fVar;
    }

    public void setStartUpFetchPosition(int i2) {
        this.mStartUpFetchPosition = i2;
    }

    public void setUpFetchEnable(boolean z2) {
        this.mUpFetchEnable = z2;
    }

    public void setUpFetchListener(g gVar) {
        this.mUpFetchListener = gVar;
    }

    public void setUpFetching(boolean z2) {
        this.mUpFetching = z2;
    }

    /* access modifiers changed from: protected */
    public void startAnim(Animator animator, int i2) {
        animator.setDuration((long) this.mDuration).start();
        animator.setInterpolator(this.mInterpolator);
    }
}
