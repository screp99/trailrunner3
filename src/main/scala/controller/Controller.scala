package controller

import model.field.Field
import model.player.Player
import model.level.{Level, Level1}

class Controller() extends IController():
  var state: State = State.MainMenu
  var level: Level = Level1()
  def changeState(newState: State): State = 
    state = newState
    state
  def start(): Level = 
    level = Level1()
    level
  def moveLeft(): Player = level.player.moveLeft()
  def moveUp(): Player = level.player.moveUp()
  def moveRight(): Player = level.player.moveRight()
  def moveDown(): Player = level.player.moveDown()
  def hasLost(): Boolean = level.lose()
  def hasWon(): Boolean = level.win()