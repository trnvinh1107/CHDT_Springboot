package com.doanjava.nhom9_chdt.controller;

import com.doanjava.nhom9_chdt.entity.Cthd;
import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.entity.Hoadon;
import com.doanjava.nhom9_chdt.repository.CthdRepository;
import com.doanjava.nhom9_chdt.repository.HoadonRepository;
import com.doanjava.nhom9_chdt.service.CartService;
import com.doanjava.nhom9_chdt.service.HoadonService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hoadons")
@RequiredArgsConstructor
public class HoadonController {
    private final HoadonService hoadonService;
    private final CthdRepository cthdRepository;
    private final HoadonRepository hoadonRepository;
    @GetMapping
    public String showAllhoadons(
            @NotNull Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "7") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("hoadons", hoadonService.getAllHoadons(pageNo,
                pageSize, sortBy));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages",
                hoadonService.getAllHoadons(pageNo, pageSize, sortBy).size() / pageSize);
        return "hoadon/list";
    }

    @GetMapping("/details/{id}")
    public String cthd(@PathVariable("id") Long id, Model model){
        Hoadon hoadon = hoadonRepository.findByHoadonId(id);
        List<Cthd> cthdList = cthdRepository.findByHoadonId(id);
        if (!cthdList.isEmpty()) {
            model.addAttribute("hoadon", hoadon);
            model.addAttribute("cthdList", cthdList);
            return "hoadon/details"; // Trả về tên của view để hiển thị chi tiết hóa đơn
        } else {
            return "error"; // Trả về tên của view lỗi nếu không tìm thấy chi tiết hóa đơn
        }
    }
}
