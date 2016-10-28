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
import android.widget.TextView;

import com.udacity.musicalstructure.R;
import com.udacity.musicalstructure.adapter.ThemeAdapter;
import com.udacity.musicalstructure.dummy.DummyContent;
import com.udacity.musicalstructure.model.Theme;
import com.udacity.musicalstructure.useful.GridSpacingItemDecoration;
import com.udacity.musicalstructure.useful.Transformation;

import java.util.List;


/**
 * Created by geovani on 26/10/16.
 */

public class TabSectionFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    protected List<Theme> mThemes;
    protected ThemeAdapter mThemeAdapter;
    public RecyclerView mRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Bundle arguments = this.getArguments();
        if (arguments != null) {
            int sectionNumber = arguments.getInt(ARG_SECTION_NUMBER);
            mThemes = DummyContent.initThemes(getContext(), sectionNumber);
            //
//            setupTabMyFavorites(sectionNumber, mRecyclerView);
        }
        // Obseve que deve instanciar o adaptar antes de incluí-lo no RecyclerView, senão error
        mThemeAdapter = new ThemeAdapter(getContext(), mThemes);
        setupRecyclerView(mRecyclerView);
        //
        mThemeAdapter.notifyDataSetChanged();
        return rootView;
    }


    /**
     * Não estou usando
     * @param sectionNumber
     * @param view
     */
    @Deprecated
    private void setupTabMyFavorites(int sectionNumber, View view) {
        if (sectionNumber == 2) {
            TextView textView = new TextView(getContext());
            textView.setText(getString(R.string.empty_favorites));
            // ... Como faço para adicionar dinamicamente TextView no RecyclerView?
        }
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, Transformation.dpToPx(10, getResources()), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mThemeAdapter);
    }



}
