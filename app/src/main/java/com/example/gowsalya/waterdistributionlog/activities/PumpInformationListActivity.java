package com.example.gowsalya.waterdistributionlog.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gowsalya.waterdistributionlog.R;
import com.example.gowsalya.waterdistributionlog.fragments.AllGatePumpFragment;
import com.example.gowsalya.waterdistributionlog.fragments.MainGatePumpFragment;
import com.example.gowsalya.waterdistributionlog.utils.Constants;
import com.example.gowsalya.waterdistributionlog.utils.DummyContent;

import java.util.List;


/** I have created master/detail flow Activity.It present list of items (ie master list) and its details.**/

/**
 * An activity representing a list of Informations. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link PumpInformationDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class PumpInformationListActivity extends AppCompatActivity {
    /** PumpInformationListActivity is the main activity of project ,displays master list to user **/

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // If the screen is small and it is not two pane,then the activity_pumpinformation_list.xml is used
        //This is the main layout for PumpInformationListActivity.java
        setContentView(R.layout.activity_pumpinformation_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        View recyclerView = findViewById(R.id.pumpinformation_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.scrollView) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pumpinformation_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);

            //onItemSelected() call back method is called,when the list item is selected

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(Constants.ARG_ITEM_ID, holder.mItem.id);
                        if (holder.mItem.id.equals(Constants.MAIN_GATE_ITEM_ID)) {
                            MainGatePumpFragment fragment = new MainGatePumpFragment();
                            fragment.setArguments(arguments);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.scrollView, fragment)
                                    .commit();
                        } else {
                            /**On smaller device displays,it involves launching a second activity
                             * in the form of the <kind_name>DetailActivity class
                             *  (which will then, in turn, create an instance of the <kind_name>DetailFragment class). **/
                            AllGatePumpFragment fragment = new AllGatePumpFragment();
                            fragment.setArguments(arguments);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.scrollView, fragment)
                                    .commit();
                        }
                    } else {
                        Context context = v.getContext();
                        //An activity represents single screen of an app and passing an intent makes to launch another activity (ie from pump list to pump detail activity)
                        Intent intent = new Intent(context, PumpInformationDetailActivity.class);
                        intent.putExtra(Constants.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
