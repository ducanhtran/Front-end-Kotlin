package com.example.Springtutorial

fun main(args: Array<String>) {
    var database:MutableList<DanhMuc> = mutableListOf<DanhMuc>()
    var dmDienTu:DanhMuc=DanhMuc(1,"Mặt hàng điện tử")
    database.add(dmDienTu)
    var bongden:SanPham=SanPham(1,"Bóng đèn điện Quang",150.0)
    dmDienTu.ThemSanPham(bongden)
    var acquy:SanPham=SanPham(2,"Ắc quy Đồng Nai",250.0)
    dmDienTu.ThemSanPham(acquy)
    var maydien:SanPham=SanPham(3,"Máy phát điện ABC",90.0)
    dmDienTu.ThemSanPham(maydien)
    var dmTieuDung:DanhMuc=DanhMuc(2,"Mặt hàng tiêu dùng")
    database.add(dmTieuDung)
    var xabong:SanPham=SanPham(4,"Xà Bông Lifeboy",15.0)
    dmTieuDung.ThemSanPham(xabong)
    var nuocruachen:SanPham=SanPham(5,"Nước rửa chén Sunlight",12.0)
            dmTieuDung.ThemSanPham(nuocruachen)
            var dmHoaChat:DanhMuc=DanhMuc(3,"Mặt hàng Hóa Chất")
    database.add(dmHoaChat)
    var dietmuoi:SanPham=SanPham(6,"Thuốc Diệt Muỗi XYZ",80.0)
    dmHoaChat.ThemSanPham(dietmuoi)
    var dietchuot:SanPham=SanPham(7,"Thuốc Diệt Chuỗi ABC",70.0)
    dmHoaChat.ThemSanPham(dietchuot)
    for (dm in database)
        println(dm)
    var kqLuu=
            JSonFileFactory().LuuFile(database,"out/data/dulieudanhmuc.json")
    if(kqLuu)
    {
        println("Lưu Json file thành công")
    }
    else
    {
        println("Lưu Json file thất bại")
    }
}
