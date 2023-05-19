package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivitySystemBinding

class SystemActivity : AppCompatActivity() {
    lateinit var binding: ActivitySystemBinding

    private lateinit var T01 : CheckBox
    private lateinit var T02 : CheckBox
    private lateinit var T03 : CheckBox
    private lateinit var T04 : CheckBox
    private lateinit var T05 : CheckBox
    private lateinit var T06 : CheckBox
    private lateinit var T07 : CheckBox
    private lateinit var T08 : CheckBox
    private lateinit var T09 : CheckBox
    private lateinit var T10 : CheckBox
    private lateinit var T11 : CheckBox
    private lateinit var T12 : CheckBox
    private lateinit var T13 : CheckBox
    private lateinit var T14 : CheckBox
    private lateinit var T15 : CheckBox
    private lateinit var T16 : CheckBox
    private lateinit var T17 : CheckBox
    private lateinit var T18 : CheckBox
    private lateinit var T19 : CheckBox
    private lateinit var T20 : CheckBox
    private lateinit var T21 : CheckBox
    private lateinit var T22 : CheckBox
    private lateinit var T23 : CheckBox
    private lateinit var T24 : CheckBox
    private lateinit var T25 : CheckBox
    private lateinit var T26 : CheckBox
    private lateinit var T27 : CheckBox
    private lateinit var T28 : CheckBox
    private lateinit var btnDiagnosa : Button
    private lateinit var resultDiagnosa : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySystemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        T01 = findViewById<CheckBox>(R.id.penglihatanTerasaKabur)
        T02 = findViewById<CheckBox>(R.id.mataBerair)
        T03 = findViewById<CheckBox>(R.id.mataBengkak)
        T04 = findViewById<CheckBox>(R.id.mataTerasaPerih)
        T05 = findViewById<CheckBox>(R.id.mataTerasaAdaYangMengganjal)
        T06 = findViewById<CheckBox>(R.id.penglihatanSilau)
        T07 = findViewById<CheckBox>(R.id.terlihatLingkaranCahaya)
        T08 = findViewById<CheckBox>(R.id.penglihatanObjekGanda)
        T09 = findViewById<CheckBox>(R.id.mataBerwarnaMerah)
        T10 = findViewById<CheckBox>(R.id.mataTerasaGatal)
        T11 = findViewById<CheckBox>(R.id.mataTerasaPanas)
        T12 = findViewById<CheckBox>(R.id.sakitKepala)
        T13 = findViewById<CheckBox>(R.id.mataTerasaSakit)
        T14 = findViewById<CheckBox>(R.id.mataMeradang)
        T15 = findViewById<CheckBox>(R.id.mataNyeriHebat)
        T16 = findViewById<CheckBox>(R.id.mataTerasaNyeri)
        T17 = findViewById<CheckBox>(R.id.kelainanPadaPupilMata)
        T18 = findViewById<CheckBox>(R.id.mataLelah)
        T19 = findViewById<CheckBox>(R.id.seringMengedipkanMata)
        T20 = findViewById<CheckBox>(R.id.pekaTerhadapCahaya)
        T21 = findViewById<CheckBox>(R.id.penglihatanDekatTerasaKabur)
        T22 = findViewById<CheckBox>(R.id.tekananBolaMataMeningkat)
        T23 = findViewById<CheckBox>(R.id.penglihatanObjekJauhKurangTerlihatJelas)
        T24 = findViewById<CheckBox>(R.id.lemakMenutupiKornea)
        T25 = findViewById<CheckBox>(R.id.menyipitkanMataUntukMelihatBendaYangDekat)
        T26 = findViewById<CheckBox>(R.id.sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang)
        T27 = findViewById<CheckBox>(R.id.mataTegang)
        T28 = findViewById<CheckBox>(R.id.terlihatBayanganGarisHitam)

        btnDiagnosa = findViewById<Button>(R.id.btnDiagnosa)
        resultDiagnosa = findViewById<TextView>(R.id.resultDiagnosa)

        btnDiagnosa.setOnClickListener{
            var namaPenyakit = ""

            // Memeriksa status checkbox dan menggabungkan nama penyakit yang sesuai dengan rule
            if (T01.isChecked && T08.isChecked
                && T16.isChecked && T28.isChecked) {
                namaPenyakit += "Katarak"
            }
            if (T05.isChecked && T20.isChecked) {
                namaPenyakit += "DryEye(MataKering)"
            }
            if (T13.isChecked && T17.isChecked
                && T22.isChecked && T26.isChecked) {
                namaPenyakit += "Glaukoma"
            }
            if (T02.isChecked && T03.isChecked
                && T10.isChecked && T11.isChecked
                && T16.isChecked) {
                namaPenyakit += "Keratitis"
            }
            if (T12.isChecked && T18.isChecked
                && T19.isChecked && T23.isChecked) {
                namaPenyakit += "Myopia"
            }
            if (T02.isChecked && T09.isChecked
                && T24.isChecked) {
                namaPenyakit += "Pterygium"
            }
            if (T12.isChecked && T21.isChecked
                && T25.isChecked ) {
                namaPenyakit += "Hypermetropi"
            }
            if (T01.isChecked && T27.isChecked) {
                namaPenyakit += "Astigmatisma"
            }
            else{
                namaPenyakit += "Penyakit yang tidak terdeteksi"
            }

            // Menampilkan hasil diagnosis di TextView resultDiagnosa
            resultDiagnosa.text = "Anda didiagnosis dengan: $namaPenyakit"

        }
    }

    fun onClickChecked(view: View?){
        val checked = (view as CheckBox).isChecked
        var str = ""
        when (view.id) {
            R.id.penglihatanTerasaKabur -> {str = if (checked) "Gejala penglihatanTerasaKabur Diseleksi" else "Gejala penglihatanTerasaKabur Tidak Diseleksi"}
            R.id.mataBerair -> {str = if (checked) "Gejala mataBerair Diseleksi" else "Gejala mataBerair Tidak Diseleksi"}
            R.id.mataBengkak -> {str = if (checked) "Gejala mataBengkak Diseleksi" else "Gejala mataBengkak Tidak Diseleksi"}
            R.id.mataTerasaPerih -> {str = if (checked) "Gejala mataTerasaPerih Diseleksi" else "Gejala mataTerasaPerih Tidak Diseleksi"}
            R.id.mataTerasaAdaYangMengganjal -> {str = if (checked) "Gejala mataTerasaAdaYangMengganjal Diseleksi" else "Gejala mataTerasaAdaYangMengganjal Tidak Diseleksi"}
            R.id.penglihatanSilau -> {str = if (checked) "Gejala penglihatanSilau Diseleksi" else "Gejala penglihatanSilau Tidak Diseleksi"}
            R.id.terlihatLingkaranCahaya -> {str = if (checked) "Gejala terlihatLingkaranCahaya Diseleksi" else "Gejala terlihatLingkaranCahaya Tidak Diseleksi"}
            R.id.penglihatanObjekGanda -> {str = if (checked) "Gejala penglihatanObjekGanda Diseleksi" else "Gejala penglihatanObjekGanda Tidak Diseleksi"}
            R.id.mataBerwarnaMerah -> {str = if (checked) "Gejala mataBerwarnaMerah Diseleksi" else "Gejala mataBerwarnaMerah Tidak Diseleksi"}
            R.id.mataTerasaGatal -> {str = if (checked) "Gejala mataTerasaGatal Diseleksi" else "Gejala mataTerasaGatal Tidak Diseleksi"}
            R.id.mataTerasaPanas -> {str = if (checked) "Gejala mataTerasaPanas Diseleksi" else "Gejala mataTerasaPanas Tidak Diseleksi"}
            R.id.sakitKepala -> {str = if (checked) "Gejala sakitKepala Diseleksi" else "Gejala sakitKepala Tidak Diseleksi"}
            R.id.mataTerasaSakit -> {str = if (checked) "Gejala mataTerasaSakit Diseleksi" else "Gejala mataTerasaSakit Tidak Diseleksi"}
            R.id.mataMeradang -> {str = if (checked) "Gejala mataMeradang Diseleksi" else "Gejala mataMeradang Tidak Diseleksi"}
            R.id.mataNyeriHebat -> {str = if (checked) "Gejala mataNyeriHebat Diseleksi" else "Gejala mataNyeriHebat Tidak Diseleksi"}
            R.id.mataTerasaNyeri -> {str = if (checked) "Gejala mataTerasaNyeri Diseleksi" else "Gejala mataTerasaNyeri Tidak Diseleksi"}
            R.id.kelainanPadaPupilMata -> {str = if (checked) "Gejala kelainanPadaPupilMata Diseleksi" else "Gejala Gejala kelainanPadaPupilMata Tidak Diseleksi"}
            R.id.mataLelah -> {str = if (checked) "Gejala mataLelah Diseleksi" else "Gejala Gejala mataLelah Tidak Diseleksi"}
            R.id.seringMengedipkanMata -> {str = if (checked) "Gejala seringMengedipkanMata Diseleksi" else "Gejala Gejala seringMengedipkanMata Tidak Diseleksi"}
            R.id.pekaTerhadapCahaya -> {str = if (checked) "Gejala pekaTerhadapCahaya Diseleksi" else "Gejala Gejala pekaTerhadapCahaya Tidak Diseleksi"}
            R.id.penglihatanDekatTerasaKabur -> {str = if (checked) "Gejala penglihatanDekatTerasaKabur Diseleksi" else "Gejala Gejala penglihatanDekatTerasaKabur Tidak Diseleksi"}
            R.id.tekananBolaMataMeningkat -> {str = if (checked) "Gejala tekananBolaMataMeningkat Diseleksi" else "Gejala Gejala tekananBolaMataMeningkat Tidak Diseleksi"}
            R.id.penglihatanObjekJauhKurangTerlihatJelas -> {str = if (checked) "Gejala penglihatanObjekJauhKurangTerlihatJelas Diseleksi" else "Gejala Gejala penglihatanObjekJauhKurangTerlihatJelas Tidak Diseleksi"}
            R.id.lemakMenutupiKornea -> {str = if (checked) "Gejala lemakMenutupiKornea Diseleksi" else "Gejala Gejala lemakMenutupiKornea Tidak Diseleksi"}
            R.id.menyipitkanMataUntukMelihatBendaYangDekat -> {str = if (checked) "Gejala menyipitkanMataUntukMelihatBendaYangDekat Diseleksi" else "Gejala Gejala menyipitkanMataUntukMelihatBendaYangDekat Tidak Diseleksi"}
            R.id.sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang -> {str = if (checked) "Gejala sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang Diseleksi" else "Gejala Gejala sumberCahayaAkanBerwarnaPelangiJikaMelihatCahayaYangTerang Tidak Diseleksi"}
            R.id.mataTegang -> {str = if (checked) "Gejala mataTegang Diseleksi" else "Gejala Gejala mataTegang Tidak Diseleksi"}
            R.id.terlihatBayanganGarisHitam -> {str = if (checked) "Gejala terlihatBayanganGarisHitam Diseleksi" else "Gejala Gejala terlihatBayanganGarisHitam Tidak Diseleksi"}
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}