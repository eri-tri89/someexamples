package com.erikperez.pictureviewer.pager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.erikperez.pictureviewer.R;
import com.erikperez.pictureviewer.pager.fragment.PagerFragment;

/**
 * Created by GoreT on 8/13/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    int[] images = {R.drawable.one_dog, R.drawable.two_dogs, R.drawable.three_dogs, R.drawable.four_dogs, R.drawable.five_dogs, R.drawable.six_dogs};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(position, images);
    }

    @Override
    public int getCount() {
        return images.length;
    }
}
