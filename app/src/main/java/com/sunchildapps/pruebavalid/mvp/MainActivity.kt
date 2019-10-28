package com.sunchildapps.pruebavalid.mvp

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sunchildapps.pruebavalid.R
import com.sunchildapps.pruebavalid.data.AppDataBase
import com.sunchildapps.pruebavalid.domain.Artist
import com.sunchildapps.pruebavalid.mvp.adapter.ArtistAdapter
import com.sunchildapps.pruebavalid.mvp.base.BaseActivity
import com.sunchildapps.pruebavalid.mvp.base.ArtistBaseView
import com.sunchildapps.pruebavalid.repository.ArtistRepositoryImpl
import com.sunchildapps.pruebavalid.repository.local.ArtistLocalRepositoryImpl
import com.sunchildapps.pruebavalid.repository.remote.ArtistRemoteRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ArtistPresenter>(), ArtistBaseView {
    override fun showArtists(artists: List<Artist>) {
        rv_artist.layoutManager = LinearLayoutManager(this)
        rv_artist.adapter = ArtistAdapter(listener,artists)
    }

    override fun showLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = GONE
    }

    override fun showError(error: String) {
        Snackbar.make(main, R.string.error_message, Snackbar.LENGTH_SHORT).show()
    }

    override fun createPresenter(): ArtistPresenter {
        val remoteRepo = ArtistRemoteRepositoryImpl()
        val appDataBase = AppDataBase.getInstance(this)

        val localRepo = ArtistLocalRepositoryImpl(appDataBase.artistDao())

        val artistsRepo = ArtistRepositoryImpl(remoteRepo, localRepo)

        return ArtistPresenterImpl(AndroidSchedulers.mainThread(), artistsRepo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val listener = { artist: Artist ->
        startActivity(Intent(ACTION_VIEW, Uri.parse(artist.url)))
    }
}
