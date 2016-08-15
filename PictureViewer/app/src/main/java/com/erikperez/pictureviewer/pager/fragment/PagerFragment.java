package com.erikperez.pictureviewer.pager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erikperez.pictureviewer.R;

public class PagerFragment extends Fragment {

    private static String POSITION = "position", IMAGE_ID = "imageId";

    public PagerFragment() {
        // Required empty public constructor
    }

    public static PagerFragment newInstance(int position, int[] image){
        PagerFragment newFrag = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        bundle.putInt(IMAGE_ID, image[position]);
        newFrag.setArguments(bundle);
        return newFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pager, container, false);

        int imageId = getArguments().getInt(IMAGE_ID);
        int position = getArguments().getInt(POSITION);

        TextView textView = (TextView)rootView.findViewById(R.id.pagerTextView);
        String defaultString = getActivity().getString(R.string.pager_text_view);

        textView.setText(defaultString + position);

        ImageView imageView = (ImageView)rootView.findViewById(R.id.pagerImageView);
        imageView.setImageResource(imageId);

        Toast.makeText(getActivity(), "Page #"+position, Toast.LENGTH_SHORT).show();

        return rootView;
    }

}
