package app.muratdev.robowarskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val seekLeft = findViewById<SeekBar>(R.id.seekBarLeft)
        seekLeft?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {

                    override fun onProgressChanged(seek: SeekBar,
                        progress: Int, fromUser: Boolean) {
                            // write custom code for progress is changed
                            textViewLeft.text = (seek.progress-100).toString();
                    }

                    override fun onStartTrackingTouch(seek: SeekBar) { }
                    override fun onStopTrackingTouch(seek: SeekBar) { }

                }
        )

        val seekRight = findViewById<SeekBar>(R.id.seekBarRight)
                seekRight?.setOnSeekBarChangeListener(object :
                        SeekBar.OnSeekBarChangeListener {

                    override fun onProgressChanged(seek: SeekBar,
                        progress: Int, fromUser: Boolean) {
                            // write custom code for progress is changed
                            textViewRight.text = (seek.progress-100).toString();
                    }

                    override fun onStartTrackingTouch(seek: SeekBar) { }
                    override fun onStopTrackingTouch(seek: SeekBar) { }

                }
        )
    }
}