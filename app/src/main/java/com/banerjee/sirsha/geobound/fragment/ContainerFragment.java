package com.banerjee.sirsha.geobound.fragment;

import android.view.View;

import com.banerjee.sirsha.geobound.R;

/**
 * Created by S.B. on 28/2/18.
 */

public class ContainerFragment extends BaseFragment {

    @Override
    protected void initializeComponent(View view) {
        replaceFragment(R.id.fragment_container_flContainer, getActivity().getSupportFragmentManager(), new HomeFragment(), false);

    }

    @Override
    protected int defineLayoutResource() {
        return R.layout.fragment_container;
    }

    @Override
    public void onClick(View view) {

    }
}
