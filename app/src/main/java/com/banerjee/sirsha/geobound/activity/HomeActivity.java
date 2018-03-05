package com.banerjee.sirsha.geobound.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.banerjee.sirsha.geobound.R;
import com.banerjee.sirsha.geobound.adapter.TabsPagerAdapter;

public class HomeActivity extends BaseActivity {

    TabsPagerAdapter myAdapter;

    @Override
    protected int defineLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void initializeComponents() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPager vpPager =  findViewById(R.id.vpPager);
        myAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this);
        vpPager.setAdapter(myAdapter);
    }
}
