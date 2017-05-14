package com.example.android.slidingtabscolors.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.android.slidingtabscolors.R;
import com.example.android.slidingtabscolors.fragments.EightFragment;
import com.example.android.slidingtabscolors.fragments.ElevenFragment;
import com.example.android.slidingtabscolors.fragments.FiveFragment;
import com.example.android.slidingtabscolors.fragments.FourFragment;
import com.example.android.slidingtabscolors.fragments.NineFragment;
import com.example.android.slidingtabscolors.fragments.OneFragment;
import com.example.android.slidingtabscolors.fragments.SevenFragment;
import com.example.android.slidingtabscolors.fragments.SixFragment;
import com.example.android.slidingtabscolors.fragments.TenFragment;
import com.example.android.slidingtabscolors.fragments.ThreeFragment;
import com.example.android.slidingtabscolors.fragments.TwelveFragment;
import com.example.android.slidingtabscolors.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Musician");
        adapter.addFrag(new TwoFragment(), "Male Singers");
        adapter.addFrag(new ThreeFragment(), "Female Singers");
        adapter.addFrag(new FourFragment(), "Raag");
        adapter.addFrag(new FiveFragment(), "Taal");
        adapter.addFrag(new SixFragment(), "Strumming");
        adapter.addFrag(new SevenFragment(), "Theme");
        adapter.addFrag(new EightFragment(), "Gener");
        adapter.addFrag(new NineFragment(), "Movies");
        adapter.addFrag(new TenFragment(), "Actor");
        adapter.addFrag(new ElevenFragment(), "Actress");
        adapter.addFrag(new TwelveFragment(), "Others");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
