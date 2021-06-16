package view.tui

import controller.{Controller, State}
import scala.util.{Failure, Success, Try}
import scala.io.{BufferedSource, Source}

class TUI(var controller: Controller):
  val quit: Int = -1
  val continue: Int = 1
  val clear: String = "\u001b[2J"
  val banner: String = "▄▄▄█████▓ ██▀███   ▄▄▄       ██▓ ██▓        ██▀███   █    ██  ███▄    █  ███▄    █ ▓█████  ██▀███\n▓  ██▒ ▓▒▓██ ▒ ██▒▒████▄    ▓██▒▓██▒       ▓██ ▒ ██▒ ██  ▓██▒ ██ ▀█   █  ██ ▀█   █ ▓█   ▀ ▓██ ▒ ██▒\n▒ ▓██░ ▒░▓██ ░▄█ ▒▒██  ▀█▄  ▒██▒▒██░       ▓██ ░▄█ ▒▓██  ▒██░▓██  ▀█ ██▒▓██  ▀█ ██▒▒███   ▓██ ░▄█ ▒\n░ ▓██▓ ░ ▒██▀▀█▄  ░██▄▄▄▄██ ░██░▒██░       ▒██▀▀█▄  ▓▓█  ░██░▓██▒  ▐▌██▒▓██▒  ▐▌██▒▒▓█  ▄ ▒██▀▀█▄\n  ▒██▒ ░ ░██▓ ▒██▒ ▓█   ▓██▒░██░░██████▒   ░██▓ ▒██▒▒▒█████▓ ▒██░   ▓██░▒██░   ▓██░░▒████▒░██▓ ▒██▒\n  ▒ ░░   ░ ▒▓ ░▒▓░ ▒▒   ▓▒█░░▓  ░ ▒░▓  ░   ░ ▒▓ ░▒▓░░▒▓▒ ▒ ▒ ░ ▒░   ▒ ▒ ░ ▒░   ▒ ▒ ░░ ▒░ ░░ ▒▓ ░▒▓░\n    ░      ░▒ ░ ▒░  ▒   ▒▒ ░ ▒ ░░ ░ ▒  ░     ░▒ ░ ▒░░░▒░ ░ ░ ░ ░░   ░ ▒░░ ░░   ░ ▒░ ░ ░  ░  ░▒ ░ ▒░\n  ░        ░░   ░   ░   ▒    ▒ ░  ░ ░        ░░   ░  ░░░ ░ ░    ░   ░ ░    ░   ░ ░    ░     ░░   ░\n            ░           ░  ░ ░      ░  ░      ░        ░              ░          ░    ░  ░   ░\n\n                                                      "
  val greetings: String = "Welcome to TrailRunner!"
  val mainMenu: List[String] = List("Start a new game", "Exit")
  var output: String = ""

  def start(): Int =
    controller.changeState(State.MainMenu)
    buildOutputForMainMenu()
    updateScreen()
    continue
  
  def evaluateInput(input: String): Int = 
    controller.state match 
      case State.MainMenu => evaluateMainMenu(input)
      case State.LevelSelection => evaluateSelection(input)
      case State.Running => evaluateRunning(input)
      case State.GameOver => evaluateGameOver(input)
    
  def evaluateMainMenu(input: String): Int =
    if input.equals("1") then
      controller.changeState(State.LevelSelection)
      buildOutputForLevelSelection()
    else if (input.equals("2")) then return quit
    updateScreen()
    continue

  def evaluateSelection(input: String): Int = {
    if input matches "[1-7]" then
      controller.changeState(State.Running)
      controller.start()
      buildOutputForRunningGame()
    updateScreen()
    continue
  }

  def evaluateRunning(input: String): Int = {
    input match 
      case "d" => controller.moveLeft()
      case "w" => controller.moveDown()
      case "s" => controller.moveUp()
      case "a" => controller.moveRight()
      case "q" => return quit
    if controller.hasWon() then 
      controller.changeState(State.GameOver)
      buildOutputForWin()
    else if controller.hasLost() then 
      controller.changeState(State.GameOver)
      buildOutputForLose()
    else
      buildOutputForRunningGame()
    updateScreen()
    continue
  }

  def evaluateGameOver(input: String): Int = 
    input match 
      case "y" => start()
      case "n" => quit

  def buildOutputForMainMenu() : String = 
    output = s"$clear$banner\n$greetings\n"
    var index = 1
    for x <- mainMenu do
      output += s"'$index': $x\n"
      index += 1
    output += "\n"
    output
  
  def buildOutputForLevelSelection() : String =
    output =  s"$clear$banner\nLevel Selection\n"
    var index = 1
    for (x <- 1 to 7) do
      output += s"'$index': Level $x\n"
      index += 1
    output += "\n"
    output

  def buildOutputForRunningGame() : String = 
      output = s"$clear$banner\n${controller.level}\n\nPlayer: [ x: ${controller.level.player.xPos + 1} | y: ${controller.level.player.yPos + 1} ]\nZiel: [ x: ${controller.level.winX + 1} | y: ${controller.level.winY + 1} ]\n"
      output

  def buildOutputForWin(): String = 
    output = s"$clear$banner\n\nCongratulations, you've found your way out of the dungeon!\n"
    buildOutputStringForEndGame()

  def buildOutputForLose(): String = 
    output = s"$clear$banner\n\nYou died!\n"
    buildOutputStringForEndGame()

  def buildOutputStringForEndGame(): String = 
    output += s"Try again?\nYes (y)\nNo (n)\n"
    output
  
  def updateScreen(): Unit = print(output)
  

