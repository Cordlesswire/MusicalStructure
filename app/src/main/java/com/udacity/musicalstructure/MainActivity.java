package com.udacity.musicalstructure;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.udacity.musicalstructure.tab.TabSectionFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);
        //
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //
        initCollapsingTabs();
        showHeaderBackgroud();
    }


    private void initCollapsingTabs() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tabslayout);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);
        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
        {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset)
            {
                if (scrollRange == -1)
                {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0)
                {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow)
                {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    public void showHeaderBackgroud() {
        try {
            Glide.with(this).load(R.drawable.music_header).into((ImageView) findViewById(R.id.image_view));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        String[] tabsName = getResources().getStringArray(R.array.tabs);

        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return TabSectionFragment.newInstance(position);
        }

        @Override
        public int getCount()
        {
            return tabsName.length;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return tabsName[0];
                case 1:
                    return tabsName[1];
                case 2:
                    return tabsName[2];
            }
            return null;
        }
    }



}
