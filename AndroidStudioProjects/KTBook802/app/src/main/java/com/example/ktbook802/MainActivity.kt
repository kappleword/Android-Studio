package com.example.ktbook802

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ktbook802.databinding.ActivityMainBinding
import com.example.ktbook802.model.BestSellerDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binging: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)//바인딩된 데이터를 뿌림
//레트로핏구현체 생성
        val retrofit = Retrofit.Builder()
            .baseUrl("https://http://book.interpark.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val bookService = retrofit.create(BookService::class.java)
        bookService.getBestSellerBooks("")
            .enqueue(object: Callback<BestSellerDTO> {
                override fun onResponse(
                    call: Call<BestSellerDTO>,
                    response: Response<BestSellerDTO>
                ) {
                    if(response.isSuccessful.not()){
                        Log.e(TAG, "NOT!! SUCCESS")
                        return;
                    }
                    response.body()?.let {
                        Log.d(TAG, "body에서 꺼내오기"+it.toString())
                        it.books.forEach{book ->
                            Log.d(TAG, book.toString())
                        }
                    }
                }
                override fun onFailure(call: Call<BestSellerDTO>, t: Throwable) {
                    //실패처리
                    Log.e(TAG, t.toString())
                }
            })
    }////end of onCreate
    companion object{
        private const val TAG = "MainActivity"
    }
}