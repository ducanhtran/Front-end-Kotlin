package com.example.Springtutorial

import java.io.Serializable

class DanhMuc {
    var MaDanhMuc:Int = 0
    var TenDanhMuc:String = ""
    var SanPhams:MutableList<SanPham> = mutableListOf()
    constructor()
    constructor(MaDanhMuc: Int, TenDanhMuc: String) {
        this.MaDanhMuc = MaDanhMuc
        this.TenDanhMuc = TenDanhMuc
    }

    override fun toString(): String {
        var s=""
        for (sp in SanPhams)
            s+="\t"+sp.toString()+ "\n"
        var infor = "Danh muc: ["+MaDanhMuc.toString()+"\t"+TenDanhMuc+"]"
        infor+="\nCác Sản phẩm của danh Mục này là:\n"+s
        return infor
    }
    fun ThemSanPham(sp:SanPham)
    {
        SanPhams.add(sp)
    }
}