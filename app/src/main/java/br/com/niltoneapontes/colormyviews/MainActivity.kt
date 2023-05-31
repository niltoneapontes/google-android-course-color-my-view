package br.com.niltoneapontes.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import br.com.niltoneapontes.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedBox = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> = listOf(
                boxOneText,
                boxTwoText,
                boxThreeText,
                boxFourText,
                boxFiveText,
                constraintLayout
            )

            val buttons: List<Button> = listOf(redButton, yellowButton, greenButton)

            for (item in clickableViews) {
                item.setOnClickListener { makeColored(it) }
            }

            for (button in buttons) {
                button.setOnClickListener {
                    when (button.id) {
                        R.id.red_button -> {
                            when (selectedBox) {
                                1 -> boxOneText.setBackgroundResource(R.color.red)
                                2 -> boxTwoText.setBackgroundResource(R.color.red)
                                3 -> boxThreeText.setBackgroundResource(R.color.red)
                                4 -> boxFourText.setBackgroundResource(R.color.red)
                                5 -> boxFiveText.setBackgroundResource(R.color.red)
                            }
                        }
                        R.id.green_button -> {
                            when (selectedBox) {
                                1 -> boxOneText.setBackgroundResource(R.color.green)
                                2 -> boxTwoText.setBackgroundResource(R.color.green)
                                3 -> boxThreeText.setBackgroundResource(R.color.green)
                                4 -> boxFourText.setBackgroundResource(R.color.green)
                                5 -> boxFiveText.setBackgroundResource(R.color.green)
                            }
                        }
                        R.id.yellow_button -> {
                            when (selectedBox) {
                                1 -> boxOneText.setBackgroundResource(R.color.yellow)
                                2 -> boxTwoText.setBackgroundResource(R.color.yellow)
                                3 -> boxThreeText.setBackgroundResource(R.color.yellow)
                                4 -> boxFourText.setBackgroundResource(R.color.yellow)
                                5 -> boxFiveText.setBackgroundResource(R.color.yellow)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> selectedBox = 1
            R.id.box_two_text -> selectedBox = 2
            R.id.box_three_text -> selectedBox = 3
            R.id.box_four_text -> selectedBox = 4
            R.id.box_five_text -> selectedBox = 5
        }
        view.setBackgroundColor(Color.GRAY)
    }
}
