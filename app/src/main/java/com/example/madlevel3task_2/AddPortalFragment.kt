package com.example.madlevel3task_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

const val REQUEST_PORTAL_KEY = "req_portal"
const val BUNDLE_PORTAL_KEY = "bundle_portal"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_add_portal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal(){
        val titleText = etTitle.text.toString()
        val urlText = etUrl.text.toString()

        if(titleText.isNotBlank() && urlText.isNotBlank()){
            val bundle = Bundle()

            bundle.putParcelable(BUNDLE_PORTAL_KEY, bundleOf(
                "PORTAL_TEXT" to titleText,
                "PORTAL_URL" to urlText
            )
            )

            setFragmentResult(REQUEST_PORTAL_KEY, bundle)
            findNavController().popBackStack()
        } else {
            Toast.makeText(activity, "not a valid portal", Toast.LENGTH_SHORT).show()
        }
    }
}