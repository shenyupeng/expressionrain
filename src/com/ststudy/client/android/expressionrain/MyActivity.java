package com.ststudy.client.android.expressionrain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import com.ststudy.client.android.expressionrain.view.ShowEmoViewManager;

public class MyActivity extends Activity {

    private RelativeLayout mParent;
    private Button mBtnTest;

    private SeekBar mSeekTime;
    private SeekBar mSeekDensity;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findView();
        new ShowEmoViewManager(MyActivity.this, mParent, 1, 1);
        initData();
        setListener();
    }

    /**
     * 寻找View
     */
    private void findView() {
        mParent = (RelativeLayout) findViewById(R.id.parent);
        mBtnTest = (Button) findViewById(R.id.btnTest);
        mSeekTime = (SeekBar) findViewById(R.id.sbTime);
        mSeekDensity = (SeekBar) findViewById(R.id.sbDensity);
    }


    /**
     * 初始化数据
     */
    private void initData() {
        mSeekTime.setMax(10);
        mSeekDensity.setMax(20);
    }


    /**
     * 设置相关监听
     */
    private void setListener() {
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShowEmoViewManager(MyActivity.this, mParent, mSeekTime.getProgress(), mSeekDensity.getProgress());
            }
        });

        mSeekTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MyActivity.this, "时间为：" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
        mSeekDensity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MyActivity.this, "密度为：" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
