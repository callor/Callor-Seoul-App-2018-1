package com.callor.woo_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubViewActivity extends AppCompatActivity {

    TextView txt_title;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_view);

        String title = getIntent().getStringExtra("TITLE");

        txt_title = findViewById(R.id.txt_sam);
        txt_title.setText(title + "버튼을 눌렀네요");

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent를 생성할때 매개변수를 넣지 않으면
                나를 실행해준(열어준, 호출해준) Activity 정보가 추출된다
                즉, MainActivity의 정보가 추출된다.
                 */
                Intent parentIntent = new Intent();

                String welcome = "반갑습니다";
                parentIntent.putExtra("WELCOME",welcome) ;

                // 마치 Dialog Box의 확인(OK) 버튼을 누른것과 같은 액션을 보내라
                setResult(RESULT_OK,parentIntent);

                finish(); // 현재 Activity를 종료하라

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
