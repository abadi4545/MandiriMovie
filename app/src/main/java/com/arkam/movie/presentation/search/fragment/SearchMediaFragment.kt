package com.arkam.movie.presentation.search.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.arkam.core.constant.Constant
import com.arkam.movie.R
import com.arkam.movie.databinding.FragmentSearchMediaBinding
import com.arkam.movie.databinding.FragmentSearchTabBinding
import com.arkam.movie.presentation.search.SearchViewModel
import com.arkam.movie.presentation.search.fragment.adapter.SearchMediaViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchMediaFragment : Fragment() {

    private var _binding: FragmentSearchMediaBinding? = null
    private val binding get() = _binding as FragmentSearchMediaBinding

    private val viewModel: SearchViewModel by viewModel()

    private lateinit var mediaType: String
    private lateinit var query: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMediaBinding.inflate(layoutInflater)

        mediaType = arguments?.getString(Constant.BUNDLE_MEDIA_TYPE).orEmpty()
        query = arguments?.getString(Constant.BUNDLE_SEARCH_QUERY).orEmpty()

        setUpSearchTabViewPager(0, mediaType)
        initObserver()

        return binding.root
    }

    private fun initObserver() {
        when(mediaType){
            Constant.BUNDLE_MEDIA_MOVIE -> {
                viewModel.searchMovie(query)
                viewModel.movieResponse.observe(viewLifecycleOwner){
                    setUpSearchTabViewPager(it.data?.totalPages ?: 1, mediaType)
                }
            }
            Constant.BUNDLE_MEDIA_TV -> {
                viewModel.searchTv(query)
                viewModel.tvResponse.observe(viewLifecycleOwner){
                    setUpSearchTabViewPager(it.data?.totalPages ?: 1, mediaType)
                }
            }
        }
    }

    private fun setUpSearchTabViewPager(pageTotal: Int, mediaType: String) {
        binding.apply {
            vpSearchPage.isUserInputEnabled = false
            vpSearchPage.adapter = activity?.let { SearchMediaViewPagerAdapter(it, mediaType, query, pageTotal) }
            if(pageTotal == 1) tabSearchPage.visibility = View.GONE
            TabLayoutMediator(tabSearchPage, vpSearchPage){ tab, position ->
                tab.text = (position+1).toString()
            }.attach()
        }
    }

}