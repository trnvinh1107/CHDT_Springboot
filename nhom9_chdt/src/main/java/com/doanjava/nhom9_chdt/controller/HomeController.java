package com.doanjava.nhom9_chdt.controller;

import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.service.DienthoaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final DienthoaiService dienthoaiService;
    @GetMapping
    public String showTrangChu(Model model){
        List<Dienthoai> filteredDienthoais = dienthoaiService.getDienThoaiNoiBat(true, 4, true);
        model.addAttribute("dienthoaiNoiBats", filteredDienthoais);
        List<Dienthoai> dienThoaiApples = dienthoaiService.getDienThoaiTheoLoai(true, 1, 4, true);
        model.addAttribute("dienThoaiApples", dienThoaiApples);
        List<Dienthoai> dienThoaiSamSungs = dienthoaiService.getDienThoaiTheoLoai(true, 2, 4, true);
        model.addAttribute("dienThoaiSamSungs", dienThoaiSamSungs);
        return "home/trangchu";
    }

    @GetMapping("/gioithieu")
    public String showGioithieu() {
        return "home/gioithieu";
    }
    @GetMapping("/dichvusuachua")
    public String showDichvusuachua() {
        return "home/dichvusuachua";
    }
}
