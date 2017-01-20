package com.xyu.keystoreencrydemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText alias_edit, need_deal_word_edit;
    private Button encryptBtn, decryptBtn;
    private TextView after_encry_tv, after_decrypt_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alias_edit = (EditText) findViewById(R.id.alias_edit);
        need_deal_word_edit = (EditText) findViewById(R.id.need_deal_word_edit);
        need_deal_word_edit = (EditText) findViewById(R.id.need_deal_word_edit);
        encryptBtn = (Button) findViewById(R.id.encryptBtn);
        decryptBtn = (Button) findViewById(R.id.decryptBtn);
        after_encry_tv = (TextView) findViewById(R.id.after_encry_tv);
        after_decrypt_tv = (TextView) findViewById(R.id.after_decrypt_tv);
        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {
                String alias_str = alias_edit.getText().toString().trim();
                String need_deal_word_str = need_deal_word_edit.getText().toString().trim();
                String after_encry_str =EncryUtils.getInstance().encryptString(need_deal_word_str,alias_str);
                after_encry_tv.setText(after_encry_str);
            }
        });
        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {
                String alias_str = alias_edit.getText().toString().trim();
                String before_decrypt_str = after_encry_tv.getText().toString();
                String after_decrypt_str =EncryUtils.getInstance().decryptString(before_decrypt_str, alias_str);
                after_decrypt_tv.setText(after_decrypt_str);
            }
        });
    }
}
