package org.edgeration.sdk.internal.preferences;

import android.content.Context;
import android.view.ViewGroup;

import com.android.settingslib.wifi.LongPressWifiEntryPreference;
import com.android.wifitrackerlib.WifiEntry;

import org.edgeration.sdk.widget.ViewOp;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceViewHolder;

public class EdgeLongPressWifiEntryPreference extends LongPressWifiEntryPreference {
    public EdgeLongPressWifiEntryPreference(Context context, WifiEntry wifiEntry, Fragment fragment) {
        super(context, wifiEntry, fragment);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) preferenceViewHolder.itemView.getLayoutParams();
        int eightDp = ViewOp.Dp2Px(getContext(), 8);
        layoutParams.setMarginStart(eightDp);
        layoutParams.setMarginEnd(eightDp);
        preferenceViewHolder.itemView.setLayoutParams(layoutParams);
    }
}
