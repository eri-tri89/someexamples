package com.erikperez.pictureviewer.multiple.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.erikperez.pictureviewer.R;

public class OneDogFragment extends Fragment {


    public OneDogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_one_dog, container,false);
        Button btn = (Button)rootView.findViewById(R.id.multiButton1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "I say goffff!", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

}
