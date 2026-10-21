package id.berhitung.petualangan

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : Activity() {
    private var angka1 = 0
    private var angka2 = 0
    private var skor = 0
    private var soal = 1

    private lateinit var pertanyaan: TextView
    private lateinit var skorTeks: TextView
    private lateinit var tombol: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tampilkanGame()
        soalBaru()
    }

    private fun tampilkanGame() {
        val halaman = LinearLayout(this)
        halaman.orientation = LinearLayout.VERTICAL
        halaman.gravity = Gravity.CENTER
        halaman.setPadding(28, 24, 28, 24)
        halaman.setBackgroundColor(Color.rgb(255, 248, 220))

        val judul = TextView(this)
        judul.text = "🌟 PETUALANGAN BERHITUNG 🌟"
        judul.textSize = 25f
        judul.gravity = Gravity.CENTER
        judul.setTextColor(Color.rgb(30, 100, 180))
        halaman.addView(judul)

        skorTeks = TextView(this)
        skorTeks.textSize = 20f
        skorTeks.gravity = Gravity.CENTER
        halaman.addView(skorTeks)

        pertanyaan = TextView(this)
        pertanyaan.textSize = 36f
        pertanyaan.gravity = Gravity.CENTER
        pertanyaan.setPadding(8, 40, 8, 40)
        halaman.addView(pertanyaan)

        tombol = LinearLayout(this)
        tombol.orientation = LinearLayout.VERTICAL
        halaman.addView(tombol)

        val ulang = Button(this)
        ulang.text = "Mulai Ulang"
        ulang.textSize = 18f
        ulang.setOnClickListener {
            skor = 0
            soal = 1
            soalBaru()
        }
        halaman.addView(ulang)

        setContentView(halaman)
    }

    private fun soalBaru() {
        angka1 = Random.nextInt(1, 11)
        angka2 = Random.nextInt(1, 11)

        skorTeks.text = "Soal $soal dari 10     ⭐ Skor: $skor"
        pertanyaan.text = "$angka1 + $angka2 = ?"
        tombol.removeAllViews()

        val jawabanBenar = angka1 + angka2
        val pilihan = (listOf(jawabanBenar) +
            (1..3).map {
                var salah: Int
                do {
                    salah = Random.nextInt(2, 21)
                } while (salah == jawabanBenar)
                salah
            }).shuffled()

        pilihan.forEach { angka ->
            val btn = Button(this)
            btn.text = angka.toString()
            btn.textSize = 25f
            btn.setOnClickListener {
                if (angka == jawabanBenar) {
                    skor += 10
                    Toast.makeText(this, "Hebat! Jawaban benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ayo coba lagi!", Toast.LENGTH_SHORT).show()
                }

                soal++
                if (soal > 10) {
                    pertanyaan.text = "🎉 Selesai!\nSkor kamu: $skor dari 100"
                    skorTeks.text = "Permainan selesai"
                    tombol.removeAllViews()
                } else {
                    soalBaru()
                }
            }
            tombol.addView(btn)
        }
    }
}
