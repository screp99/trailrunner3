import view.tui.TUI
import controller.{Controller, State}
import scala.io.StdIn.readLine

object Main extends App {
  val controller = Controller()
  val tui = new TUI(controller)
  tui.start()
  var input: String = readLine()
  while tui.evaluateInput(input) != -1 do input = readLine()
  println("\nBis zum nächsten Mal!\n")
}
