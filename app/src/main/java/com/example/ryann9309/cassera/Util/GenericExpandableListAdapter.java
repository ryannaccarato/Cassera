package com.example.ryann9309.cassera.Util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ryann9309.cassera.Model.CurrentLesson;
import com.example.ryann9309.cassera.Model.Feedback;
import com.example.ryann9309.cassera.Model.StudentAssignmentsItem;
import com.example.ryann9309.cassera.R;

public class GenericExpandableListAdapter extends BaseExpandableListAdapter {

    CurrentLesson mCurrentLesson;
    Context mContext;

    public GenericExpandableListAdapter(Context context, CurrentLesson currentLesson) {
        mContext = context;
        mCurrentLesson = currentLesson;
    }

    @Override
    public int getGroupCount() {
        return mCurrentLesson.studentAssignments.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((StudentAssignmentsItem)getGroup(groupPosition)).studentFeedback.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mCurrentLesson.studentAssignments.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ((StudentAssignmentsItem)getGroup(groupPosition)).studentFeedback.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return ((StudentAssignmentsItem)getGroup(groupPosition)).hashCode();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return ((Feedback)getChild(groupPosition, childPosition)).hashCode();
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
        String title = group.title;
        lblListHeader.setText(title == null || title.isEmpty() ? "Generic Title: " + group.assignmentId : title);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Feedback child = (Feedback) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_group_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.textView_ListViewGroup_Item);
        String message = child.message;
        txtListChild.setText(message == null || message.isEmpty() ? "Generic Feedback: " + child.hashCode() : message);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
