package com.ststudy.client.android.expressionrain.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ststudy.client.android.expressionrain.R;
import com.ststudy.client.android.expressionrain.anim.BezierEvaluator;

import java.util.Random;

/**
 * Created by Aaron on 2016/2/3.
 * 自定义的动画View
 */
public class EmoView extends ImageView {

    private int mContainerWidth;
    private int mContainerHeight;
    private int[] mPoints;
    private ViewGroup mViewGroup;

    public EmoView(Context context, ViewGroup pViewGroup) {
        super(context);
        initData(pViewGroup);
    }

    /**
     * 初始化数据
     */
    private void initData(ViewGroup pViewGroup) {
        mViewGroup = pViewGroup;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pViewGroup.addView(this, params);
        mPoints = new int[2];
        mContainerWidth = pViewGroup.getWidth();
        mContainerHeight = pViewGroup.getHeight();
        mPoints[0] = new Random().nextInt(mContainerWidth);
        mPoints[1] = new Random().nextInt(mContainerWidth);
        ValueAnimator animator1 = ValueAnimator.ofObject(new BezierEvaluator(), new PointF(mPoints[0], 0), new PointF(mPoints[1] - 90, mContainerHeight - 90));
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                EmoView.this.setX(pointF.x);
                EmoView.this.setY(pointF.y);
            }
        });


        animator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mViewGroup.removeView(EmoView.this);
                EmoView.this.destroyDrawingCache();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        animator1.setRepeatMode(ValueAnimator.REVERSE);
        animator1.setDuration(new Random().nextInt(3000) + 2000);
        animator1.setTarget(EmoView.this);
        set.start();
        setImageResource(R.drawable.flower);
    }
}
