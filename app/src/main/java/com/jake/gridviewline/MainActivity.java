package com.jake.gridviewline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jake.library.GridViewLine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 100; i++)
        {
            data.add(i + "");
        }
        GridViewLine gridView = (GridViewLine)findViewById(R.id.gridView);
        gridView.setAdapter(mAdapter);
    }

    private BaseAdapter mAdapter = new BaseAdapter()
    {
        @Override
        public int getCount()
        {
            return data.size();
        }

        @Override
        public String getItem(int position)
        {
            return data.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder;
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_item, null);
                holder = new ViewHolder();
                holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
                convertView.setTag(holder);
            }
            else { holder = (ViewHolder)convertView.getTag(); }
            holder.tvName.setText(getItem(position));
            return convertView;
        }

        class ViewHolder
        {
            TextView tvName;
        }
    };
}
