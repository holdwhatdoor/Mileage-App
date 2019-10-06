package com.example.mileageapp.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "shift_table")
public class Shift {

    @PrimaryKey(autoGenerate = true)
    private int shiftId = 0;

    private Date startShift;
    private Date endShift;
    private long startMileage;
    private long endMileage;

    @Ignore
    public Shift(){}

    public Shift(int shiftId, Date startShift, Date endShift, long startMileage, long endMileage){
        this.shiftId = shiftId;
        this.startShift = startShift;
        this.endShift = endShift;
        this.startMileage = startMileage;
        this.endMileage = endMileage;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public Date getStartShift() {
        return startShift;
    }

    public void setStartShift(Date startShift) {
        this.startShift = startShift;
    }

    public Date getEndShift() {
        return endShift;
    }

    public void setEndShift(Date endShift) {
        this.endShift = endShift;
    }

    public long getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(long startMileage) {
        this.startMileage = startMileage;
    }

    public long getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(long endMileage) {
        this.endMileage = endMileage;
    }
}
