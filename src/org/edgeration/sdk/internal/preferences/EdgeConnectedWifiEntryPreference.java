package org.edgeration.sdk.internal.preferences;

import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.settings.wifi.ConnectedWifiEntryPreference;
import com.android.wifitrackerlib.WifiEntry;

import org.edgeration.sdk.R;
import org.edgeration.sdk.widget.ViewOp;

import java.lang.reflect.Field;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.internal.PreferenceImageView;

public class EdgeConnectedWifiEntryPreference extends ConnectedWifiEntryPreference {
    public EdgeConnectedWifiEntryPreference(Context context, WifiEntry wifiEntry, Fragment fragment) {
        super(context, wifiEntry, fragment);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        View holderView = preferenceViewHolder.itemView;
        TextView titleView = holderView.findViewById(android.R.id.title);
        TextView summaryView = holderView.findViewById(android.R.id.summary);
        PreferenceImageView imageView = holderView.findViewById(android.R.id.icon);
        titleView.setTextColor(Color.WHITE);
        summaryView.setTextColor(Color.WHITE);
        summaryView.setAlpha(0.6f);
        ViewOp.reTintImage(imageView, Color.WHITE);
        WifiInfo info = getWifiInfo(getWifiEntry());
        if (info != null)
            titleView.append("Gen" + info.getWifiStandard());

        holderView.findViewById(com.android.settingslib.R.id.two_target_divider).setVisibility(View.GONE);

        holderView.setBackground(getContext().getDrawable(R.drawable.themed_single_item_corner));

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holderView.getLayoutParams();
        int eightDp = ViewOp.Dp2Px(getContext(), 8);
        layoutParams.setMargins(eightDp, eightDp, eightDp, eightDp);
        holderView.setLayoutParams(layoutParams);
    }

    private WifiInfo getWifiInfo(WifiEntry entry) {
        Class entryCls = WifiEntry.class;
        try {
            Field infoField = entryCls.getDeclaredField("mWifiInfo");
            return (WifiInfo) infoField.get(entry);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
