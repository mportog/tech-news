package br.com.alura.technews.repository

class Resourse<T>(val dado: T, val erro: String? = null)

fun <T> criaResourseDeFalha(
    resourseAtual: Resourse<T?>?,
    mensagemErro: String?
): Resourse<T?> {
    if (resourseAtual != null) {
        return Resourse(dado = resourseAtual.dado, erro = mensagemErro)
    }
    return Resourse(dado = null, erro = mensagemErro)

}