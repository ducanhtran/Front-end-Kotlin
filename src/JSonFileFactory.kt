package com.example.Springtutorial

import com.example.Springtutorial.SanPham
import com.google.gson.Gson
import java.io.FileWriter
import java.io.FileReader
import com.google.gson.reflect.TypeToken

class JSonFileFactory {
    fun LuuFile(data:MutableList<SanPham>, path:String) :Boolean
    {
        try{
            val gs = Gson()
            val file = FileWriter(path)
            gs.toJson(data,file)
            file.close()
            return true
        }
        catch (ex:Exception)
        {
            ex.printStackTrace()
        }
        return false
    }

    fun DocFile(path:String) :MutableList<SanPham>
    {
        var data:MutableList<SanPham> = mutableListOf()
        try {
            val gson = Gson()
            var file = FileReader(path)
            data = gson.fromJson<MutableList<SanPham>>(file,
                    object : TypeToken<MutableList<SanPham>>()
                    {
                    }.type
            )
            file.close()
        }
        catch (ex:Exception)
        {
            ex.printStackTrace()
        }
        return data
    }
}