package model.player

trait IPlayer():
  def toGameString: String
  def moveRight(): IPlayer
  def moveLeft(): IPlayer
  def moveUp(): IPlayer
  def moveDown(): IPlayer