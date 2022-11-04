package com.kkalkkalparrot.daily;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class MainActivity extends FragmentActivity {

    TabLayout tabs;
    Journal fragment1; //화면1
    Community fragment2; //화면2
    Finder fragment3; //화면3
    Habit_tracker fragment4; // 화면4
    
    int position; // 현재 화면

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Journal();
        fragment2 = new Community();
        fragment3 = new Finder();
        fragment4 = new Habit_tracker();

        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("탭1"));
        tabs.addTab(tabs.newTab().setText("탭2"));
        tabs.addTab(tabs.newTab().setText("탭3"));
        tabs.addTab(tabs.newTab().setText("탭4"));


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = fragment1;
                else if(position == 1)
                    selected = fragment2;
                else if(position == 2)
                    selected = fragment3;
                else if(position == 3)
                    selected = fragment4;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}