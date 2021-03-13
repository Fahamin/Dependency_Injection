package com.kodiapps.fast.free.secure.dagger2test;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.core.content.PermissionChecker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Sha_Modeule {
    public Context context;

    public Sha_Modeule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContex()
    {
        return  context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharPref(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
