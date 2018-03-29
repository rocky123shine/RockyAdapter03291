package com.study.rocky.rockyadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public abstract class RockyBaseLVAdapter<M> extends BaseAdapter implements IRockyAdapter<M, RockyHolder> {
    private List<M> mList = new ArrayList<>();

    @Override
    public int getCount() {
        return modelSize();
    }

    @Override
    public M getItem(int position) {
        return getCurrentItemModel(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RockyHolder holder = null;
        if (convertView == null) {
            holder = createViewHolder(LayoutInflater.from(parent.getContext()));
            convertView = holder.itemView;
            convertView.setTag(holder);
        } else {
            holder = (RockyHolder) convertView.getTag();
        }
        bindHolder(holder, position);
        return convertView;
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
    public void addAllModel(List<M> list) {
        if (list == null) {
            return;
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void clearAll() {
        mList.clear();
        notifyDataSetChanged();
    }


    @Override
    public M getCurrentItemModel(int position) {
        return mList.get(position);
    }

    @Override
    public int modelSize() {
        return mList.size();
    }

    @Override
    public RockyHolder createViewHolder(LayoutInflater inflater) {
        RockyHolder holder = new RockyHolder(inflater.inflate(setLayoutSource(), null));
        return holder;
    }

    public abstract int setLayoutSource();


}
