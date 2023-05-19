package com.example.lab4

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.READ_CONTACTS
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class Contacts : AppCompatActivity() {
    private val launcher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ map ->
        if(map.values.all{it}) {

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        checkPermissons()
    }


    private fun checkPermissons(){
        val isAllGranted = REQUEST_PERMISSION.all { permissons ->
            ContextCompat.checkSelfPermission(this@Contacts, permissons) == PackageManager.PERMISSION_GRANTED

        }
        if(isAllGranted ){

        }else{
            launcher.launch(REQUEST_PERMISSION)
        }
    }
    companion object{
        private val REQUEST_PERMISSION: Array<String> = buildList {
            add(READ_CONTACTS)
            add(CALL_PHONE)
        }.toTypedArray()
    }
}