package id.kalbenutritionals.imos.network_model

import com.google.gson.annotations.SerializedName

/**
 * Created by github.com/ilhamsuaib on 14/01/19.
 * modified by github.com/nurhidayat-agung 16/04/20
 */

data class NewsResponseModel(
    @field:SerializedName("status")
    val status: String?,
    @field:SerializedName("totalResults")
    val totalResults: Int?,
    @field:SerializedName("articles")
    val articles: List<NewsModel>
)