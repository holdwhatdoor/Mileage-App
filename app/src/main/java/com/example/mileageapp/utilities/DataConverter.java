package com.example.mileageapp.utilities;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        Date date = null;

        return date;
    }

    @TypeConverter
    public static Long toLong(Date timestamp){
        Long date = null;

        return date;
    }

}
