package co.id.sulthan.myquran.ui.ayat

import androidx.lifecycle.MutableLiveData
import co.id.sulthan.core.domain.usecase.AyatUseCase
import co.id.sulthan.core.ui.BaseViewModel
import co.id.sulthan.core.utils.RxUtils

class AyatVM(private val ayatUseCase: AyatUseCase) : BaseViewModel() {

    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getAyatBySurat(nomor: String) {
        showProgressbar.value = true
        compositeDisposable.add(
            ayatUseCase.getAyat(nomor)
                .compose(RxUtils.applySingleAsync())
                .subscribe({ result ->
                    ayatUseCase.saveAyat(result)
                    showProgressbar.value = false
                }, this::onError)
        )
    }

    fun deleteAyatAfterDestroy() = ayatUseCase.deleteAyat()

    val ayatByLocal = ayatUseCase.getAyatAsPage()

    override fun onError(error: Throwable) {
        messageData.value = error.message
    }
}