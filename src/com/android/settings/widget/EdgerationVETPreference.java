package com.android.settings.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;

import org.edgeration.sdk.R;
import org.edgeration.sdk.misc.Constants;
import org.edgeration.sdk.widget.ViewOp;

import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.RecyclerView;

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

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) mHolder.getLayoutParams();
        float margin = ViewOp.Dp2Px(getContext(), Constants.CORNER_RADIUS_IN_DP);
        params.setMargins((int) margin, (int) margin / 2, (int) margin, 0);
        mHolder.setLayoutParams(params);

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
