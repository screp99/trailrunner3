package controller

import model.field.Field
import model.player.Player
import model.level.Level

class Controller(var player: Player,
  var field: Field,
  var level: Level) extends IController():
    def moveLeft(): Player = player.moveLeft()
    def moveUp(): Player = player.moveUp()
    def moveRight(): Player = player.moveRight()
    def moveDown(): Player = player.moveDown()
    def 