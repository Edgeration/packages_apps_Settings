package org.edgeration.sdk.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.android.settings.widget.ToggleSwitch;
import com.android.settings.R;

import org.edgeration.sdk.view.EdgerationViewBase;

import androidx.annotation.Nullable;

public class SwitchBarInternal extends EdgerationViewBase {
    TextView mTextView;
    ImageView mRestrictedIcon;
    CardView mCard;
    EdgeSwitchWithTransponder mEdgeSwitch;

    public SwitchBarInternal(Context context) {
        super(context);
        sanitize();
    }

    public SwitchBarInternal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        sanitize();
    }

    public SwitchBarInternal(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        sanitize();
    }

    public SwitchBarInternal(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        sanitize();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.widget_edge_switch_bar_internal;
    }

    private void sanitize() {
        mTextView = findViewById(R.id.switch_text);
        mRestrictedIcon = findViewById(R.id.restricted_icon);
        mEdgeSwitch = findViewById(R.id.switch_widget);
        mCard = findViewById(R.id.root);
    }

    public TextView getSwitchBarTextView() {
        return mTextView;
    }

    public ImageView getRestrictedIcon() {
        return mRestrictedIcon;
    }

    public EdgeSwitchWithTransponder getEdgeSwitch() {
        return mEdgeSwitch;
    }

    public ToggleSwitch getSwitch() {
        return mEdgeSwitch.getSwitch();
    }

    public CardView getCard() {
        return mCard;
    }
}
