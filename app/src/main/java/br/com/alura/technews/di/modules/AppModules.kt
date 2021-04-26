package br.com.alura.technews.di.modules

import androidx.room.Room
import br.com.alura.technews.database.AppDatabase
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.retrofit.webclient.NoticiaWebClient
import br.com.alura.technews.ui.viewmodel.FormularioNoticiaviewModel
import br.com.alura.technews.ui.viewmodel.ListaNoticiasViewModel
import br.com.alura.technews.ui.viewmodel.VisualizaNoticiaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "news.db"

val appModules = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }
    single {
        get<AppDatabase>().noticiaDAO
    }
    single {
        NoticiaWebClient()
    }
    single {
        NoticiaRepository(get(), get())
    }
    viewModel {
        ListaNoticiasViewModel(get())
    }
    viewModel { (id: Long) ->
        VisualizaNoticiaViewModel(id, get())
    }
    viewModel {
        FormularioNoticiaviewModel(get())
    }

}