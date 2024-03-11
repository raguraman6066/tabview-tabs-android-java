package com.example.tab_navigation_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

//view pager -show multiple fragments on user swipes
public class MainActivity extends AppCompatActivity {
ViewPager2 pager2;
TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager2=findViewById(R.id.viewPager);
        ViewPagerAdapter vpa=new ViewPagerAdapter(this);
        pager2.setAdapter(vpa);
        tabLayout=findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position){
                    case 0:tab.setText("RED");break;
                    case 1:tab.setText("GREEN");break;
                    case 2:tab.setText("BLUE");break;
                }
            }
        }).attach();
    }

    class ViewPagerAdapter extends FragmentStateAdapter{

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch(position){
                case 0:return new RedFragment();
                case 1:return new GreenFragment();
                case 2:return new BlueFragment();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}