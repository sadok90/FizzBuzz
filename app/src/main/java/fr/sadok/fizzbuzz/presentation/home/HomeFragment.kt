package fr.sadok.fizzbuzz.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import fr.sadok.fizzbuzz.R
import fr.sadok.fizzbuzz.databinding.HomeFragmentBinding
import fr.sadok.fizzbuzz.home.HomeViewModel

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel

    private lateinit var binding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnValidate.setOnClickListener {
            viewModel.validate(
                binding.edtNumber1.text.toString().trim(),
                binding.edtNumber2.text.toString().trim(),
                binding.edtLimit.text.toString().trim(),
                binding.edtText1.text.toString().trim(),
                binding.edtText2.text.toString().trim())
        }


        viewModel.goToResultScreen.observe(viewLifecycleOwner, { fizzBuzzData ->
            if(fizzBuzzData != null) {
                findNavController().navigate(HomeFragmentDirections.actionHomeToResult(fizzBuzzData))
                viewModel.clearNavigationData()
            }

        })

        return binding.root

    }

}