package uz.octo.feature_movies.presentation.view.bottom_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.octo.feature_movies.databinding.FragmentSupportBinding
import uz.octo.feature_movies.presentation.viewmodel.CategoryViewModel

class DownloadFragment : Fragment() {
private  lateinit var binding:FragmentSupportBinding
    private lateinit var viewModel: CategoryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSupportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CategoryViewModel::class.java)

        viewModel.state.observe(viewLifecycleOwner, Observer{
            if(!it.isLoading){
                Log.i("loading",it.isLoading.toString())

                if(it.error.isNotBlank()){
                    Log.i("error",it.error.toString())
                }else{
                    Log.i("success",it.movies.toString())
                }
            }
        })
    }
}