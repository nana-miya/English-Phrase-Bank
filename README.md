# English Phrase Bank (CRUD Web Application)

https://github.com/user-attachments/assets/9f0b2d36-fb1f-4373-90c8-12cfb5ff643e

Java (Spring Boot) で作成した、英単語学習管理アプリです。
「覚えたフレーズを逃さない、声で確認できる」をコンセプトに開発しました。

## 🚀 主な機能
- **CRUD機能**: フレーズの登録、一覧表示、編集、削除。
- **検索・フィルター**: キーワード検索とお気に入り（🌟）による絞り込み。
- **音声読み上げ**: Web Speech API を活用し、登録した英語をネイティブ音声で再生。
- **レスポンシブデザイン**: Bootstrapを使用し、PC・スマホ両方で快適に操作可能。

## 🛠 使用技術
- **Backend**: Java 21 / Spring Boot 3.4
- **Database**: H2 Database (In-Memory)
- **Frontend**: Thymeleaf / Bootstrap 5 / JavaScript (Web Speech API)
- **Build Tool**: Maven

## 💡 こだわり・工夫した点
- **ユーザー体験 (UX)**: 登録した最新のフレーズが一番上に来るように設計。
- **セキュリティ**: Thymeleaf 3.1の制約に対応し、JavaScriptへのデータ受け渡しを `data-*` 属性経由で行う安全な設計にしました。
