package com.winterprojects.tvmazeapp.presentation.showDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.winterprojects.tvmazeapp.databinding.FragmentShowDetailsBinding

class ShowDetailsFragment: Fragment() {
    private lateinit var binding: FragmentShowDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowDetailsBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

}