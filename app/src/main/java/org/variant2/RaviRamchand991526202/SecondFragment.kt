package org.variant2.RaviRamchand991526202

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.variant2.RaviRamchand991526202.databinding.FragmentSecondBinding

//Ravi Ramchand 991526202
/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var count = 0;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if(bundle == null){
            Log.d("Error", "Error")
        }

        val args = SecondFragmentArgs.fromBundle(bundle!!)

        if(!args.sunglasses.isNullOrBlank()){
            count++;
        }
        if(!args.umbrella.isNullOrBlank()){
            count++;
        }
        if(!args.passport.isNullOrBlank()){
            count++;
        }

        if(args.sunglasses.isNullOrBlank() && args.passport.isNullOrBlank() && args.umbrella.isNullOrBlank()){
            binding.selectResults.setText("Nothing was selected")
        }
        binding.selectResults.setText(args.sunglasses +"\n\n" + args.passport +"\n\n" +args.umbrella)

        binding.nextBtnFrag2.setOnClickListener {
            val directions = SecondFragmentDirections.actionSecondFragmentToNameFragment(count);
            //findNavController().navigate(R.id.action_secondFragment_to_nameFragment);
            findNavController().navigate(directions);
            println(args.sunglasses + args.passport + args.umbrella);
            println("Count: $count");
        }
        binding.backBtnFrag2.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}