package com.banerjee.sirsha.geobound.fragment;

import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.banerjee.sirsha.geobound.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

/**
 * Created by S.B. on 27/2/18.
 */

public class HomeFragment extends BaseFragment{


    private static final int PLACE_PICKER_REQUEST = 1000;
    private GoogleApiClient mClient;

    @Override
    protected void initializeComponent(View view) {
        final FloatingActionButton fab = view.findViewById(R.id.fragment_home_fabAddEvent);

        fab.setOnClickListener(this);

    }


    @Override
    protected int defineLayoutResource() {
        return R.layout.fragment_home;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_fabAddEvent:
                addFragment(R.id.fragment_container_flContainer, this, new AddBoundFragment(), false, false);
                break;
            default:
                break;
        }
    }
}
