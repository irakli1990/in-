
package com.plangenerator.ism.JsonClasses;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CourseCodeSearcher {

    @SerializedName("ects_credits_simplified")
    private Object mEctsCreditsSimplified;
    @SerializedName("fac_id")
    private String mFacId;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private Name mName;

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

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Name getName() {
        return mName;
    }

    public void setName(Name name) {
        mName = name;
    }

}
