package com.example.mileageapp.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepo {

    // AppRepo instance variable
    private static AppRepo appInstance;

    // Database variable and executor
    private AppDB mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    // LiveData variables for database table data
    private LiveData<List<Shift>> mShifts;

    // AppRepo constructor
    private AppRepo(Context context){
        mDb = AppDB.getInstance(context);
        mShifts = getAllShifts();
    }

    // LiveData list to get all shift data
    private LiveData<List<Shift>> getAllShifts() {
        return mDb.shiftDAO().getAll();
    }

    // Method to return shift by id
    public Shift getShiftById(int shiftId){
        return mDb.shiftDAO().getShiftById(shiftId);
    }

    // Inserts a shift into the database
    public void insertShift(final Shift shift) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.shiftDAO().insertShift(shift);
            }
        });
    }

    // Deletes a shift from the database
    public void deleteShift(final Shift shift) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.shiftDAO().deleteShift(shift);
            }
        });
    }

    // Deletes all shifts from the database
    public void deleteAllShifts() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.shiftDAO().deleteAll();
            }
        });
    }

    // Method to return instance of AppRepo variable
    public static AppRepo getAppInstance(Context context) {
        if(appInstance == null) {
            appInstance = new AppRepo(context);
        }
        return appInstance;
    }


}
