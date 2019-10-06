package com.example.mileageapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShiftDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShift(Shift shift);

    @Delete
    void deleteShift(Shift shift);

    @Query("SELECT * FROM shift_table WHERE shiftId = :id")
    Shift getShiftById(int id);

    @Query("SELECT * FROM shift_table ORDER BY startShift")
    LiveData<List<Shift>> getAll();

    @Query("DELETE FROM shift_table")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM shift_table")
    int getCount();

}
