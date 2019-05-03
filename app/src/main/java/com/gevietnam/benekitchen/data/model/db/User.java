/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Entity(tableName = "users")
public class User {

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @PrimaryKey
    public Long id;

    public String name;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}
