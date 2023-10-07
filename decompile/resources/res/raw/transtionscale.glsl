attribute vec4 position;
attribute vec4 inputTextureCoordinate;
varying vec2 textureCoordinate;

uniform float progress;

const float PI = 3.1415926;

void main (void) {
    //一次缩放的最大时长
    float duration = 0.6;
    //振幅
    float maxAmplitude = 0.3;
    //每次传进来的时间在0-0.6范围内
    //mod求模
    float time = mod(progress, duration);
    //PI / duration 一个单位时间点对应的角度
    //time * (PI / duration) 当前时间对应的角度
    //sin(time * (PI / duration))计算值这个角度对应的值 -1~1之间
    //abs(sin(time * (PI / duration))) 求出绝对值0-1之间
    //1.0 + maxAmplitude * abs(sin(time * (PI / duration))) 结果是:1.0~1.3之间的值
    float amplitude = 1.0 + maxAmplitude * abs(sin(time * (PI / duration)));
    //将顶点坐标的x和y分别乘以一个放大系数，即振幅，在纹理坐标不变的情况下，就达到了拉伸的效果
    //xy放大，zw保持不变
    gl_Position = vec4(position.x * amplitude, position.y * amplitude, position.zw);
    //将纹理坐标传递给TextureCoordsVarying
    textureCoordinate = inputTextureCoordinate.xy;
}
