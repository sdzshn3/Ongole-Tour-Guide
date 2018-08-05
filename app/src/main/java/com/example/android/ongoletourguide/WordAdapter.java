package com.example.android.ongoletourguide;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    public View view;
    private ArrayList<Word> mWord;
    private Context mContext;
    private Typeface semiBoldText;
    private Typeface regularText;

    public WordAdapter(Context context, ArrayList<Word> words) {
        mContext = context;
        mWord = words;
    }

    private Word getItem(int position) {
        return mWord.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Word currentWord = getItem(position);

        semiBoldText = Typeface.createFromAsset(mContext.getAssets(), "Montserrat-SemiBold.ttf");
        regularText = Typeface.createFromAsset(mContext.getAssets(), "Montserrat-Regular.ttf");

        //All info variables of places
        String placeTitle = currentWord.getTitle();
        String placeSubTitle = currentWord.getSubTitle();
        String placeRatingValueString = String.valueOf(currentWord.getRating());
        float placeRatingValueFloat = currentWord.getRating();
        int placeImageResId = currentWord.getImageResourceId();

        holder.title.setTypeface(semiBoldText);
        holder.title.setText(placeTitle);
        holder.subTitle.setTypeface(regularText);
        holder.subTitle.setText(placeSubTitle);
        holder.ratingValue.setText(placeRatingValueString);

        if (currentWord.hasImage()) {
            holder.imageView.setImageResource(placeImageResId);
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        holder.ratingBar.setRating(placeRatingValueFloat);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder moreDetailsDialog = new AlertDialog.Builder(mContext);
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.place_detail_layout, null);
                moreDetailsDialog.setView(view);
                final AlertDialog dialog = moreDetailsDialog.create();

                ImageView dialogPlaceImage = view.findViewById(R.id.dialog_place_image);
                if (currentWord.hasImage()) {
                    dialogPlaceImage.setImageResource(currentWord.getImageResourceId());
                    dialogPlaceImage.setVisibility(View.VISIBLE);
                } else {
                    dialogPlaceImage.setVisibility(View.GONE);
                }

                TextView dialogPlaceTitle = view.findViewById(R.id.dialog_place_title);
                dialogPlaceTitle.setTypeface(semiBoldText);
                dialogPlaceTitle.setText(currentWord.getTitle());

                TextView dialogRatingValue = view.findViewById(R.id.dialog_rating_value);
                dialogRatingValue.setText(String.valueOf(currentWord.getRating()));

                RatingBar dialogRatingBar = view.findViewById(R.id.dialog_rating_of_place);
                dialogRatingBar.setRating(currentWord.getRating());

                TextView dialogPlaceAddress = view.findViewById(R.id.dialog_place_address);
                dialogPlaceAddress.setText(currentWord.getAddress());

                TextView dialogPlacePhoneNumber = view.findViewById(R.id.dialog_phone_number);
                dialogPlacePhoneNumber.setText(currentWord.getPhoneNumber());

                RelativeLayout visitMapsButton = view.findViewById(R.id.visit_maps);
                visitMapsButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentWord.getPlaceLink()));
                        mContext.startActivity(mapIntent);
                    }
                });

                RelativeLayout phoneCall = view.findViewById(R.id.phone_call);
                phoneCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!currentWord.getPhoneNumber().equals("NA")) {
                            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", currentWord.getPhoneNumber(), null));
                            mContext.startActivity(intent);
                        } else {
                            Toast.makeText(mContext, "Phone number not available", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                RelativeLayout sharePlace = view.findViewById(R.id.share_place);
                sharePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent share = new Intent(android.content.Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                        share.putExtra(Intent.EXTRA_SUBJECT, currentWord.getTitle());
                        share.putExtra(Intent.EXTRA_TEXT, currentWord.getPlaceLink());

                        mContext.startActivity(Intent.createChooser(share, "Share place!"));
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWord.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_text_view)
        TextView title;
        @BindView(R.id.subTitle_text_view)
        TextView subTitle;
        @BindView(R.id.rating_value_of_place)
        TextView ratingValue;
        @BindView(R.id.image)
        ImageView imageView;
        @BindView(R.id.rating_of_place)
        RatingBar ratingBar;

        ViewHolder(View listItemView) {
            super(listItemView);
            ButterKnife.bind(this, listItemView);
        }
    }
}
