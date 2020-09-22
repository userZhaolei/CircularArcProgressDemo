package com.zl.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zl.circulararcprogress.CircularArcProgressView;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            i += 1;
            progress_circular.setProgress(i);
            progress_circular2.setProgress(i);
            progress_circular3.setProgress(i);
            progress_circular4.setProgress(i);
            Log.d("testActivity", "" + i);
            if(i!=100){
                handler.sendMessageDelayed(Message.obtain(), 100);
            }

        }
    };
    private CircularArcProgressView progress_circular;
    private CircularArcProgressView progress_circular2;
    private CircularArcProgressView progress_circular3;
    private CircularArcProgressView progress_circular4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress_circular = findViewById(R.id.progress_circular);
        progress_circular2 = findViewById(R.id.progress_circular2);
        progress_circular3 = findViewById(R.id.progress_circular3);
        progress_circular4 = findViewById(R.id.progress_circular4);

        progress_circular.addCircularArcProgressViewListener(new CircularArcProgressView.CircularArcProgressViewListener() {
            @Override
            public void success() {
                Toast.makeText(MainActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        });



        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                handler.sendMessageDelayed(Message.obtain(), 100);
            }
        });
    }
}
