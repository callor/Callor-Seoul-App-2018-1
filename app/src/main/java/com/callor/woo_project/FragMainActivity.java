package com.callor.woo_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.callor.woo_project.adapter.MainPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragMainActivity extends AppCompatActivity {

    ViewPager vp ;
    TabLayout tabLayout ;
    String title ;
    int menu_id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_main);

        title = getIntent().getStringExtra("TTILE");
        menu_id = getIntent().getIntExtra("MENU_ID",0);
        Log.d("FM", ":" + menu_id);

        vp = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        // res/value/page_title.xml에 선언된 string-array를 문자열 배열로 가져오기

        String[] strPageTitles;

        switch (menu_id) {
            case R.id.txt_menu_01 :
                strPageTitles
                =  this.getResources()
                    .getStringArray(R.array.main_page_01);
                break;

            case R.id.txt_menu_02 :
                strPageTitles
                        =  this.getResources()
                        .getStringArray(R.array.main_page_02);

                break;

            case R.id.txt_menu_03 :
                strPageTitles
                        =  this.getResources()
                        .getStringArray(R.array.main_page_03);
                break;

            default:
                strPageTitles = null;
        }

        // noArrayList는 실제적인 ArrayList와 달라서
        // list를 추가, 삭제하는데 문제가 있다.
        List<String> noArrayLyst = Arrays.asList(strPageTitles);

        // 정상적인 ArrayList를 생성하는 방법
        List<String> pageTitles
            = new ArrayList<>(Arrays.asList(strPageTitles));

        MainPagerAdapter adapter
                = new MainPagerAdapter(getSupportFragmentManager(),
                menu_id,
                pageTitles);

        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);

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
