package co.id.sulthan.core.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import co.id.sulthan.core.domain.model.Ayat
import io.reactivex.Single

interface AyatRepository {

    fun getAyat(nomorSurat: String): Single<List<Ayat>>

    fun saveAyat(ayat: List<Ayat>)

    fun getAyatAsPage() : LiveData<PagedList<Ayat>>

    fun deleteAyat()

}