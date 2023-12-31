package com.arkam.movie.presentation.search.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arkam.core.constant.Constant
import com.arkam.core.domain.model.Resource
import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.movie.MovieResult
import com.arkam.core.domain.model.tv.Tv
import com.arkam.core.domain.model.tv.TvResult
import com.arkam.movie.`interface`.OnItemClickCallback
import com.arkam.movie.adapter.VerticalListAdapter
import com.arkam.movie.databinding.FragmentSearchTabBinding
import com.arkam.movie.presentation.detail.DetailActivity
import com.arkam.movie.presentation.search.SearchViewModel
import com.arkam.movie.presentation.search.fragment.adapter.SearchMediaViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchTabFragment : Fragment() {

    private var _binding: FragmentSearchTabBinding? = null
    private val binding get() = _binding as FragmentSearchTabBinding

    private val viewModel: SearchViewModel by viewModel()

    private lateinit var query: String
    private var page = 1
    private lateinit var mediaType: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchTabBinding.inflate(layoutInflater)

        query = arguments?.getString(Constant.BUNDLE_SEARCH_QUERY) ?: ""
        page = arguments?.getInt(SearchMediaViewPagerAdapter.BUNDLE_SEARCH_PAGE) ?: 1
        mediaType = arguments?.getString(Constant.BUNDLE_MEDIA_TYPE) ?: ""

        initObserver()

        return binding.root
    }

    private fun initObserver() {
        when(mediaType){
            Constant.BUNDLE_MEDIA_MOVIE -> {
                viewModel.searchMovie(query, page.toString())
                viewModel.movieResponse.observe(viewLifecycleOwner){
                    setUpSearchRV(it)
                }
            }
            Constant.BUNDLE_MEDIA_TV -> {
                viewModel.searchTv(query)
                viewModel.tvResponse.observe(viewLifecycleOwner){
                    setUpSearchRV(it)
                }
            }
        }
    }

    private fun <T> setUpSearchRV(resource: Resource<T>?) {
        when(resource){
            is Resource.Success -> {
                when(resource.data){
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        displayMovie(result)
                    }
                    is TvResult -> {
                        val result = resource.data as TvResult
                        displayTv(result)
                    }
                }
            }
            else -> {}
        }
    }

    private fun displayTv(result: TvResult) {
        binding.rvSearch.apply {
            val mAdapter = VerticalListAdapter<Tv>()
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            mAdapter.setData(result.tv)
            mAdapter.setOnItemClickCallback(
                object : OnItemClickCallback{
                    override fun onItemClicked(id: Int) {
                        startActivity(
                            Intent(context, DetailActivity::class.java)
                                .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                .putExtra(Constant.EXTRA_MEDIA_TYPE, Constant.EXTRA_MEDIA_TV)
                        )
                    }
                }
            )
        }
    }

    private fun displayMovie(result: MovieResult) {
        binding.rvSearch.apply {
            val mAdapter = VerticalListAdapter<Movie>()
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            mAdapter.setData(result.movie)
            mAdapter.setOnItemClickCallback(
                object : OnItemClickCallback{
                    override fun onItemClicked(id: Int) {
                        startActivity(
                            Intent(context, DetailActivity::class.java)
                                .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                .putExtra(Constant.EXTRA_MEDIA_TYPE, Constant.EXTRA_MEDIA_MOVIE)
                        )
                    }
                }
            )
        }
    }
}