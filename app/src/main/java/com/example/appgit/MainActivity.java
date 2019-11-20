package com.example.appgit;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Uri telNumber;
    Intent call;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LocationManager managerLoc = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> fournisseurs= managerLoc.getAllProviders();
        for(String f : fournisseurs) {
            Toast.makeText(getApplicationContext(),"" +f,Toast.LENGTH_LONG ).show();
            if(f.equals(LocationManager.GPS_PROVIDER)){

            }


            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String []{Manifest.permission.RECEIVE_SMS}, 1 );
            }
            else {



            }



        }


/*

 /////////////////////////////WIFI///////////////////////////////////////////

        ConnectivityManager manager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo net = manager.getActiveNetworkInfo();

        if(net != null) {
            Log.d("TP", "state = " +net.getState().compareTo(NetworkInfo.State.CONNECTED));
            if(net.getState().compareTo(NetworkInfo.State.CONNECTED) == 0){
                Log.d("TP", "Connecté");
            }
           int type = net.getType();
            Log.d("TP","type =" +type);
        }

        WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(!wifi.isWifiEnabled()){
            wifi.setWifiEnabled(true);
            Log.d("TP","vient de se Connecter");
        }

        else {
            Log.d("TP","Connecte");
        }



/*
/////////////////////Envoi message/////////////////////////////////////

        SmsManager manager= SmsManager.getDefault();

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String []{Manifest.permission.RECEIVE_SMS}, 1 );
        }
        else {

            manager.sendTextMessage("tel:5554", null, "Hello, it's me...", null, null);


        }


     /*
       ////////////////////////////Lancer appel directement//////////////////////////

       telNumber = Uri.parse("tel:0666666666");
        call = new Intent(Intent.ACTION_CALL,  telNumber);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String []{Manifest.permission.CALL_PHONE}, 1 );
        }
         else {

             startActivity(call);

        }

    }

    public void onRequestPermissionResult(int requestCode, @NonNull String [] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case 1: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED);
                else {
                    Toast.makeText(this,"L'utilisateur a refuse", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }*/
    }
}
