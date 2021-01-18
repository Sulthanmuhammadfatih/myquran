package co.id.sulthan.core.data.source.local.room

import androidx.paging.DataSource
import co.id.sulthan.core.data.source.local.entity.AyatEntity
import co.id.sulthan.core.data.source.local.entity.SurahEntity
import co.id.sulthan.core.domain.model.Ayat
import co.id.sulthan.core.domain.model.Surat
import retrofit2.http.Query
import java.nio.charset.CodingErrorAction.REPLACE

@QuranDao.Dao
interface QuranDao {

    @Insert(onConflict = REPLACE)
    fun insertSurah(meal: List<SurahEntity>)

    @Insert(onConflict = REPLACE)
    fun insertAyat(meal: List<AyatEntity>)

    @Query("SELECT * FROM surat")
    fun getSurahPagination(): DataSource.Factory<Int, Surat>

    @Query("SELECT * FROM ayat")
    fun getAyatPagination(): DataSource.Factory<Int, Ayat>

    @Query("DELETE FROM ayat")
    fun nukeAyatTable()

    @Query("DELETE FROM surat")
    fun nukeSuratTable()
}