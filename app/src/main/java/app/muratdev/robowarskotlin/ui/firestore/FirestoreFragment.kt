package app.muratdev.robowarskotlin.ui.firestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.muratdev.robowarskotlin.R

class FirestoreFragment : Fragment() {

    private lateinit var firestoreViewModel: FirestoreViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        firestoreViewModel =
                ViewModelProvider(this).get(FirestoreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_firestore, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        firestoreViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}