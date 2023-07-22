package com.example.twitterapp.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.twitterapp.databinding.FragmentFeedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    private val feedViewModel: FeedViewModel by viewModel()
    private var _binding: FragmentFeedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedViewModel.getFeedData()
        feedViewModel.loadingLiveData.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.isVisible = isLoading
        }

        feedViewModel.feedLiveData.observe(viewLifecycleOwner) { feedList ->
            binding.errorMsgTv.isVisible = false
            binding.feedRecyclerView.apply {
                isVisible = true
                adapter = FeedAdapter(feedList)
            }
        }

        feedViewModel.errorLiveData.observe(viewLifecycleOwner) { errMsg ->
            binding.feedRecyclerView.isVisible = false
            binding.errorMsgTv.apply {
                isVisible = true
                text = errMsg
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}