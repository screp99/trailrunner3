package model.level

import model.field.Field
import model.player.Player

class Level(val dungeon: Array[Array[Field]],
  val name: String,
  val player: Player,
  val winX: Int,
  val winY: Int,
  val doorX: Int,
  val doorY: Int,
  var isDoorOpen: Boolean) extends ILevel(10):
  
  def lose(): Boolean = 
    if dungeon(player.yPos)(player.xPos).value < 0 then
      return true
    false
  

  def playerStandsOnDoor(): Boolean = 
    if player.xPos == doorX && player.yPos == doorY then
      return true
    false
  

  def win(): Boolean = 
    if isDoorOpen && playerStandsOnDoor() then
      return true
    false
  

  def fillNullValues() : Unit = 
    for i <- 0 until 10; j <- 0 until 10 do 
      val dungeonField = Option(dungeon(i)(j))
      dungeonField.getOrElse(dungeon(i)(j) = Field(-99, "Wall", false, false))
  

  def standsPlayerInFrontOfOpenDoor(): Level = 
    if player.xPos == winX && player.yPos == winY && this.sum() == 0 then
      this.isDoorOpen = true
    this
  

  def closeDoor() : Level = 
    this.isDoorOpen = false
    this
  
  def sum() : Int = 
    var sum = 0
    for i <- 0 until size; j <- 0 until size do
      if dungeon(i)(j).value > 0 && dungeon(i)(j).value < 10 then
        sum += dungeon(i)(j).value
    sum
    
  override def toString: String = dungeon.map(_.mkString).mkString("\n")