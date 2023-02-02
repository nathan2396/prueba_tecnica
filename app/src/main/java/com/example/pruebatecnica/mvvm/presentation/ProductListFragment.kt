package com.example.pruebatecnica.mvvm.presentation

import android.os.Bundle
import android.text.InputType
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.FragmentProductListBinding
import com.example.pruebatecnica.domain.ProductsApi
import com.example.pruebatecnica.mvvm.common.VMFactory
import com.example.pruebatecnica.mvvm.view_model.ProductListViewModel
import com.example.pruebatecnica.repository.ProductsRepositoryImpl
import com.example.pruebatecnica.use_case.SearchProductsUseCase
import com.example.pruebatecnica.mvvm.common.GenericActivity

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private val showProductListVM by activityViewModels<ProductListViewModel> { VMFactory(showProductListUseCase) }
    private lateinit var showProductListUseCase:SearchProductsUseCase
    private lateinit var navControl : NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.apply { lifecycleOwner = this@ProductListFragment }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        showProductListUseCase = SearchProductsUseCase(ProductsRepositoryImpl(ProductsApi.Builder().build()))
        navControl = Navigation.findNavController(view)
        binding.apply {
            productListVM = this@ProductListFragment.showProductListVM

        }
        showProductListVM?.let { vm ->
            vm.loaderStatus.observe(viewLifecycleOwner) {
                (requireActivity() as GenericActivity).loadingView(it)
            }
            vm.initAdapter()

        }
        initSearch()
    }


    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {}
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean { return true }
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
                (menu.findItem(R.id.appSearchBar).actionView as SearchView)?.apply {
                    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            initSearch(query!!)
                            return true
                        }
                        override fun onQueryTextChange(newText: String?): Boolean = false
                    })
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    private fun initSearch(query :String? = null) {
        showProductListVM.getProductList(coincidence = query)  { Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show() }
    }
}