import view.tui.TUI
import controller.Controller
import scala.io.StdIn.readLine

object Main extends App {
  val controller = Controller(null, null, null)
  val tui = new TUI(controller)
  var input: String = ""
  while tui.evaluateInput(input) != -1 do input = readLine()
  println("Bis zum nächsten Mal!")
}
