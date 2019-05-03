/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.local.db;

import com.gevietnam.benekitchen.data.model.db.Option;
import com.gevietnam.benekitchen.data.model.db.Question;
import com.gevietnam.benekitchen.data.model.db.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public interface DbHelper {

    Observable<List<Question>> getAllQuestions();

    Observable<List<User>> getAllUsers();

    Observable<List<Option>> getOptionsForQuestionId(Long questionId);

    Observable<Boolean> insertUser(final User user);

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveOptionList(List<Option> optionList);

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveQuestionList(List<Question> questionList);
}
