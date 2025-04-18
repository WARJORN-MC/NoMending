# NoMending Plugin (1.21.4)

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.4-brightgreen)
![Version](https://img.shields.io/badge/Version-1.0.1--BETA-yellow)

A lightweight Spigot plugin that completely disables the Mending enchantment on your Minecraft server.

## Features

- **Blocks Mending application** through all methods:
  - Enchanting tables
  - Anvil combinations
  - Enchanted books
- **Version compatible**: Specifically designed for Minecraft 1.21.4
- **Lightweight**: Minimal performance impact
- **Configurable**: (Future update) Enable/disable logging

## Installation

1. Download the latest `NoMending-1.0.1-BETA.jar` from releases
2. Place the JAR file in your server's `plugins/` folder
3. Restart your server

## Commands

Currently no commands available (planned for future updates)

## Permissions

Currently no permissions required (planned for future updates)

## How It Works

The plugin:
1. Listens for enchantment events and removes Mending if applied
2. Intercepts anvil operations to prevent Mending combinations
3. Handles enchanted books properly

## Planned Features

- [ ] Command to scan and remove existing Mending items
- [ ] Configuration file for options
- [ ] Villager trade protection
- [ ] Logging toggle

## Support

Version: 1.0.1-BETA  
Minecraft: 1.21.4  
Author: YourName  
Issue tracker: [GitHub Issues](#)

## License

This project is licensed under MIT License.
