package com.example.ryann9309.cassera.Util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.ryann9309.cassera.Model.AvailableLessonsItem;
import com.example.ryann9309.cassera.R;
import java.util.List;

public class LessonsExpandableListAdapter extends BaseExpandableListAdapter {

    //region Fields
    private List<AvailableLessonsItem> mAvailableLessonsItems;
    private Context mContext;
    //endregion

    //region Constructor
    public LessonsExpandableListAdapter(Context context, List<AvailableLessonsItem> availableLessonsItems) {
        mContext = context;
        mAvailableLessonsItems = availableLessonsItems;
    }
    //endregion

    //region Public
    @Override
    public int getGroupCount() { return 1; }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mAvailableLessonsItems.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return "Previous Lessons";
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mAvailableLessonsItems.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getChild(groupPosition, childPosition).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_group, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.textView_ListViewGroup_Header);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(group);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        AvailableLessonsItem child = (AvailableLessonsItem) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_group_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.textView_ListViewGroup_Item);
        txtListChild.setText("Lesson " + child.lessonNumber);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    //endregion
}
