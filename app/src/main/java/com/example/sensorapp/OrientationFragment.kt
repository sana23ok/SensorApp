package com.example.sensorapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class OrientationFragment : Fragment(), SensorEventListener {

    private lateinit var sensorNameTextView: TextView
    private lateinit var orientationTextView: TextView
    private lateinit var sensorManager: SensorManager
    private var orientationSensor: Sensor? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_orientation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)

        sensorNameTextView = view.findViewById(R.id.sensorOrientNameTextView)
        orientationTextView = view.findViewById(R.id.orientationTextView)

        if (orientationSensor == null) {
            sensorNameTextView.text = "Orientation sensor not found"
        } else {
            sensorNameTextView.text = "Orientation sensor: ${orientationSensor?.name}"
        }
    }


    override fun onResume() {
        super.onResume()
        orientationSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ORIENTATION) {
            val azimuthRad = event.values[0]
            val pitchRad = event.values[1]
            val rollRad = event.values[2]

            val azimuthDeg = Math.toDegrees(azimuthRad.toDouble()).toFloat()
            val pitchDeg = Math.toDegrees(pitchRad.toDouble()).toFloat()
            val rollDeg = Math.toDegrees(rollRad.toDouble()).toFloat()

            orientationTextView.text = String.format(
                "Azimuth: %.2f°\nTilt angle: %.2f°\nRotation: %.2f°",
                azimuthDeg, pitchDeg, rollDeg
            )
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
