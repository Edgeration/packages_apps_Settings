package org.edgeration.sdk.transponder;

import android.content.Context;
import android.util.AttributeSet;

import com.android.settings.widget.ToggleSwitch;

import org.edgeration.sdk.widget.EdgeSwitch;

import java.lang.ref.WeakReference;

import androidx.annotation.Nullable;

public class ToggleSwitchTransponder extends ToggleSwitch {
    WeakReference<EdgeSwitch> mEdgeSwitch;

    public ToggleSwitchTransponder(Context context) {
        super(context);
    }

    public ToggleSwitchTransponder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ToggleSwitchTransponder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ToggleSwitchTransponder(Context context, AttributeSet attributeSet, int i, int i1) {
        super(context, attributeSet, i, i1);
    }

    public void bindEdgeSwitch(EdgeSwitch edgeSwitch) {
        mEdgeSwitch = new WeakReference<>(edgeSwitch);
    }

    @Override
    public void setChecked(boolean b) {
        super.setChecked(b);
        if (mEdgeSwitch != null)
            mEdgeSwitch.get().setChecked(b, true);
    }

    @Override
    public void setCheckedInternal(boolean b) {
        super.setCheckedInternal(b);
        if (mEdgeSwitch != null)
            mEdgeSwitch.get().setChecked(b, true);
    }

    @Override
    public boolean isChecked() {
        return super.isChecked();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (mEdgeSwitch != null)
            mEdgeSwitch.get().setEnabled(enabled);
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (mEdgeSwitch != null)
            mEdgeSwitch.get().setVisibility(visibility);
    }

    @Override
    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener listener) {
        if (mEdgeSwitch != null)
            mEdgeSwitch.get().setOnCheckedChangeListener(listener);
    }
}
