package com.example.ryann9309.cassera.Util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.ryann9309.cassera.Model.Feedback;
import com.example.ryann9309.cassera.Model.StudentAssignmentsItem;
import com.example.ryann9309.cassera.R;
import java.util.List;

public class LessonAssignmentsExpandableListAdapter extends BaseExpandableListAdapter {

    //region Fields
    private List<StudentAssignmentsItem> mStudentAssignmentsItems;
    private Context mContext;
    //endregion

    //region Constructor
    public LessonAssignmentsExpandableListAdapter(Context context, List<StudentAssignmentsItem> studentAssignmentsItems) {
        mContext = context;
        mStudentAssignmentsItems = studentAssignmentsItems;
    }
    //endregion

    //region Public
    @Override
    public int getGroupCount() {
        return mStudentAssignmentsItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String[] split = ((StudentAssignmentsItem)getGroup(groupPosition)).description.split("\\.");
        return split.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mStudentAssignmentsItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        /*StudentAssignmentsItem item = (StudentAssignmentsItem)getGroup(groupPosition);
        return item.studentFeedback.get(childPosition);*/
        String[] split = ((StudentAssignmentsItem)getGroup(groupPosition)).description.split("\\.");
        return split[childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return getGroup(groupPosition).hashCode();
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
        StudentAssignmentsItem group = (StudentAssignmentsItem) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_group, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.textView_ListViewGroup_Header);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(group.title);

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
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    //endregion
}
