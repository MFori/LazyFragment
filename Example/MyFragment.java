package cz.martinforejt.slider.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cz.martinforejt.slider.R;

/**
 * Created by Martin Forejt on 29.10.2016.
 * forejt.martin97@gmail.com
 */

public class MyFragment extends LazyFragment {

    // newInstance constructor for creating fragment with arguments
    public static MyFragment newInstance(String title) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment, container, false);
    }

    @Override
    public void onFirstVisible(){
        // load data here
        Toast.makeText(getActivity(), "Data loading", Toast.LENGTH_LONG).show();
        super.onFirstVisible();
    }

    @Override
    public void onVisibilityChange(boolean isVisible) {
        if(isVisible) {
            Toast.makeText(getActivity(), "Visible", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Invisible", Toast.LENGTH_LONG).show();
        }
    }
}
