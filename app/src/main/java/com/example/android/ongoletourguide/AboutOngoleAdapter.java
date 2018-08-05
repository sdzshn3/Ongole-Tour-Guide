package com.example.android.ongoletourguide;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutOngoleAdapter extends RecyclerView.Adapter<AboutOngoleAdapter.ViewHolder> {

    private ArrayList<Word> mWord;
    private Context mContext;

    public AboutOngoleAdapter(Context context, ArrayList<Word> words) {
        mContext = context;
        mWord = words;
    }

    public Word getItem(int position) {
        return mWord.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_ongole, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word currentWord = getItem(position);
        Typeface semiBoldText = Typeface.createFromAsset(mContext.getAssets(), "Montserrat-SemiBold.ttf");
        Typeface regularText = Typeface.createFromAsset(mContext.getAssets(), "Montserrat-Regular.ttf");

        holder.aboutOngole.setTypeface(regularText);
        holder.aboutOngole.setText(currentWord.getAboutOngole());
        holder.ongoleTitleView.setTypeface(semiBoldText);
        holder.OngoleImageView.setImageResource(currentWord.getOngoleResourceId());
    }

    @Override
    public int getItemCount() {
        return mWord.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.aboutOngoleText)
        TextView aboutOngole;
        @BindView(R.id.ongoleTitle)
        TextView ongoleTitleView;
        @BindView(R.id.ongolePhoto)
        ImageView OngoleImageView;

        ViewHolder(View listItemView) {
            super((listItemView));
            ButterKnife.bind(this, listItemView);
        }
    }
}
