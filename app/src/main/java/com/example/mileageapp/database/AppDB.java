package com.example.mileageapp.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mileageapp.utilities.DataConverter;

@Database(entities = {Shift.class}, version = 1, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class AppDB extends RoomDatabase{
    public static final String Mileage_DB = "MileageDatabase.db";

    private static AppDB instance;
    public static final Object LOCK = new Object();

    public abstract ShiftDAO shiftDAO();

}
