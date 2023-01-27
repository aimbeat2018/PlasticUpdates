package com.plasticupdates.activity;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.plasticupdates.R;


public class BaseActivity {
    static AlertDialog dialog;

    public static void progressDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.layout_loading_dialog);
        dialog = builder.create();
        dialog.setCancelable(false);
    }

    public static void showProgress() {
        try {
            if (dialog != null && !dialog.isShowing())
                dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideProgress() {
        try {
            if (dialog != null)
                if (dialog.isShowing())
                    dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
