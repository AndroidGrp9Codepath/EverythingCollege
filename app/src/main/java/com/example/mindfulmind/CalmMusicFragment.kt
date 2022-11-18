package com.example.mindfulmind

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestHeaders
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class CalmMusicFragment : Fragment() {
    // Trailing slash is needed
    val baseURL = "https://accounts.spotify.com/"
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service :spotifyAPIInterface = retrofit.create(spotifyAPIInterface::class.java)
    var client_ID = "3dab13ce9fd94ea08c31bdbe9199520d"
    var client_Secret =  "16c67251d12f44279fd98e7a912f714d"


    var client_creds = ("$client_ID:$client_Secret")
    var endpoint: String = "https://api.spotify.com/v1/albums/6Wwyv7eqfjRaDZpbRsxEgp/tracks";

    val client_creds_b64: String = Base64.getEncoder().encodeToString(client_creds.toByteArray())
    var token_data = mapOf<String,String>("grant_type" to "client_credentials")
    var token_header = mapOf<String,String>("Authorization" to String(Base64.getDecoder().decode(client_creds_b64))) //Basic<base64 encoded client_id:client_secret>
    val listCall : Call<spotifyToken> = service.getToken("Basic $client_creds_b64","client_credentials")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getToken()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calm_music, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
    }

    companion object {
        fun newInstance(): CalmMusicFragment {
            return CalmMusicFragment()
        }
    }
    private fun getToken(){
        listCall.clone().enqueue(object : Callback<spotifyToken> {

            override fun onResponse(call: Call<spotifyToken>?, response: Response<spotifyToken>?) {
                if (response?.body() != null) {
                    var mAccessToken = response.body()!!.access_token
                    Log.i("Response!", mAccessToken)
                    apicall(mAccessToken)

                }
                if(response?.body() == null){
                    Log.i("Response!", "null response body")
                }
            }

            override fun onFailure(call: Call<spotifyToken>, t: Throwable) {
                Log.e("Error", t!!.message.toString())
            }

        })

    }
    fun apicall(mAccessToken: String) {
        val client = AsyncHttpClient()
        var params: RequestParams = RequestParams();
        var requestHeaders: RequestHeaders =  RequestHeaders();
        requestHeaders["Authorization"] = "Bearer $mAccessToken";

        client.get(
            endpoint,
            requestHeaders,
            params,
            object : JsonHttpResponseHandler() {
                override fun onSuccess(statusCode: Int, headers: okhttp3.Headers?, json: JSON?) {
                    Log.d("DEBUG", json?.jsonObject.toString())
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: okhttp3.Headers?,
                    response: String?,
                    throwable: Throwable?
                ) {
                    Log.d("DEBUG", response!!)
                }
            })

    }


}