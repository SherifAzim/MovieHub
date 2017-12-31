package com.etiennelawlor.moviehub.data.database.models;

import io.realm.RealmObject;

/**
 * Created by etiennelawlor on 2/14/17.
 */

public class IntegerRealmModel extends RealmObject {

    // region Fields
    public Integer value;
    // endregion

    // region Getters
    public Integer getValue() {
        return value;
    }
    // endregion

    // region Setters
    public void setValue(Integer value) {
        this.value = value;
    }
    // endregion
}