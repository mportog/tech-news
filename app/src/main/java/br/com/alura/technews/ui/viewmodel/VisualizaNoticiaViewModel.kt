package br.com.alura.technews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resourse

class VisualizaNoticiaViewModel(
    private val id: Long,
    private val repository: NoticiaRepository
) : ViewModel() {

     val noticiaEncontrada = repository.buscaPorId(id)


    fun remove(): LiveData<Resourse<Void?>> {
        return noticiaEncontrada.value?.run {
            repository.remove(this)
        } ?: MutableLiveData<Resourse<Void?>>().also {
            it.value = Resourse(null, "Nitícia não encontrada")
        }
    }
}