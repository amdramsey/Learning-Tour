/*
 ********************************
 * Project name: Suq Althulatha *
 * Programmer: Ahmed Ramsey     *
 * Designer: Ahmed Ramsey       *
 ********************************
 */
package lib;

import android.content.Context;

public class Toast {

    public static void makeText(Context c, String txt) {

        android.widget.Toast.makeText(c, txt, android.widget.Toast.LENGTH_SHORT).show();

    }

}