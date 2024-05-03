package uz.octo.feature_movies.presentation.view.home_tab

import PopularRecyclerAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import uz.octo.feature_movies.R
import uz.octo.feature_movies.databinding.CardDetailsBinding
import uz.octo.feature_movies.databinding.FragmentDescriptionHomeBinding
import uz.octo.feature_movies.presentation.adapter.DetailsAdapter
import uz.octo.feature_movies.presentation.adapter.GenresAdapter
import uz.octo.feature_movies.presentation.viewmodel.CategoryViewModel
import uz.octo.feature_movies.presentation.viewmodel.DetailsViewModel

class DescriptionHomeFragment : Fragment() {
    private lateinit var binding: FragmentDescriptionHomeBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(DetailsViewModel::class.java)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (!it.isLoading) {
                binding.progressBar.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.error
                } else {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.errorText.visibility = View.INVISIBLE
                    binding.detailsContainer.detailsContainerVisible.visibility = View.VISIBLE
                   // binding.detailsContainer.detailsContainerIn.visibility = View.VISIBLE
                }
            }
        })
    }
}