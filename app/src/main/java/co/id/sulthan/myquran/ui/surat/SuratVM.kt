package co.id.sulthan.myquran.ui.surat

import androidx.lifecycle.MutableLiveData
import co.id.sulthan.core.domain.usecase.SuratUseCase
import co.id.sulthan.core.ui.BaseViewModel
import co.id.sulthan.core.utils.RxUtils

class SuratVM(private val suratUseCase: SuratUseCase) : BaseViewModel() {

    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getSurat() {
        showProgressbar.value = true
        compositeDisposable.add(
            suratUseCase.getSurat()
                .compose(RxUtils.applySingleAsync())
                .subscribe({ result ->
                    showProgressbar.value = false
                    suratUseCase.saveSurah(result)
                }, this::onError)
        )
    }

    val suratByLocal = suratUseCase.getSuratAsPage()

    fun deleteSuratAfterDestroy() = suratUseCase.deleteSurat()


    override fun onError(error: Throwable) {
        messageData.value = error.message
    }
}