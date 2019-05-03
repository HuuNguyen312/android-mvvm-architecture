/*
 *  Copyright (C) 2019 GEVIETNAM
 */

package com.gevietnam.benekitchen.data.model.others;

import com.gevietnam.benekitchen.data.model.db.Option;
import com.gevietnam.benekitchen.data.model.db.Question;

import java.util.List;

/**
 * Created by HuuNguyen on 05/03/2019
 */

public class QuestionCardData {

    public boolean mShowCorrectOptions;

    public List<Option> options;

    public Question question;

    public QuestionCardData(Question question, List<Option> options) {
        this.question = question;
        this.options = options;
    }
}
