
package com.plangenerator.ism.JsonClasses;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item {

    @SerializedName("course_id")
    private String mCourseId;
    @SerializedName("ects_credits_simplified")
    private Object mEctsCreditsSimplified;
    @SerializedName("fac_id")
    private String mFacId;
    @SerializedName("name")
    private Name mName;



    public Item(){}


    public Item(String mCourseId, Object mEctsCreditsSimplified, String mFacId, Name mName) {
        this.mCourseId = mCourseId;
        this.mEctsCreditsSimplified = mEctsCreditsSimplified;
        this.mFacId = mFacId;
        this.mName = mName;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public void setCourseId(String courseId) {
        mCourseId = courseId;
    }

    public Object getEctsCreditsSimplified() {
        return mEctsCreditsSimplified;
    }

    public void setEctsCreditsSimplified(Object ectsCreditsSimplified) {
        mEctsCreditsSimplified = ectsCreditsSimplified;
    }

    public String getFacId() {
        return mFacId;
    }

    public void setFacId(String facId) {
        mFacId = facId;
    }

    public Name getName() {

        return mName;
    }

    public void setName(Name name) {
        mName = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mCourseId='" + mCourseId + '\'' +
                ", mEctsCreditsSimplified=" + mEctsCreditsSimplified +
                ", mFacId='" + mFacId + '\'' +
                ", mName=" + mName +
                '}';
    }

}
