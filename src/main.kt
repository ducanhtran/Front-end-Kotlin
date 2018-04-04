package com.example.Springtutorial

fun main(args: Array<String>) {
    var data:MutableList<SanPham> = mutableListOf()
    var sp1=SanPham(1,"Coca cola",15.5)
    data.add(sp1)
    var sp2=SanPham(2,"Sting",25.0)
    data.add(sp2)
    var sp3=SanPham(3,"Redbull",17.0)
    data.add(sp3)

    println("Ban muon xuat file Json (nhap 1) hay XML (nhap2)")
    var a: Int = readLine()!!.toInt()
    if (a==1) {
        var kqLuu =
                XMLFileFactory().LuuFile(data, "out/data/dulieusanpham.xml")
        if (kqLuu) {
            println("Lưu text file thành công")
        } else {
            println("Lưu text file thất bại")
        }
    }
    else
    {
        var data:MutableList<SanPham> = mutableListOf()
        var sp1=SanPham(1,"Coca cola",15.5)
        data.add(sp1)
        var sp2=SanPham(2,"Sting",25.0)
        data.add(sp2)
        var sp3=SanPham(3,"Redbull",17.0)
        data.add(sp3)
        var kqLuu=
                JSonFileFactory().LuuFile(data,"out/data/dulieusanpham.json")
        if(kqLuu)
        {
            println("Lưu Json file thành công")
        }
        else
        {
            println("Lưu Json file thất bại")
        }
    }
}
//Doc file Json
//fun main(args: Array<String>) {
//    var data:MutableList<SanPham> =
//            JSonFileFactory().DocFile("d:/dulieusanpham.json")
//    for (sp in data)
//        println(sp)
//}
