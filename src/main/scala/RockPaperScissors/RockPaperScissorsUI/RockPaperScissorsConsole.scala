package RockPaperScissors.RockPaperScissorsUI

import RockPaperScissors.Util.{Actor, EventBus}
import RockPaperScissors.messages.Commands.{CreateNewGame, GameType, PlayShape}

class RockPaperScissorsConsole( val playerName: String = "You",
                                val opponentName: String = "I"
                              ) extends Actor with Console {

  val defaultActions: List[ConsoleAction] = HelpAction :: ExitAction :: Nil

  val consoleStatuses: Map[Status.Value, ConsoleStatus] =
    Map(Status.CreateGame -> new ConsoleStatus("What kind of game do you like to play?", GameTypeAction :: defaultActions),
        Status.AmountOfTurns -> new ConsoleStatus("Of how many turns do you want your game to consist?", AmountOfTurnsAction :: defaultActions))

  def start(): Unit = {
    EventBus.connect(this)
    welcomePlayer()
    inputLoop(consoleStatuses(Status.CreateGame))
  }

  def exitNow(): Unit = {
    //no special actions when exiting
  }

  override def receiveMessage(message: Any): Unit = message match {
    case message: PlayShape => println("You now have to play something...")
    case _ => Unit
  }

  def welcomePlayer(): Unit = {
    println("Hi, let's play Rock-Paper-Scissors")
    println("If you do not know how to play, you can always type \"help\"")
    println("To exit, use the command \"exit\"")
  }

  override def askHelp(currentStatus: ConsoleStatus): Unit = {
    println("Showing help:")

    val currentlyAvailableCommands = currentStatus.commands
    currentlyAvailableCommands.foreach(item => printf("%s - %s\n", item.name, item.description))
    inputLoop(currentStatus)
  }

  def getAvailableCommands(commands: List[ConsoleAction]): String = commands.map(_.name) mkString(" - ")

  def inputLoop(currentStatus: ConsoleStatus): Unit = {
    printf("%s [%s]\n", currentStatus.questionToPlayer, getAvailableCommands(currentStatus.commands))
    val userInput = scala.io.StdIn.readLine()
    val inputFound = currentStatus.commands.exists(_.trigger(this, currentStatus, userInput))

    if(!inputFound) {
      println(s"Input '$userInput' was not recognized... (ask HELP if you need help)")

      //try again
      inputLoop(currentStatus)
    }
  }

  override def saveGameType(currentStatus: ConsoleStatus, input: String): Unit = {
    val gameType = if (input.matches("(?i)(.*p.*c.*)")) GameType.PlayerVsComputer else GameType.ComputerVsComputer

    val nextStatus = consoleStatuses(Status.AmountOfTurns)
    inputLoop(new ConsoleStatus(nextStatus.questionToPlayer, nextStatus.commands, Some(gameType)))
  }

  override def saveAmountOfTurns(currentStatus: ConsoleStatus, input: String): Unit = {
    val gameType = currentStatus.data.get.asInstanceOf[GameType.Value]
    EventBus.sent(new CreateNewGame(gameType, playerName, opponentName, input.toInt))
  }

  def endGame(): Unit = {
    println("The game has ended...")
  }
}

object Status extends Enumeration {
  val CreateGame, AmountOfTurns, GetShape = Value
}
