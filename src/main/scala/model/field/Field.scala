package model.field

class Field(var value: Int,
  val fieldType: String = "Ground",
  var fog: Boolean = false,
  var isPlayerOnField: Boolean = false) extends IField():

  def isBroken:Boolean = value == 0

  def isSet:Boolean = value >= 0

  def PlayerWalksOnField(): Field = 
    this.value -= 1
    this.isPlayerOnField = true
    this

  def PlayerLeavesField(): Field = 
    this.isPlayerOnField = false
    this
  

  def setValue(newValue : Int): Field = 
    this.value = newValue
    this
  

  def earthquake: Field = 
    if value > 0 && value < 9 then this.value = 0
    this
  

  override def toString: String = 
    if value == -99 then " |X| "
    else if value == -10 || value == -20 then " |T| "
    else if this.isPlayerOnField then " |P| "
    else " |" + value.toString + "| "
  