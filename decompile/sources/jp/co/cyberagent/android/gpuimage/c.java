package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;
import android.opengl.GLES20;

public class c extends a {

    /* renamed from: g  reason: collision with root package name */
    private PointF f29675g;

    /* renamed from: h  reason: collision with root package name */
    private int f29676h;

    /* renamed from: i  reason: collision with root package name */
    private float f29677i;

    /* renamed from: j  reason: collision with root package name */
    private int f29678j;

    /* renamed from: k  reason: collision with root package name */
    private float f29679k;

    /* renamed from: l  reason: collision with root package name */
    private int f29680l;

    /* renamed from: m  reason: collision with root package name */
    private float f29681m;

    /* renamed from: n  reason: collision with root package name */
    private int f29682n;

    public c() {
        this(new PointF(0.5f, 0.5f), 0.25f, 0.71f);
    }

    public c(PointF pointF, float f2, float f3) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float aspectRatio;\nuniform highp float refractiveIndex;\n// uniform vec3 lightPosition;\nconst highp vec3 lightPosition = vec3(-0.5, 0.5, 1.0);\nconst highp vec3 ambientLightPosition = vec3(0.0, 0.0, 1.0);\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\nhighp float distanceFromCenter = distance(center, textureCoordinateToUse);\nlowp float checkForPresenceWithinSphere = step(distanceFromCenter, radius);\n\ndistanceFromCenter = distanceFromCenter / radius;\n\nhighp float normalizedDepth = radius * sqrt(1.0 - distanceFromCenter * distanceFromCenter);\nhighp vec3 sphereNormal = normalize(vec3(textureCoordinateToUse - center, normalizedDepth));\n\nhighp vec3 refractedVector = 2.0 * refract(vec3(0.0, 0.0, -1.0), sphereNormal, refractiveIndex);\nrefractedVector.xy = -refractedVector.xy;\n\nhighp vec3 finalSphereColor = texture2D(inputImageTexture, (refractedVector.xy + 1.0) * 0.5).rgb;\n\n// Grazing angle lighting\nhighp float lightingIntensity = 2.5 * (1.0 - pow(clamp(dot(ambientLightPosition, sphereNormal), 0.0, 1.0), 0.25));\nfinalSphereColor += lightingIntensity;\n\n// Specular lighting\nlightingIntensity  = clamp(dot(normalize(lightPosition), sphereNormal), 0.0, 1.0);\nlightingIntensity  = pow(lightingIntensity, 15.0);\nfinalSphereColor += vec3(0.8, 0.8, 0.8) * lightingIntensity;\n\ngl_FragColor = vec4(finalSphereColor, 1.0) * checkForPresenceWithinSphere;\n}\n");
        this.f29675g = pointF;
        this.f29677i = f2;
        this.f29681m = f3;
    }

    private void c(float f2) {
        this.f29679k = f2;
        a(this.f29680l, f2);
    }

    public void a(float f2) {
        this.f29681m = f2;
        a(this.f29682n, f2);
    }

    public void a(int i2, int i3) {
        float f2 = ((float) i3) / ((float) i2);
        this.f29679k = f2;
        c(f2);
        super.a(i2, i3);
    }

    public void a(PointF pointF) {
        this.f29675g = pointF;
        a(this.f29676h, pointF);
    }

    public void b() {
        super.b();
        this.f29676h = GLES20.glGetUniformLocation(k(), "center");
        this.f29678j = GLES20.glGetUniformLocation(k(), "radius");
        this.f29680l = GLES20.glGetUniformLocation(k(), "aspectRatio");
        this.f29682n = GLES20.glGetUniformLocation(k(), "refractiveIndex");
    }

    public void b(float f2) {
        this.f29677i = f2;
        a(this.f29678j, f2);
    }

    public void c() {
        super.c();
        b(this.f29677i);
        a(this.f29675g);
        a(this.f29681m);
    }
}
