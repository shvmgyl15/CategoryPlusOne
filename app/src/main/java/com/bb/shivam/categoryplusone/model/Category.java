package com.bb.shivam.categoryplusone.model;

/**
 * Created by shivam on 27/08/17.
 */

public class Category {
    private String categoryName;
    private String parentCategoryId;
    private int distance;

    public Category(){

    }

    public Category(String categoryName, String parentCategoryId, int distance){
        setCategoryName(categoryName);
        setParentCategoryId(parentCategoryId);
        setDistance(distance);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
