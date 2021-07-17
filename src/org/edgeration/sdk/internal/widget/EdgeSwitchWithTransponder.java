package org.edgeration.sdk.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import com.android.settings.widget.ToggleSwitch;

import org.edgeration.sdk.transponder.ToggleSwitchTransponder;
import org.edgeration.sdk.widget.EdgeSwitch;

import androidx.annotation.Nullable;

public class EdgeSwitchWithTransponder extends EdgeSwitch {
    ToggleSwitchTransponder mTransponder;

    public EdgeSwitchWithTransponder(Context context) {
        super(context);
        sanitize();
    }

    public EdgeSwitchWithTransponder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        sanitize();
    }

    public EdgeSwitchWithTransponder(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        sanitize();
    }

    public EdgeSwitchWithTransponder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        sanitize();
    }

    private void sanitize() {
        mTransponder = new ToggleSwitchTransponder(getContext());
        mTransponder.bindEdgeSwitch(this);
    }

    @Override
    protected void checkedChanged() {
        if (mListener != null) {
            if (mListener instanceof CompoundButton.OnCheckedChangeListener)
                ((CompoundButton.OnCheckedChangeListener) mListener).onCheckedChanged(mTransponder, mChecked);
            else if (mListener instanceof OnCheckedChangeListener)
                ((OnCheckedChangeListener) mListener).onCheckedChanged(this, mChecked);
        }
    }

    public ToggleSwitch getSwitch() {
        return mTransponder;
    }
}
