/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.gevietnam.benekitchen.data.model.db.Option;
import java.util.List;

/**
 * Created by HuuNguyen on 05/03/2019
 */
@Dao
public interface OptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Option option);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Option> options);

    @Query("SELECT * FROM options")
    List<Option> loadAll();

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    List<Option> loadAllByQuestionId(Long questionId);
}
