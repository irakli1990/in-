
package com.plangenerator.ism.JsonClasses;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Faculties {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private Name mName;

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
