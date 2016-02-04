package com.ststudy.client.android.expressionrain.anim;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * 贝塞尔曲线
 */
public class BezierEvaluator implements TypeEvaluator<PointF> {

    @Override
    public PointF evaluate(float fraction, PointF startValue,
                           PointF endValue) {
        return BezierCurve.bezier(fraction, startValue, endValue);
    }

}

