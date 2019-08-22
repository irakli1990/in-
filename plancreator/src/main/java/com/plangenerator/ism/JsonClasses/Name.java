
package com.plangenerator.ism.JsonClasses;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Name {

    @SerializedName("en")
    private String mEn;
    @SerializedName("pl")
    private String mPl;

    public String getEn() {
        return mEn;
    }

    public void setEn(String en) {
        mEn = en;
    }

    public String getPl() {
        return mPl;
    }

    public void setPl(String pl) {
        mPl = pl;
    }

}
