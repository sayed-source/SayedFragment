package com.example.sayedfragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.sayedfragment.CommunicationViewModel
import com.google.android.material.textfield.TextInputEditText

class FirstFragment : Fragment(){
    private var communicationViewModel: CommunicationViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_first_fragment,
                container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)


        nameEditText.addTextChangedListener(
                object : TextWatcher {
                    override fun beforeTextChanged(
                            charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }
                    override fun onTextChanged(charSequence: CharSequence,

                                               i: Int, i1: Int, i2: Int) {

                        communicationViewModel!!.setName(charSequence.toString())
                    }
                    override fun afterTextChanged(editable: Editable) {
                    }
                })

    }
    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }


}