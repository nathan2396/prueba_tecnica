package com.example.pruebatecnica.mvvm.common

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.airbnb.lottie.LottieDrawable
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.FragmentLoadingAnimationBinding


class LoadingScreenFragment : DialogFragment() {

    var fragmentMG : FragmentManager? = null
    val LOTTIE_ASSET = "loading_animation.json"

    private lateinit var binding : FragmentLoadingAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog_Transparent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoadingAnimationBinding.inflate(inflater, container, true)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false

        binding.animationView.imageAssetsFolder = "assets"
        binding.animationView.setAnimation(LOTTIE_ASSET)
        binding.animationView.repeatCount = LottieDrawable.INFINITE

        playAnimation()
    }

    fun playAnimation() {
        binding.animationView.playAnimation()
    }

    override fun onDismiss(dialog: DialogInterface) {
        binding.animationView.cancelAnimation()
        super.onDismiss(dialog)
    }

    override fun onStart() {
        super.onStart()
        dialog!!.window.apply {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog!!.window!!.setLayout(width, height)
        }
    }

    companion object
    {
        const val TAG = "LoadingScreenFragment"

        fun display(fragmentManager: FragmentManager): LoadingScreenFragment
        {
            val dialogFragment = LoadingScreenFragment()

            dialogFragment.show(fragmentManager, TAG)
            dialogFragment.fragmentMG = fragmentManager
            return dialogFragment
        }
    }
}