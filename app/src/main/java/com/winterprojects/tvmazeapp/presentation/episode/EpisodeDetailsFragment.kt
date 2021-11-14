package com.winterprojects.tvmazeapp.presentation.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.winterprojects.tvmazeapp.databinding.FragmentEpisodeDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EpisodeDetailsFragment : Fragment() {
    private val args: EpisodeDetailsFragmentArgs by navArgs()

    private val episodeDetailsViewModel: EpisodeDetailsViewModel by viewModel { parametersOf(args.episode) }

    private lateinit var binding: FragmentEpisodeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)

        initializeObservers()

        initializeListeners()

        return binding.root
    }

    private fun initializeListeners() {
        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initializeObservers() {
        episodeDetailsViewModel.episode.observe(viewLifecycleOwner) { episode ->
            binding.episode = episode
        }
    }
}