package org.variant2.RaviRamchand991526202

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.variant2.RaviRamchand991526202.databinding.FragmentFirstBinding
import org.variant2.RaviRamchand991526202.databinding.FragmentSelectionBinding
import kotlin.system.exitProcess

//Ravi Ramchand 991526202
class SelectionFragment : Fragment() {
    private var _binding: FragmentSelectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle = arguments

        if(bundle == null){
            Log.d("Error", "Error")
        }

        val args = SelectionFragmentArgs.fromBundle(bundle!!)


        binding.selectionFragName.text = "Name: " +args.name
        binding.selectedItems.text = "Items: " +args.selection.toString()

        binding.exitBtn.setOnClickListener {
            println("Exit button clicked");
            println("Count: "+args.selection)
            exitProcess(-1)
        }
    }


}