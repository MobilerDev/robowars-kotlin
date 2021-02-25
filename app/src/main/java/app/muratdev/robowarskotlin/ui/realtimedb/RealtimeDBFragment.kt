package app.muratdev.robowarskotlin.ui.realtimedb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.muratdev.robowarskotlin.R

class RealtimeDBFragment : Fragment() {

    private lateinit var realtimeDBViewModel: RealtimeDBViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        realtimeDBViewModel =
                ViewModelProvider(this).get(RealtimeDBViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_realtimedb, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        realtimeDBViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}