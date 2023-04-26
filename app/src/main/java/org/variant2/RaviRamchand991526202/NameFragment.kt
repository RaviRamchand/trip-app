package org.variant2.RaviRamchand991526202

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.variant2.RaviRamchand991526202.databinding.FragmentNameBinding
import org.variant2.RaviRamchand991526202.databinding.FragmentSecondBinding

//Ravi Ramchand 991526202
class NameFragment : Fragment() {
    private var _binding: FragmentNameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var username = ""

        binding.nameFragNextBtn.setOnClickListener {
            var bundle = arguments

            if(bundle == null){
                Log.d("Error", "Error")
            }

            val args = NameFragmentArgs.fromBundle(bundle!!)

            println("Count: "+args.count);

            username = binding.editName.text.toString();

            val directions = NameFragmentDirections.actionNameFragmentToSelectionFragment(username,0, args.count)

            findNavController().navigate(directions)

            //findNavController().navigate(R.id.action_nameFragment_to_selectionFragment);
        }

    }

}