/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.gevietnam.benekitchen.data.local.db.dao.OptionDao;
import com.gevietnam.benekitchen.data.local.db.dao.QuestionDao;
import com.gevietnam.benekitchen.data.local.db.dao.UserDao;
import com.gevietnam.benekitchen.data.model.db.Option;
import com.gevietnam.benekitchen.data.model.db.Question;
import com.gevietnam.benekitchen.data.model.db.User;

/**
 * Created by HuuNguyen on 05/03/2019
 */

@Database(entities = {User.class, Question.class, Option.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract OptionDao optionDao();

    public abstract QuestionDao questionDao();

    public abstract UserDao userDao();
}
