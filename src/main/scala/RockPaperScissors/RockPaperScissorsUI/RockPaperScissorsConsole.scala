package RockPaperScissors.RockPaperScissorsUI

import RockPaperScissors.Util.{Actor, EventBus, PlayableShape}
import RockPaperScissors.messages.Commands.{CreateNewGame, GameType, PlayShape}
import RockPaperScissors.messages.Events.PlayerPlayedShape

class RockPaperScissorsConsole(private var exit: Boolean = false) extends Actor with Console {

  def start(): Unit = {
    EventBus.connect(this)
    welcomePlayer()
    createGame()
    gameLoop()
  }

  def exitNow(): Unit = {
    exit = true
  }

  val defaultActions: List[ConsoleAction] = HelpAction :: ExitAction :: Nil
  var currentActions: List[ConsoleAction] = defaultActions

  override def receiveMessage(message: Any): Unit = message match {
    case message: PlayShape => println("You now have to play something...")
    case _ => Unit
  }

  def welcomePlayer(): Unit = {
    println("Hi, let's play Rock-Paper-Scissors")
    println("Do you know how to play you can always type \"help\"")
    println("To exit, use the commando \"exit\"")
  }

  def askHelp(): Unit = {
    println("Showing help:")
    defaultActions.foreach(item => printf("%s - %s\n", item.name, item.description))
  }

  def gameLoop(): Unit = {
    println("Please give input: ")
    val userInput = scala.io.StdIn.readLine()
    val inputFound = defaultActions.exists(_.trigger(this, userInput))

    if(!inputFound) println(s"Input '$userInput' was not recognized... (ask HELP if you need help)")
    if(!exit) gameLoop()
  }

  def createGame(): Unit = {
    EventBus.sent(new CreateNewGame(GameType.PlayerVsComputer, "You", "Computer", 2))
    EventBus.sent(new PlayerPlayedShape("You", PlayableShape.Scissors))
    EventBus.sent(new PlayerPlayedShape("You", PlayableShape.Scissors))
  }

  def endGame(): Unit = {
    println("The game has ended...")
  }
}
