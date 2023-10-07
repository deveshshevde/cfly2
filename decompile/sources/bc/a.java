package bc;

import com.alibaba.android.arouter.facade.enums.RouteType;
import java.util.Map;
import javax.lang.model.element.Element;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private RouteType f5597a;

    /* renamed from: b  reason: collision with root package name */
    private Element f5598b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f5599c;

    /* renamed from: d  reason: collision with root package name */
    private String f5600d;

    /* renamed from: e  reason: collision with root package name */
    private String f5601e;

    /* renamed from: f  reason: collision with root package name */
    private int f5602f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f5603g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Integer> f5604h;

    /* renamed from: i  reason: collision with root package name */
    private String f5605i;

    public a a(int i2) {
        this.f5602f = i2;
        return this;
    }

    public a a(RouteType routeType) {
        this.f5597a = routeType;
        return this;
    }

    public a a(Class<?> cls) {
        this.f5599c = cls;
        return this;
    }

    public a a(String str) {
        this.f5600d = str;
        return this;
    }

    public a b(int i2) {
        this.f5603g = i2;
        return this;
    }

    public a b(String str) {
        this.f5601e = str;
        return this;
    }

    public Map<String, Integer> l() {
        return this.f5604h;
    }

    public RouteType m() {
        return this.f5597a;
    }

    public Class<?> n() {
        return this.f5599c;
    }

    public String o() {
        return this.f5600d;
    }

    public String p() {
        return this.f5601e;
    }

    public int q() {
        return this.f5602f;
    }

    public int r() {
        return this.f5603g;
    }

    public String toString() {
        return "RouteMeta{type=" + this.f5597a + ", rawType=" + this.f5598b + ", destination=" + this.f5599c + ", path='" + this.f5600d + '\'' + ", group='" + this.f5601e + '\'' + ", priority=" + this.f5602f + ", extra=" + this.f5603g + ", paramsType=" + this.f5604h + ", name='" + this.f5605i + '\'' + '}';
    }
}
