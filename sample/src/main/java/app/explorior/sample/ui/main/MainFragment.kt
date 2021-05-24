package app.explorior.sample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import app.explorior.sample.MyApp
import app.explorior.sample.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val analytics = (requireActivity().application as MyApp).analytics
        viewModel =
            ViewModelProviders.of(this, MainViewModelFactory(analytics)).get(MainViewModel::class.java)

        view?.findViewById<View>(R.id.button)?.setOnClickListener {
            viewModel.logEventA()
        }

        view?.findViewById<View>(R.id.button2)?.setOnClickListener {
            viewModel.logEventB()
        }
    }

}
