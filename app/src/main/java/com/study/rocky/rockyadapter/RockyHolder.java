package com.study.rocky.rockyadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

//这是通用的holder  适合 RV和LV
public class RockyHolder extends RecyclerView.ViewHolder {

    private Map<Integer, View> mapView;
    private View itemRootView;

    public RockyHolder(View itemView) {
        super(itemView);
        this.itemRootView = itemView;
        mapView = new HashMap<>();
    }

    public RockyHolder setText(int view_id, String data) {
        if (!mapView.containsKey(view_id)) {
            Toast.makeText(itemRootView.getContext(), "控件为初始化", Toast.LENGTH_SHORT).show();
            return this;
        }
        ((TextView) mapView.get(view_id)).setText(data);
        return this;
    }


    public RockyHolder setImageView(int view_id, String url) {
        if (!mapView.containsKey(view_id)) {
            Toast.makeText(itemRootView.getContext(), "控件为初始化", Toast.LENGTH_SHORT).show();
            return this;
        }
//        ((ImageView) mapView.get(view_id))
        Toast.makeText(itemRootView.getContext(), "图片加载 暂时未设置", Toast.LENGTH_SHORT).show();
        return this;
    }

    public RockyHolder setButton(int view_id, String data) {
        if (!mapView.containsKey(view_id)) {
            Toast.makeText(itemRootView.getContext(), "控件为初始化", Toast.LENGTH_SHORT).show();
            return this;
        }
        ((Button) mapView.get(view_id)).setText(data);
        return this;
    }

    public RockyHolder initView(int id, ViewType type) {
        if (mapView.containsKey(id)) {
        } else {
            switch (type) {
                case TV:
                    mapView.put(id, (TextView) itemRootView.findViewById(id));
                    break;
                case IV:
                    mapView.put(id, (ImageView) itemRootView.findViewById(id));
                    break;
                case BTN:
                    mapView.put(id, (Button) itemRootView.findViewById(id));
                    break;
                case RV:
                    mapView.put(id, (RecyclerView) itemRootView.findViewById(id));
                    break;
                case LV:
                    mapView.put(id, (ListView) itemRootView.findViewById(id));
                    break;
                case LL:
                    mapView.put(id, (LinearLayout) itemRootView.findViewById(id));
                    break;
                case RL:
                    mapView.put(id, (RelativeLayout) itemRootView.findViewById(id));
                    break;
                case VIEW:
                    mapView.put(id, itemRootView.findViewById(id));
                    break;
                default:
                    mapView.put(id, itemRootView.findViewById(id));
            }

        }
        return this;
    }

    public RockyHolder setOnClickListener(int view_id, View.OnClickListener listener){
        if (!mapView.containsKey(view_id)) {
            Toast.makeText(itemRootView.getContext(), "控件"+view_id+"没有初始化", Toast.LENGTH_SHORT).show();
            return this;
        }
        mapView.get(view_id).setOnClickListener(listener);
        return this;
    }

    public RockyHolder setOnLongClickListener(int view_id, View.OnLongClickListener listener){
        if (!mapView.containsKey(view_id)) {
            Toast.makeText(itemRootView.getContext(), "控件为初始化", Toast.LENGTH_SHORT).show();
            return this;
        }
        mapView.get(view_id).setOnLongClickListener(listener);
        return this;
    }
}