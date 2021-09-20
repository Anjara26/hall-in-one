package com.example.hallinonesport.model;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class LocaleDbAccessTest {

    private LocaleDbAccess db = new LocaleDbAccess(ApplicationProvider.getApplicationContext());

    @Test
    public void getEquipments() throws Exception {
        assertThat(db.getEquipments().size(), equalTo(18));
    }

    @Test
    public void getTrainings() throws Exception {
        assertThat(db.getTrainings().size(), equalTo(4));
    }
}