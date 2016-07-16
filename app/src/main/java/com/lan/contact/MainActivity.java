package com.lan.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

   // private List<Map<String,String>> list;
    private List<ConInfo> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView contact = (ListView) findViewById(R.id.contact);
        //list = ContactInfo.getContactInfo(this);
        lists = ContactInfo.getCon(this);
        System.out.println(lists.size());
      //  System.out.println("====="+list.size());


        contact.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return lists.size();
            }

            @Override
            public Object getItem(int i) {
                return lists.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                //优化：减少view的加载，避免卡顿情况
                Viewholder hold = new Viewholder();
                if(view == null){
                view = View.inflate(getApplicationContext(),R.layout.contact,null);
                hold.name = (TextView) view.findViewById(R.id.name);
                hold.num = (TextView) view.findViewById(R.id.num);

               /* hold.name.setText(list.get(i).get("name"));
                hold.num.setText(list.get(i).get("num"));
                view.setTag(hold);}else {
                   hold = (Viewholder) view.getTag();
                    hold.name.setText(list.get(i).get("name"));
                    hold.num.setText(list.get(i).get("num"));*/

                   hold.name.setText(lists.get(i).getName());
                    hold.num.setText(lists.get(i).getNum());
                    view.setTag(hold);}else {
                    hold = (Viewholder) view.getTag();
                    hold.name.setText(lists.get(i).getName());
                    hold.num.setText(lists.get(i).getNum());
                }
                return view;
            }
        });
    }
    private static class Viewholder {
        TextView name;
        TextView num;
    }
}
