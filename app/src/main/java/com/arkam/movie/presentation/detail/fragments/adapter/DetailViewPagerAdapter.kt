package com.arkam.movie.presentation.detail.fragments.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arkam.core.constant.Constant
import com.arkam.core.domain.model.detail.MovieDetail
import com.arkam.core.domain.model.detail.TvDetail
import com.arkam.movie.presentation.detail.fragments.OtherFragment
import com.arkam.movie.presentation.detail.fragments.OverviewFragment

class DetailViewPagerAdapter<T>(
    fa: FragmentActivity,
    val id: String,
    val detailData: T
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        val otherFragment = OtherFragment()
        val overviewFragment = OverviewFragment()
        val bundle = Bundle()
        bundle.putString(Constant.BUNDLE_MOVIE_ID, id)
        if(detailData is MovieDetail){
            bundle.putParcelable(Constant.BUNDLE_MOVIE_DETAIL, detailData as MovieDetail)
            bundle.putString(Constant.BUNDLE_MEDIA_TYPE, Constant.BUNDLE_MEDIA_MOVIE)
        } else if (detailData is TvDetail){
            bundle.putParcelable(Constant.BUNDLE_MOVIE_DETAIL, detailData as TvDetail)
            bundle.putString(Constant.BUNDLE_MEDIA_TYPE, Constant.BUNDLE_MEDIA_TV)
        }
        otherFragment.arguments = bundle
        overviewFragment.arguments = bundle

        return when(position) {
            0 -> overviewFragment
            else -> otherFragment
        }
    }

}