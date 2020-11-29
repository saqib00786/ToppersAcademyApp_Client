package com.example.toppersacademyapp.Model;
public class FacultyModel {
    private String mImageUrl;
    private String mFacName;
    private String mWorkAt;
    private String mEducation;
    private String mContact;

    private boolean expande;

    public FacultyModel() {
    }

    public FacultyModel(String mImageUrl, String mFacName, String mWorkAt, String mEducation, String mContact) {
        this.mImageUrl = mImageUrl;
        this.mFacName = mFacName;
        this.mWorkAt = mWorkAt;
        this.mEducation = mEducation;
        this.mContact = mContact;
        this.expande = false;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmFacName() {
        return mFacName;
    }

    public String getmWorkAt() {
        return mWorkAt;
    }

    public String getmEducation() {
        return mEducation;
    }

    public String getmContact() {
        return mContact;
    }

    public boolean isExpande() {
        return expande;
    }

    public void setExpande(boolean expande) {
        this.expande = expande;
    }

}