package com.arkam.movie.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arkam.core.constant.Constant
import com.arkam.movie.presentation.home.fragment.HomeTabFragment

object HomeTabFragmentGenerator {
    fun generate(category: String, mediaType: String): Fragment {
        val bundle = Bundle()
        val fragment = HomeTabFragment()
        bundle.putString(Constant.BUNDLE_MOVIE_CATEGORY, category)
        bundle.putString(Constant.BUNDLE_MEDIA_TYPE, mediaType)
        fragment.arguments = bundle
        return fragment
    }
}