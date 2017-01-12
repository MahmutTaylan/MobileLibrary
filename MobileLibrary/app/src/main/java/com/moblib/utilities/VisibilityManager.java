package com.moblib.utilities;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;

import com.moblib.views.PlaceHolder;


public class VisibilityManager {
    private View[] mMainContent;
    private PlaceHolder mPlaceHolder;

    public VisibilityManager(@NonNull PlaceHolder placeHolder, View... mainContent) {
        this.mPlaceHolder = placeHolder;
        this.mMainContent = mainContent;
    }

    public void showMainContent() {
        setMainContentVisibility(View.VISIBLE);
    }

    public void showLoading(@StringRes String message){
        setMainContentVisibility(View.GONE);
        mPlaceHolder.showLoading(message);
    }

    public void showFailure(@StringRes String message){
        setMainContentVisibility(View.GONE);
        mPlaceHolder.showFailure(message);
    }

    private void setMainContentVisibility(int visibility) {
        if (mMainContent != null) {
            for (View view : mMainContent) {
                if (view != null) {
                    view.setVisibility(visibility);
                }
            }
        }
        if (visibility == View.VISIBLE) {
            mPlaceHolder.setVisibility(View.GONE);
            mPlaceHolder.removeAllViews();

        } else {
            mPlaceHolder.setVisibility(View.VISIBLE);
        }
    }
}
