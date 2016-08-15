package com.erikperez.pictureviewer.multiple.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.erikperez.pictureviewer.R;

public class MultipleMenuFragment extends Fragment {

    Fragment frag;
    FragmentTransaction fragmentTransaction;

    public MultipleMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_multiple_menu, container, false);

        frag = new OneDogFragment();
        fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.fragContainer, frag);
        fragmentTransaction.commit();

        Button btn1 = (Button)rootView.findViewById(R.id.multiMenuBtn1);
        Button btn2 = (Button)rootView.findViewById(R.id.multiMenuBtn2);
        Button btn3 = (Button)rootView.findViewById(R.id.multiMenuBtn3);

        btn1.setOnClickListener(changeFragment(new OneDogFragment()));
        btn2.setOnClickListener(changeFragment(new TwoDogsFragment()));
        btn3.setOnClickListener(changeFragment(new ThreeDogsFragment()));


        return rootView;
    }

    private View.OnClickListener changeFragment(final Fragment newFrag){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag = newFrag;
                fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.fragContainer, frag);
                fragmentTransaction.commit();
            }
        };
    }

}
