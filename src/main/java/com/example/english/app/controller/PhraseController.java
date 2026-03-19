package com.example.english.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.english.app.model.Phrase;
import com.example.english.app.repository.PhraseRepository;

@Controller
public class PhraseController {

    private final PhraseRepository repository;

    public PhraseController(PhraseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model, 
                       @RequestParam(name = "keyword", required = false) String keyword,
                       @RequestParam(name = "onlyFavorite", defaultValue = "false") boolean onlyFavorite) {
        List<Phrase> phraseList;
        
        if (onlyFavorite) {
            // ここを変更
            phraseList = repository.findByFavoriteTrueOrderByIdDesc();
        } else if (keyword != null && !keyword.isEmpty()) {
            // ここを変更
            phraseList = repository.findByEnglishTextContainingIgnoreCaseOrderByIdDesc(keyword);
        } else {
            // ここを変更
            phraseList = repository.findAllByOrderByIdDesc();
        }
        
        model.addAttribute("phrases", phraseList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("onlyFavorite", onlyFavorite);
        return "index";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Phrase phrase) {
        repository.save(phrase);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/favorite/{id}")
    public String toggleFavorite(@PathVariable("id") Long id) {
        Phrase p = repository.findById(id).orElseThrow();
        p.setFavorite(!p.isFavorite());
        repository.save(p);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("phrase", repository.findById(id).orElseThrow());
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Phrase phrase) {
        phrase.setId(id);
        repository.save(phrase);
        return "redirect:/";
    }
}