package com.janedales.giftmywishclone.data.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateHelper {

    public static long getDaysLeft(String date){
        String s = date.split("T")[0];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date firstDate = Calendar.getInstance().getTime();
            Date secondDate = sdf.parse(s);

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return diff;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
