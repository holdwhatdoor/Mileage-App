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

    public static synchronized AppDB getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDB.class,
                            Mileage_DB)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

}
