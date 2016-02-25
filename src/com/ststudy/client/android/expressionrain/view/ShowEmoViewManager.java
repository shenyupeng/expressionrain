package com.ststudy.client.android.expressionrain.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;

/**
 * Created by Aaron on 2016/2/4.
 * 显示表情雨管理
 */
public class ShowEmoViewManager {

    private Context mContext;
    private ViewGroup mViewGroup;
    private int mTime;
    private int mDensity;

    /**
     * 显示图形构造
     *
     * @param pContext   上下文
     * @param pViewGroup 填充的group
     * @param pTime      控制的时间
     * @param pDensity   控制的密度
     */
    public ShowEmoViewManager(Context pContext, ViewGroup pViewGroup, int pTime, int pDensity) {
        mContext = pContext;
        mViewGroup = pViewGroup;
        mTime = pTime;
        mDensity = pDensity;
        handler.sendEmptyMessageDelayed(1, 1000);
    }

    private void addEmoView() {
        for (int i = 0; i < mDensity; i++) {
            new EmoView(mContext, mViewGroup);
        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (mTime > 0) {
                        addEmoView();
                        handler.sendEmptyMessageDelayed(1, 1000);
                        mTime--;
                    }
                    break;
            }

        }
    };

}
