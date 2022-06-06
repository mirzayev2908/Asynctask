package com.example.asynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asynctask.databinding.ActivityMainBinding
import java.lang.Exception
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyAsyncTask().execute()

    }

    inner class MyAsyncTask : AsyncTask<Void, Void, Void>() {

        override fun onPreExecute() {
            super.onPreExecute()
            binding.tv.text = "Beginning"
        }

        override fun doInBackground(vararg p0: Void?): Void? {

            try {
                for (i in 0..100){
                    binding.progressBar.progress=i
                    TimeUnit.SECONDS.sleep(1)
                }

            } catch (e:Exception){
                e.printStackTrace()
            }
          //  binding.tv.text = "Running"
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            binding.tv.text = "Ending"
        }

    }
}