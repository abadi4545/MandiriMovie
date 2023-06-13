package com.arkam.movie.presentation.home.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arkam.core.constant.Constant
import com.arkam.movie.presentation.detail.fragments.OverviewFragment
import com.arkam.movie.presentation.home.fragment.HomeTabFragment
import com.arkam.movie.utils.HomeTabFragmentGenerator

class HomeViewPagerAdapter(
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {

        val topRatedMovie = HomeTabFragmentGenerator.generate(Constant.TOP_RATED_MOVIE, Constant.BUNDLE_MEDIA_MOVIE)
        val topRatedTv = HomeTabFragmentGenerator.generate(Constant.TOP_RATED_TV, Constant.BUNDLE_MEDIA_TV)
        val airingTodayTv = HomeTabFragmentGenerator.generate(Constant.AIRING_TODAY_TV, Constant.BUNDLE_MEDIA_TV)
        val popularTv = HomeTabFragmentGenerator.generate(Constant.POPULAR_TV, Constant.BUNDLE_MEDIA_TV)

        return listOf(airingTodayTv, topRatedMovie, topRatedTv, popularTv)[position]
    }

}