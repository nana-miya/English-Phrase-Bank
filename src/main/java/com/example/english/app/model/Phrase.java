package com.example.english.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String englishText;
    private String japaneseText;
    private String memo;
    private boolean favorite;

    // --- ここで右クリック > Source > Generate Getters and Setters を実行 ---
    // ※以下は自動生成されるコードのイメージです
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEnglishText() { return englishText; }
    public void setEnglishText(String englishText) { this.englishText = englishText; }
    public String getJapaneseText() { return japaneseText; }
    public void setJapaneseText(String japaneseText) { this.japaneseText = japaneseText; }
    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }
    public boolean isFavorite() { return favorite; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }
}