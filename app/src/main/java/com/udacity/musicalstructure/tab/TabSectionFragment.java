package com.udacity.musicalstructure.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.musicalstructure.R;
import com.udacity.musicalstructure.adapter.ThemeAdapter;
import com.udacity.musicalstructure.dummy.DummyContent;
import com.udacity.musicalstructure.model.Theme;
import com.udacity.musicalstructure.util.GridSpacingItemDecoration;
import com.udacity.musicalstructure.util.Transformation;

import java.util.List;


/**
 * Created by geovani on 26/10/16.
 */

public class TabSectionFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mArgument;

    protected List<Theme> mThemes;
    protected ThemeAdapter mThemeAdapter;
    public RecyclerView mRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mArgument = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }


    public TabSectionFragment() {
    }


    public static TabSectionFragment newInstance(int sectionNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        //
        TabSectionFragment fragment = new TabSectionFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_tab, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        //
        mThemes = DummyContent.initThemes(getContext(), mArgument);
        mThemeAdapter = new ThemeAdapter(getContext(), mThemes);
        setupRecyclerView(mRecyclerView, mThemeAdapter);
        mThemeAdapter.notifyDataSetChanged();
        return rootView;
    }


    private void setupRecyclerView(RecyclerView recyclerView, ThemeAdapter themeAdapter) {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, Transformation.dpToPx(10, getResources()), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(themeAdapter);
    }



}
