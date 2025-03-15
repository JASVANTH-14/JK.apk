package com.example.jk

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendDeviceInfo()
    }

    private fun sendDeviceInfo() {
        Thread({
            try {
                val data: JSONObject = JSONObject()
                data.put("Device", Build.MODEL)
                data.put("Manufacturer", Build.MANUFACTURER)
                data.put("AndroidVersion", Build.VERSION.RELEASE)

                val url: URL = URL(SERVER_URL)
                val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
                conn.setRequestMethod("POST")
                conn.setRequestProperty("Content-Type", "application/json")
                conn.setDoOutput(true)

                val os: OutputStream = conn.getOutputStream()
                os.write(data.toString().getBytes())
                os.flush()
                os.close()

                val responseCode: Int = conn.getResponseCode()
                Log.d("JK", "Server Response: " + responseCode)
                conn.disconnect()
            } catch (e: Exception) {
                Log.e("JK", "Error: " + e.getMessage())
            }
        }).start()
    }

    companion object {
        private val SERVER_URL: String = "http://192.168.114.104:5000/receive"
    }
}