package com.example.gowsalya.waterdistributionlog.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gowsalya.waterdistributionlog.R;
import com.example.gowsalya.waterdistributionlog.activities.PumpInformationDetailActivity;
import com.example.gowsalya.waterdistributionlog.activities.PumpInformationListActivity;
import com.example.gowsalya.waterdistributionlog.listeners.TimeListener;
import com.example.gowsalya.waterdistributionlog.utils.DummyContent;
/** **/

/**
 * A fragment representing a single PumpInformation detail screen.
 * This fragment is either contained in a {@link PumpInformationListActivity}
 * in two-pane mode (on tablets) or a {@link PumpInformationDetailActivity}
 * on handsets.
 */
public class AllGatePumpFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AllGatePumpFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_gate_pump_layout, container, false);
        Button valveOnTime = (Button) rootView.findViewById(R.id.all_gate_valve_on_time);
        Button valveOffTime = (Button) rootView.findViewById(R.id.all_gate_valve_off_time);

        TimeListener timeListener = new TimeListener(getContext());

        valveOnTime.setOnClickListener(timeListener);
        valveOffTime.setOnClickListener(timeListener);

        return rootView;
    }
}
