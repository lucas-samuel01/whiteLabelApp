package com.lucas.whitelabelapp.ui.addProduct

import android.net.Uri
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.lucas.whitelabelapp.databinding.FragmentAddProductBinding
import com.lucas.whitelabelapp.util.CurrencyTextWatcher
import com.lucas.whitelabelapp.util.PRODUCT_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProductFragment : BottomSheetDialogFragment() {

    private var _binding:FragmentAddProductBinding? =null
    private val binding get() = _binding!!
    private var  imageUri: Uri? = null
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        uri ->
        imageUri = uri
        binding.imageProduct.setImageURI(uri)
    }
    private val viewModel: AddProductViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeVmEvents()
        setListeners()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddProductBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun observeVmEvents(){
        viewModel.imageUriErrorResId.observe(viewLifecycleOwner){ drawableResId ->
            binding.imageProduct.setBackgroundResource(drawableResId)
        }
        viewModel.priceFieldErrorResId.observe(viewLifecycleOwner){ stringResId ->
            binding.inputLayoutPrice.setError(stringResId)
        }
        viewModel.descriptionFieldErrorResId.observe(viewLifecycleOwner){ stringResId ->
            binding.inputLayoutDescription.setError(stringResId)
        }

        viewModel.productCreated.observe(viewLifecycleOwner){product ->
            findNavController().run{
                Log.d("entrou AQUI","FIND NAV CONTROLLER")
                previousBackStackEntry?.savedStateHandle?.set(PRODUCT_KEY, product)
                popBackStack()
            }

        }
    }

    private fun TextInputLayout.setError(stringResId: Int?){
        error = if(stringResId != null){
            getString(stringResId)
        }else null
    }

    private  fun setListeners(){
        binding.imageProduct.setOnClickListener{
            choseImage()
        }
        binding.buttonAddProduct.setOnClickListener{
            val descriptor = binding.inputDescription.text.toString()
            val price = binding.inputPrice.text.toString()

            viewModel.createProduct(descriptor,price,imageUri)

        }
        binding.inputPrice.run {
            addTextChangedListener(CurrencyTextWatcher(this))
        }
    }
    private fun choseImage(){
        getContent.launch("image/*")
    }
}