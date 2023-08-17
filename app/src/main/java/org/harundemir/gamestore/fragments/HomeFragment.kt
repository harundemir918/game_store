package org.harundemir.gamestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.harundemir.gamestore.adapters.CategoriesAdapter
import org.harundemir.gamestore.adapters.TopGamesAdapter
import org.harundemir.gamestore.data.categoryList
import org.harundemir.gamestore.data.gameList
import org.harundemir.gamestore.databinding.FragmentHomeBinding
import org.harundemir.gamestore.models.Category
import org.harundemir.gamestore.models.Game

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = getSampleCategories()
        val topGames = getSampleTopGames()

        val categoriesAdapter = CategoriesAdapter(categories)
        binding.categoriesHorizontalList.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding.categoriesHorizontalList.adapter = categoriesAdapter

        val topGamesAdapter = TopGamesAdapter(topGames)
        binding.topGamesHorizontalList.layoutManager = LinearLayoutManager(requireContext())
        binding.topGamesHorizontalList.adapter = topGamesAdapter
    }

    private fun getSampleCategories(): List<Category> {
        return categoryList.subList(0, 5)
    }

    private fun getSampleTopGames(): List<Game> {
        return gameList.subList(0, 5)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}