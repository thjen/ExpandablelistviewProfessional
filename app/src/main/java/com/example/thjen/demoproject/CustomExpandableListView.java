package com.example.thjen.demoproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListView extends BaseExpandableListAdapter {

    Context context;
    List<ItemGroup> listGroup;
    HashMap<ItemGroup, List<ItemChild>> listChild;

    public CustomExpandableListView(Context context, HashMap<ItemGroup, List<ItemChild>> listChild, List<ItemGroup> listGroup) {
        this.context = context;
        this.listChild = listChild;
        this.listGroup = listGroup;
    }

    @Override
    public int getGroupCount() {

        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {

        List childList = listChild.get(listGroup.get(i));
        if (childList == null) {
            return 0;
        }

        return listChild.get(listGroup.get(i)).size();

    }

    @Override
    public Object getGroup(int i) {
        return listGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {

        List childList = listChild.get(listGroup.get(i));
        if (childList == null ) {
            return 0;
        }

        return listChild.get(listGroup.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public static class ViewHolderGroup {

        TextView tv_group1, tv_group2;
        public static Button bt_addChild;

    }

    public class ViewHolderChild {

        TextView tv_child1, tv_child2;

    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {

        ViewHolderGroup holderGroup = new ViewHolderGroup();

        if ( view == null ) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.row_group, null);
            holderGroup.tv_group1 = view.findViewById(R.id.tv_group1);
            holderGroup.tv_group2 = view.findViewById(R.id.tv_group2);
            holderGroup.bt_addChild = view.findViewById(R.id.btAddChild);

            view.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup) view.getTag();
        }

        holderGroup.tv_group1.setText(listGroup.get(i).getsGroup1());
        holderGroup.tv_group2.setText(listGroup.get(i).getsGroup2());

        holderGroup.bt_addChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DialogAddChild.class);
                intent.putExtra("positon", i);
                context.startActivity(intent);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        ViewHolderChild holderChild = new ViewHolderChild();

        if ( view == null ) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.row_child, null);
            holderChild.tv_child1 = view.findViewById(R.id.tv_child1);
            holderChild.tv_child2 = view.findViewById(R.id.tv_child2);
            view.setTag(holderChild);
        } else {
            holderChild = (ViewHolderChild) view.getTag();
        }

        List childList = listChild.get(listGroup.get(i));
        if (childList != null && !childList.isEmpty()) {

            ItemChild child = (ItemChild) getChild(i, i1);
            holderChild.tv_child1.setText(" " + child.getsChild1());
            holderChild.tv_child2.setText(" " + child.getsChild2());

        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
