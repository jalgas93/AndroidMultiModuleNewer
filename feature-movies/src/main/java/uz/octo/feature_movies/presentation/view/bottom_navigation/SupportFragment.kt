package uz.octo.feature_movies.presentation.view.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.octo.feature_movies.R
import uz.octo.feature_movies.databinding.FragmentSupportBinding
import uz.octo.feature_movies.presentation.view.support_tab.ChildItem
import uz.octo.feature_movies.presentation.view.support_tab.SupportAdapter
import uz.octo.feature_movies.presentation.view.support_tab.SupportItem
import uz.octo.feature_movies.presentation.viewmodel.PeopleViewModel
import uz.octo.feature_movies.presentation.viewmodel.PopularViewModel

class SupportFragment : Fragment() {
    private lateinit var binding: FragmentSupportBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: PeopleViewModel
    private val parentList = ArrayList<SupportItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSupportBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PeopleViewModel::class.java)

        binding.supportRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.supportRecyclerView.setHasFixedSize(true)

        addDataToList()
        val adapter = SupportAdapter(parentList)
        binding.supportRecyclerView.adapter = adapter
    }

    private fun addDataToList() {
        val childItem1 = ArrayList<ChildItem>()
        childItem1.add(ChildItem("Check", logo = R.drawable.check))
        childItem1.add(ChildItem("Check", logo = R.drawable.check))
        childItem1.add(ChildItem("Check", logo = R.drawable.check))
        childItem1.add(ChildItem("Check", logo = R.drawable.check))
        childItem1.add(ChildItem("Check", logo = R.drawable.check))
        childItem1.add(ChildItem("Check", logo = R.drawable.check))

        parentList.add(SupportItem("Game Development", R.drawable.check, childItem1))

        val childItem2 = ArrayList<ChildItem>()
        childItem2.add(ChildItem("Check", logo = R.drawable.check))
        childItem2.add(ChildItem("Check", logo = R.drawable.check))
        childItem2.add(ChildItem("Check", logo = R.drawable.check))
        childItem2.add(ChildItem("Check", logo = R.drawable.check))
        childItem2.add(ChildItem("Check", logo = R.drawable.check))
        childItem2.add(ChildItem("Check", logo = R.drawable.check))

        parentList.add(SupportItem("Android Development", R.drawable.check, childItem2))


        val childItem3 = ArrayList<ChildItem>()
        childItem3.add(ChildItem("Check", logo = R.drawable.check))
        childItem3.add(ChildItem("Check", logo = R.drawable.check))
        childItem3.add(ChildItem("Check", logo = R.drawable.check))
        childItem3.add(ChildItem("Check", logo = R.drawable.check))
        childItem3.add(ChildItem("Check", logo = R.drawable.check))
        childItem3.add(ChildItem("Check", logo = R.drawable.check))

        parentList.add(SupportItem("Java script", R.drawable.check, childItem3))
    }
}