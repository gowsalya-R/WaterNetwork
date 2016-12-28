package com.example.gowsalya.waterdistributionlog.listeners;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by Gowsalya on 13/6/16.
 */
public class TimeListener implements View.OnClickListener {
    private final Context context;

    public TimeListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(final View v) {
        final Calendar c = Calendar.getInstance();
        int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        int hour = hourOfDay > 12 ? hourOfDay - 12 : hourOfDay;
        ((Button) v).setText((hour == 0 ? 12 : hour) + " : " + (minute < 10 ? "0" : "") + minute + " " + (hourOfDay >= 12 ? "PM" : "AM"));

//        // Launch Time Picker Dialog
//        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
//                new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        int hour = hourOfDay > 12 ? hourOfDay - 12 : hourOfDay;
//                        ((Button) v).setText((hour == 0 ? 12 : hour) + " : " + (minute < 10 ? "0" : "") + minute + " " + (hourOfDay >= 12 ? "PM" : "AM"));
//                    }
//                }, mHour, mMinute, false);
//        timePickerDialog.show();

    }
}
