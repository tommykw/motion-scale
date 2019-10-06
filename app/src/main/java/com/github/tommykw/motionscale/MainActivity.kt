package com.github.tommykw.motionscale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.*
import com.github.tommykw.motionscale.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.motionLayout)

        binding.square.setOnClickListener { view ->
            if (binding.motionLayout.currentState == R.id.scale_down) {
                binding.motionLayout.transitionToStart()
            } else if (binding.motionLayout.currentState == R.id.scale_up) {
                val constraintSet = binding.motionLayout.getConstraintSet(R.id.scale_down)

                constraintSet.connect(view.id, TOP, R.id.container, TOP, 0)
                constraintSet.connect(view.id, START, R.id.container, START, 0)
                constraintSet.connect(view.id, END, R.id.container, END, 0)
                constraintSet.connect(view.id, BOTTOM, R.id.container, BOTTOM, 0)

                binding.motionLayout.updateState(R.id.scale_down, constraintSet)
                binding.motionLayout.transitionToEnd()
            }
        }
    }
}