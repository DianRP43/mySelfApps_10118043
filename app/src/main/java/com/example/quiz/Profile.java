package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    //(21 Mei 2021, 10118043, Dian Rosa Pratama, IF-01)
    Button callme, instagram, location;


    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        instagram = findViewById(R.id.btn_instagram);
//        callme = findViewById(R.id.btn_callme);
//        callme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callMe("tel:082118080393");
//            }
//        });
        instagram.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/dianrosapratama/");
            }
        });

        location = findViewById(R.id.btn_findme);

        location.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                gotoUrl("https://goo.gl/maps/4DsPTJeqfyopwSVf7");
            }
        });
        //ass
        drawerLayout = findViewById(R.id.DrawerLayout);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void ClickMenu(View view) {
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view) {
        HomeActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        //redirect to home
        HomeActivity.redirectActivity(this, HomeActivity.class);
    }

    public void ClickGallery(View view) {
        //redirect to gallery
        HomeActivity.redirectActivity(this, Gallery.class);
    }

    public void ClickDaily(View view) {
        //redirect to gallery
        HomeActivity.redirectActivity(this, Daily.class);
    }

    public void ClickMusic(View view) {
        //redirect to music
        HomeActivity.redirectActivity(this, Music.class);

    }

    public void ClickProfile(View view) {
        //recreate
        recreate();

    }

    public void ClickLogout(View view) {
        //close
        HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }

    public void ClickAbout(View view) {
        //redirect to Gallery
        About(this);
    }

    public static void About(final Activity activity) {
        //alert
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("About");
        //set message
        builder.setMessage("dip v0.01Aplikasi ini memuat data data pribadi tentang Dian Rosa Pratama ");

        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //dismiss dialog
                dialog.dismiss();

            }

        });
        //show dialog
        builder.show();
    }

    public void onButtonTap(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dianrosapratama2000@gmail.com"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{""});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(intent, null));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }

    public void callClick(View view) {
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:083822011677"));
        if (ContextCompat.checkSelfPermission(Profile.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Profile.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(intentCall);
        }
    }
}