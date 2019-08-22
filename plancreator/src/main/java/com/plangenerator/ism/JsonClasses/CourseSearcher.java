
package com.plangenerator.ism.JsonClasses;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CourseSearcher {

    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("next_page")
    private Boolean mNextPage;


    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public Boolean getNextPage() {
        return mNextPage;
    }

    public void setNextPage(Boolean nextPage) {
        mNextPage = nextPage;
    }

}
