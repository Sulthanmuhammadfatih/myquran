package co.id.sulthan.core.data.source.remote.network

import co.id.sulthan.core.data.source.remote.response.ResponseAyat
import co.id.sulthan.core.data.source.remote.response.ResponseSurat
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("data")
    fun getAllSurat(): Single<ResponseSurat>

    @GET("surat/{nomor_surat}")
    fun getAyat(
        @Path("nomor_surat") nomor: String
    ): Single<ResponseAyat>
}