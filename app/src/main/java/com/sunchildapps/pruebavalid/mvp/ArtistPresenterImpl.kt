package com.sunchildapps.pruebavalid.mvp

import com.sunchildapps.pruebavalid.domain.Artist
import com.sunchildapps.pruebavalid.repository.ArtistRepository
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class ArtistPresenterImpl(
    private val scheduler: Scheduler,
    private val repo: ArtistRepository
) : ArtistPresenter() {

    lateinit var disposable: Disposable

    override fun getArtists() {
        if (!isViewAttached()) return

        getView()?.showLoading()
        disposable = repo.getArtists(1)
            .observeOn(scheduler)
            .subscribeWith(object : DisposableObserver<List<Artist>>() {
                override fun onComplete() {

                }

                override fun onNext(t: List<Artist>) {
                    if (!isViewAttached()) return
                    getView()?.showArtists(t)
                }

                override fun onError(e: Throwable) {
                    if (!isViewAttached()) return
                    getView()?.showError(e.localizedMessage)
                }

            }

            )
    }

    override fun onDetach() {
        super.onDetach()
        disposable.dispose()
    }
}