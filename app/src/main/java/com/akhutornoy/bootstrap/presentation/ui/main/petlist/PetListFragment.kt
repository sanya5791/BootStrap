package com.akhutornoy.bootstrap.presentation.ui.main.petlist

import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.akhutornoy.bootstrap.R
import com.akhutornoy.bootstrap.presentation.ui.base.BaseViewModel
import com.akhutornoy.bootstrap.presentation.ui.base.BaseViewModelFragment
import com.akhutornoy.bootstrap.presentation.ui.main.model.PetModel
import com.github.ajalt.timberkt.Timber
import kotlinx.android.synthetic.main.fragment_petlist.*
import javax.inject.Inject

class PetListFragment : BaseViewModelFragment() {

    @Inject
    lateinit var viewModel: PetListViewModel

    @Inject
    lateinit var navigator: PetListNavigator

    private lateinit var adapter: PetListAdapter

    @LayoutRes
    override fun fragmentLayoutId(): Int = R.layout.fragment_petlist

    override fun initView() {
        initToolbar()
        initSwipeRefresh()
        initAdapter()
    }

    private fun initToolbar() {
        requireActivity().setActionBar(toolbar)
    }

    private fun initSwipeRefresh() {
        swiperefresh.setOnRefreshListener { viewModel.loadPets() }
    }

    private fun initAdapter() {
        val listener = object : PetListAdapter.OnPetClickListener {
            override fun onPetClicked(pet: PetModel) {
                navigator.navigateToPetPicture(pet)
            }
        }
        adapter = PetListAdapter(listener)
        rv_pets.adapter = adapter

    }

    override fun getBaseViewModel(): BaseViewModel = viewModel

    override fun initViewModelObservers() {
        viewModel.showProgressLiveData.observe(viewLifecycleOwner, Observer { swiperefresh.isRefreshing = it })
        viewModel.petsLiveData.observe(viewLifecycleOwner, Observer (::onPetsLoaded))
    }

    private fun onPetsLoaded(pets: List<PetModel>) {
        Timber.e { "onPetsLoaded(): petsSize=${pets.size}" }
        adapter.items = pets
    }

    interface PetListNavigator {
        fun navigateToPetPicture(pet: PetModel)
    }

    companion object {

        fun newInstance() = PetListFragment()

    }

}