package RockPaperScissors.RockPaperScissorsUI

import RockPaperScissors.Util.{Actor, EventBus, PlayableShape}
import RockPaperScissors.messages.Commands.{CreateNewGame, GameType, PlayShape}
import RockPaperScissors.messages.Events.PlayerPlayedShape

class RockPaperScissorsConsole( val playerName: String = "You", val opponentName: String = "I") extends Actor with Console {

  val defaultActions: List[ConsoleAction] = HelpAction :: ExitAction :: Nil

  val consoleStates: Map[ConsoleStates.Value, ConsoleState] =
    Map(ConsoleStates.CreateGame -> new ConsoleState("What kind of game do you like to play?", GameTypeAction :: defaultActions),
        ConsoleStates.AmountOfTurns -> new ConsoleState("Of how many turns do you want your game to consist?", AmountOfTurnsAction :: defaultActions))

  def start(): Unit = {
    EventBus.connect(this)
    welcomePlayer()
    inputLoop(consoleStates(ConsoleStates.CreateGame))
  }

  def exitNow(): Unit = {
    //do nothing, this game ends
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

  override def askHelp(currentState: ConsoleState): Unit = {
    println("Showing help:")

    val currentlyAvailableCommands = currentState.commands
    currentlyAvailableCommands.foreach(item => printf("%s - %s\n", item.name, item.description))
    inputLoop(currentState)
  }

  def getAvailableCommands(commands: List[ConsoleAction]): String = commands.map(_.name) mkString " - "

  def inputLoop(currentState: ConsoleState): Unit = {
    printf("%s [%s]\n", currentState.questionToPlayer, getAvailableCommands(currentState.commands))
    val userInput = scala.io.StdIn.readLine()
    val inputFound = currentState.commands.exists(_.trigger(this, currentState, userInput))

    if(!inputFound) {
      println(s"Input '$userInput' was not recognized... (ask HELP if you need help)")

      //try again
      inputLoop(currentState)
    }
  }

  override def saveGameType(currentState: ConsoleState, input: String): Unit = {
    val gameType = if (input.matches("(?i)(.*p.*c.*)")) GameType.PlayerVsComputer else GameType.ComputerVsComputer

    val nextState = consoleStates(ConsoleStates.AmountOfTurns)

    //start new
    inputLoop(new ConsoleState(nextState.questionToPlayer, nextState.commands, Some(gameType)))
  }

  override def saveAmountOfTurns(currentState: ConsoleState, input: String): Unit = {
    val gameType = currentState.data.get.asInstanceOf[GameType.Value]
    EventBus.sent(new CreateNewGame(gameType, playerName, opponentName, input.toInt))
  }

  override def playShape(input: String): Unit = {
    val shape =
      if(input.matches("(?i)(.*r.*)")) PlayableShape.Rock
      else if(input.matches("(?i)(.*p.*)")) PlayableShape.Paper
      else PlayableShape.Scissors

    EventBus.sent(new PlayerPlayedShape(playerName, shape))
  }

  def endGame(): Unit = {
    println("The game has ended...")
  }
}

object ConsoleStates extends Enumeration {
  val CreateGame, AmountOfTurns, GetShape = Value
}
