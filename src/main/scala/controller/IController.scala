package controller

import model.field.IField
import model.player.IPlayer
import model.level.ILevel

enum State: 
  case MainMenu
  case LevelSelection
  case Running
  case GameOver

trait IController():
  def changeState(newState: State): State
  def start(): ILevel
  def moveLeft(): IPlayer
  def moveUp(): IPlayer
  def moveRight(): IPlayer
  def moveDown(): IPlayer
  def hasLost(): Boolean
  def hasWon(): Boolean
