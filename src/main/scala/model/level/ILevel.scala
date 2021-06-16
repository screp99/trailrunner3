package model.level

import model.field.IField
import model.player.IPlayer

trait ILevel(val size: Int):
  def lose(): Boolean
  def win(): Boolean
  def standsPlayerInFrontOfOpenDoor(): ILevel
  def closeDoor(): ILevel
  def playerStandsOnDoor(): Boolean
  def fillNullValues() : Boolean
  def toString: String