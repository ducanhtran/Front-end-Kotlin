package com.example.Springtutorial

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.FileInputStream

class SanPham{
    var ma:Int = 0
    var ten:String = ""
    var donGia:Double = 0.0
    constructor()
    constructor(ma: Int, ten: String, donGia: Double){
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
    }

    override fun toString(): String {
        return ma.toString()+"\t"+ten+"\t"+donGia
    }
}