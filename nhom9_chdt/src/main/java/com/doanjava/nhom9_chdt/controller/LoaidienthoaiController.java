package com.doanjava.nhom9_chdt.controller;

import com.doanjava.nhom9_chdt.entity.Loaidienthoai;
import com.doanjava.nhom9_chdt.service.LoaidienthoaiService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/loaidienthoais")
@RequiredArgsConstructor
public class LoaidienthoaiController {
    private final LoaidienthoaiService loaidienthoaiService;
    @GetMapping
    public String showAllloaidienthoais(
            @NotNull Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "7") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("loaidienthoais", loaidienthoaiService.getAllLoaidienthoais(pageNo,
                pageSize, sortBy));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages",
                loaidienthoaiService.getAllLoaidienthoais(pageNo, pageSize, sortBy).size() / pageSize);
        return "loaidienthoai/list";
    }
    @GetMapping("/add")
    public String addloaidienthoaiForm(@NotNull Model model) {
        model.addAttribute("loaidienthoai", new Loaidienthoai());
        return "loaidienthoai/add";
    }
    @PostMapping("/add")
    public String addloaidienthoai(
            @Valid @ModelAttribute("loaidienthoai") Loaidienthoai loaidienthoai,
            @NotNull BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            return "loaidienthoai/add";
        }
        loaidienthoaiService.addLoaidienthoai(loaidienthoai);
        return "redirect:/loaidienthoais";
    }
    @GetMapping("/edit/{id}")
    public String editloaidienthoaiForm(@NotNull Model model, @PathVariable long id)
    {
        var loaidienthoai = loaidienthoaiService.getLoaidienthoaiById(id);
        model.addAttribute("loaidienthoai", loaidienthoai.orElseThrow(() -> new
                IllegalArgumentException("Loai dien thoai not found")));
        return "loaidienthoai/edit";
    }
    @PostMapping("/edit")
    public String editloaidienthoai(@Valid @ModelAttribute("loaidienthoai") Loaidienthoai loaidienthoai,
                                    @NotNull BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            return "loaidienthoai/edit";
        }
        loaidienthoaiService.updateLoaidienthoai(loaidienthoai);
        return "redirect:/loaidienthoais";
    }
    @GetMapping("/delete/{id}")
    public String deleteloaidienthoai(@PathVariable long id) {
        loaidienthoaiService.getLoaidienthoaiById(id)
                .ifPresentOrElse(
                        loaidienthoai -> loaidienthoaiService.deleteLoaidienthoaiById(id),
                        () -> { throw new IllegalArgumentException("Loai dien thoai not found"); });
        return "redirect:/loaidienthoais";
    }
    @GetMapping("/search")
    public String searchsdienthoai(
            @NotNull Model model,
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("loaidienthoais", loaidienthoaiService.searchLoaidienthoai(keyword));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages",
                loaidienthoaiService
                        .getAllLoaidienthoais(pageNo, pageSize, sortBy)
                        .size() / pageSize);
        return "loaidienthoai/list";
    }
}
