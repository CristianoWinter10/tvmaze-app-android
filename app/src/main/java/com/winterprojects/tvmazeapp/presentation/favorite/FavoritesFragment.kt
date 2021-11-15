package com.winterprojects.tvmazeapp.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.FragmentFavoritesBinding
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel
import org.koin.android.ext.android.inject

import com.google.android.material.snackbar.Snackbar
import com.winterprojects.tvmazeapp.R

class FavoritesFragment : Fragment(), OnItemClickListener<FavoriteShowModel>,
    OnRemoveFavoriteItemClickListener {
    private var snackBar: Snackbar? = null
    private val favoritesViewModel: FavoritesViewModel by inject()

    private lateinit var favoriteAdapter: FavoriteAdapter

    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(
            inflater,
            container,
            false
        )

        initializeAdapters()
        initializeObservers()

        return binding.root
    }

    private fun initializeAdapters() {
        favoriteAdapter = FavoriteAdapter(this, this)
        binding.recyclerViewFavoriteShows.apply {
            adapter = favoriteAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initializeObservers() {
        favoritesViewModel.favorites.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResultState.Loaded -> {
                    favoriteAdapter.submitList(result.data)
                }
            }
        }
    }

    override fun onItemClick(favoriteShowModel: FavoriteShowModel) {
        val action = FavoritesFragmentDirections.actionFavoritesFragmentToShowDetailsNavGraph(
            favoriteShowModel.id
        )
        findNavController().navigate(action)
    }

    override fun onRemoveFavoriteItemClickListener(
        itemPosition: Int,
        favoriteShowModel: FavoriteShowModel
    ) {
        favoriteAdapter.notifyItemRemoved(itemPosition)
        favoritesViewModel.removeFavoriteItem(itemPosition, favoriteShowModel)
        showUndoRemoveFavorite()
    }

    private fun showUndoRemoveFavorite() {
        snackBar?.dismiss()
        snackBar = Snackbar.make(
            requireView(), R.string.undo_remove_favorite,
            Snackbar.LENGTH_LONG
        )
        snackBar?.setAction(R.string.undo) { _ -> undoDelete() }
        snackBar?.show()
    }

    private fun undoDelete() {
        favoriteAdapter.notifyItemInserted(favoritesViewModel.lastPositionFavoriteShowModelRemoved)
        favoritesViewModel.undoRemoveFavoriteItem()
    }
}