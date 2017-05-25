package com.android.example.strings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    String str1;
    String str2;

    @BindView(R.id.string1)
    EditText string1;
    @BindView(R.id.string2)
    EditText string2;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progress.setVisibility(View.GONE);
    }

    @OnClick(R.id.button)
    public void onClick (View view) {
        if (view.getId() == R.id.button) {
            str1=string1.getText().toString();
            str2=string2.getText().toString();
            Toast.makeText(this,"first: " + str1+" . Second: " + str2, Toast.LENGTH_SHORT).show();
        }
    }

}
