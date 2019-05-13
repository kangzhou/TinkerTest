package com.zhouk.tinkertest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    Button fixBugBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestTinker();
    }

    private void TestTinker() {
        Toast.makeText(this,Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/patch_signed_7zip.apk",Toast.LENGTH_LONG).show();
        fixBugBtn = findViewById(R.id.fixBugbBtn);
        textView = findViewById(R.id.text);
        textView.setText("我已修复");
        fixBugBtn.setVisibility(View.INVISIBLE);

        fixBugBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath() +
                                "/patch_signed_7zip.apk");//等下要push到SD卡里面去apk，以达到更新的目的

            }
        });
    }
}
