package com.study.rocky.rockyadapter;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class TestLVAdapter extends RockyBaseLVAdapter<String> {
    @Override
    public void bindHolder(RockyHolder holder, int position) {
        holder.initView(R.id.tv_test,ViewType.TV);
        holder.setText(R.id.tv_test,getCurrentItemModel(position));
    }

    @Override
    public int setLayoutSource() {
        return R.layout.item_rv_test;
    }
}
