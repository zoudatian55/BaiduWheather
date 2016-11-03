package material.danny_jiang.com.baiduweatherdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by axing on 16/10/27.
 */

public class CommonAdapter<T> extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<T> list;
    private int layoutId;
    private int variableId;

    public CommonAdapter(Context context, List<T> list, int layoutId, int variableId) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding = null;

        if (convertView == null) {
            binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        binding.setVariable(variableId, list.get(position));

        return binding.getRoot();
    }
}
