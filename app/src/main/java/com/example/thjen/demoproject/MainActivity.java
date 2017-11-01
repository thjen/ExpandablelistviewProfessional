package com.example.thjen.demoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView lv;
    public static List<ItemGroup> listGroup = new ArrayList<>();
    EditText et_add;
    Button bt_add;

    public static HashMap<ItemGroup, List<ItemChild>> listChild = new HashMap<>();

    public static List<ItemChild> addlist = new ArrayList<>();

    CustomExpandableListView customExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ExpandableListView) findViewById(R.id.exLv);
        bt_add = (Button) findViewById(R.id.btAdd1);
        et_add = (EditText) findViewById(R.id.etAdd1);

        customExpandableListView = new CustomExpandableListView(this, listChild, listGroup);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listGroup.add(new ItemGroup(et_add.getText().toString(), 1, "Ok"));
                customExpandableListView.notifyDataSetChanged();
            }
        });

        lv.setAdapter(customExpandableListView);

        lv.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(MainActivity.this, " Close", Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(MainActivity.this, " Open", Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPositon, int childPosition, long l) {
                Toast.makeText(MainActivity.this, " " + listChild.get(listGroup.get(groupPositon)).get(childPosition).getsChild1(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPositon, long l) {
//                Toast.makeText(MainActivity.this," " + listGroup.get(groupPositon).getsGroup1(), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

    }

}
