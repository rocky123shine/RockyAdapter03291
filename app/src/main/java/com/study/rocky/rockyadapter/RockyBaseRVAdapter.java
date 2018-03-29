package com.study.rocky.rockyadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/3/29 0029.
 */

public abstract class RockyBaseRVAdapter<M> extends RecyclerView.Adapter implements
        IRockyAdapter<M,RockyHolder> {
    //列表数据 集合
    protected List<M> mList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createViewHolder(LayoutInflater.from(parent.getContext()));

    }

    @Override
    public RockyHolder createViewHolder(LayoutInflater inflater) {
        RockyHolder holder = new RockyHolder(inflater.inflate(setLayoutSource(), null));
        return holder;
    }

    protected abstract int setLayoutSource();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.itemView.setLayoutParams(lp);
        bindHolder((RockyHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return modelSize();
    }

    @Override
    public void addAllModel(List<M> list) {
        if (list == null) {
            return;
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void addModel(M model) {
        if (model == null) {
            return;
        }
        mList.add(model);
        notifyDataSetChanged();
    }

    @Override
    public M getCurrentItemModel(int position) {

        if (0 <= position && position < mList.size()) {
            return mList.get(position);

        } else {
            return null;
        }
    }

    @Override
    public int modelSize() {
        return mList.size();
    }

    @Override
    public void clearAll() {
        mList.clear();
        notifyDataSetChanged();
    }


}
