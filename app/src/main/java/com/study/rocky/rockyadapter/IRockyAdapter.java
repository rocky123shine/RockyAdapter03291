package com.study.rocky.rockyadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by Rocky on 2018/3/29 0029.
 * <p>
 * 这里提供 adapter 的公共方法
 */

//第一步 泛型 给出实体类 设置数据 和 缓存类
public interface IRockyAdapter<M,H> {
    //提供获取当前Item 的实体类对象
    M getCurrentItemModel(int position);

    //提供 添加实体类对象的方法
    void addModel(M model);

    //设置数据
    void addAllModel(List<M> list);

    //提供获取 当前数据的总条数
    int modelSize();

    //设置 通用的holder  这里使用RecyclerView 的Holder
    H createViewHolder(LayoutInflater inflater);

    //绑定数据
    void bindHolder(H holder, int position);
    void clearAll();


}
