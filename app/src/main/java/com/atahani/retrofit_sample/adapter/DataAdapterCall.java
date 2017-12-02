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
import com.atahani.retrofit_sample.models.CallModel;
import com.atahani.retrofit_sample.utility.AppPreferenceTools;
import com.atahani.retrofit_sample.utility.shamsiDate;

import java.util.Collections;
import java.util.List;


/**
 *  Adapter show tweet in Recycler view
 */
public class DataAdapterCall extends RecyclerView.Adapter<DataAdapterCall.DataViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<CallModel> mData = Collections.emptyList();
    private DataEventHandler mDataEventHandler;
    private AppPreferenceTools mAppPreferenceTools;

    public DataAdapterCall(Context context, DataEventHandler dataEventHandler) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataEventHandler = dataEventHandler;
        mAppPreferenceTools = new AppPreferenceTools(this.mContext);
    }

    public void updateAdapterData(List<CallModel> data) {
        this.mData = data;
    }


    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        CallModel currentModel = mData.get(position);
        holder.mTxBody.setText(currentModel.Message);
        java.util.Date utilDate = currentModel.Date;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        String u= new String(sqlDate.toString());

        String[] m = u.split("-");

        shamsiDate shamsiDate =new shamsiDate();
       String date= shamsiDate.shamsiDate(Integer.parseInt(m[0]) ,Integer.parseInt(m[1]),Integer.parseInt(m[2]));

        String c = new String(currentModel.Date.toString());
        String time= (String) c.subSequence(11,19);
//date+ " "+time

        holder.mTxDate.setText(date+ " "+time );

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * view holder for tweet adapter we have one view as data_rowxml layout
     */
    public class DataViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLymain;
        private TextView mTxBody;
        private ImageView mImEdit;
        private ImageView mImDelete;
        private TextView mTxDate;

        public DataViewHolder(View itemView) {
            super(itemView);
            mLymain = (LinearLayout) itemView.findViewById(R.id.main);
            mTxBody = (TextView) itemView.findViewById(R.id.top_name);
            TextView text_det = (TextView) itemView.findViewById(R.id.bottom_text);

            TextView text1Head = (TextView) itemView.findViewById(R.id.name1);
            text1Head.setText("- تاریخ -");
            mTxDate = (TextView) itemView.findViewById(R.id.name2);
            mImEdit = (ImageView) itemView.findViewById(R.id.more);
            mImDelete = (ImageView) itemView.findViewById(R.id.delet);
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



    /**
     * define interface to handle events
     */
    public interface DataEventHandler {
        void onEditData(String Id, int position);

        void onDeleteData(String Id, int position);
        void onDetailData(String Id, int position);
    }
}
