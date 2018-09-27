package com.callor.woo_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.callor.woo_project.adapter.MainPagerAdapter;
import com.callor.woo_project.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView menu_01;
    TextView menu_02;
    TextView menu_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        menu_01 = findViewById(R.id.txt_menu_01);
        menu_02 = findViewById(R.id.txt_menu_02);
        menu_03 = findViewById(R.id.txt_menu_03);

        menu_01.setOnClickListener(this);
        menu_02.setOnClickListener(this);
        menu_03.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String title = "없음";
        switch (id) {
            case R.id.txt_menu_01 :
                title = "임신/출산";
                title = ((TextView)v).getText().toString();
                break ; // return
            case R.id.txt_menu_02 :
                title = "영유아";
                title = ((TextView)v).getText().toString();
                break ; // return

            case R.id.txt_menu_03:
                title = "아동";
                title = ((TextView)v).getText().toString();
                break;

        }
         Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(MainActivity.this,SubViewActivity.class);
        Intent intent
                = new Intent(MainActivity.this,
                FragMainActivity.class);

        intent.putExtra("TITLE",title);
        intent.putExtra("MENU_ID",v.getId());

        startActivity(intent);

        // requestCode : 내 id 값
//        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // resultCode 는 setResult() 설정된 값
        if(resultCode == RESULT_OK) {

            // requestCode는 내가 start할때 설정한 값
            if(requestCode == 100) {
                String welcome = data.getStringExtra("WELCOME");
                welcome = "Sub Activity가 " + welcome + " 이라고 하네요";
                Toast.makeText(MainActivity.this,welcome,Toast.LENGTH_LONG).show();
            }
        }
    }
}
