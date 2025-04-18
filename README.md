# NoMending Plugin (v1.1.0)

![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-brightgreen)
![Version](https://img.shields.io/badge/Version-1.1.0-blue)
![License](https://img.shields.io/badge/License-MIT-green)

A Spigot plugin that completely disables the Mending enchantment with additional tools to clean existing items.

## ✨ Features
- **Blocks Mending** in all forms:
  - Enchanting tables
  - Anvil combinations
  - Enchanted books
- **New Command**:
  ```/clearmending [player]``` - Remove Mending from inventories
- **Permission System**:
  - `nomending.clean` - Self-clearing
  - `nomending.clean.others` - Admin clearing
- **Zero Performance Impact**

## 🛠️ Installation
1. Download `NoMending-1.1.0.jar` from [Releases](#)
2. Place in your server's `plugins/` folder
3. Restart the server

## 📋 Commands
| Command | Description | Permission |
|---------|-------------|------------|
| `/clearmending` | Clear your own inventory | `nomending.clean` |
| `/clearmending <player>` | Clear another player's inventory | `nomending.clean.others` |

## ⚙️ Config (v1.1.0)
```yaml
# config.yml
log-actions: true  # Log clearing actions to console
broadcast-clears: false  # Announce when players' items are cleared
