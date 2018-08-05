package com.example.android.ongoletourguide;

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mTitle;
    private String mSubTitle;
    private String mAddress;
    private String mAboutOngole;
    private String mPlaceLink;
    private String mPhoneNumber;
    private int mOngoleImageResourceId;
    private float mRating;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String title, String subTitle, String address, String placeLink, int imageResourceId, float rating, String phoneNumber) {
        mTitle = title;
        mSubTitle = subTitle;
        mAddress = address;
        mImageResourceId = imageResourceId;
        mPlaceLink = placeLink;
        mRating = rating;
        mPhoneNumber = phoneNumber;
    }

    public Word(String title, String subTitle, String address, String placeLink, float rating, String phoneNumber) {
        mTitle = title;
        mSubTitle = subTitle;
        mAddress = address;
        mPlaceLink = placeLink;
        mRating = rating;
        mPhoneNumber = phoneNumber;
    }

    public Word(String aboutOngole, int ongoleImageResourceId) {
        mAboutOngole = aboutOngole;
        mOngoleImageResourceId = ongoleImageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getAboutOngole() {
        return mAboutOngole;
    }

    public String getPlaceLink() {
        return mPlaceLink;
    }

    public int getOngoleResourceId() {
        return mOngoleImageResourceId;
    }

    public float getRating() {
        return mRating;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }
}
