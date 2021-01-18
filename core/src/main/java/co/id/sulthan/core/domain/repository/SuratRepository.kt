package co.id.sulthan.core.domain.repository


import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import co.id.sulthan.core.domain.model.Surat
import io.reactivex.Single

interface SuratRepository {

    fun getSurat() : Single<List<Surat>>

    fun saveSurah(surat: List<Surat>)

    fun getSuratAsPage() : LiveData<PagedList<Surat>>

    fun deleteSurat()

}