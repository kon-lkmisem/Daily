package com.kkalkkalparrot.daily;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Community extends Fragment {

    protected boolean setting = false;
    public ImageButton GL_Btn1;
    public LinearLayout con;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_group_list, container, false);


        GL_Btn1 = rootView.findViewById(R.id.groupList_bt1);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                showDialog(v.getTag().toString());
                Intent intent = new Intent(getContext(), GroupFeedsActivity.class);
                intent.putExtra("id", v.getTag().toString());
                startActivity(intent);
            }
        };

        //그룹 추가버튼 리스너
        GL_Btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                showDialog("그룹 조작 버튼 누름");
                if (setting == false) {
                    v.setRotation(45);
                    ((View) rootView.findViewById(R.id.groupListBackground)).setVisibility(View.VISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt1_t)).setVisibility(View.VISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt1_b)).setVisibility(View.VISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt2_t)).setVisibility(View.VISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt2_b)).setVisibility(View.VISIBLE);
                }else{
                    v.setRotation(0);
                    ((View) rootView.findViewById(R.id.groupListBackground)).setVisibility(View.INVISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt1_t)).setVisibility(View.INVISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt1_b)).setVisibility(View.INVISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt2_t)).setVisibility(View.INVISIBLE);
                    ((View) rootView.findViewById(R.id.groupList_opt2_b)).setVisibility(View.INVISIBLE);
                }
                setting = !setting;
            }
        });


        // 그룹 목록 생성 및 표시
        con = rootView.findViewById(R.id.groupList);
        LayoutInflater inflater2 = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(int i =0; i<10; i++) {

            String groupName = "그룹" + Integer.toString(i);
            String groupDescription = "그룹" + Integer.toString(i)+"에 대한 설명입니다.";
            String groupTags = "#태그1";
            for(int j=0;j<i;j++){
                groupTags+="#태그"+Integer.toString(j+2);
            }

            LinearLayout ll = new LinearLayout(getActivity());
            ll.setPadding(0,50,0,50);
            LinearLayout groupLayout = (LinearLayout) inflater2.inflate(R.layout.group_list_sub,null);
            groupLayout.setTag(Integer.toString(i));
            ((TextView)groupLayout.findViewById(R.id.groupName)).setText(groupName);
            ((TextView)groupLayout.findViewById(R.id.groupDescription)).setText(groupDescription);
            ((TextView)groupLayout.findViewById(R.id.groupTags)).setText(groupTags);
            groupLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            groupLayout.setOnClickListener(listener);

            ll.addView(groupLayout);
            con.addView(ll);
        }

        return rootView;
    }
}