#!/bin/bash

echo "NyuggerLeaderboard GitHub feltöltő script indítása..."

# Git init, repo hozzáadás
git init
git remote add origin https://github.com/Itssuboo/nyuggerleaderboard.git

# Fájlok hozzáadása és commitolása
git add .
git commit -m "Initial commit - NyuggerSMP Discord Leaderboard plugin"

# Branch beállítása és feltöltés
git branch -M main
git push -u origin main

echo "✅ Sikeresen feltöltötted a plugin-t a GitHub-ra!"
