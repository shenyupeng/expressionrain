package com.ststudy.client.android.expressionrain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.ststudy.client.android.expressionrain.view.ShowEmoViewManager;

public class MyActivity extends Activity {

    private RelativeLayout mParent;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mParent = (RelativeLayout) findViewById(R.id.parent);
        (findViewById(R.id.btnTest)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShowEmoViewManager(MyActivity.this, mParent, 6, 20);
            }
        });
    }

}
