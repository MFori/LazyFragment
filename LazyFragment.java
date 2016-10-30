package cz.martinforejt.slider.viewpager;

import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;

/**
 * Created by Martin Forejt on 30.10.2016.
 * forejt.martin97@gmail.com
 */

public abstract class LazyFragment extends Fragment {

    private boolean _wasVisible = false;

    @CallSuper
    protected void onFirstVisible(){
        _wasVisible = true;
    }

    protected void onVisibilityChange(boolean isVisible) {
        throw new UnsupportedOperationException("method not overridden");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        // is full initialized
        if (LazyFragment.this.getActivity() == null) return;

        // is first show - lazy load data
        if (!_wasVisible) {
            onFirstVisible();
        }

        // call visibility change
        try {
            onVisibilityChange(isVisibleToUser);
        } catch (UnsupportedOperationException e){
            // child not override 'onVisibilityChange' method
        }
    }

}
