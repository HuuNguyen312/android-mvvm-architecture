/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Entity(tableName = "questions")
public class Question {

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("question_img_url")
    @ColumnInfo(name = "question_img_url")
    public String imgUrl;

    @Expose
    @SerializedName("question_text")
    @ColumnInfo(name = "question_text")
    public String questionText;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}
