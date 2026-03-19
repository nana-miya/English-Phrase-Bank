package com.example.english.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.english.app.model.Phrase;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    // 検索（新しい順）
    List<Phrase> findByEnglishTextContainingIgnoreCaseOrderByIdDesc(String keyword);
    
    // お気に入り（新しい順）
    List<Phrase> findByFavoriteTrueOrderByIdDesc();
    
    // 全件取得（新しい順）
    List<Phrase> findAllByOrderByIdDesc();
}