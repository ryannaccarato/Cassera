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

public class FeedbackExpandableListAdapter extends BaseExpandableListAdapter {

    //region Fields
    private List<AvailableLessonsItem> mAvailableLessonsItemList;
    private Context mContext;
    //endregion

    //region Constructor
    public FeedbackExpandableListAdapter(Context context, List<AvailableLessonsItem> availableLessonsItems) {
        mContext = context;
        mAvailableLessonsItemList = availableLessonsItems;
    }
    //endregion

    //region Public
    @Override
    public int getGroupCount() { return mAvailableLessonsItemList.size(); }

    @Override
    public int getChildrenCount(int groupPosition) { return 5; }

    @Override
    public Object getGroup(int groupPosition) { return mAvailableLessonsItemList.get(groupPosition); }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        AvailableLessonsItem availableLessonsItem = (AvailableLessonsItem)getGroup(groupPosition);
        switch (childPosition) {
            case 0:
                return "Id: " + availableLessonsItem.lessonId;
            case 1:
                return "Created: " + availableLessonsItem.createdOn;
            case 2:
                return "Completed: " + availableLessonsItem.completedOn;
            case 3:
                return "Status: " + availableLessonsItem.status;
            case 4:
                return "Notes: " + availableLessonsItem.notes;
        }
        return "";
    }

    @Override
    public long getGroupId(int groupPosition) { return getGroup(groupPosition).hashCode(); }

    @Override
    public long getChildId(int groupPosition, int childPosition) { return getChild(groupPosition, childPosition).hashCode(); }

    @Override
    public boolean hasStableIds() { return true; }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        AvailableLessonsItem group = (AvailableLessonsItem) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_group, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.textView_ListViewGroup_Header);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(String.format("Lesson %1$s: %2$s", group.lessonNumber, group.title));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_group_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.textView_ListViewGroup_Item);
        txtListChild.setText(child);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return false; }
    //endregion
}
