package com.study.rocky.rockyadapter;

import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class RockyTestRVAdapter extends RockyBaseRVAdapter<String> {


    @Override
    protected int setLayoutSource() {
        return R.layout.item_rv_test;
    }

    @Override
    public void bindHolder(final RockyHolder holder, final int position) {
        holder.initView(R.id.tv_test, ViewType.TV);
        holder.setText(R.id.tv_test,getCurrentItemModel(position));
        holder.setOnClickListener(R.id.tv_test, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RockyTestRVAdapter", getCurrentItemModel(position));
            }
        });
    }
}
