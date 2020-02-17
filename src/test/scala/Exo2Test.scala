package battledev201911

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer


class Exo2Test extends FunSuite {

	class Exo2Wrapper(in: List[String]) extends Exo2 {

		val mockBuffer = new ListBuffer[Int]()

		override def input = in
		override def output(result: Int) = (mockBuffer += result)

		def hasResult = !mockBuffer.isEmpty
		def testResult = mockBuffer.head

	}

	test("dude & buddy") {
		val in = List(15, 34, 25, 10).map(_.toString)
		val expected = 5 + 24 + 15

		val exo = new Exo2Wrapper(in)
		exo.contestResponse

		if (!exo.hasResult) fail("no result returned")
        else assert(exo.testResult === expected)
	}

}
