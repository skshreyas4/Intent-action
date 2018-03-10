package com.example.skshr.actioninintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by skshr on 26-01-2018.
 */

public class FirstScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstscreen);
    }

    public void webview(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(i);

    }

    public void phone(View v) {
        String phno = "+919901454200";
        Intent g = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phno));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(g);
    }

    public void mail(View v) {
        Intent f = new Intent(Intent.ACTION_SEND);
        f.setData(Uri.parse("mailto:"));
        f.setType("text/plain");
        f.putExtra(Intent.EXTRA_EMAIL, new String("test@test.com"));
        f.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        f.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        startActivity(Intent.createChooser(f,"Send mail..."));
    }
    }



