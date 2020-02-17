package battledev201911


class Exo1 {

	def input = io.Source.stdin.getLines.toList

	def output(result: String) = System.out.println(result)

	def transform(line: String): (String, Int) = {
		val array = line.split(" ")
		(array(0), array(1).toInt)
	}

	def contestResponse() {
		val in = input

		val N = in(0)

		val nameAndLength = for (line <- in.tail) yield transform(line)

		val mini = nameAndLength.minBy(person => person._2)

		output(mini._1)
	}

}
