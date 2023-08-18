package org.harundemir.gamestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.adapters.CategoriesAdapter
import org.harundemir.gamestore.data.categoryList
import org.harundemir.gamestore.databinding.FragmentCategoriesBinding
import org.harundemir.gamestore.models.Category
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var categoriesAdapter: CategoriesAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = categoryList
        categoriesAdapter = CategoriesAdapter(categories)
        binding.categoriesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.categoriesList.adapter = categoriesAdapter

        binding.categoriesSearch.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filterList(newText)
                    return true
                }
            })
        }
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<Category>()
            for (category in categoryList) {
                if (category.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(category)
                }
            }

            if (filteredList.isNotEmpty()) {
                binding.categoriesList.isVisible = true
                binding.categoriesNotFound.isVisible = false
                categoriesAdapter.setFilteredList(filteredList)
            } else {
                binding.categoriesList.isVisible = false
                binding.categoriesNotFound.isVisible = true
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}