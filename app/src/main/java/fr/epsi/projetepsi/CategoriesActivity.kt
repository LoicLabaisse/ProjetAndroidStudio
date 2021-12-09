package fr.epsi.projetepsi

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        showBtnBack()
        setHeaderTitle("Rayons")
        val categories = arrayListOf<Categories>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategory)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoriesAdapter = CategoriesAdapter(categories)
        recyclerView.adapter = categoriesAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null) {
                    val jsOb = JSONObject(data)
                    val jsArray = jsOb.getJSONArray("items")
                    for (i in 0 until jsArray.length()) {
                        val jsCategory = jsArray.getJSONObject(i)
                        val title = jsCategory.optString("title", "")
                        val productUrl = jsCategory.optString("product_url", "")
                        val id = jsCategory.optString("id", "")

                        val category = Categories(title = title, productUrl = productUrl, id = id)
                        categories.add(category)
                        Log.d("Category", category.title)
                    }
                    runOnUiThread(Runnable {
                        categoriesAdapter.notifyDataSetChanged()
                    })
                }
            }
        })
    }
}