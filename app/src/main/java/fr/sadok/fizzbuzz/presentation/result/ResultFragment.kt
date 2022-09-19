package fr.sadok.fizzbuzz.presentation.result

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import fr.sadok.fizzbuzz.R
import fr.sadok.fizzbuzz.databinding.ResultFragmentBinding

class ResultFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel
    private lateinit var binding: ResultFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.result_fragment, container, false)

        NavigationUI.setupActionBarWithNavController(requireActivity() as AppCompatActivity, findNavController())

        val args = ResultFragmentArgs.fromBundle(requireArguments())
        val fizzBuzzData = args.fizzBuzzArg
        viewModel = ViewModelProvider(this, ResultViewModel.Factory(fizzBuzzData))[ResultViewModel::class.java]
        val adapter = ResultAdapter()
        binding.rvResult.adapter = adapter

        viewModel.resultList.observe(viewLifecycleOwner, {
            it?.apply {
                adapter.submitList(it)
            }
        })


        return binding.root
    }


}