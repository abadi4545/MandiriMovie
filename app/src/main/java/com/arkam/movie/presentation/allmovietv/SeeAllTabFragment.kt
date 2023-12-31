package com.arkam.movie.presentation.allmovietv

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
import com.arkam.movie.`interface`.OnItemClickCallback
import com.arkam.movie.adapter.VerticalListAdapter
import com.arkam.movie.databinding.FragmentSeeAllTabBinding
import com.arkam.movie.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SeeAllTabFragment : Fragment() {

    private val viewModel: AllMovieTvViewModel by viewModel()

    private var _binding: FragmentSeeAllTabBinding? = null
    private val binding get() = _binding as FragmentSeeAllTabBinding

    private lateinit var category: String
    private var page = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeeAllTabBinding.inflate(layoutInflater)

        category = arguments?.getString(Constant.BUNDLE_MOVIE_CATEGORY) ?: Constant.NOW_PLAYING_MOVIE
        page = arguments?.getInt(Constant.BUNDLE_MOVIE_PAGE) ?: 1

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        viewModel.getMoviesByCategory(category, page.toString())
        viewModel.movieResponse.observe(viewLifecycleOwner){
            setUpHomeTabRv(it)
        }
    }

    private fun <T> setUpHomeTabRv(resource: Resource<T>) {
        when(resource){
            is Resource.Success -> {
                when(resource.data){
                    is MovieResult -> {
                        val result = resource.data as MovieResult
                        binding.rvSeeAllTab.apply {
                            val mAdapter = VerticalListAdapter<Movie>()
                            layoutManager = LinearLayoutManager(context)
                            adapter = mAdapter
                            mAdapter.setData(result.movie)

                            mAdapter.setOnItemClickCallback(object: OnItemClickCallback {
                                override fun onItemClicked(id: Int) {
                                    startActivity(
                                        Intent(context, DetailActivity::class.java)
                                            .putExtra(Constant.EXTRA_DETAIl_ID, id)
                                    )
                                }

                            })

                        }

                    }
                }
            }
            else -> {}
        }

    }
}