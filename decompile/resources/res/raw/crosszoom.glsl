precision highp float;

uniform sampler2D inputImageTexture;
varying vec2 textureCoordinate;

uniform float progress;

void main (void) {

    //**************设置基础值*********//
    // 时间周期
    float duration = 0.7;
    //最大透明度
    float maxAlpha = 0.4;
    //最大放大比例
    float maxScale = 1.8;

    //**************计算变化值*********//
    //当前传进来时间对应的0-1之间的实际值
    float time = mod(progress, duration) / duration; // 0~1
    //取反,透明度减小
    float alpha = maxAlpha * (1.0 - time);
    //计算缩放比例
    float scale = 1.0 + (maxScale - 1.0) * time;

    //将顶点坐标对应的纹理坐标的x/y值到中心点的距离，缩小一定的比例，仅仅只是改变了纹理坐标，而保持顶点坐标不变，从而达到拉伸效果
    float weakX = 0.5 + (textureCoordinate.x - 0.5) / scale;
    float weakY = 0.5 + (textureCoordinate.y - 0.5) / scale;
    vec2 weakTextureCoords = vec2(weakX, weakY);
    //**************计算纹理坐标*********//
    vec4 weakMask = texture2D(inputImageTexture, weakTextureCoords);
    vec4 mask = texture2D(inputImageTexture, textureCoordinate);

    //**************混合*********//
    gl_FragColor = mask * (1.0 - alpha) + weakMask * alpha;
}
