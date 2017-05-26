package com.android.example.strings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.string1)
    EditText string1;
    @BindView(R.id.string2)
    EditText string2;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            String str1 = string1.getText().toString();
            char[] char1 = str1.toCharArray();
            String str2 = string2.getText().toString();
            char[] char2 = str2.toCharArray();
            if (char1.length != char2.length) {
                Toast.makeText(this, "Размеры строк должны быть одинаковыми", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, String.valueOf(comparison(char1, char2)), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Собственно сам алгоритм выявляющий состоят ли строки из одним обьектов.
    public boolean comparison(char[] str1, char[] str2) {

        // Вспомогательный массив для хранения совпадающий букв.
        ArrayList<Character> mas = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();

        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j] && mas.size() == i) {
                    Boolean flag = false;
                    if (number.size() != 0) {
                        for (int k : number) {
                            if (k == j) {
                                flag = true;
                            }
                        }
                    }
                    if (!flag) {
                        mas.add(str1[i]);
                        number.add(j);
                    }
                }
            }
        }

        return str1.length == mas.size();
    }

}
