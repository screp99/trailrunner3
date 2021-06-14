package view.tui

import scala.util.Try

abstract class State(tui: TUI) {
  def evaluateInput(input: String): Int
}

class MainMenuState(tui: TUI) extends State(tui: TUI) {
  override def evaluateInput(input: String): Int = {
    tui.evaluateMainMenu(input)
  }

  override def toString: String = {
    tui.buildOutputStringForMainMenu()
  }
}

class SelectionState(tui: TUI) extends State(tui: TUI) {
  override def evaluateInput(input: String): Int = {
    tui.evaluateSelection(input)
  }

  override def toString: String = {
    tui.buildOutputStringForSelectionMenu()
  }

}

class RunningState(tui: TUI) extends State(tui: TUI) {
  override def evaluateInput(input: String): Int = {
    tui.evaluateRunning(input)
  }

  override def toString: String = {
    tui.buildOutputStringForRunningGame()
  }
}

class WinState(tui: TUI) extends State(tui: TUI) {
  override def evaluateInput(input: String): Int = {
    tui.evaluateWin(input)
  }

  override def toString: String = {
    tui.buildOutputStringForWin()
  }
}

class LoseState(tui: TUI) extends State(tui: TUI) {
  override def evaluateInput(input: String): Int = {
    tui.evaluateLose(input)
  }

  override def toString: String = {
    tui.buildOutputStringForLose()
  }
}
