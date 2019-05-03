/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Entity(
        tableName = "options",
        foreignKeys = @ForeignKey(
                entity = Question.class,
                parentColumns = "id",
                childColumns = "question_id"
        )
)
public class Option {

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("is_correct")
    @ColumnInfo(name = "is_correct")
    public boolean isCorrect;

    @Expose
    @SerializedName("option_text")
    @ColumnInfo(name = "option_text")
    public String optionText;

    @Expose
    @SerializedName("question_id")
    @ColumnInfo(name = "question_id")
    public Long questionId;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}
