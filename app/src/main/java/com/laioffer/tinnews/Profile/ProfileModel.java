package com.laioffer.tinnews.Profile;

import android.annotation.SuppressLint;

import com.laioffer.tinnews.TinApplication;
import com.laioffer.tinnews.database.AppDatabase;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = TinApplication.getDataBase();

    @SuppressLint("CheckResult")
    @Override
    public void deleteAllNewsCache() {
        Completable.fromAction(() -> db.newsDao().deleteAllNews()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            presenter.onCacheCleared();
        }, error -> {

        });
    }


    @Override
    public void setDefaultCountry(String country) {

    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
