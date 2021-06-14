package model.player

class Player(var xPos: Int,
  var yPos: Int) extends IPlayer():

  def toGameString: String = "P"

  def moveRight(): Player = 
    this.xPos += 1
    return this
  

  def moveLeft(): Player = 
    this.xPos -= 1
    return this
  

  def moveUp(): Player = 
    this.yPos -= 1
    return this
  

  def moveDown(): Player = 
    this.yPos += 1
    return this
  