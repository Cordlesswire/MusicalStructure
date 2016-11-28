package com.udacity.musicalstructure.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.udacity.musicalstructure.R;
import com.udacity.musicalstructure.detail.DetailActivity;
import com.udacity.musicalstructure.detail.ItemListActivity;
import com.udacity.musicalstructure.model.Theme;

import java.util.List;

/**
 * Created by geovani on 23/10/16.
 */

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.MyViewHolder> {

    public static final String EXTRA_THEME = "theme";
    private Context mContext;
    private List<Theme> mThemes;


    public ThemeAdapter(Context context, List<Theme> themes) {
        mContext = context;
        mThemes  = themes;
    }


    protected class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView count;
        public ImageView thumbnail;
        public View mView;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            title     = (TextView) itemView.findViewById(R.id.title);
            count     = (TextView) itemView.findViewById(R.id.count);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            mView     = itemView;
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_theme, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Theme theme = mThemes.get(position);
        holder.title.setText(theme.getName());
        holder.count.setText(String.format(mContext.getString(R.string.audios), theme.getNumOfSongs()));
        //
        Glide.with(mContext).load(theme.getImageId()).into(holder.thumbnail);
        //
        startActivityOnClick(holder);
    }


    /**
     * Se o usuário tocar na imagem vai para lista de músicas para poder executar as mesmas.
     * Se tocar no título do tema, irar para detalhes sobre o tema
     * @param holder
     */
    private void startActivityOnClick(MyViewHolder holder) {
        final Bundle params = new Bundle();
        params.putString(EXTRA_THEME, holder.title.getText().toString());
        //
        holder.thumbnail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Context context = v.getContext();
                Intent intent = new Intent(context, ItemListActivity.class);
                intent.putExtras(params);
                //
                context.startActivity(intent);
            }
        });
        holder.mView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtras(params);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mThemes.size();
    }



}
