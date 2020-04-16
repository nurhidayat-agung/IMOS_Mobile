package id.kalbenutritionals.imos.network_model

import com.google.gson.annotations.SerializedName

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

class NewsModel(
    @field:SerializedName("title")
    val title: String?,
    @field:SerializedName("description")
    val description: String?,
    @field:SerializedName("urlToImage")
    val urlToImage: String?,
    @field:SerializedName("publishedAt")
    val publishedAt: String?,
    @field:SerializedName("author")
    val author: String?
)