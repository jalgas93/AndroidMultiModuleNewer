package uz.octo.feature_movies.presentation.view.bottom_navigation

import PopularRecyclerAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.octo.feature_movies.databinding.FragmentHomeBinding
import uz.octo.feature_movies.domain.navigation.NavigationList
import uz.octo.feature_movies.presentation.viewmodel.PopularViewModel
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PopularRecyclerAdapter
    private lateinit var viewModel: PopularViewModel

    @Inject
    lateinit var navigation: NavigationList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PopularViewModel::class.java)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (!it.isLoading) {
                binding.progressBar.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.error
                } else {

                    binding.recyclerView.visibility = View.VISIBLE
                    binding.recyclerView.layoutManager = GridLayoutManager(context, 1)
                    adapter = PopularRecyclerAdapter(it.movies, context = context)
                    binding.recyclerView.adapter = adapter
                    adapter.onItemClick = {
                        Log.i("Click", "Click")
                         navigation.openMovie(it.id)

                    }
                }
            }
        })
    }
}