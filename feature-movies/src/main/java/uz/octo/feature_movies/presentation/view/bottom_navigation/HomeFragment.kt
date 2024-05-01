package uz.octo.feature_movies.presentation.view.bottom_navigation

import PopularRecyclerAdapter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.octo.feature_movies.R
import uz.octo.feature_movies.databinding.FragmentHomeBinding
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.domain.navigation.NavigationList
import uz.octo.feature_movies.presentation.adapter.GenresAdapter
import uz.octo.feature_movies.presentation.viewmodel.CategoryViewModel
import uz.octo.feature_movies.presentation.viewmodel.GenresViewModel
import uz.octo.feature_movies.presentation.viewmodel.PopularViewModel
import javax.inject.Inject
import android.widget.RelativeLayout;

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PopularRecyclerAdapter
    private lateinit var viewModel: CategoryViewModel
    private lateinit var viewModelGenres: GenresViewModel
    private lateinit var adapterGenres: GenresAdapter

    @Inject
    lateinit var navigation: NavigationList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_done)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Navigate to settings screen.
                true
            }
            R.id.action_done -> {
                // Save profile changes.
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun clickBackButton(){
       // binding.favToolbar.toolBar.setNavigationOnClickListener{}
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelGenres = ViewModelProvider(requireActivity()).get(GenresViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity()).get(CategoryViewModel::class.java)

        viewModelGenres.state.observe(viewLifecycleOwner,Observer{
            if (!it.isLoading) {
                binding.genres.psbGenres.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.genres.erGenres.visibility = View.VISIBLE
                    binding.genres.erGenres.text = it.error
                } else {

                    binding.genres.rvGenres.visibility  = View.VISIBLE
                    adapterGenres = GenresAdapter(it.domainGenreItems)
                    binding.genres.rvGenres.adapter = adapterGenres
                    adapterGenres.onItemClick = {
                       viewModel.getCategory(it.id)
                    }
                }
            }
        })


        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (!it.isLoading) {
                binding.body.progressBar.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.body.errorText.visibility = View.VISIBLE
                    binding.body.errorText.text = it.error
                } else {
                    binding.body.recyclerView.visibility = View.VISIBLE
                    binding.body.recyclerView.layoutManager = GridLayoutManager(context, 1)
                    adapter = PopularRecyclerAdapter(it.movies, context = context)
                    binding.body.recyclerView.adapter = adapter
                    adapter.onItemClick = {
                         navigation.openMovie(it.id)
                    }
                }
            }
        })
    }


}