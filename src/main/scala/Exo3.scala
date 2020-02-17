package battledev201911

import scala.annotation.tailrec


class Exo3 {

	class Action(val time: Int)

	case class PickUp(start: Int, end: Int) extends Action(start)
	case class Leave(end: Int, cableIndex: Int) extends Action(end)

	def input = io.Source.stdin.getLines.toList

	def output(result: List[Int]) = System.out.println(result.map(_ + 1).mkString(" "))

	def noOutput = System.out.println("pas possible")

	def transform(line: String): (Int, Int) = {
		val array = line.split(" ")
		(array(0).toInt, array(1).toInt)
	}

	def sort(list: List[Action]): List[Action] = {
		list.sortBy {
			case Leave(time, _) => (time, 0)
			case PickUp(time, _) => (time, 1)
		}	
	}

	@tailrec final def assign(freeCables: List[Int], assigned: List[Int], actions: List[Action]): Option[List[Int]] =
		actions match {
			case Nil => Some(assigned.reverse)
			case Leave(_, index) :: tail => {
				val newfree = index :: freeCables
				assign(newfree, assigned, tail)
			}
			case PickUp(_, _) :: tail if (freeCables.isEmpty) => None
			case PickUp(_, end) :: tail => {
				val cable = freeCables.head
				val newFree = freeCables.tail
				val remainingActions = sort(Leave(end, cable) :: tail)
				assign(newFree, cable :: assigned, remainingActions)
			}
	}

	def contestResponse() {
		val in = input

		// Number of cables
		val N = in(0).split(" ")(0).toInt

		// Number of requests
		val M = in(0).split(" ")(1).toInt

		// (start, end)
		val times = for (line <- in.tail) yield transform(line)
		val actions = times.map(request => PickUp(request._1, request._2))

		val sorted = sort(actions)

		val initialCables = (0 until N).toList
		val result = assign(initialCables, Nil, sorted)

		if (result.isEmpty) noOutput
		else output(result.get)
	}

}
