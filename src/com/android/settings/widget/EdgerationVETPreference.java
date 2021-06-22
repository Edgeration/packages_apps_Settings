package com.android.settings.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;

import org.edgeration.sdk.R;

import androidx.preference.PreferenceViewHolder;

public class EdgerationVETPreference extends ValidatedEditTextPreference{
    protected View mHolder;

    public EdgerationVETPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EdgerationVETPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EdgerationVETPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EdgerationVETPreference(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mHolder = holder.itemView;

        Configuration mConfiguration = getContext().getResources().getConfiguration();
        switch (mConfiguration.uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                mHolder.setBackground(getContext().getDrawable(R.drawable.single_item_corner_dark));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                mHolder.setBackground(getContext().getDrawable(R.drawable.single_item_corner_light));
                break;
        }
    }
}
