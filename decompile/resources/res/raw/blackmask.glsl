
precision highp float;

uniform sampler2D inputImageTexture;
varying vec2 textureCoordinate;

uniform float progress;

const float PI = 3.1415926;

void main (void) {
    //时间周期
    float duration = 0.6;
    //计算0-0.6
    float time = mod(progress, duration);
    //白色纹理坐标
    vec4 whiteMask = vec4(0.0, 0.0, 0.0, 0.0);
    //计算线性范围
    float amplitude = abs(sin(time * (PI / duration)));
    //原始纹坐标
    vec4 mask = texture2D(inputImageTexture, textureCoordinate);
    //混合
    gl_FragColor = mask * (1.0 - amplitude) + whiteMask * amplitude;
}