package com.janedales.giftmywishclone.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity
public class Children {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @SerializedName("comments")
    private ArrayList<Comment> comments = new ArrayList<>();

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Children(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Ignore
    public Children(int id, ArrayList<Comment> comments) {
        this.id = id;
        this.comments = comments;
    }

    public Children(){}
}

