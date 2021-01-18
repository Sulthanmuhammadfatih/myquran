package co.id.sulthan.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import co.id.sulthan.core.domain.model.Ayat
import co.id.sulthan.core.domain.repository.AyatRepository

class AyatInteractor(private val ayatRepository: AyatRepository) : AyatUseCase {
    override fun getAyat(nomorSurat: String) = ayatRepository.getAyat(nomorSurat)

    override fun saveAyat(ayat: List<Ayat>) = ayatRepository.saveAyat(ayat)

    override fun getAyatAsPage(): LiveData<PagedList<Ayat>> = ayatRepository.getAyatAsPage()

    override fun deleteAyat() = ayatRepository.deleteAyat()
}