package com.example.testecarrefour

import com.example.testecarrefour.core.BaseFragment
import com.example.testecarrefour.databinding.FragmentUserDetailBinding
import com.example.testecarrefour.response.UsersResponse
import com.example.testecarrefour.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserDetailsFragment: BaseFragment<FragmentUserDetailBinding>() {

    private val viewModel: MainViewModel by sharedViewModel()

    override fun layoutId() = R.layout.fragment_user_detail

    override fun init() {
        observe()
    }

    fun observe(){
        viewModel.getUserDetails.observe(viewLifecycleOwner) {data ->

            binding?.apply {

                if(data?.avatar_url?.isNotEmpty() == true)
                    Picasso.get().load(data.avatar_url).into(ivUserPhoto)

                tvUserName.text = data?.login
                tvUserEmail.text = data?.node_id
            }
        }
    }
}