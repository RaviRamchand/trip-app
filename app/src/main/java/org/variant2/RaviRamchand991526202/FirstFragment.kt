package org.variant2.RaviRamchand991526202

//Ravi Ramchand 991526202

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.variant2.RaviRamchand991526202.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var umbrella:String = "";
        var sunglasses:String = "";
        var passport:String = "";

        //Check if umbrella was selected -> Set back to empty if it was selected and unselected
        binding.cbUmbrella.setOnCheckedChangeListener{buttonView, isChecked ->
            println("Umbrella clicked")
            if(binding.cbUmbrella.isChecked) {
                umbrella = "Umbrella"
            }
            else {
                umbrella = "";
            }
        }

        //Check if sunglasses was selected -> Set back to empty if it was selected and unselected
        binding.cbSunglasses.setOnCheckedChangeListener{buttonView, isChecked ->
            println("Sunglasses clicked")
            if(binding.cbSunglasses.isChecked){
                sunglasses = "Sunglasses";
            }
            else {
                sunglasses = "";
            }

        }

        //Check if passport was selected -> Set back to empty if it was selected and unselected
        binding.cbPassport.setOnCheckedChangeListener{buttonView, isChecked ->
            println("Passport clicked")
            if(binding.cbPassport.isChecked){
                passport = "Passport";
            }
            else {
                passport = "";
            }
        }

        //navigate to Second Fragment with specified arguments
        binding.nextBtn.setOnClickListener {
            //findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            val directions = FirstFragmentDirections.actionFirstFragmentToSecondFragment(umbrella, sunglasses, passport)
            findNavController().navigate(directions)
        }

        println("Passport: $passport, Umbrella $umbrella, Sunglasses: $sunglasses");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}