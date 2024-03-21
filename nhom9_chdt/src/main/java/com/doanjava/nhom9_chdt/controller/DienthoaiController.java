package com.doanjava.nhom9_chdt.controller;

import com.doanjava.nhom9_chdt.daos.Item;
import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.service.CartService;
import com.doanjava.nhom9_chdt.service.DienthoaiService;
import com.doanjava.nhom9_chdt.service.LoaidienthoaiService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dienthoais")
@RequiredArgsConstructor
public class DienthoaiController {
    private final DienthoaiService dienthoaiService;

    private final LoaidienthoaiService loaidienthoaiService;

    private final CartService cartService;

    @GetMapping
    public String showAlldienthoais(
            @NotNull Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "7") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("dienthoais", dienthoaiService.getAllDienthoais(pageNo,
                pageSize, sortBy));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("loaidienthoais",
                loaidienthoaiService.getAllLoaidienthoais());
        model.addAttribute("totalPages",
                dienthoaiService.getAllDienthoais(pageNo, pageSize, sortBy).size() / pageSize + 1);
        return "dienthoai/list";
    }
    @GetMapping("/danhsach")
    public String danhSachDT(
            @NotNull Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "8") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("dienthoais", dienthoaiService.getAllDienthoais(pageNo,
                pageSize, sortBy));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("loaidienthoais",
                loaidienthoaiService.getAllLoaidienthoais());
        model.addAttribute("totalPages",
                dienthoaiService.getAllDienthoais(pageNo, pageSize, sortBy).size() / (pageSize) + 1);
        return "dienthoai/danhsach";
    }
    @GetMapping("/detail/{id}")
    public String detailDienthoai(Model model, @PathVariable long id) {
        Optional<Dienthoai> dienthoai = dienthoaiService.getDienthoaiById(id);
        model.addAttribute("dienthoai", dienthoai);
        return "dienthoai/detail";
    }
    @GetMapping("/dienthoai/{maLoai}")
    public String showDienthoaiLoai(Model model, @PathVariable int maLoai) {
        List<Dienthoai> dienthoais = dienthoaiService.getDienThoaiByMaLoai(maLoai, true);
        model.addAttribute("dienthoais", dienthoais);
        return "dienthoai/loai";
    }
    @GetMapping("/add")
    public String adddienthoaiForm(@NotNull Model model) {
        model.addAttribute("dienthoai", new Dienthoai());
        model.addAttribute("loaidienthoais",
                loaidienthoaiService.getAllLoaidienthoais());
        return "dienthoai/add";
    }
    @PostMapping("/add")
    public String adddienthoai(
            @Valid @ModelAttribute("dienthoai") Dienthoai dienthoai,
            @NotNull BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            model.addAttribute("loaidienthoais",
                    loaidienthoaiService.getAllLoaidienthoais());
            return "dienthoai/add";
        }
        dienthoaiService.addDienthoai(dienthoai);
        return "redirect:/dienthoais";
    }
    @GetMapping("/edit/{id}")
    public String editdienthoaiForm(@NotNull Model model, @PathVariable long id)
    {
        var dienthoai = dienthoaiService.getDienthoaiById(id);
        model.addAttribute("dienthoai", dienthoai.orElseThrow(() -> new
                IllegalArgumentException("Dien thoai not found")));
        model.addAttribute("loaidienthoais", loaidienthoaiService.getAllLoaidienthoais());
        return "dienthoai/edit";
    }
    @PostMapping("/edit")
    public String editdienthoai(@Valid @ModelAttribute("dienthoai") Dienthoai dienthoai,
                                @NotNull BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            model.addAttribute("loaidienthoais",
                    loaidienthoaiService.getAllLoaidienthoais());
            return "dienthoai/edit";
        }
        dienthoaiService.updateDienthoai(dienthoai);
        return "redirect:/dienthoais";
    }
    @GetMapping("/delete/{id}")
    public String deletedienthoai(@PathVariable long id) {
        dienthoaiService.getDienthoaiById(id)
                .ifPresentOrElse(
                        dienthoai -> dienthoaiService.deleteDienthoaiById(id),
                        () -> { throw new IllegalArgumentException("Dien thoai not found"); });
        return "redirect:/dienthoais";
    }
    @GetMapping("/search")
    public String searchdienthoai(
            @NotNull Model model,
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("dienthoais", dienthoaiService.searchDienthoai(keyword));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages",
                dienthoaiService
                        .getAllDienthoais(pageNo, pageSize, sortBy)
                        .size() / pageSize);
        model.addAttribute("loaidienthoais",
                loaidienthoaiService.getAllLoaidienthoais());
        return "dienthoai/danhsach";
    }
    @PostMapping("/add-to-cart")
    public String addToCart(HttpSession session,
                            @RequestParam long id,
                            @RequestParam String tenDienThoai,
                            @RequestParam String hinh,
                            @RequestParam double giaBan,
                            @RequestParam(defaultValue = "1") int quantity)
    {
        var cart = cartService.getCart(session);
        cart.addItems(new Item(id, tenDienThoai, hinh, giaBan, quantity));
        cartService.updateCart(session, cart);
        return "redirect:/";
    }
}
