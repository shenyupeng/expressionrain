package com.ststudy.client.android.expressionrain.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Created by Aaron on 2016/2/4.
 * 显示表情雨管理
 */
public class ShowEmoViewManager {

    private Context mContext;
    private ViewGroup mViewGroup;
    private int mTime;
    private int mDensity;
    private MyHandler mHandler;

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
        mHandler = new MyHandler(ShowEmoViewManager.this);
        mHandler.sendEmptyMessageDelayed(1, 1000);
    }

    private void addEmoView() {
        for (int i = 0; i < mDensity; i++) {
            new EmoView(mContext, mViewGroup);
        }
    }

    private static class MyHandler extends Handler {
        private final WeakReference<ShowEmoViewManager> mShowEmoView;

        public MyHandler(ShowEmoViewManager autoScrollViewPager) {
            this.mShowEmoView = new WeakReference<ShowEmoViewManager>(autoScrollViewPager);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ShowEmoViewManager _showEomView = this.mShowEmoView.get();
                    if (_showEomView != null) {
                        _showEomView.mHandler.removeMessages(1);
                        if (_showEomView.mTime > 0) {
                            _showEomView.addEmoView();
                            _showEomView.mHandler.sendEmptyMessageDelayed(1, 1000);
                            _showEomView.mTime--;
                        }
                    }
                default:
                    break;
            }
        }
    }
}
