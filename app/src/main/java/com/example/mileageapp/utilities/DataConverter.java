package com.example.mileageapp.utilities;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataConverter {

    @TypeConverter
    public static Date toDate(){
        Date date = null;

        return date;
    }

}
