package com.example.testecarrefour

import android.text.Editable
import android.text.TextWatcher
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testecarrefour.core.BaseFragment
import com.example.testecarrefour.databinding.FragmentGitListBinding
import com.example.testecarrefour.extensions.Navigate
import com.example.testecarrefour.extensions.navigateWithAnimations
import com.example.testecarrefour.response.UsersResponse
import com.example.testecarrefour.ui.GitListAdapter
import com.example.testecarrefour.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GitListFragment : BaseFragment<FragmentGitListBinding>() {

    private val viewModel: MainViewModel by sharedViewModel()
    private var adapter: GitListAdapter? = null
    private var originalList: ArrayList<UsersResponse> = arrayListOf()
    private var userName: String? = ""
    private var filteredList: ArrayList<UsersResponse> = arrayListOf()

    override fun layoutId() = R.layout.fragment_git_list

    override fun create() {
        viewModel.fetchGitList()
    }

    override fun init() {
        setObservers()
        render()
        searchBar()
    }

    private fun setObservers() {

        viewModel.getList.observe(viewLifecycleOwner) {
            showLoading(false)
            adapter?.setList(ArrayList(it))
            originalList = it
        }

    }

    private fun render() {

        adapter = GitListAdapter {
            userName = originalList[it].login
            viewModel.getListUsers(userName)
            findNavController().navigateWithAnimations(R.id.UserDetailsFragment)
        }

        binding?.apply {

            listGitAdapter.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            })
            listGitAdapter.adapter = adapter
        }
    }

    private fun searchBar() {
        binding?.apply {
            searchEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    filterList(s.toString())
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })
        }
    }

    private fun filterList(query: String) {
        filteredList = ArrayList(originalList.filter {
            it.login.contains(query, ignoreCase = true)
        })

        adapter?.setList(filteredList)
        adapter?.notifyDataSetChanged()
    }
}
