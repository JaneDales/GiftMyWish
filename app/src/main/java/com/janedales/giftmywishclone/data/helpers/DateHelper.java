package com.janedales.giftmywishclone.data.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateHelper {

    private final static String TimeFormatIso8601Constant = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static String ACTIVE = "Active ";

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

    public static String getLastSeen(String time){
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dt = new SimpleDateFormat(TimeFormatIso8601Constant, Locale.getDefault());
        dt.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date dt2 = dt.parse(time);
            date.setTime(new Date(dt2.getTime()));

            Calendar now =  Calendar.getInstance();
            long diff = now.getTimeInMillis() - date.getTimeInMillis();

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = diff / daysInMilli;
            diff %= daysInMilli;

            long elapseHours = diff / hoursInMilli;
            diff %= hoursInMilli;

            long elapseMinutes = diff / minutesInMilli;
            diff %= minutesInMilli;

            long elapseSeconds = diff / secondsInMilli;

            long totalHours = elapseHours;
            if (elapsedDays > 0){
                totalHours += (elapsedDays * 24);
            }

            System.out.println("totalHours -> " + totalHours +
                    ", days ->" + elapsedDays +
                    ", minutes -> " + elapseMinutes +
                    ", seconds -> " + elapseSeconds
            );

            int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
            int month = date.get(Calendar.MONTH);

            if (totalHours < 24 && elapseHours >= 1L){
                return ACTIVE + elapseHours + "h " + elapseMinutes + "m ago";
            }
            else if (totalHours < 24 && elapseHours == 0L && elapseMinutes <= 0L){
                return ACTIVE + "1m ago";
            }
            else if (totalHours < 24 && elapseHours == 0L){
                return ACTIVE + elapseMinutes + "m ago";
            }
            else if (totalHours >= 25 && totalHours <= 47){
                return ACTIVE + "Yesterday";
            }
            else {
                return ACTIVE + getNameOfMonth(month) + " " + dayOfMonth;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getNameOfMonth(int month) {
        switch (month){
            case 0: return "Jan";
            case 1: return "Feb";
            case 2: return "Mar";
            case 3: return "Apr";
            case 4: return "May";
            case 5: return "Jun";
            case 6: return "Jul";
            case 7: return "Aug";
            case 8: return "Sep";
            case 9: return "Oct";
            case 10: return "Nov";
            default: return "Dec";
        }
    }
}
