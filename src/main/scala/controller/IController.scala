package controller

import model.field.IField
import model.player.IPlayer
import model.level.ILevel

trait IController():
    def moveLeft(): IPlayer
    def moveUp(): IPlayer
    def moveRight(): IPlayer
    def moveDown(): IPlayer
