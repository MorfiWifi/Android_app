package com.atahani.retrofit_sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atahani.retrofit_sample.R;
import com.atahani.retrofit_sample.models.UserModel;
import com.atahani.retrofit_sample.utility.AppPreferenceTools;

import java.util.Collections;
import java.util.List;

/**
 * Created by m.hosein on 11/12/2017.
 */

public class DataAdapterUser extends RecyclerView.Adapter<DataAdapterUser.DataViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<UserModel> mData = Collections.emptyList();
    private DataEventHandler mDataEventHandler;
    private AppPreferenceTools mAppPreferenceTools;

    public DataAdapterUser(Context context, DataEventHandler dataEventHandler) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataEventHandler = dataEventHandler;
        mAppPreferenceTools = new AppPreferenceTools(this.mContext);
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new DataViewHolder(view);
    }

    public void updateAdapterData(List<UserModel> data) {
        this.mData = data;
    }


    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        UserModel currentModel = mData.get(position);
        holder.mTxBody.setText(currentModel.UserName);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLymain;
        private TextView mTxBody;
        private ImageView mImEdit;
        private ImageView mImDelete;

        public DataViewHolder(View itemView) {
            super(itemView);
            mLymain = (LinearLayout) itemView.findViewById(R.id.main);
            mTxBody = (TextView) itemView.findViewById(R.id.top_name);
            TextView text_det = (TextView) itemView.findViewById(R.id.bottom_text);
            mImEdit = (ImageView) itemView.findViewById(R.id.more);
            mImDelete = (ImageView) itemView.findViewById(R.id.delet);

            TextView text1Head = (TextView) itemView.findViewById(R.id.name1);
            text1Head.setVisibility(View.GONE);
            TextView mTxDate = (TextView) itemView.findViewById(R.id.name2);
            mTxDate.setVisibility(View.GONE);


            mImDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mDataEventHandler != null) {
                        mDataEventHandler.onDeleteData(String.valueOf(mData.get(getAdapterPosition()).Id), getAdapterPosition());
                    }
                }
            });

            mImEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mDataEventHandler != null) {
                        mDataEventHandler.onEditData(String.valueOf(mData.get(getAdapterPosition()).Id), getAdapterPosition());
                    }
                }
            });

            text_det.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mDataEventHandler != null) {
                        mDataEventHandler.onDetailData(String.valueOf(mData.get(getAdapterPosition()).Id), getAdapterPosition());
                    }
                }
            });
        }

    }




    public interface DataEventHandler {
        void onEditData(String Id, int position);

        void onDeleteData(String Id, int position);
        void onDetailData(String Id, int position);
    }

}
