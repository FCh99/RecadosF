package com.example.faustocheca.recadosf.getservice;


import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by faustocheca on 14/9/16.
 */
public class Utils {
    Context context;
    public Date newDate;


    public Utils(Context context) {
        this.context = context;
    }

    /*
    Proceso de reformatear String a Date
    "Sep 14, 2016 9:07:00 AM"
    "M dd, yyyy hh:mm:ss a"



     */

    public Date myDateFormat (String date1) {

        SimpleDateFormat format = new SimpleDateFormat("M dd, yyyy hh:mm:ss a", Locale.FRANCE);
        try {
            newDate = format.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;




    }

}
