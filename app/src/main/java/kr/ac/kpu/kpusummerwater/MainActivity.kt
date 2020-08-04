package kr.ac.kpu.kpusummerwater

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Region
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


//ppt ch10 레이아웃 include 방법 참조! Github branch Test 2
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val mainIntent = Intent(this, RegionSelect::class.java)
        mainButton.setOnClickListener(){
            //startActivity(mainIntent)
            showSettingPopup()
        }
    }
    private fun showSettingPopup(){
        val placeArray = arrayOf("현재 장소","다른 장소")
        lateinit var mainIntent: Intent
        
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("장소 선택")
            .setSingleChoiceItems(placeArray, -1, { _, which ->
                if(which == 0){
                    mainIntent = Intent(this,WaterView::class.java)
                }
                else{
                    mainIntent = Intent(this,RegionSelect::class.java)
                }
            } )
            .setPositiveButton("확인"){ dialog, which ->
                startActivity(mainIntent)
            }
            .setNeutralButton("취소",null)
            .create()
            .show()
    }
}

