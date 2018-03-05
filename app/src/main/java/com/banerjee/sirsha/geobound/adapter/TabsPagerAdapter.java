package com.banerjee.sirsha.geobound.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import com.banerjee.sirsha.geobound.R;
import com.banerjee.sirsha.geobound.fragment.ContainerFragment;
import com.banerjee.sirsha.geobound.fragment.LocationFragment;
import com.banerjee.sirsha.geobound.fragment.SettingsFragment;

/**
 * Created by S.B. on 27/2/18.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 3;
//    private String[] titles = new String[]{"First Fragment", "Second Fragment", "Third Fragment"};

    Drawable myDrawable;
    String title;

    private Context context;

    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ContainerFragment();
            case 1:
                return new LocationFragment();
            case 2:
                return new SettingsFragment();
            default:
                return null;
        }

    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
//        return  titles[position];

        switch (position) {
            case 0:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_home_icon);
                title = context.getResources().getString(R.string.label_home);
                break;
            case 1:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_location_icon);
                title = context.getResources().getString(R.string.label_location);
                break;
            case 2:
                myDrawable = context.getResources().getDrawable(R.drawable.ic_settings);
                title = context.getResources().getString(R.string.label_settings);
                break;

            default:
                break;
        }
        final SpannableStringBuilder sb = new SpannableStringBuilder("      " + title); // space added before text for convenience
        try {
//            myDrawable.setBounds(0, 5, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
            myDrawable.setBounds(0, 5, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
            ImageSpan span = new ImageSpan(myDrawable, DynamicDrawableSpan.ALIGN_BASELINE);
            sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return sb;
    }
}
