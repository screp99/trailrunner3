package model.field

class Field(var value: Int,
  val fieldType: String,
  var fog: Boolean,
  var isPlayerOnField: Boolean) extends IField():

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
    if value > 0 && value < 9 then
        this.value = 0
    this
  

  override def toString: String = 
    if value == -99 then
        return " |X| "
    else if value == -10 || value == -20 then
        return " |T| "
    else if this.isPlayerOnField then
        return " |P| "
    else
        " |" + value.toString + "| "
  