package model.level

import model.field.Field
import model.player.Player

class Level1 extends Level(Array.ofDim[Field](10, 10),
  "Level1",
  Player(1,8),
  5,
  2,
  5,
  1,
  false):

  // Zeile 1 der Matrix
  dungeon(1)(1) = Field(3)
  dungeon(1)(2) = Field(4)
  dungeon(1)(5) = Field(-10)
  dungeon(1)(8) = Field(1, isPlayerOnField = true)

  // Zeile 2 der Matrix
  dungeon(2)(1) = Field(1)
  dungeon(2)(2) = Field(2)
  dungeon(2)(3) = Field(1)
  dungeon(2)(5) = Field(1)
  dungeon(2)(7) = Field(2)
  dungeon(2)(8) = Field(2)

  // Zeile 3 der Matrix
  dungeon(3)(1) = Field(1)
  dungeon(3)(2) = Field(1)
  dungeon(3)(3) = Field(2)
  dungeon(3)(4) = Field(1)
  dungeon(3)(5) = Field(1)
  dungeon(3)(6) = Field(1)
  dungeon(3)(7) = Field(2)
  dungeon(3)(8) = Field(2)

  // Zeile 4 der Matrix
  dungeon(4)(3) = Field(1)
  dungeon(4)(4) = Field(2)
  dungeon(4)(5) = Field(2)
  dungeon(4)(6) = Field(2)
  dungeon(4)(7) = Field(2)
  dungeon(4)(8) = Field(3)

  // Zeile 5 der Matrix
  dungeon(5)(1) = Field(1)
  dungeon(5)(2) = Field(1)
  dungeon(5)(4) = Field(1)
  dungeon(5)(5) = Field(1)
  dungeon(5)(6) = Field(1)
  dungeon(5)(8) = Field(2)

  // Zeile 6 der Matrix
  dungeon(6)(1) = Field(1)
  dungeon(6)(2) = Field(2)
  dungeon(6)(3) = Field(3)
  dungeon(6)(4) = Field(5)
  dungeon(6)(5) = Field(4)
  dungeon(6)(6) = Field(2)
  dungeon(6)(7) = Field(2)
  dungeon(6)(8) = Field(2)

  // Zeile 7 der Matrix
  dungeon(7)(3) = Field(2)
  dungeon(7)(4) = Field(3)
  dungeon(7)(5) = Field(3)
  dungeon(7)(6) = Field(2)
  dungeon(7)(7) = Field(2)
  dungeon(7)(8) = Field(1)

  // Zeile 8 der Matrix
  dungeon(8)(1) = Field(1)
  dungeon(8)(2) = Field(1)
  dungeon(8)(3) = Field(1)
  dungeon(8)(4) = Field(1)
  dungeon(8)(5) = Field(2)
  dungeon(8)(6) = Field(2)
  dungeon(8)(7) = Field(1)
  dungeon(8)(8) = Field(1)
  fillNullValues()

