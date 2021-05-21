package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class Music extends AppCompatActivity {
    Context contextVideo;
    RecyclerView recyclerViewVideo;
    RecyclerView.Adapter recyclerViewAdapterVideo;
    RecyclerView.LayoutManager recylerViewLayoutManagerVideo;
    String[] subjectValuesVideo = {
            "Video1"
    };
    String[] subjectUrlVideo = {
            "android.resource://"+ getPackageName() +"/" + R.raw.video2
    };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        contextVideo = getApplicationContext();
        recyclerViewVideo = findViewById(R.id.recyclerViewVideo);
        recylerViewLayoutManagerVideo = new LinearLayoutManager(contextVideo);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewVideo.setLayoutManager(recylerViewLayoutManagerVideo);
        recyclerViewAdapterVideo = new AdapterRecycleViewVideo(subjectValuesVideo,subjectUrlVideo,contextVideo );
        recyclerViewVideo.setAdapter(recyclerViewAdapterVideo);
        //ass
        drawerLayout = findViewById(R.id.DrawerLayout);
    }
    public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        HomeActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect to home
        HomeActivity.redirectActivity(this,HomeActivity.class);
    }
    public void ClickGallery(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Gallery.class);
    }

    public void ClickDaily(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Daily.class);
    }
    public void ClickMusic(View view){

        //recreate
        recreate();
    }
    public void ClickProfile(View view){
        //redirect to profile
        HomeActivity.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //close
        HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }
}