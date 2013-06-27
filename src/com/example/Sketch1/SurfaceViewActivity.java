package com.example.Sketch1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class SurfaceViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }
}
