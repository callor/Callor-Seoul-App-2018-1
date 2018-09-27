package com.callor.woo_project.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.callor.woo_project.R;
import com.callor.woo_project.adapter.GoDataViewAdapter;
import com.callor.woo_project.models.GoDataListVO;
import com.callor.woo_project.service.GodataGetterService;

import java.util.List;
import java.util.concurrent.ExecutionException;

// Fragment class 반드시 v4.app의 Fragment를 import한다.
public class MainFragment extends Fragment {

    static String PAGE_TITLE = "pageTitle" ;
    static String MENU_ID = "menu_id";

    String pageTitle  ;
    int menu_id ;

    // Fragment를 ViewPager에 표시하기 위해서는
    // 반드시 빈(기본) 생성자를 만들어 주어야 한다.
    public MainFragment() {

    }


    @SuppressLint("ValidFragment")
    public MainFragment(String pageTitle, int menu_id) {
        this.pageTitle = pageTitle;
        this.menu_id = menu_id;
    }

//    @SuppressLint("ValidFragment")
//    public MainFragment(String pageTitle, int menu_id) {
//            this.pageTitle = pageTitle;
//            this.menu_id = menu_id;
//
//    }


    public static MainFragment newInstance(String pageTitle,int menu_id)  {
        MainFragment mainFragment = new MainFragment();

        Bundle string = new Bundle();

        string.putString(PAGE_TITLE,pageTitle);
        // string.putString("pageTitle",pageTitle);
        string.putInt(MENU_ID,menu_id);

        mainFragment.setArguments(string);
        return mainFragment;

    }

    public static MainFragment newInstance(String pageTitle)  {
        MainFragment mainFragment = new MainFragment();

        /*보통 클래스이 맴버변수를 세팅하는 방법은
             this.pageTitle = pageTitle; 이렇게 사용하나

         Fragment는 특성상 움직이는 객체인 관계로
         member변수의 값을 잃을 수 있다.
         그래서 member 변수의 값을 세팅할때는
         아래와 같이 사용한다.
        */
        // newInstatance가 받은 pagrTitle을 Fragement에 심는 절차
        Bundle string = new Bundle();

        string.putString(PAGE_TITLE,pageTitle);
        string.putInt("NUM",001);
        string.putString("name","홍길동");

        // string.putString("pageTitle",pageTitle);

        mainFragment.setArguments(string);
        return mainFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            pageTitle = getArguments().getString(PAGE_TITLE);
            menu_id = getArguments().getInt(MENU_ID);
            Log.d("MF Menu_ID",":" + menu_id);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // fragment*.xml 파일을 불러와서 화면을 그리는 부분
        View rootView
                = inflater.inflate(R.layout.fragment_man,container,false);

        RecyclerView recyclerView = rootView.findViewById(R.id.frag_list);

        // 데이터 가져오기
//        GoDataGetterService goGetter = new GoDataGetterService();
//        List<GoDataListVO> goDataList = goGetter.execute(100)

        GodataGetterService goGetter = new GodataGetterService();
        try {
            List<GoDataListVO> goDataList
                    = (List<GoDataListVO>)goGetter.execute(menu_id).get();

            GoDataViewAdapter adapter = new GoDataViewAdapter(goDataList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


//        TextView textView = rootView.findViewById(R.id.page_title);
//        textView.setText("메롱");

        return rootView ;

//        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
