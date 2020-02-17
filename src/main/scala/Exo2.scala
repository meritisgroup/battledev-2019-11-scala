package battledev201911


class Exo2 {

	def input = io.Source.stdin.getLines.toList

	def output(result: Int) = System.out.println(result.toString)

	def contestResponse() {
		val in = input

		val lengths = in.map(str => str.toInt)

		val mini = lengths.min

		val result = lengths.map(length => length - mini).sum

		output(result)
	}

}
