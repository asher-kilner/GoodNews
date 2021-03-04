package com.example.goodnews

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()

    }

    private fun getNews(){
        val url = "https://newsapi.org/v2/everything?q=Apple&from=2021-02-22&sortBy=popularity&apiKey=60c79275a2964eb38fff01f189d27ee7"
        val client = AsyncHttpClient()
        val params = RequestParams()
        client[url, params, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject?) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here

                Log.e("jsonData",response.toString())
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, res: String, t: Throwable) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)

                Toast.makeText(applicationContext, "fail $statusCode", Toast.LENGTH_SHORT).show()

            }
        }]
    }
}