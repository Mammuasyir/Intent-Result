package com.muasyir.startactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muasyir.startactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBiasa.setOnClickListener {
            startActivity(Intent(this, BiasaActivity::class.java))
        }

        binding.btnResult.setOnClickListener {
            val i = Intent(this, ResultActivity::class.java)
            startActivityForResult(i, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100) {
            if (resultCode == 200) {
                val name = data?.getStringExtra("DT")
                binding.tvHasil.text = name
            }
        }
    }
}