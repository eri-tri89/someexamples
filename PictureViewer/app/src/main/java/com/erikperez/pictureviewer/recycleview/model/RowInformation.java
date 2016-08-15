package com.erikperez.pictureviewer.recycleview.model;

/**
 * Created by GoreT on 8/13/2016.
 */
public class RowInformation {
    int iconId;
    String title, description, imagelink;

    public RowInformation() {
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
