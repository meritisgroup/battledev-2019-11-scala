package battledev201911

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer
import java.io.{ByteArrayOutputStream, StringReader}


class Exo1Test extends FunSuite {

	class Exo1Wrapper(in: List[String]) extends Exo1 {

		val mockBuffer = new ListBuffer[String]()

		override def input = in
		override def output(result: String) = (mockBuffer += result)

		def hasResult = !mockBuffer.isEmpty
		def testResult = mockBuffer.head

	}

	test("dude & buddy") {
		val in = List("2", "dude 3", "buddy 15")
		val expected = "dude"

		val exo = new Exo1Wrapper(in)
		exo.contestResponse

		if (!exo.hasResult) fail("no result returned")
        else assert(exo.testResult === expected)
	}

}
