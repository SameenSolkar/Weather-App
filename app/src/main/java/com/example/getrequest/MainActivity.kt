package com.example.getrequest

import com.example.getrequest.RetrofitInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import retrofit2.HttpException
import retrofit2.http.Tag
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("oncreate","oncreate init")

        val TAG:String = "Main"
        val temp :TextView = findViewById(R.id.temperature)
        val climate :TextView = findViewById(R.id.climate)
        val location:TextView =findViewById(R.id.location)
        val editText:EditText = findViewById(R.id.inputlocation)
        val iconImage:ImageView = findViewById(R.id.iconImage)

        lifecycleScope.launchWhenCreated {
            val response =
                    try {
                            RetrofitInstance.api.getWeatherData(q="Mumbai",appid = "d5b56fd07988143ae141503ed9d81742",unit = "metric")
                    }
                    catch (e: IOException){
                        Log.e("Error",e.toString())
                        return@launchWhenCreated
                    }
                    catch (e: HttpException){
                        Log.e("Error","Http Exception ")
                        return@launchWhenCreated
                    }
            if (response.isSuccessful && response.body()!=null){
                Log.i("Data",response.body().toString())
                val tempdata = response.body()
                val climatedata = response.body()
                val locationdata = response.body()
                val icondata = response.body()
                temp.setText(tempdata!!.main.temp.toString()+"°C")
                climate.setText(climatedata!!.weather[0].main)
                location.setText(locationdata!!.name.toString())
                val icon:String = icondata!!.weather[0].icon

                when (icon){
                    "01d" -> iconImage.setImageResource(R.drawable._01d)
                    "01n" -> iconImage.setImageResource(R.drawable._01n)
                    "02d" -> iconImage.setImageResource(R.drawable._02d)
                    "02n" -> iconImage.setImageResource(R.drawable._02n)
                    "03d" -> iconImage.setImageResource(R.drawable._03d)
                    "03n" -> iconImage.setImageResource(R.drawable._03n)
                    "04d" -> iconImage.setImageResource(R.drawable._04d)
                    "04n" -> iconImage.setImageResource(R.drawable._04n)
                    "09d" -> iconImage.setImageResource(R.drawable._09d)
                    "09n" -> iconImage.setImageResource(R.drawable._09n)
                    "10d" -> iconImage.setImageResource(R.drawable._10d)
                    "10n" -> iconImage.setImageResource(R.drawable._10n)
                    "11d" -> iconImage.setImageResource(R.drawable._11d)
                    "11n" -> iconImage.setImageResource(R.drawable._11n)
                    "13d" -> iconImage.setImageResource(R.drawable._13d)
                    "13n" -> iconImage.setImageResource(R.drawable._13n)
                    "50d" -> iconImage.setImageResource(R.drawable._50d)
                    "50n" -> iconImage.setImageResource(R.drawable._50n)
                }

            }
        }

        editText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                lifecycleScope.launchWhenCreated {
                    val response =
                            try {

                                if(editText.text.toString().isNotEmpty()) {
                                    RetrofitInstance.api.getWeatherData(q=editText.text.toString(),appid = "d5b56fd07988143ae141503ed9d81742",unit = "metric")
                                }

                                else{
                                    RetrofitInstance.api.getWeatherData(q="Mumbai",appid = "d5b56fd07988143ae141503ed9d81742",unit = "metric")
                                }

                            }
                            catch (e: IOException){
                                Log.e("Error",e.toString())
                                return@launchWhenCreated
                            }
                            catch (e: HttpException){
                                Log.e("Error","Http Exception ")
                                return@launchWhenCreated
                            }
                    if (response.isSuccessful && response.body()!=null){
                        Log.i("Data",response.body().toString())
                        val tempdata = response.body()
                        val climatedata = response.body()
                        val locationdata = response.body()
                        val icondata = response.body()
                        temp.setText(tempdata!!.main.temp.toString()+"°C")
                        climate.setText(climatedata!!.weather[0].main)
                        location.setText(locationdata!!.name.toString())
                        val icon:String = icondata!!.weather[0].icon

                        when (icon){
                            "01d" -> iconImage.setImageResource(R.drawable._01d)
                            "01n" -> iconImage.setImageResource(R.drawable._01n)
                            "02d" -> iconImage.setImageResource(R.drawable._02d)
                            "02n" -> iconImage.setImageResource(R.drawable._02n)
                            "03d" -> iconImage.setImageResource(R.drawable._03d)
                            "03n" -> iconImage.setImageResource(R.drawable._03n)
                            "04d" -> iconImage.setImageResource(R.drawable._04d)
                            "04n" -> iconImage.setImageResource(R.drawable._04n)
                            "09d" -> iconImage.setImageResource(R.drawable._09d)
                            "09n" -> iconImage.setImageResource(R.drawable._09n)
                            "10d" -> iconImage.setImageResource(R.drawable._10d)
                            "10n" -> iconImage.setImageResource(R.drawable._10n)
                            "11d" -> iconImage.setImageResource(R.drawable._11d)
                            "11n" -> iconImage.setImageResource(R.drawable._11n)
                            "13d" -> iconImage.setImageResource(R.drawable._13d)
                            "13n" -> iconImage.setImageResource(R.drawable._13n)
                            "50d" -> iconImage.setImageResource(R.drawable._50d)
                            "50n" -> iconImage.setImageResource(R.drawable._50n)
                        }

                    }
                }
                false
            } else {
                false
            }
        }






    }
}