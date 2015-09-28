package com.cfihackathon.alertindia.ui.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cfihackathon.alertindia.R;
import com.cfihackathon.alertindia.backend.model.AmberAlertItem;

import java.util.List;

/**
 * Created by someshk on 9/27/15.
 */
public class AmberAlertAdapter extends RecyclerView.Adapter<AmberAlertAdapter.ViewHolder> {
    private static final String TAG = "AmberAlertAdapter";
    private Context mContext;
    private List<AmberAlertItem> mDataset;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mSummaryV;
        public ImageView mThumbnailV;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getLayoutPosition() + " clicked.");
                    AmberAlertItem item = mDataset.get(getAdapterPosition());
                    onItemClick(item);
                }
            });

            mTextView = (TextView) v.findViewById(R.id.title);
            mSummaryV = (TextView) v.findViewById(R.id.summary);
            mThumbnailV = (ImageView) v.findViewById(R.id.thumbnail);

        }
        public TextView getTextView() {
            return mTextView;
        }
        public ImageView getThumbnailV() { return mThumbnailV; }
    }

    public AmberAlertAdapter(Context context, List<AmberAlertItem> dataset) {
        mContext = context;
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mDataset = dataset;
    }

    public void updateData(List<AmberAlertItem> dataset) {
        mDataset = dataset;
        notifyDataSetChanged();
    }

    public void onItemClick(AmberAlertItem item) {
        // FIXME - Add code to show the Amber Alert
//        AmberAlertDetail.start(mContext, item);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "AmberAlertAdapter: onCreateViewHolder");
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_amber_alert, parent, false);

        // TODO - Set the view's size, margins, paddings and layout parameters
        v.setBackgroundResource(mBackground);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - Get the element from the dataset at this positon
        // Replace the contents of the view with that element
        Log.d(TAG, "VideosAdapter: onBindViewHolder: Element = " + position);
        AmberAlertItem item =  mDataset.get(position);

        String thumbnail = "dummy";

        if(thumbnail!=null) {
//            Picasso.with(mContext).load(thumbnail).into(holder.getThumbnailV());
            // We don't need to have the background color so set it to Transparent color.
            // This reduces the GPU overdraw and improves the UI performance.
            holder.getThumbnailV().setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        if(mDataset!=null) {
            int size = mDataset.size();
            Log.d(TAG, "VideosAdapter: getItemCount: Items in dataset = " + size);
            return size;
        } else {
            // there are no items in the data set
            Log.d(TAG, "VideosAdapter: getItemCount: No items in data set");
            return 0;
        }
    }
}
