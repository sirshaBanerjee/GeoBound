package com.banerjee.sirsha.geobound.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.banerjee.sirsha.geobound.R;

/**
 * Created by S.B. on 27/2/18.
 */

public class AddBoundFragment extends BaseFragment {

    private Button btnPickLocation;

    @Override
    protected void initializeComponent(View view) {

        btnPickLocation = view.findViewById(R.id.fragment_add_bound_btnPickLocation);

        btnPickLocation.setOnClickListener(this);

        setUpMap();
    }

    @Override
    protected int defineLayoutResource() {
        return R.layout.fragment_add_bound;
    }

    private void setUpMap() {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_add_bound_btnPickLocation:
                addFragment(R.id.fragment_container_flContainer, this, new PickPlaceFragment(),
                        false, false);
            default:
                break;
        }
    }

}
