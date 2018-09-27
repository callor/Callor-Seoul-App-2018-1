package com.callor.woo_project.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.callor.woo_project.fragment.MainFragment;

import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    List<String> pageTitle ;
    int menu_id = 0;
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainPagerAdapter(FragmentManager fm, List<String> pageTitle) {
        super(fm);
        this.pageTitle = pageTitle;
    }

    public MainPagerAdapter(FragmentManager fm,int menu_id, List<String> pageTitle) {
        super(fm);
        this.pageTitle = pageTitle;
        this.menu_id = menu_id ;
        Log.d("MP Const",":" + menu_id );
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        // return super.getPageTitle(position);
        return pageTitle.get(position);

    }

    @Override
    public Fragment getItem(int position) {
//        return MainFragment.newInstance(pageTitle.get(position),menu_id);

        return new MainFragment(pageTitle.get(position), menu_id);

    }

    @Override
    public int getCount() {
        return pageTitle.size();
    }
}
